package com.mcst.gbn30;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mcst.dto.pernInfoDto;
import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309502Dto;
import com.mcst.gbn30.service.pg309502Service;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;

@Controller
public class pg309502Controll {

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "commonService")
	private com.mcst.main.service.commonService commonService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

	@Resource(name = "pg309502Service")
	private pg309502Service pg309502Service;

    protected static Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping(value="/gbn30/pg309502.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309502(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		return "gbn30/pg309502";
    }

    @RequestMapping(value="/gbn30/pg309502List.ajax", method={RequestMethod.POST})
    public ModelAndView pg309502List(@ModelAttribute("pg309502Dto") pg309502Dto pg309502Dto, HttpSession session, Model model) throws Exception {

		List<pg309502Dto> pg309502DtoList = pg309502Service.selectPg309502List(pg309502Dto);

		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("rowData", pg309502DtoList);

		ModelAndView modelAndView = new ModelAndView("jsonView", map);
		return modelAndView;
    }

    @RequestMapping(value="/gbn30/pg309502Input.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309502Input(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	model.addAttribute("processType","INSERT");

    	pg309502Dto pg309502Dto = new pg309502Dto();

       	List<pg309502Dto> pg309502DtoInfo = pg309502Service.selectPg309502Info(pg309502Dto);
    	model.addAttribute("pg309502Info", pg309502DtoInfo);

    	return "gbn30/pg309502Input";
    }

    @RequestMapping(value="/gbn30/pg309502Modify.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309502Modify(@ModelAttribute("pg309502Dto") pg309502Dto pg309502Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	model.addAttribute("processType","UPDATE");

    	pernInfoDto pernInfoDto = commonService.selectPernInfo(pg309502Dto.getPernNum());
    	model.addAttribute("pernInfo", pernInfoDto);

    	List<pg309502Dto> pg309502DtoInfo = pg309502Service.selectPg309502Info(pg309502Dto);
    	model.addAttribute("pg309502Info", pg309502DtoInfo);

    	return "gbn30/pg309502Input";
    }

    @RequestMapping(value="/gbn30/pg309502Save.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309502Save(@ModelAttribute("pg309502Dto") pg309502Dto pg309502Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	String msg = "";
    	String close = "";
    	int dupChk = 0;
    	int rtn = 0;

    	logger.info("MenuId=>"+pg309502Dto.getPernNum());
    	logger.info("MenuId=>"+pg309502Dto.getMenuId());
    	logger.info("MenuAuth=>"+pg309502Dto.getMenuAuth());

    	//logger.info(pg309502Dto.getProcessType());
    	//if ("INSERT".equals(pg309502Dto.getProcessType())) {
    	//	dupChk = pg309502Service.selectPg309502Check(pg309502Dto);
    	//}
/*
    	usr200tDto usr200tDto = new usr200tDto();

    	BeanUtils.copyProperties(usr200tDto, pg309502Dto);

    	logger.info(dupChk);

    	if (dupChk > 0) {
    		msg = "이미 입력된 구분코드가 존재 합니다.";
    	} else {
    		rtn = pg309502Service.updatePg309502(usr200tDto);

        	if (rtn > 0) {
        		msg = "정상적으로 저장 되었습니다.";
        		close = "true";
        	} else {
        		msg = "저장시 오류가 발생 되었습니다.";
        	}
    	}

    	model.addAttribute("msg", msg);
    	model.addAttribute("close", close);
    	model.addAttribute("pg309502Info", pg309502Dto);
    	*/
    	return "gbn30/pg309502Input";

    }

    @RequestMapping(value="/gbn30/pg309502Delete.ajax", method={RequestMethod.POST})
    public ResponseEntity<String> pg309502Delete(@ModelAttribute("pg309502Dto") pg309502Dto pg309502Dto, HttpSession session, Model model) throws Exception {

    	int childChk = 0;
    	int rtn = 0;
    	ResponseEntity<String> resRtn = null;

    	childChk = pg309502Service.selectPg309502DelCheck(pg309502Dto);

    	if (childChk > 0) {
    		resRtn = new ResponseEntity<>(URLEncoder.encode("하위 메뉴가 존재합니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

    		logger.info(resRtn);
    	} else {
    		rtn = pg309502Service.deletePg309502(pg309502Dto);

       		if (rtn == 1) {
       			resRtn = new ResponseEntity<>(URLEncoder.encode("정상적으로 삭제 되었습니다." , "UTF-8"),HttpStatus.OK);

       			logger.info(resRtn);
       		} else {
       			resRtn = new ResponseEntity<>(URLEncoder.encode("삭제 처리중 오류가 발생되었습니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

       			logger.info(resRtn);
       		}
    	}

    	return resRtn;
    }

}
