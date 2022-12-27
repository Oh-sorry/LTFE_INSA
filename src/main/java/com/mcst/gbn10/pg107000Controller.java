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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
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
import com.mcst.dto.gbn10.pg104500Dto;
import com.mcst.dto.gbn10.pg107000Dto;
import com.mcst.gbn10.service.pg107000Service;

import egovframework.com.EgovMessageSource;

@Controller
public class pg107000Controller {
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg107000Service")
	protected pg107000Service pg107000Service;
	
	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	/* 연봉구분 형식 (100000 -> 1,000,000) */
	public String comma(int value) {
		DecimalFormat df = new DecimalFormat("###,###");
		String value_str = df.format(value);
		return value_str;
	}
	
	/* 전화번호 변환 (01011112222 -> 010-1111-2222) */
	public static String repreNum(String src) {
		if (src == null) {
		      return "";
		}
	    return src.replaceFirst("(^[0-9]{6})([0-9]{7})$", "$1-$2");
	}
	
	@RequestMapping(value = "/gbn10/pg107000.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg107000(@ModelAttribute("pg107000Dto") pg107000Dto pg107000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {
		
		/* 재/퇴직 */
		List<pg107000Dto> pg107000DtoGbnJoinList = pg107000Service.selectPg107000GbnJoinList(pg107000Dto);
		/* 입/퇴사 연도 */
		List<pg107000Dto> pg107000DtoYearList = pg107000Service.selectpg107000DtoYearList(pg107000Dto);
		/* 입/퇴사 월 */
		List<pg107000Dto> pg107000DtoMonthList = pg107000Service.selectpg107000DtoMonthList(pg107000Dto);
		
		List<pg107000Dto> pg107000DtoList = pg107000Service.selectPg107000List(pg107000Dto);
		
		for (int i = 0; i < pg107000DtoList.size(); i++) {
			
			/* 연봉구분 형식 (100000 -> 1,000,000) */
			pg107000DtoList.get(i).setStringWagesAmt(comma(Integer.parseInt(pg107000DtoList.get(i).getWagesAmt())));
			
			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			pg107000DtoList.get(i).setJoinDate(dateUtil.formatDate(pg107000DtoList.get(i).getJoinDate(), '.'));
			if (pg107000DtoList.get(i).getRetrDate() != null) {
				pg107000DtoList.get(i).setRetrDate(dateUtil.formatDate(pg107000DtoList.get(i).getRetrDate(), '.'));
			}
			/* 주소 복호화 */
			pg107000DtoList.get(i).setKorAddr(AES128.decrypt(pg107000DtoList.get(i).getKorAddr()));
			/* 주민번호 복호화 */
			pg107000DtoList.get(i).setRepreNum(repreNum(AES128.decrypt(pg107000DtoList.get(i).getRepreNum())));
			
			if (pg107000DtoList.get(i).getRetrDate() != null) {
				pg107000DtoList.get(i).setGubun("퇴사");
			} else {
				pg107000DtoList.get(i).setGubun("입사");
			}
		}
		
		model.put("gbnJoin", pg107000DtoGbnJoinList);
		
		model.addAttribute("pernList", pg107000DtoList);
		model.addAttribute("yearList", pg107000DtoYearList);
		model.addAttribute("monthList", pg107000DtoMonthList);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg107000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg107000";
	}
	/* 엑셀 다운로드 */
	@SuppressWarnings("resource")
	@RequestMapping(value = "/gbn10/pg107000Excel.do")
	public void ExcelDownload(@ModelAttribute("pg107000Dto") pg107000Dto pg107000Dto, HttpServletResponse response) throws Exception {
		XSSFWorkbook wb = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("1page");
		int cellCount = 0;
		int rowNum = 0;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<pg107000Dto> excelDownload = pg107000Service.excelDownload(pg107000Dto);
		
		for (int i = 0; i < excelDownload.size(); i++) {
			
			/* 연봉구분 형식 (100000 -> 1,000,000) */
			excelDownload.get(i).setStringWagesAmt(comma(Integer.parseInt(excelDownload.get(i).getWagesAmt())));
			
			/* 날짜 형식 (yyyymmdd -> yyyy.mm.dd) */
			excelDownload.get(i).setJoinDate(dateUtil.formatDate(excelDownload.get(i).getJoinDate(), '.'));
			if (excelDownload.get(i).getRetrDate() != null) {
				excelDownload.get(i).setRetrDate(dateUtil.formatDate(excelDownload.get(i).getRetrDate(), '.'));
			}
			/* 주소 복호화 */
			excelDownload.get(i).setKorAddr(AES128.decrypt(excelDownload.get(i).getKorAddr()));
			/* 주민번호 복호화 */
			excelDownload.get(i).setRepreNum(repreNum(AES128.decrypt(excelDownload.get(i).getRepreNum())));
			
			if (excelDownload.get(i).getRetrDate() != null) {
				excelDownload.get(i).setGubun("퇴사");
			} else {
				excelDownload.get(i).setGubun("입사");
			}
		}
		// 열 폭 수정
		CellStyle style = wb.createCellStyle();
		style = wb.createCellStyle();
		
		sheet.setColumnWidth(3, 8000);
		sheet.setColumnWidth(7, 3000);
		sheet.setColumnWidth(9, 3000);
		sheet.setColumnWidth(10, 3000);
		sheet.setColumnWidth(11, 4000);
		sheet.setColumnWidth(12, 4000);
		
		//header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("구분");
		cell = row.createCell(1);
		cell.setCellValue("NO");
		cell = row.createCell(2);
		cell.setCellValue("사번");
		cell = row.createCell(3);
		cell.setCellValue("부서");
		cell = row.createCell(4);
		cell.setCellValue("직위");
		cell = row.createCell(5);
		cell.setCellValue("직급");
		cell = row.createCell(6);
		cell.setCellValue("근무지");
		cell = row.createCell(7);
		cell.setCellValue("입사일");
		cell = row.createCell(8);
		cell.setCellValue("주소");
		cell = row.createCell(9);
		cell.setCellValue("급여구분");
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell = row.createCell(1);
		cell = row.createCell(2);
		cell.setCellValue("성명");
		cell = row.createCell(3);
		cell = row.createCell(4);
		cell.setCellValue("주민번호");
		cell = row.createCell(5);
		cell.setCellValue("호봉");
		cell = row.createCell(6);
		cell = row.createCell(7);
		cell.setCellValue("퇴직일");
		cell = row.createCell(8);
		cell = row.createCell(9);
		cell.setCellValue("월급여");
		
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));
		sheet.addMergedRegion(new CellRangeAddress(0,1,3,3));
		sheet.addMergedRegion(new CellRangeAddress(0,1,6,6));
		sheet.addMergedRegion(new CellRangeAddress(0,1,8,8));
		
		// Body
		logger.info("사원 등록 수 :" + excelDownload.size());
		
		for (int i = 0; i < excelDownload.size(); i++) {
			row = sheet.createRow(rowNum);
			cellCount = 0;

			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getGubun());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getRnum());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPernNo());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getDeptName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPostName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPayName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getWorkAreaName());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getJoinDate());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getKorAddr());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getSalaryName());

			cellCount = 0;

			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 0, 0));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 1, 1));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 3, 3));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 6, 6));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 8, 8));

			rowNum++;
			
			row = sheet.createRow(rowNum++);
			cell = row.createCell(cellCount++);
			cell = row.createCell(cellCount++);
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getName());
			cell = row.createCell(cellCount++);
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getRepreNum());
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getPayGrade2());
			cell = row.createCell(cellCount++);
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getRetrDate());
			cell = row.createCell(cellCount++);
			cell = row.createCell(cellCount++);
			cell.setCellValue(excelDownload.get(i).getStringWagesAmt());

		}
		 

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=Join/Retr (" + sdf1.format(System.currentTimeMillis()) + ").xlsx"); // 파일이름지정.
		// response OutputStream에 엑셀 작성
		wb.write(response.getOutputStream());
		wb.close();
	}
}
