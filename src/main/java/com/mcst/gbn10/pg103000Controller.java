package com.mcst.gbn10;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.AES128.AES128;
import com.mcst.common.dateUtil;
import com.mcst.common.stringUtil;
import com.mcst.dto.db.hzz140tDto;
import com.mcst.dto.gbn10.pg102000Dto;
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
	public String pg103000(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) throws Exception {
		
		Cookie cookie = new Cookie("fileDownloadToken", "TRUE");
		response.addCookie(cookie);
		
		/* 부서 검색 */
		List<pg103000Dto> pg103000DtoDeptList1 = pg103000Service.selectPg103000DetpList1(pg103000Dto);
		List<pg103000Dto> pg103000DtoDeptList2 = pg103000Service.selectPg103000DetpList2(pg103000Dto);
		
		/* 증명구분 검색 */
		List<pg103000Dto> pg103000DtoCertGbn = pg103000Service.selectPg103000CertGbn(pg103000Dto);

		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg103000Dto, Map.class);
		
		/* 페이징 */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pg103000Dto.getPageIndex()); //1
		paginationInfo.setRecordCountPerPage(pg103000Dto.getPageUnit()); //10
		paginationInfo.setPageSize(pg103000Dto.getPageSize()); //10
		
		/* 전체 게시글 수 확인 */
		int totCnt = pg103000Service.pageListCnt(pg103000Dto);
		paginationInfo.setTotalRecordCount(totCnt);
		
		pg103000Dto.setFirstIndex(paginationInfo.getFirstRecordIndex()); 
		pg103000Dto.setLastIndex(paginationInfo.getLastRecordIndex()); 
		pg103000Dto.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		/* 뒤로/앞으로 버튼 */
		pg103000Dto.setStartDate(paginationInfo.getFirstPageNoOnPageList());
		int end = paginationInfo.getFirstPageNoOnPageList() + pg103000Dto.getPageSize()-1;
		pg103000Dto.setEndDate(end);
		int realEnd = (int)(Math.ceil((paginationInfo.getTotalRecordCount() * 1.0)/ (double)pg103000Dto.getPageUnit()));
		boolean xprev = pg103000Dto.getStartDate() > 1;
		boolean xnext = pg103000Dto.getEndDate() < realEnd;
		pg103000Dto.setPrev(xprev);
		pg103000Dto.setNext(xnext);
		
		List<pg103000Dto> pg103000DtoList = pg103000Service.selectPg103000List(pg103000Dto);
		
		for(int i=0; i<pg103000DtoList.size(); i++) {
			
			/* 성명 decode */
			pg103000DtoList.get(i).setUsrname(AES128.decrypt(pg103000DtoList.get(i).getUsrname()));
			
			/*주민번호 decode -> '-'처리*/
			pg103000DtoList.get(i).setUsrrepreNum(stringUtil.repreNum(AES128.decrypt(pg103000DtoList.get(i).getUsrrepreNum())));
			
			/*날짜 '.' 처리*/
			pg103000DtoList.get(i).setExpDate(dateUtil.formatDate(pg103000DtoList.get(i).getExpDate(), '.'));
			pg103000DtoList.get(i).setJoinDate(dateUtil.formatDate(pg103000DtoList.get(i).getJoinDate(), '.'));
			if(pg103000DtoList.get(i).getRetrDate() != null) {
				pg103000DtoList.get(i).setRetrDate(dateUtil.formatDate(pg103000DtoList.get(i).getRetrDate(), '.'));
			} else {
				pg103000DtoList.get(i).setRetrDate(" ");
			}
			
			pg103000DtoList.get(i).setHanDate(dateUtil.formatDate(pg103000DtoList.get(i).getHanDate(), '.'));
			
			/*증명 구분*/
			if(pg103000DtoList.get(i).getCertGbn().equals("1")) {
				pg103000DtoList.get(i).setCertGbn("신입");
			} else if(pg103000DtoList.get(i).getCertGbn().equals("2")) {
				pg103000DtoList.get(i).setCertGbn("경력");
			} else {
				pg103000DtoList.get(i).setCertGbn(" ");
			}
			
		}
		
		model.addAttribute("searchFormData", result);
		model.addAttribute("pernList", pg103000DtoList);
		model.addAttribute("deptList1", pg103000DtoDeptList1);
		model.addAttribute("deptList2", pg103000DtoDeptList2);
		model.addAttribute("certList", pg103000DtoCertGbn);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("totalPageCnt",(int)Math.ceil(totCnt / (double)pg103000Dto.getPageUnit()));
	    model.addAttribute("paginationInfo",paginationInfo);
		
		return "gbn10/pg103000";
	}
	
	@RequestMapping(value = "/gbn10/pg103000Input.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg103000Input(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, ModelMap model) throws Exception {
		
		model.addAttribute("processType","INSERT");
		
		return "gbn10/pg103000Input";
	}
	
	@RequestMapping(value = "/gbn10/pg103000Save.do", method={RequestMethod.GET,RequestMethod.POST})
	public String pg103000Save(final MultipartHttpServletRequest multiRequest, @ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception{

		if (pg103000Dto.getWorkPeriod1().equals("")) {
			pg103000Dto.setWorkPeriod1(null);
		}
		if (pg103000Dto.getWorkPeriod2().equals("")) {
			pg103000Dto.setWorkPeriod2(null);
		}
		if (pg103000Dto.getWorkPeriod3().equals("")) {
			pg103000Dto.setWorkPeriod3(null);
		}
		if (pg103000Dto.getUsrfield1().equals(" ")) {
			pg103000Dto.setUsrfield1(null);
		}
		if (pg103000Dto.getUsrfield2().equals(" ")) {
			pg103000Dto.setUsrfield2(null);
		}
		
		String msg = "";
		String close = "";
		int dupChk = 0;
		int rtn = 0;		
		
		if ("INSERT".equals(pg103000Dto.getProcessType())) {			
			dupChk = pg103000Service.selectPg103000Check(pg103000Dto);
		}
		
		hzz140tDto hzz140tDto = new hzz140tDto();
		
		BeanUtils.copyProperties(hzz140tDto, pg103000Dto);
		
		hzz140tDto.setUsrname(AES128.encrypt(pg103000Dto.getUsrname()));
		hzz140tDto.setUsrrepreNum(AES128.encrypt(pg103000Dto.getUsrrepreNum()));
		hzz140tDto.setUsrbirth(AES128.encrypt(pg103000Dto.getUsrbirth()));
		hzz140tDto.setUsraddr(AES128.encrypt(pg103000Dto.getUsraddr()));
		
		if (dupChk > 0) {
			msg = "이미 입력된 정보가 존재합니다.";
		} else {
			rtn = pg103000Service.updatePg103000(hzz140tDto);
			
			if (rtn > 0) {
	    		msg = "정상적으로 저장 되었습니다.";
	    		close = "true";
	    	} else {
	    		msg = "저장시 오류가 발생 되었습니다.";
	    	}
		}
		
		model.addAttribute("msg", msg);
    	model.addAttribute("close", close);
    	model.addAttribute("pg103000Info", pg103000Dto);
    	
		return "gbn10/pg103000Input";
	}
	
	@RequestMapping(value = "/gbn10/pg103000Search.do", method={RequestMethod.GET,RequestMethod.POST})
	public String pg103000Search(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, HttpServletResponse response, ModelMap model) throws Exception{
		
		List<pg103000Dto> pg103000DtoSearchList = pg103000Service.selectPg103000SearchList(pg103000Dto);
		
		for(int i=0; i<pg103000DtoSearchList.size(); i++) {
			/*주민번호 decode -> '-'처리*/
			pg103000DtoSearchList.get(i).setUsrrepreNum(stringUtil.repreNum(AES128.decrypt(pg103000DtoSearchList.get(i).getUsrrepreNum())));
			
			/* 사원 주소 */
			pg103000DtoSearchList.get(i).setUsraddr(AES128.decrypt(pg103000DtoSearchList.get(i).getUsraddr()));
			
			/* 사원 생년월일 */
			pg103000DtoSearchList.get(i).setUsrbirth(dateUtil.formatDate((AES128.decrypt(pg103000DtoSearchList.get(i).getUsrbirth())), '-'));
			
		}
		
		model.addAttribute("searchList", pg103000DtoSearchList);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg103000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg103000Search";
	}
	
	@RequestMapping(value = "/gbn10/pg103000Modify.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg103000Modify(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, ModelMap model) throws Exception {
		
		model.addAttribute("processType","UPDATE");
		
		pg103000Dto pg103000DtoInfo = pg103000Service.selectPg103000Info(pg103000Dto);
		
		/* 사원 성명 */
		pg103000DtoInfo.setUsrname(AES128.decrypt(pg103000DtoInfo.getUsrname()));
		/* 주민번호 */
		pg103000DtoInfo.setUsrrepreNum(stringUtil.repreNum(AES128.decrypt(pg103000DtoInfo.getUsrrepreNum())));
		/*주소*/
		pg103000DtoInfo.setUsraddr(AES128.decrypt(pg103000DtoInfo.getUsraddr()));
		/* 생년월일 */
		pg103000DtoInfo.setUsrbirth(AES128.decrypt(pg103000DtoInfo.getUsrbirth()));
		
		/* 신청일/처리일 */
		pg103000DtoInfo.setExpDate(dateUtil.formatDate((pg103000DtoInfo.getExpDate()), '-'));
		pg103000DtoInfo.setHanDate(dateUtil.formatDate((pg103000DtoInfo.getHanDate()), '-'));
		
		model.addAttribute("pg103000Info", pg103000DtoInfo);
		
		return "gbn10/pg103000Input";
	}

	@RequestMapping(value = "/gbn10/pg103000Delete.ajax", method={RequestMethod.POST})
	public ResponseEntity<String> pg103000Delete(@ModelAttribute("pg103000Dto") pg103000Dto pg103000Dto, HttpSession session, ModelMap model) throws Exception {
		
		int rtn =0;
		ResponseEntity<String> resRtn = null;
		
		rtn = pg103000Service.deletePg103000(pg103000Dto);
		
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
