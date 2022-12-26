package com.mcst.gbn10;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.AES128.AES128;
import com.mcst.common.dateUtil;
import com.mcst.dto.gbn10.pg104500Dto;
import com.mcst.dto.gbn10.pg105500Dto;
import com.mcst.gbn10.service.pg105500Service;

import egovframework.com.EgovMessageSource;

@Controller
public class pg105500Controller {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "pg105500Service")
	protected pg105500Service pg105500Service;
	
	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	@RequestMapping(value = "/gbn10/pg105500.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg105500(@ModelAttribute("pg105500Dto") pg105500Dto pg105500Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
	
		List<pg105500Dto> pg105500DtoList = pg105500Service.selectPg105500List(pg105500Dto);
		
		/* 부서 앞/뒤 */
		List<pg105500Dto> pg105500DtoDeptList1 = pg105500Service.selectPg105500DeptList1(pg105500Dto);
		List<pg105500Dto> pg105500DtoDeptList2 = pg105500Service.selectPg105500DeptList2(pg105500Dto);
		/* 직위 */
		List<pg105500Dto> pg105500DtoGbnList2 = pg105500Service.selectPg105500GbnList2(pg105500Dto);
		/* 근무처 */
		List<pg105500Dto> pg105500DtoGbnList3 = pg105500Service.selectPg105500GbnList3(pg105500Dto);
		/* 급여구분 */
		List<pg105500Dto> pg105500DtoGbnList4 = pg105500Service.selectPg105500GbnList4(pg105500Dto);
		
		
		
		for (int i = 0; i < pg105500DtoList.size(); i++) {
			
			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			pg105500DtoList.get(i).setJoinDate(dateUtil.formatDate(pg105500DtoList.get(i).getJoinDate(), '.'));
			if (pg105500DtoList.get(i).getPayGradeDate() != null) {
				pg105500DtoList.get(i).setPayGradeDate(dateUtil.formatDate(pg105500DtoList.get(i).getPayGradeDate(), '.'));
			} else {
				pg105500DtoList.get(i).setPayGradeDate(" ");
			}
			if (pg105500DtoList.get(i).getPayGrade2Date() != null) {
				pg105500DtoList.get(i).setPayGrade2Date(dateUtil.formatDate(pg105500DtoList.get(i).getPayGrade2Date(), '.'));
			} else {
				pg105500DtoList.get(i).setPayGrade2Date(" ");
			}
			if (pg105500DtoList.get(i).getCareerSDate() != null) {
				pg105500DtoList.get(i).setCareerSDate(dateUtil.formatDate(pg105500DtoList.get(i).getCareerSDate(), '.'));
			} else {
				pg105500DtoList.get(i).setCareerSDate(" ");
			}
			
			/* 경력 계산 */
			pg105500DtoList.get(i).setCareer(pg105500DtoList.get(i).getCareerYear()+"년 " + pg105500DtoList.get(i).getCareerMonth()+"월");
		}
		
		model.addAttribute("pernList", pg105500DtoList);
		
		model.addAttribute("deptList1", pg105500DtoDeptList1);
		model.addAttribute("deptList2", pg105500DtoDeptList2);
		model.addAttribute("gbnList2", pg105500DtoGbnList2);
		model.addAttribute("gbnList3", pg105500DtoGbnList3);
		model.addAttribute("gbnList4", pg105500DtoGbnList4);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg105500Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg105500";
	}
	
	/* 엑셀 다운로드 */
	@SuppressWarnings("resource")
	@RequestMapping(value = "/gbn10/pg105500Excel.do")
	public void ExcelDownload(@ModelAttribute("pg105500Dto") pg105500Dto pg105500Dto, HttpServletResponse response) throws Exception {
		XSSFWorkbook wb = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("1page");
		int cellCount = 0;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<pg105500Dto> excelDownload = pg105500Service.excelDownload(pg105500Dto);
		
		for (int i = 0; i < excelDownload.size(); i++) {

			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			excelDownload.get(i).setJoinDate(dateUtil.formatDate(excelDownload.get(i).getJoinDate(), '.'));
			if (excelDownload.get(i).getPayGradeDate() != null) {
				excelDownload.get(i).setPayGradeDate(dateUtil.formatDate(excelDownload.get(i).getPayGradeDate(), '.'));
			} else {
				excelDownload.get(i).setPayGradeDate(" ");
			}
			if (excelDownload.get(i).getPayGrade2Date() != null) {
				excelDownload.get(i).setPayGrade2Date(dateUtil.formatDate(excelDownload.get(i).getPayGrade2Date(), '.'));
			} else {
				excelDownload.get(i).setPayGrade2Date(" ");
			}
			if (excelDownload.get(i).getCareerSDate() != null) {
				excelDownload.get(i).setCareerSDate(dateUtil.formatDate(excelDownload.get(i).getCareerSDate(), '.'));
			} else {
				excelDownload.get(i).setCareerSDate(" ");
			}
			
			/* 경력 계산 */
			excelDownload.get(i).setCareer(excelDownload.get(i).getCareerYear()+"년 " + excelDownload.get(i).getCareerMonth()+"월");

		}
		// 열 폭 수정
		CellStyle style = wb.createCellStyle();
		style = wb.createCellStyle();
		
		sheet.setColumnWidth(2, 8000);
		/*
		 * sheet.setColumnWidth(7, 3000); sheet.setColumnWidth(9, 3000);
		 * sheet.setColumnWidth(10, 3000); sheet.setColumnWidth(11, 4000);
		 * sheet.setColumnWidth(12, 4000);
		 */
		
		//header
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("사번");
		cell = row.createCell(1);
		cell.setCellValue("성명");
		cell = row.createCell(2);
		cell.setCellValue("부서");
		cell = row.createCell(3);
		cell.setCellValue("직위");
		cell = row.createCell(4);
		cell.setCellValue("급여구분");
		cell = row.createCell(5);
		cell.setCellValue("직급");
		cell = row.createCell(6);
		cell.setCellValue("호봉");
		cell = row.createCell(7);
		cell.setCellValue("나이");
		cell = row.createCell(8);
		cell.setCellValue("입사일");
		cell = row.createCell(9);
		cell.setCellValue("승급일");
		cell = row.createCell(10);
		cell.setCellValue("승호일");
		cell = row.createCell(11);
		cell.setCellValue("경력시작일");
		cell = row.createCell(12);
		cell.setCellValue("경력");
		
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
			cell.setCellValue(excelDownload.get(i).getDeptName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPostName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getSalaryName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPayName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getHobong());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getAge());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getJoinDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPayGradeDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPayGrade2Date());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getCareerSDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getCareer());
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=Career (" + sdf1.format(System.currentTimeMillis()) + ").xlsx"); // 파일이름지정.
		// response OutputStream에 엑셀 작성
		wb.write(response.getOutputStream());
		wb.close();
	}
}
