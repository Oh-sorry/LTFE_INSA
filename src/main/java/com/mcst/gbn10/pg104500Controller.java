package com.mcst.gbn10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcst.main.service.mainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.AES128.AES128;
import com.mcst.common.dateUtil;
import com.mcst.common.stringUtil;
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

	@RequestMapping(value = "/gbn10/pg104500.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg104500(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) throws Exception {
		/* 재/퇴직 */
		List<pg104500Dto> pg104500DtoGbnJoinList = pg104500Service.selectPg104500GbnJoinList(pg104500Dto);
		/* 부서 */
		List<pg104500Dto> pg104500DtoGbnList = pg104500Service.selectPg104500GbnList(pg104500Dto);
		/* 부서 앞/뒤 */
		List<pg104500Dto> pg104500DtoDeptList1 = pg104500Service.selectPg104500DeptList1(pg104500Dto);
		List<pg104500Dto> pg104500DtoDeptList2 = pg104500Service.selectPg104500DeptList2(pg104500Dto);
		/* 직위 */
		List<pg104500Dto> pg104500DtoGbnList2 = pg104500Service.selectPg104500GbnList2(pg104500Dto);
		/* 직급 */
		List<pg104500Dto> pg104500DtoGbnList3 = pg104500Service.selectPg104500GbnList3(pg104500Dto);
		/* 급여구분 */
		List<pg104500Dto> pg104500DtoGbnList4 = pg104500Service.selectPg104500GbnList4(pg104500Dto);

		
		List<pg104500Dto> pg104500DtoList = pg104500Service.selectPg104500List(pg104500Dto);
		
		for (int i = 0; i < pg104500DtoList.size(); i++) {

			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			pg104500DtoList.get(i).setJoinDate(dateUtil.formatDate(pg104500DtoList.get(i).getJoinDate(), '.'));
			if (pg104500DtoList.get(i).getRetrDate() != null) {
				pg104500DtoList.get(i).setRetrDate(dateUtil.formatDate(pg104500DtoList.get(i).getRetrDate(), '.'));
			}

			/* 전화번호 decode */
			pg104500DtoList.get(i).setPhoneNo(stringUtil.formatPhone(AES128.decrypt(pg104500DtoList.get(i).getPhoneNo())));

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
			
			/* 생년월일 복호화 */
			pg104500DtoList.get(i).setBirtDate(AES128.decrypt(pg104500DtoList.get(i).getBirtDate()));
		}

		model.put("gbnList", pg104500DtoGbnList);
		model.addAttribute("deptList1", pg104500DtoDeptList1);
		model.addAttribute("deptList2", pg104500DtoDeptList2);
		model.put("gbnList2", pg104500DtoGbnList2);
		model.put("gbnList3", pg104500DtoGbnList3);
		model.put("gbnList4", pg104500DtoGbnList4);
		model.put("gbnJoin", pg104500DtoGbnJoinList);
		model.addAttribute("pernList", pg104500DtoList);

		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg104500Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg104500";
	}

	/* 엑셀 다운로드 */
	@SuppressWarnings("resource")
	@RequestMapping(value = "/gbn10/pg104500Excel.do")
	public void ExcelDownload(@ModelAttribute("pg104500Dto") pg104500Dto pg104500Dto, HttpServletResponse response) throws Exception {
		XSSFWorkbook wb = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("1page");
		int cellCount = 0;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<pg104500Dto> excelDownload = pg104500Service.excelDownload(pg104500Dto);
		
		for (int i = 0; i < excelDownload.size(); i++) {

			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			excelDownload.get(i).setJoinDate(dateUtil.formatDate(excelDownload.get(i).getJoinDate(), '.'));
			if (excelDownload.get(i).getRetrDate() != null) {
				excelDownload.get(i).setRetrDate(dateUtil.formatDate(excelDownload.get(i).getRetrDate(), '.'));
			}

			/* 전화번호 decode */
			excelDownload.get(i).setPhoneNo(stringUtil.formatPhone(AES128.decrypt(excelDownload.get(i).getPhoneNo())));

			/* 남/여 구분 */
			if(excelDownload.get(i).getSexCode().equals("1")) {
				excelDownload.get(i).setSexCode("남");
			} else {
				excelDownload.get(i).setSexCode("여");
			}
			
			/* 상조회 구분 */
			if(excelDownload.get(i).getMutualYn().equals("1")) {
				excelDownload.get(i).setMutualYn("Y");
			} else {
				excelDownload.get(i).setMutualYn("N");
			}
			
			/* 생년월일 복호화 */
			excelDownload.get(i).setBirtDate(AES128.decrypt(excelDownload.get(i).getBirtDate()));
		}
		// 열 폭 수정
		CellStyle style = wb.createCellStyle();
		style = wb.createCellStyle();
		
		sheet.setColumnWidth(4, 8000);
		sheet.setColumnWidth(8, 3000);
		sheet.setColumnWidth(10, 3000);
		sheet.setColumnWidth(11, 3000);
		sheet.setColumnWidth(12, 4000);
		sheet.setColumnWidth(13, 4000);
		
		//header
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("사번");
		cell = row.createCell(1);
		cell.setCellValue("성명");
		cell = row.createCell(2);
		cell.setCellValue("생년월일");
		cell = row.createCell(3);
		cell.setCellValue("성별");
		cell = row.createCell(4);
		cell.setCellValue("부서");
		cell = row.createCell(5);
		cell.setCellValue("직위");
		cell = row.createCell(6);
		cell.setCellValue("입사구분");
		cell = row.createCell(7);
		cell.setCellValue("사원구분");
		cell = row.createCell(8);
		cell.setCellValue("급여구분");
		cell = row.createCell(9);
		cell.setCellValue("연봉구분");
		cell = row.createCell(10);
		cell.setCellValue("입사일자");
		cell = row.createCell(11);
		cell.setCellValue("퇴사일자");
		cell = row.createCell(12);
		cell.setCellValue("근무지");
		cell = row.createCell(13);
		cell.setCellValue("핸드폰");
		cell = row.createCell(14);
		cell.setCellValue("상조회");
		
		// Body
		logger.info("사원 등록 수 :" + excelDownload.size());
		
		for (int i = 0; i < excelDownload.size(); i++) {
			row = sheet.createRow(i + 1);
			cellCount = 0;
			cell = row.createCell(cellCount++);
			
			cell.setCellValue(excelDownload.get(i).getPernNo());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getBirtDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getSexCode());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getDeptName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPostName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getJoinName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getEmployName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getSalaryName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getWagesAmt());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getJoinDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getRetrDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getWorkAreaName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPhoneNo());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getMutualYn());
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=INSA (" + sdf1.format(System.currentTimeMillis()) + ").xlsx"); // 파일이름지정.
		// response OutputStream에 엑셀 작성
		wb.write(response.getOutputStream());
		wb.close();
	}
	

}
	
