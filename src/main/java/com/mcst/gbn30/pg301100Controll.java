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
import com.mcst.dto.gbn30.pg301100Dto;
import com.mcst.gbn30.service.pg301100Service;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;

@Controller
public class pg301100Controll {

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

	@Resource(name = "pg301100Service")
	private pg301100Service pg301100Service;

    protected static Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping(value="/gbn30/pg301100.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg301100(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	List<pg301100Dto> pg301100DtoGbnList = pg301100Service.selectPg309501GbnList(pg301100Dto);

    	model.put("gbnList", pg301100DtoGbnList);

    	return "gbn30/pg301100";
    }

    @RequestMapping(value="/gbn30/pg301100List.ajax", method={RequestMethod.POST})
    public ModelAndView pg301100List(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpSession session, Model model) throws Exception {

		List<pg301100Dto> pg301100DtoList = pg301100Service.selectPg301100List(pg301100Dto);

		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("rowData", pg301100DtoList);

		ModelAndView modelAndView = new ModelAndView("jsonView", map);
		return modelAndView;
    }

    @RequestMapping(value="/gbn30/pg301100Input.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg301100Input(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	pg301100Dto pg301100DtoGbnName = pg301100Service.selectPg309501GbnName(pg301100Dto);

    	model.addAttribute("gubnName",pg301100DtoGbnName);
    	model.addAttribute("processType","INSERT");

    	return "gbn30/pg301100Input";
    }

    @RequestMapping(value="/gbn30/pg301100Modify.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg301100Modify(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	model.addAttribute("processType","UPDATE");

    	pg301100Dto pg301100DtoGbnName = pg301100Service.selectPg309501GbnName(pg301100Dto);
    	model.addAttribute("gubnName",pg301100DtoGbnName);

    	pg301100Dto pg301100DtoInfo = pg301100Service.selectPg301100Info(pg301100Dto);
    	model.addAttribute("pg301100Info", pg301100DtoInfo);

    	return "gbn30/pg301100Input";
    }

    @RequestMapping(value="/gbn30/pg301100Save.do", method={RequestMethod.GET,RequestMethod.POST})
    public String pg301100Save(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	String msg = "";
    	String close = "";
    	String newMenuId = "";
    	int rtn = 0;

    	usr200tDto usr200tDto = new usr200tDto();

    	if (pg301100Dto.getMenuId() == null || "".equals(pg301100Dto.getMenuId())) {
    		newMenuId = pg301100Service.selectpg301100MenuId(pg301100Dto);

    		pg301100Dto.setMenuId(newMenuId);
    	}

    	BeanUtils.copyProperties(usr200tDto, pg301100Dto);

		rtn = pg301100Service.updatePg301100(usr200tDto);

    	if (rtn > 0) {
    		msg = "정상적으로 저장 되었습니다.";
    		close = "true";
    	} else {
    		msg = "저장시 오류가 발생 되었습니다.";
    	}

    	model.addAttribute("msg", msg);
    	model.addAttribute("close", close);
    	model.addAttribute("pg301100Info", pg301100Dto);

    	return "gbn30/pg301100Input";
    }

    @RequestMapping(value="/gbn30/pg301100Delete.ajax", method={RequestMethod.POST})
    public ResponseEntity<String> pg301100Delete(@ModelAttribute("pg301100Dto") pg301100Dto pg301100Dto, HttpSession session, Model model) throws Exception {

    	int childChk = 0;
    	int rtn = 0;
    	ResponseEntity<String> resRtn = null;

		rtn = pg301100Service.deletePg301100(pg301100Dto);

   		if (rtn == 1) {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("정상적으로 삭제 되었습니다." , "UTF-8"),HttpStatus.OK);

   			logger.info(resRtn);
   		} else {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("삭제 처리중 오류가 발생되었습니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

   			logger.info(resRtn);
   		}

    	return resRtn;
    }

}
