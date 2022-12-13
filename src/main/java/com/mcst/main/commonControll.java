package com.mcst.main;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcst.dto.nameSearchDto;
import com.mcst.main.service.commonService;

import egovframework.com.EgovMessageSource;

@Controller
public class commonControll {

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "commonService")
	private commonService commonService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    protected static Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping(value="/nameSearch.ajax", method={RequestMethod.GET})
    public @ResponseBody Map nameSearch(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, Model model) throws Exception {

    	logger.info(request.getParameter("term"));

    	String searchName = request.getParameter("term");

    	nameSearchDto nameSearchDto = new nameSearchDto();

    	nameSearchDto.setSearchName(searchName);

    	List<nameSearchDto> nameSearchDtoList = commonService.selectSearchName(nameSearchDto);

    	Map<String, Object> result = new HashMap<String, Object>();

    	for (int i = 0; i < nameSearchDtoList.size(); i++) {
    		result.put(nameSearchDtoList.get(i).getPernNo(), nameSearchDtoList.get(i).getName());

    		// logger.info(nameSearchDtoList.get(i).getName());
    	}

		return result;
    }

}
