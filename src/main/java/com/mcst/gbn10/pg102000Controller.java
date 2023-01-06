package com.mcst.gbn10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcst.common.dateUtil;
import com.mcst.common.stringUtil;
import com.mcst.dto.db.hte100tDto;
import com.mcst.dto.gbn10.pg102000Dto;
import com.mcst.gbn10.service.pg102000Service;
import com.mcst.main.service.mainService;
import com.mcst.dto.fileDto;

import egovframework.com.EgovMessageSource;

@Controller
public class pg102000Controller {
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "mainService")
	private mainService mainService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "pg102000Service")
	private pg102000Service pg102000Service;

	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	@RequestMapping(value = "/gbn10/pg102000.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg102000(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception {

		List<pg102000Dto> pg102000DtoEduList = pg102000Service.selectPg102000EduList(pg102000Dto);
		for (int i = 0; i < pg102000DtoEduList.size(); i++) {
			// 시작일, 종료일
			if (!pg102000DtoEduList.get(i).getEduStartDate().trim().contentEquals("-"))
			pg102000DtoEduList.get(i).setEduStartDate(dateUtil.formatDate(pg102000DtoEduList.get(i).getEduStartDate(), '.'));
			if (!pg102000DtoEduList.get(i).getEduEndDate().trim().contentEquals("-"))
			pg102000DtoEduList.get(i).setEduEndDate(dateUtil.formatDate(pg102000DtoEduList.get(i).getEduEndDate(), '.'));
		}
		model.addAttribute("educationList", pg102000DtoEduList);
		
		List<pg102000Dto> pg102000DtoEduTypeList = pg102000Service.selectPg102000EduTypeList(pg102000Dto);
		model.addAttribute("eduTypeList", pg102000DtoEduTypeList);
		
		// 페이지 새로고침 될때마다 검색에 사용된 값들을 가져오기 위한
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg102000Dto, Map.class);
		model.addAttribute("searchFormData", result);

		return "gbn10/pg102000";
	}
	
	@RequestMapping(value = "/gbn10/pg102000Input.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg102000Input(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, ModelMap model) throws Exception {
		
		model.addAttribute("processType","INSERT");
		
		return "gbn10/pg102000Input";
	}
	
	@RequestMapping(value = "/gbn10/pg102000Search.do", method={RequestMethod.GET,RequestMethod.POST})
	public String pg102000Search(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpServletResponse response, ModelMap model) throws Exception{
		
		List<pg102000Dto> pg102000DtoSearchList = pg102000Service.selectPg102000SearchList(pg102000Dto);
		model.addAttribute("searchList", pg102000DtoSearchList);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map result = objectMapper.convertValue(pg102000Dto, Map.class);
		model.addAttribute("searchFormData", result);
		
		return "gbn10/pg102000Search";
	}
	
	@RequestMapping(value = "/gbn10/pg102000Modify.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String pg102000Modify(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, ModelMap model) throws Exception {
		
		model.addAttribute("processType", "UPDATE");
		
		pg102000Dto pg102000DtoInfo = pg102000Service.selectPg102000Info(pg102000Dto);
		
		if(pg102000DtoInfo.getEduStartDate() != null)
		pg102000DtoInfo.setEduStartDate(dateUtil.formatDate(pg102000DtoInfo.getEduStartDate(), '-'));
		if(pg102000DtoInfo.getEduEndDate() != null)
		pg102000DtoInfo.setEduEndDate(dateUtil.formatDate(pg102000DtoInfo.getEduEndDate(), '-'));
		
		model.addAttribute("pg102000Info", pg102000DtoInfo);
		
		return "gbn10/pg102000Input";
	}
	
	@RequestMapping(value = "/gbn10/pg102000Save.do", method={RequestMethod.GET,RequestMethod.POST})
	public String pg102000Save(final MultipartHttpServletRequest multiRequest, @ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpServletRequest request, HttpServletResponse reponse, HttpSession session, ModelMap model) throws Exception{
		
		if(pg102000Dto.getEduSponsor().equals("")) {
			pg102000Dto.setEduSponsor(null);
		}
		if(pg102000Dto.getEduTypeCode().equals("")) {
			pg102000Dto.setEduTypeCode(null);
		}
		if(pg102000Dto.getEduMethodCode().equals("")) {
			pg102000Dto.setEduMethodCode(null);
		}
		if(pg102000Dto.getEduExpense().equals("")) {
			pg102000Dto.setEduExpense("0");
		}
		if(pg102000Dto.getEduRefund().equals("")) {
			pg102000Dto.setEduRefund("0");
		}
		if(pg102000Dto.getEduRealExpense().equals("")) {
			pg102000Dto.setEduRealExpense("0");
		}
		if(pg102000Dto.getEduContents().equals("")) {
			pg102000Dto.setEduContents(null);
		}
		if(pg102000Dto.getEduObject().equals("")) {
			pg102000Dto.setEduObject(null);
		}

		logger.info("getEduSponsor : " + pg102000Dto.getEduSponsor());
		logger.info("getJoinBa : " + pg102000Dto.getJoinBa());
		logger.info("getEduTypeCode : " + pg102000Dto.getEduTypeCode());
		logger.info("getEduMethodCode : " + pg102000Dto.getEduMethodCode());
		logger.info("getEduExpense : " + pg102000Dto.getEduExpense());
		logger.info("getEduRefund : " + pg102000Dto.getEduRefund());
		logger.info("getEduRealExpense : " + pg102000Dto.getEduRealExpense());
		logger.info("getEduContents : " + pg102000Dto.getEduContents());
		logger.info("getEduObject : " + pg102000Dto.getEduObject());
		logger.info("getRealFile : " + pg102000Dto.getRealfile());
		logger.info("getServFile : " + pg102000Dto.getServfile());
		
		String msg = "";
		String close = "";
		int dupChk = 0;
		int rtn = 0;		
		
		if ("INSERT".equals(pg102000Dto.getProcessType())) {			
			dupChk = pg102000Service.selectPg102000Check(pg102000Dto);			
		}
		
		final Map<String, MultipartFile> file = multiRequest.getFileMap();
		
		if (!file.isEmpty()) {
			List<fileDto> filedto = parseFileInf(file, "pg102000_", 0, "", "");
			
			pg102000Dto.setRealfile(filedto.get(0).getOrignlFileNm());
			pg102000Dto.setServfile(filedto.get(0).getStreFileNm());
			logger.info(pg102000Dto.getRealfile());
			logger.info(pg102000Dto.getServfile());
	    }
		
		hte100tDto hte100tDto = new hte100tDto();
		
		BeanUtils.copyProperties(hte100tDto, pg102000Dto);
		logger.info("dupChk = " + dupChk);

		if (dupChk > 0) {
			msg = "이미 입력된 정보가 존재합니다.";
		} else {
			rtn = pg102000Service.updatePg102000(hte100tDto);
			
			if (rtn > 0) {
	    		msg = "정상적으로 저장 되었습니다.";
	    		close = "true";
	    	} else {
	    		msg = "저장시 오류가 발생 되었습니다.";
	    	}
		}
    	
    	model.addAttribute("msg", msg);
    	model.addAttribute("close", close);
    	model.addAttribute("pg102000Info", pg102000Dto);
		
		return "gbn10/pg102000Input";
	}
	
	@RequestMapping(value="/gbn10/pg102000Delete.ajax", method={RequestMethod.POST})
    public ResponseEntity<String> pg102000Delete(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpSession session, ModelMap model) throws Exception {
		
    	int rtn = 0;
    	ResponseEntity<String> resRtn = null;

    	pg102000Dto pg102000DtoInfo = pg102000Service.selectPg102000Info(pg102000Dto);
    	String path = propertyService.getString("Globals.fileStorePath");
		String storedFileName = pg102000DtoInfo.getServfile();
		
		File file = new File(path + File.separator + storedFileName);

		if (file.exists()) { // 파일이 존재하면
			file.delete(); // 파일 삭제
		}
		rtn = pg102000Service.deletePg102000(pg102000Dto);

   		if (rtn == 1) {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("정상적으로 삭제 되었습니다." , "UTF-8"),HttpStatus.OK);

   			logger.info(resRtn);
   		} else {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("삭제 처리중 오류가 발생되었습니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

   			logger.info(resRtn);
   		}

    	return resRtn;
    }
	
	@RequestMapping("/gbn10/pg102000excelDownload.do")
	public void pg102000excelDownload(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpServletResponse response)	throws Exception {
		Cookie cookie = new Cookie("fileDownloadToken", "TRUE");
		response.addCookie(cookie);
		
		List<Map<String, Object>> excelList = pg102000Service.excelList(pg102000Dto);
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("교육사항");
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
		cell.setCellValue("성명");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(1);
		cell.setCellValue("부서");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(2);
		cell.setCellValue("시작일");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(3);
		cell.setCellValue("교육명");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);
		cell.setCellValue("교육기관");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellValue("교육유형");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);
		cell.setCellValue("입사구분");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(7);
		cell.setCellValue("교육비");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(8);
		cell.setCellValue("환급금액");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(9);
		cell.setCellValue("첨부파일");
		cell.setCellStyle(headerStyle);
		
		
		row = sheet.createRow(rowNum++);
		row.setHeight((short) 480);
		cell = row.createCell(0);
		cell.setCellValue("사번");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(1);
		cell.setCellValue("직위");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(2);
		cell.setCellValue("종료일");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(3);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);		
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellValue("교육방법");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);		
		cell.setCellStyle(headerStyle);
		cell = row.createCell(7);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(8);
		cell.setCellValue("실비용");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(9);		
		cell.setCellStyle(headerStyle);

		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));

		// Body
		for (int i = 0; i < excelList.size(); i++) {
			row = sheet.createRow(rowNum);
			row.setHeight((short) 480);
			cell = row.createCell(0);
			cell.setCellValue(String.valueOf(excelList.get(i).get("name")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(String.valueOf(excelList.get(i).get("deptFullName")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			if (!String.valueOf(excelList.get(i).get("eduStartDate")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("eduStartDate")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("eduStartDate")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduTitle")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(4);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduSponsor")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(5);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduTypeCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellValue(String.valueOf(excelList.get(i).get("joinBa")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduExpense")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduRefund")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			cell.setCellValue(String.valueOf(excelList.get(i).get("realfile")));
			cell.setCellStyle(bodyStyle);
						
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 3, 3));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 4, 4));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 6, 6));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 7, 7));
			sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum + 1, 9, 9));

			rowNum++;

			row = sheet.createRow(rowNum++);
			row.setHeight((short) 480);
			cell = row.createCell(0);
			cell.setCellValue(String.valueOf(excelList.get(i).get("pernNo")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(1);
			cell.setCellValue(String.valueOf(excelList.get(i).get("postCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(2);
			if (!String.valueOf(excelList.get(i).get("eduEndDate")).contentEquals("-")) {
				cell.setCellValue(dateUtil.formatDate(String.valueOf(excelList.get(i).get("eduEndDate")), '.'));
			} else {
				cell.setCellValue(String.valueOf(excelList.get(i).get("eduEndDate")));
			}
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(5);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduMethodCode")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(7);
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(8);
			cell.setCellValue(String.valueOf(excelList.get(i).get("eduRealExpense")));
			cell.setCellStyle(bodyStyle);
			cell = row.createCell(9);
			cell.setCellStyle(bodyStyle);
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=education_chart.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}
		
	@RequestMapping(value = "/gbn10/fileDownload.do", method = { RequestMethod.GET, RequestMethod.POST })
	public void fileDownload(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpServletResponse response) throws Exception {
		
		String fileName = new String(pg102000Dto.getRealfile().getBytes("UTF-8"), "ISO-8859-1");		
		
		try {
			String path = propertyService.getString("Globals.fileStorePath");
			File file = new File(path, pg102000Dto.getServfile());
			
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			
			FileInputStream fileInputStream = new FileInputStream(file.getPath()); // 파일 읽어오기
			OutputStream out = response.getOutputStream();
			
			int read = 0;
			byte[] buffer = new byte[1024];
			// 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
			while ((read = fileInputStream.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			
		} catch (Exception e) {
			throw new Exception("download error");
		}
		
	}

	@RequestMapping(value="/gbn10/pg102000FileDelete.ajax", method={RequestMethod.POST})
    public ResponseEntity<String> pg102000FileDelete(@ModelAttribute("pg102000Dto") pg102000Dto pg102000Dto, HttpSession session, ModelMap model) throws Exception {
		
    	int rtn = 0;
    	ResponseEntity<String> resRtn = null;
    	
    	hte100tDto hte100tDto = new hte100tDto();
    	BeanUtils.copyProperties(hte100tDto, pg102000Dto);
    	
    	String path = propertyService.getString("Globals.fileStorePath");
		String storedFileName = pg102000Dto.getServfile();
		
		File file = new File(path + File.separator + storedFileName);

		if (file.exists()) { // 파일이 존재하면
			file.delete(); // 파일 삭제
		}
		rtn = pg102000Service.updateFilePg102000(hte100tDto);

   		if (rtn == 1) {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("정상적으로 삭제 되었습니다." , "UTF-8"),HttpStatus.OK);

   			logger.info(resRtn);
   		} else {
   			resRtn = new ResponseEntity<>(URLEncoder.encode("삭제 처리중 오류가 발생되었습니다." , "UTF-8"),HttpStatus.BAD_REQUEST);

   			logger.info(resRtn);
   		}

    	return resRtn;
	}
	//////////////////////////////////////////////////////////////// 이하는 fileUtil.java에서 가져온 코드 
	
	public static final int BUFF_SIZE = 2048;
	
	/**
     * 첨부파일에 대한 목록 정보를 취득한다.
     *
     * @param files
     * @return
     * @throws Exception
     */
	public List<fileDto> parseFileInf(Map<String, MultipartFile> files, String KeyStr, int fileKeyParam, String atchFileId, String storePath) throws Exception {
    	int fileKey = fileKeyParam;

    	String storePathString = "";
    	String atchFileIdString = "";

		if ("".equals(storePath) || storePath == null) {
		    storePathString = propertyService.getString("Globals.fileStorePath");
		} else {
		    storePathString = propertyService.getString(storePath);
		}

		if (!"".equals(atchFileId) && atchFileId != null) {
		    atchFileIdString = atchFileId;
		}

		File saveFolder = new File(storePathString);

		if (!saveFolder.exists() || saveFolder.isFile()) {
		    saveFolder.mkdirs();
		}

		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
		MultipartFile file;
		String filePath = "";
		List<fileDto> result  = new ArrayList<fileDto>();
		fileDto fvo;

		while (itr.hasNext()) {
		    Entry<String, MultipartFile> entry = itr.next();

		    file = entry.getValue();
		    String orginFileName = file.getOriginalFilename();

		    //--------------------------------------
		    // 원 파일명이 없는 경우 처리
		    // (첨부가 되지 않은 input file type)
		    //--------------------------------------
		    if ("".equals(orginFileName)) {
		    	continue;
		    }
		    ////------------------------------------

		    int index = orginFileName.lastIndexOf(".");
		    String fileExt = orginFileName.substring(index + 1);
		    String newName = KeyStr + stringUtil.getTimeStamp() + fileKey;
		    long _size = file.getSize();

		    if (!"".equals(orginFileName)) {
		    	filePath = storePathString + File.separator + newName;
		    	file.transferTo(new File(filePath));
		    }

		    fvo = new fileDto();
		    fvo.setFileExtsn(fileExt);
		    fvo.setFileStreCours(storePathString);
		    fvo.setFileMg(Long.toString(_size));
		    fvo.setOrignlFileNm(orginFileName);
		    fvo.setStreFileNm(newName);
		    fvo.setAtchFileId(atchFileIdString);
		    fvo.setFileSn(String.valueOf(fileKey));

		    writeFile(file, newName, storePathString);

		    result.add(fvo);

		    fileKey++;
		}

		return result;
    }
	
	/**
     * 파일을 실제 물리적인 경로에 생성한다.
     *
     * @param file
     * @param newName
     * @param stordFilePath
     * @throws Exception
     */
    protected static void writeFile(MultipartFile file, String newName, String stordFilePath) throws Exception {
    	InputStream stream = null;
    	OutputStream bos = null;
    	newName = stringUtil.isNullToString(newName).replaceAll("..", "");
    	stordFilePath = stringUtil.isNullToString(stordFilePath).replaceAll("..", "");
    	try {
    		stream = file.getInputStream();
    		File cFile = new File(stordFilePath);

    		if (!cFile.isDirectory())
    			cFile.mkdir();

    		bos = new FileOutputStream(stordFilePath + File.separator + newName);

    		int bytesRead = 0;
    		byte[] buffer = new byte[BUFF_SIZE];

    		while ((bytesRead = stream.read(buffer, 0, BUFF_SIZE)) != -1) {
    			bos.write(buffer, 0, bytesRead);
    		}
    	} catch (FileNotFoundException fnfe) {
    		logger.debug("fnfe: {}", fnfe);
    	} catch (IOException ioe) {
    		logger.debug("ioe: {}", ioe);
    	} catch (Exception e) {
    		logger.debug("e: {}", e);
    	} finally {
    		if (bos != null) {
    			try {
    				bos.close();
    			} catch (Exception ignore) {
    				logger.debug("IGNORED: "+ ignore.getMessage());
    			}
    		}
    		if (stream != null) {
    			try {
    				stream.close();
    			} catch (Exception ignore) {
    				logger.debug("IGNORED: "+ ignore.getMessage());
    			}
    		}
    	}
    }

}
