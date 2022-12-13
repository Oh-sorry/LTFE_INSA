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

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309501Dto;
import com.mcst.gbn30.service.pg309501Service;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;

@Controller
public class pg309501Controll {

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

	@Resource(name = "pg309501Service")
	private pg309501Service pg309501Service;

    protected static Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping(value="/gbn30/pg309501.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309501(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		return "gbn30/pg309501";
    }

    @RequestMapping(value="/gbn30/pg309501List.ajax", method={RequestMethod.POST})
    public ModelAndView pg309501List(@ModelAttribute("pg309501Dto") pg309501Dto pg309501Dto, HttpSession session, Model model) throws Exception {

		List<pg309501Dto> pg309501DtoList = pg309501Service.selectPg309501List(pg309501Dto);

		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("rowData", pg309501DtoList);

		ModelAndView modelAndView = new ModelAndView("jsonView", map);
		return modelAndView;
    }

    @RequestMapping(value="/gbn30/pg309501Input.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309501Input(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	model.addAttribute("processType","INSERT");

    	return "gbn30/pg309501Input";
    }

    @RequestMapping(value="/gbn30/pg309501Modify.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309501Modify(@ModelAttribute("pg309501Dto") pg309501Dto pg309501Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	model.addAttribute("processType","UPDATE");

    	pg309501Dto pg309501DtoInfo = pg309501Service.selectPg309501Info(pg309501Dto);
    	model.addAttribute("pg309501Info", pg309501DtoInfo);

    	return "gbn30/pg309501Input";
    }

    @RequestMapping(value="/gbn30/pg309501Save.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg309501Save(@ModelAttribute("pg309501Dto") pg309501Dto pg309501Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	String msg = "";
    	String close = "";
    	int dupChk = 0;
    	int rtn = 0;

    	logger.info(pg309501Dto.getProcessType());
    	if ("INSERT".equals(pg309501Dto.getProcessType())) {
    		dupChk = pg309501Service.selectPg309501Check(pg309501Dto);
    	}

    	usr200tDto usr200tDto = new usr200tDto();

    	BeanUtils.copyProperties(usr200tDto, pg309501Dto);

    	logger.info(dupChk);

    	if (dupChk > 0) {
    		msg = "이미 입력된 구분코드가 존재 합니다.";
    	} else {
    		rtn = pg309501Service.updatePg309501(usr200tDto);

        	if (rtn > 0) {
        		msg = "정상적으로 저장 되었습니다.";
        		close = "true";
        	} else {
        		msg = "저장시 오류가 발생 되었습니다.";
        	}
    	}

    	model.addAttribute("msg", msg);
    	model.addAttribute("close", close);
    	model.addAttribute("pg309501Info", pg309501Dto);

    	return "gbn30/pg309501Input";
    }

    @RequestMapping(value="/gbn30/pg309501Delete.ajax", method={RequestMethod.POST})
    public ResponseEntity<String> pg309501Delete(@ModelAttribute("pg309501Dto") pg309501Dto pg309501Dto, HttpSession session, Model model) throws Exception {

    	int childChk = 0;
    	int rtn = 0;
    	ResponseEntity<String> resRtn = null;

    	childChk = pg309501Service.selectPg309501DelCheck(pg309501Dto);

    	if (childChk > 0) {
    		resRtn = new ResponseEntity<>(URLEncoder.encode("하위 메뉴가 존재합니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

    		logger.info(resRtn);
    	} else {
    		rtn = pg309501Service.deletePg309501(pg309501Dto);

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
