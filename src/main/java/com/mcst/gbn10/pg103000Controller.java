package com.mcst.gbn10;

import java.util.List;

import javax.annotation.Resource;
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

import com.mcst.dto.gbn10.pg103000Dto;
import com.mcst.gbn10.service.pg103000Service;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;

@Controller
public class pg103000Controller {
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg103000Service")
	protected pg103000Service pg103000Service;
	
	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	@RequestMapping(value = "/gbn10/pg103000.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg103000(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		
		List<pg103000Dto> pg107000DtoList = pg103000Service.selectPg103000List(pg103000Dto);
		
		model.addAttribute("pernList", pg107000DtoList);
		
		return "gbn10/pg103000";
	}
}
