package com.mcst.gbn10;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcst.dto.gbn10.pg109503Dto;
import com.mcst.gbn10.service.pg109503Service;
import com.mcst.main.service.mainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.AES128.AES128;
import com.mcst.common.dateUtil;
import com.mcst.common.stringUtil;

import egovframework.com.EgovMessageSource;

@Controller
public class pg109503Controller {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg109503Service")
	private pg109503Service pg109503Service;

	protected static Logger logger = Logger.getLogger(Main.class.getName());

	@RequestMapping(value = "/gbn10/pg109503.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg109503(@ModelAttribute("pg109503Dto") pg109503Dto pg109503Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

		List<pg109503Dto> pg109503DtoOrgList = pg109503Service.selectPg109503OrgList(pg109503Dto);

		for (int i = 0; i < pg109503DtoOrgList.size(); i++) {

			// ?????????
			if (pg109503DtoOrgList.get(i).getDeptFullName() != null) {
				pg109503DtoOrgList.get(i).setDeptFullName(pg109503DtoOrgList.get(i).getDeptFullName().replace(" ", "<br>"));
			}			

			// ????????????, ?????????
			pg109503DtoOrgList.get(i).setJoinDate(dateUtil.formatDate(pg109503DtoOrgList.get(i).getJoinDate(), '.'));
			if (!pg109503DtoOrgList.get(i).getRetrDate().trim().contains("-")) {
				pg109503DtoOrgList.get(i).setRetrDate(dateUtil.formatDate(pg109503DtoOrgList.get(i).getRetrDate(), '.'));
			}

			// ?????????
			if (pg109503DtoOrgList.get(i).getWorkArea() != null) {
				pg109503DtoOrgList.get(i).setWorkArea(pg109503DtoOrgList.get(i).getWorkArea().replace("(", "<br>("));
			}

			// ?????????, ?????????
			if (!pg109503DtoOrgList.get(i).getPayGradeDate().trim().contains("-")) {
				pg109503DtoOrgList.get(i).setPayGradeDate(dateUtil.formatDate(pg109503DtoOrgList.get(i).getPayGradeDate(), '.'));
			}
			if (!pg109503DtoOrgList.get(i).getPayGradeDate2().trim().contains("-")) {
				pg109503DtoOrgList.get(i).setPayGradeDate2(dateUtil.formatDate(pg109503DtoOrgList.get(i).getPayGradeDate2(), '.'));
			}

			// ????????????, ???????????????
			pg109503DtoOrgList.get(i).setTelephone(stringUtil.formatPhone(AES128.decrypt(pg109503DtoOrgList.get(i).getTelephone())));
			pg109503DtoOrgList.get(i).setPhoneNo(stringUtil.formatPhone(AES128.decrypt(pg109503DtoOrgList.get(i).getPhoneNo())));

		}
		model.put("organizationList", pg109503DtoOrgList);

		List<pg109503Dto> pg109503DtoDeptList1 = pg109503Service.selectPg109503DeptList1(pg109503Dto);
		model.put("deptList1", pg109503DtoDeptList1);

		List<pg109503Dto> pg109503DtoDeptList2 = pg109503Service.selectPg109503DeptList2(pg109503Dto);
		model.put("deptList2", pg109503DtoDeptList2);

		// ????????? ???????????? ???????????? ????????? ????????? ????????? ???????????? ??????
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg109503Dto, Map.class);
		model.addAttribute("searchFormData", result);

		return "gbn10/pg109503";
	}

	@RequestMapping("/gbn10/pg109503excelDownload.do")
	public void pg109503excelDownload(@ModelAttribute("pg109503Dto") pg109503Dto pg109503Dto, HttpServletResponse response)	throws Exception {

		Cookie cookie = new Cookie("fileDownloadToken", "TRUE");
		response.addCookie(cookie);

		List<Map<String, Object>> excelList = pg109503Service.excelList(pg109503Dto);
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("????????? ??????");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);

		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setWrapText(true);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// Header
		row = sheet.createRow(rowNum++);
		row.setHeight((short) 480);
		cell = row.createCell(0);
		cell.setCellValue("No");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(1);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(2);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(3);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(7);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(8);
		cell.setCellValue("?????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(9);
		cell.setCellValue("?????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(10);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);

		row = sheet.createRow(rowNum++);
		row.setHeight((short) 480);
		cell = row.createCell(0);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(1);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(2);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(3);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);
		cell.setCellValue("??????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);
		cell.setCellValue("????????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(7);
		cell.setCellValue("?????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(8);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(9);
		cell.setCellValue("?????????");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(10);
		cell.setCellValue("???????????????");
		cell.setCellStyle(headerStyle);

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));

		// Body
		for (int i = 0; i < excelList.size(); i++) {
			row = sheet.createRow(rowNum);
			row.setHeight((short) 480);
			cell = row.createCell(0);
			cell.setCellValue(String.valueOf(excelList.get(i).get("rnum")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(String.valueOf(excelList.get(i).get("pernNo")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			cell.setCellValue(String.valueOf(excelList.get(i).get("deptName1")) + "\n" + String.valueOf(excelList.get(i).get("deptName2")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellValue(String.valueOf(excelList.get(i).get("postCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(4);
			cell.setCellValue(String.valueOf(excelList.get(i).get("payGrade")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(5);
			cell.setCellValue(String.valueOf(excelList.get(i).get("joinCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(String.valueOf(excelList.get(i).get("salaryCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			if (!String.valueOf(excelList.get(i).get("joinDate")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("joinDate")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("joinDate")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(String.valueOf(excelList.get(i).get("workArea")).replace("(", "\n("));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			if (!String.valueOf(excelList.get(i).get("payGradeDate")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("payGradeDate")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("payGradeDate")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(10);
			cell.setCellValue(stringUtil.formatPhone(AES128.decrypt(String.valueOf(excelList.get(i).get("telephone")))));
			cell.setCellStyle(bodyStyle);

			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 0, 0));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 2, 2));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 3, 3));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 8, 8));

			rowNum++;

			row = sheet.createRow(rowNum++);
			row.setHeight((short) 480);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(String.valueOf(excelList.get(i).get("name")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(4);
			cell.setCellValue(String.valueOf(excelList.get(i).get("payGrade2")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(5);
			cell.setCellValue(String.valueOf(excelList.get(i).get("employType")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(String.valueOf(excelList.get(i).get("wagesAmt")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			if (!String.valueOf(excelList.get(i).get("retrDate")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("retrDate")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("retrDate")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			if (!String.valueOf(excelList.get(i).get("payGradeDate2")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("payGradeDate2")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("payGradeDate2")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(10);
			cell.setCellValue(stringUtil.formatPhone(AES128.decrypt(String.valueOf(excelList.get(i).get("phoneNo")))));
			cell.setCellStyle(bodyStyle);
		}

		// ??? ?????? ?????? (100??? 3.12?????? ??????)
		sheet.setColumnWidth(0, 2500); // No
		sheet.setColumnWidth(1, 2500); // ??????, ??????
		sheet.setColumnWidth(2, 6500); // ??????
		sheet.setColumnWidth(3, 2500); // ??????
		sheet.setColumnWidth(4, 3500); // ??????, ??????
		sheet.setColumnWidth(5, 2800); // ????????????, ????????????
		sheet.setColumnWidth(6, 3200); // ????????????, ????????????
		sheet.setColumnWidth(7, 2700); // ????????????, ?????????
		sheet.setColumnWidth(8, 6500); // ?????????
		sheet.setColumnWidth(9, 2700); // ?????????, ?????????
		sheet.setColumnWidth(10, 3800); // ????????????, ???????????????

		// ????????? ????????? ????????? ??????
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=organization_chart.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();

	}

}
