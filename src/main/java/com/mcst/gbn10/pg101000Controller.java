package com.mcst.gbn10;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.common.dateUtil;
import com.mcst.common.stringUtil;
import com.mcst.dto.gbn10.pg101000Dto;
import com.mcst.dto.gbn10.pg102000Dto;
import com.mcst.gbn10.service.pg101000Service;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;

@Controller
public class pg101000Controller {
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg101000Service")
	private pg101000Service pg101000Service;

	protected static Logger logger = Logger.getLogger(Main.class.getName());

	@RequestMapping(value="/gbn10/pg101000.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg101000(@ModelAttribute("pg101000Dto") pg101000Dto pg101000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		
		pg101000Dto pg101000DtoPernInfo = pg101000Service.selectPg101000PernInfo(pg101000Dto);
		
		if(pg101000Dto.getPernNo() != null && !pg101000Dto.getPernNo().isEmpty()) {			
			if(pg101000DtoPernInfo.getRepreNum() != null && !pg101000DtoPernInfo.getRepreNum().isEmpty())
			pg101000DtoPernInfo.setRepreNum(stringUtil.repreNum(pg101000DtoPernInfo.getRepreNum()));
			if(pg101000DtoPernInfo.getJoinDate() != null)
			pg101000DtoPernInfo.setJoinDate(dateUtil.formatDate(pg101000DtoPernInfo.getJoinDate(), '.'));
			if(pg101000DtoPernInfo.getExpireDate() != null)
			pg101000DtoPernInfo.setExpireDate(dateUtil.formatDate(pg101000DtoPernInfo.getExpireDate(), '.'));
			if(pg101000DtoPernInfo.getPayGradeDate() != null)
			pg101000DtoPernInfo.setPayGradeDate(dateUtil.formatDate(pg101000DtoPernInfo.getPayGradeDate(), '.'));
			if(pg101000DtoPernInfo.getPayGradeDate2() != null)
			pg101000DtoPernInfo.setPayGradeDate2(dateUtil.formatDate(pg101000DtoPernInfo.getPayGradeDate2(), '.'));
			if(pg101000DtoPernInfo.getRetrDate() != null)
			pg101000DtoPernInfo.setRetrDate(dateUtil.formatDate(pg101000DtoPernInfo.getRetrDate(), '.'));
		}
		
		model.addAttribute("pernInfo", pg101000DtoPernInfo);
		
		
		// 페이지 새로고침 될때마다 검색에 사용된 값들을 가져오기 위한
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg101000Dto, Map.class);
		model.addAttribute("searchFormData", result);
				
		return "gbn10/pg101000";
	}
	
	@RequestMapping(value = "/gbn10/pg101000Search.do", method={RequestMethod.GET,RequestMethod.POST})
	public String pg101000Search(@ModelAttribute("pg101000Dto") pg101000Dto pg101000Dto, HttpServletResponse response, ModelMap model) throws Exception{
		
		List<pg101000Dto> pg101000DtoSearchList = pg101000Service.selectPg101000SearchList(pg101000Dto);
		for (int i = 0; i < pg101000DtoSearchList.size(); i++) {			
			if (pg101000DtoSearchList.get(i).getJoinDate() != null) {
				pg101000DtoSearchList.get(i).setJoinDate(dateUtil.formatDate(pg101000DtoSearchList.get(i).getJoinDate(), '.'));
			}
			if (pg101000DtoSearchList.get(i).getRetrDate() != null) {
				pg101000DtoSearchList.get(i).setRetrDate(dateUtil.formatDate(pg101000DtoSearchList.get(i).getRetrDate(), '.'));
			}
			if (pg101000DtoSearchList.get(i).getRepreNum() != null) {
				pg101000DtoSearchList.get(i).setRepreNum(stringUtil.repreNum(pg101000DtoSearchList.get(i).getRepreNum()));
			}
		}
		model.addAttribute("cnt", pg101000DtoSearchList.size());
		model.addAttribute("searchList", pg101000DtoSearchList);		
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg101000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg101000Search";
	}

	// 기본인적 탭
	@RequestMapping(value="/gbn10/pg101001.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg101001(@ModelAttribute("pg101000Dto") pg101000Dto pg101000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
	
		pg101000Dto pg101000DtoPernInfo = pg101000Service.selectPg101000PernInfo(pg101000Dto);
		
		if(pg101000Dto.getPernNo() != null && !pg101000Dto.getPernNo().isEmpty()) {			
			if(pg101000DtoPernInfo.getRepreNum() != null && !pg101000DtoPernInfo.getRepreNum().isEmpty())
			pg101000DtoPernInfo.setRepreNum(stringUtil.repreNum(pg101000DtoPernInfo.getRepreNum()));
			if(pg101000DtoPernInfo.getJoinDate() != null)
			pg101000DtoPernInfo.setJoinDate(dateUtil.formatDate(pg101000DtoPernInfo.getJoinDate(), '.'));
			if(pg101000DtoPernInfo.getExpireDate() != null)
			pg101000DtoPernInfo.setExpireDate(dateUtil.formatDate(pg101000DtoPernInfo.getExpireDate(), '.'));
			if(pg101000DtoPernInfo.getPayGradeDate() != null)
			pg101000DtoPernInfo.setPayGradeDate(dateUtil.formatDate(pg101000DtoPernInfo.getPayGradeDate(), '.'));
			if(pg101000DtoPernInfo.getPayGradeDate2() != null)
			pg101000DtoPernInfo.setPayGradeDate2(dateUtil.formatDate(pg101000DtoPernInfo.getPayGradeDate2(), '.'));
			if(pg101000DtoPernInfo.getRetrDate() != null)
			pg101000DtoPernInfo.setRetrDate(dateUtil.formatDate(pg101000DtoPernInfo.getRetrDate(), '.'));
		}
		
		model.addAttribute("pernInfo", pg101000DtoPernInfo);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg101000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg101001";
	}
	
	// 발령이력 탭
	@RequestMapping(value="/gbn10/pg101002.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg101002(@ModelAttribute("pg101000Dto") pg101000Dto pg101000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
	
		return "gbn10/pg101002";
	}
}
