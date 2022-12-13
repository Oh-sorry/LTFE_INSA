package com.mcst.main;

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

import com.mcst.dto.loginDto;
import com.mcst.dto.loginMenuAuthDto;
import com.mcst.main.service.mainService;

import egovframework.com.EgovMessageSource;
import egovframework.com.EgovUserDetailsHelper;

@Controller
public class mainControll {

    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    protected static Logger logger = Logger.getLogger(Main.class.getName());

    @RequestMapping(value="/login.do", method={RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	loginDto loginDto = (loginDto) EgovUserDetailsHelper.getAuthenticatedUser();

		if (loginDto.getPernNo() != null) {
			return "redirect:/main.do";
		} else {
			String referrer = request.getHeader("Referer");
			request.getSession().setAttribute("prevPage", referrer);

			return "login";
		}
    }

    @RequestMapping(value="/loginChk.do", method={RequestMethod.POST})
    public String loginChk(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, @ModelAttribute("loginDto") loginDto loginDto, ModelMap model) throws Exception {

		logger.info("getPernNo => "+ loginDto.getPernNo());
		logger.info("getPernPwd => "+ loginDto.getPernPwd());

    	int rtn = mainService.selectLoginChk(loginDto);

    	logger.info("rtn => "+ rtn);

		if (rtn == 1) {
			loginDto loginInfoDto = mainService.selectLoginInfo(loginDto);

			logger.info("getPernNo => "+ loginInfoDto.getPernNo());
			logger.info("getName => "+ loginInfoDto.getName());
			logger.info("getPernAuth => "+ loginInfoDto.getPernAuth());

			List<loginMenuAuthDto> loginMenuAuthListDto = mainService.selectMenuAuth(loginDto);

			session.setAttribute("loginDto", loginInfoDto);
			session.setAttribute("loginMenuListDto", loginMenuAuthListDto);

			String redirectUrl = (String) session.getAttribute("prevPage");

			if (redirectUrl != null) {
				session.removeAttribute("prevPage");
				return "redirect:"+redirectUrl;
			} else {
				return "redirect:/main.do";
			}

			//return "login";

		} else {
			model.addAttribute("message", "로그인 정보가 올바르지 않습니다");
	    	return "login";
		}
    }

    @RequestMapping(value="/logOut.do", method={RequestMethod.GET,RequestMethod.POST})
    public String logOut(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

    	//loginDto loginDto = null;
    	//session.setAttribute("loginDto", loginDto);
    	session.invalidate();

   		return "forward:/login.do";
    }

    @RequestMapping(value="/main.do", method={RequestMethod.GET,RequestMethod.POST})
    public String main(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
    	loginDto loginDto = (loginDto) EgovUserDetailsHelper.getAuthenticatedUser();

		if (loginDto.getPernNo() != null) {
			return "main";
		} else {
			return "login";
		}
    }

}
