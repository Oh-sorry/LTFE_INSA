package com.mcst.gbn10;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mcst.main.service.mainService;
import com.mcst.AES128.AES128;
import com.mcst.common.dateUtil;
import com.mcst.dto.gbn10.pg104500Dto;
import com.mcst.gbn10.service.pg104500Service;

import egovframework.com.EgovMessageSource;

@Controller
public class pg104500Controller {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg104500Service")
	protected pg104500Service pg104500Service;

	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	/* 전화번호 변환 (01011112222 -> 010-1111-2222) */
	public static String phone(String src) {
		if (src == null) {
		      return "";
		}
		if(src.length() == 8) {
		      return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
	    } else if (src.length() == 12) {
	      return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
	    }
	    return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	}
	/* 연봉구분 형식 (100000 -> 1,000,000) */
	public String comma(int value) {
		DecimalFormat df = new DecimalFormat("###,###");
		String value_str = df.format(value);
		return value_str;
	}
	
	@RequestMapping(value = "/gbn10/pg104500.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg104500(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpServletRequest request,
			HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		/* 재/퇴직 */
		List<pg104500Dto> pg104500DtoGbnJoinList = pg104500Service.selectPg104500GbnJoinList(pg104500Dto);
		/* 부서 */
		List<pg104500Dto> pg104500DtoGbnList = pg104500Service.selectPg104500GbnList(pg104500Dto);
		/* 직위 */
		List<pg104500Dto> pg104500DtoGbnList2 = pg104500Service.selectPg104500GbnList2(pg104500Dto);
		/* 직급 */
		List<pg104500Dto> pg104500DtoGbnList3 = pg104500Service.selectPg104500GbnList3(pg104500Dto);
		/* 급여구분 */
		List<pg104500Dto> pg104500DtoGbnList4 = pg104500Service.selectPg104500GbnList4(pg104500Dto);

		model.put("gbnList", pg104500DtoGbnList);
		model.put("gbnList2", pg104500DtoGbnList2);
		model.put("gbnList3", pg104500DtoGbnList3);
		model.put("gbnList4", pg104500DtoGbnList4);
		model.put("gbnJoin", pg104500DtoGbnJoinList);

		return "gbn10/pg104500";
	}

	@RequestMapping(value = "/gbn10/pg104500List.ajax", method = { RequestMethod.POST })
	public ModelAndView pg104500List(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpSession session,
			Model model) throws Exception {

		List<pg104500Dto> pg104500DtoList = pg104500Service.selectPg104500List(pg104500Dto);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowData", pg104500DtoList);

		for (int i = 0; i < pg104500DtoList.size(); i++) {

			/* 연봉구분 형식 (100000 -> 1,000,000) */
			pg104500DtoList.get(i).setStringWagesAmt(comma(pg104500DtoList.get(i).getWagesAmt()));

			/*
			 * if(pg104500DtoList.get(i).getWagesAmt() != 0 ||
			 * pg104500DtoList.get(i).getWagesAmt() != ' ') { } else {
			 * pg104500DtoList.get(i).setStringWagesAmt("-"); }
			 */

			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			pg104500DtoList.get(i).setJoinDate(dateUtil.formatDate(pg104500DtoList.get(i).getJoinDate(), '.'));
			if (pg104500DtoList.get(i).getRetrDate() != null) {
				pg104500DtoList.get(i).setRetrDate(dateUtil.formatDate(pg104500DtoList.get(i).getRetrDate(), '.'));
			}

			/* 전화번호 decode */
			pg104500DtoList.get(i).setPhoneNo(phone(AES128.decrypt(pg104500DtoList.get(i).getPhoneNo())));

			/* 남/여 구분 */
			if(pg104500DtoList.get(i).getSexCode().equals("1")) {
				pg104500DtoList.get(i).setSexCode("남");
			} else {
				pg104500DtoList.get(i).setSexCode("여");
			}
			
			/* 상조회 구분 */
			if(pg104500DtoList.get(i).getMutualYn().equals("1")) {
				pg104500DtoList.get(i).setMutualYn("Y");
			} else {
				pg104500DtoList.get(i).setMutualYn("N");
			}
		}

		ModelAndView modelAndView = new ModelAndView("jsonView", map);
		return modelAndView;
	}
}
