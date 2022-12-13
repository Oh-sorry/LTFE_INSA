package com.mcst.gbn10;

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
import com.mcst.dto.gbn10.pg104500Dto;
import com.mcst.gbn10.service.pg104500Service;

import egovframework.com.EgovMessageSource;

@Controller
public class pg104500Controller {

	@Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    @Resource(name = "pg104500Service")
    protected pg104500Service pg104500Service;
    
    protected static Logger logger = Logger.getLogger(Main.class.getName());
    
    @RequestMapping(value="/gbn10/pg104500.do", method={RequestMethod.GET, RequestMethod.POST})
    public String pg104500(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	
    	List<pg104500Dto> pg104500DtoGbnList = pg104500Service.selectPg104500GbnList(pg104500Dto);
    	
    	model.put("gbnList", pg104500DtoGbnList);
    	
    	return "gbn10/pg104500";
    }
    @RequestMapping(value="/gbn10/pg104500List.ajax", method={RequestMethod.POST})
    public ModelAndView pg104500List(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpSession session, Model model) throws Exception {

		List<pg104500Dto> pg104500DtoList = pg104500Service.selectPg104500List(pg104500Dto);

		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("rowData", pg104500DtoList);

		ModelAndView modelAndView = new ModelAndView("jsonView", map);
		return modelAndView;
    }
}
