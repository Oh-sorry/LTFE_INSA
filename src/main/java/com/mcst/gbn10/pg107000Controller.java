package com.mcst.gbn10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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
import com.mcst.common.stringUtil;
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
	
	@RequestMapping(value = "/gbn10/pg107000.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg107000(@ModelAttribute("pg107000Dto") pg107000Dto pg107000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

		List<pg107000Dto> pg107000DtoList = pg107000Service.selectPg107000List(pg107000Dto);
		
		/* ???/?????? */
		List<pg107000Dto> pg107000DtoGbnJoinList = pg107000Service.selectPg107000GbnJoinList(pg107000Dto);
		/* ???/?????? ?????? */
		List<pg107000Dto> pg107000DtoYearList = pg107000Service.selectpg107000DtoYearList(pg107000Dto);
		/* ???/?????? ??? */
		List<pg107000Dto> pg107000DtoMonthList = pg107000Service.selectpg107000DtoMonthList(pg107000Dto);
		/* ???/?????? ????????? */
		List<pg107000Dto> pg107000DtoJoinCount = pg107000Service.selectpg107000DtoJoinCount(pg107000Dto);
		List<pg107000Dto> pg107000DtoRetrCount = pg107000Service.selectpg107000DtoRetrCount(pg107000Dto);
		
		for (int i = 0; i < pg107000DtoList.size(); i++) {
			
			/* ?????? ?????? (yyyymmdd -> yyyy.mm.dd) */
			pg107000DtoList.get(i).setJoinDate(dateUtil.formatDate(pg107000DtoList.get(i).getJoinDate(), '.'));
			if (pg107000DtoList.get(i).getRetrDate() != null) {
				pg107000DtoList.get(i).setRetrDate(dateUtil.formatDate(pg107000DtoList.get(i).getRetrDate(), '.'));
			}
			/* ?????? ????????? */
			pg107000DtoList.get(i).setKorAddr(AES128.decrypt(pg107000DtoList.get(i).getKorAddr()));
			/* ???????????? ????????? */
			pg107000DtoList.get(i).setRepreNum(stringUtil.repreNum(AES128.decrypt(pg107000DtoList.get(i).getRepreNum())));
			
			/* ?????? : ???/?????? */
			if (pg107000DtoList.get(i).getRetrDate() != null) {
				pg107000DtoList.get(i).setGubun("??????");
			} else {
				pg107000DtoList.get(i).setGubun("??????");
			}
			
		}

		model.addAttribute("pernList", pg107000DtoList);
		
		model.put("gbnJoin", pg107000DtoGbnJoinList);
		model.addAttribute("yearList", pg107000DtoYearList);
		model.addAttribute("monthList", pg107000DtoMonthList);
		model.addAttribute("joinCount", pg107000DtoJoinCount.get(0).getJoinCount());
		model.addAttribute("retrCount", pg107000DtoRetrCount.get(0).getRetrCount());
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg107000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg107000";
	}
	/* ?????? ???????????? */
	@SuppressWarnings("resource")
	@RequestMapping(value = "/gbn10/pg107000Excel.do")
	public void ExcelDownload(@ModelAttribute("pg107000Dto") pg107000Dto pg107000Dto, HttpServletResponse response) throws Exception {
		
		Cookie cookie = new Cookie("fileDownloadToken", "TRUE");
		response.addCookie(cookie);
		
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
			
			/* ?????? ?????? (yyyymmdd -> yyyy.mm.dd) */
			excelDownload.get(i).setJoinDate(dateUtil.formatDate(excelDownload.get(i).getJoinDate(), '.'));
			if (excelDownload.get(i).getRetrDate() != null) {
				excelDownload.get(i).setRetrDate(dateUtil.formatDate(excelDownload.get(i).getRetrDate(), '.'));
			}
			/* ?????? ????????? */
			excelDownload.get(i).setKorAddr(AES128.decrypt(excelDownload.get(i).getKorAddr()));
			/* ???????????? ????????? */
			excelDownload.get(i).setRepreNum(stringUtil.repreNum(AES128.decrypt(excelDownload.get(i).getRepreNum())));
			
			if (excelDownload.get(i).getRetrDate() != null) {
				excelDownload.get(i).setGubun("??????");
			} else {
				excelDownload.get(i).setGubun("??????");
			}
		}
		// ??? ??? ??????
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
		cell.setCellValue("??????");
		cell = row.createCell(1);
		cell.setCellValue("NO");
		cell = row.createCell(2);
		cell.setCellValue("??????");
		cell = row.createCell(3);
		cell.setCellValue("??????");
		cell = row.createCell(4);
		cell.setCellValue("??????");
		cell = row.createCell(5);
		cell.setCellValue("??????");
		cell = row.createCell(6);
		cell.setCellValue("?????????");
		cell = row.createCell(7);
		cell.setCellValue("?????????");
		cell = row.createCell(8);
		cell.setCellValue("??????");
		cell = row.createCell(9);
		cell.setCellValue("????????????");
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell = row.createCell(1);
		cell = row.createCell(2);
		cell.setCellValue("??????");
		cell = row.createCell(3);
		cell = row.createCell(4);
		cell.setCellValue("????????????");
		cell = row.createCell(5);
		cell.setCellValue("??????");
		cell = row.createCell(6);
		cell = row.createCell(7);
		cell.setCellValue("?????????");
		cell = row.createCell(8);
		cell = row.createCell(9);
		cell.setCellValue("?????????");
		
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));
		sheet.addMergedRegion(new CellRangeAddress(0,1,3,3));
		sheet.addMergedRegion(new CellRangeAddress(0,1,6,6));
		sheet.addMergedRegion(new CellRangeAddress(0,1,8,8));
		
		// Body
		logger.info("?????? ?????? ??? :" + excelDownload.size());
		
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
			cell.setCellValue(excelDownload.get(i).getWagesAmt());

		}
		 

		// ????????? ????????? ????????? ??????
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=Join/Retr (" + sdf1.format(System.currentTimeMillis()) + ").xlsx"); // ??????????????????.
		// response OutputStream??? ?????? ??????
		wb.write(response.getOutputStream());
		wb.close();
	}
}
