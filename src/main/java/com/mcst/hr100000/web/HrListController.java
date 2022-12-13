package com.mcst.hr100000.web;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.mcst.dto.db.hpa100tDto;
import com.mcst.hr100000.service.HrListService;

import net.sf.jasperreports.engine.JasperRunManager;

/**
 * 게시물 관리를 위한 컨트롤러 클래스
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.19
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.19  이삼섭          최초 생성
 *  2009.06.29  한성곤	       2단계 기능 추가 (댓글관리, 만족도조사)
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Controller
public class HrListController {

   @Resource(name = "hrListService")
   private HrListService hrListService;

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    @Autowired
    private DefaultBeanValidator beanValidator;

    @Autowired
    DataSource dataSource;

     /**
     * 게시물에 대한 목록을 조회한다.
     *
     * @param boardVO
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/hr/selectList.do", method=RequestMethod.GET)
    public String HrselectList(HttpServletRequest request, HttpServletResponse reponse, HttpSession session, @ModelAttribute("hpa100tDto") hpa100tDto hpa100tDto, ModelMap model) throws Exception {

    	PaginationInfo paginationInfo = new PaginationInfo();

    	Map<String, Object> map = hrListService.HrselectList(hpa100tDto);
    	model.addAttribute("resultList", map.get("resultList"));

    	return "Hr/selectList";
    }

    @RequestMapping(value="/hr/selectListAjax.ajax", method=RequestMethod.GET)
    public ModelAndView selectListAjax(@ModelAttribute("hpa100tDto") hpa100tDto hpa100tDto,Model model) throws Exception {

		PaginationInfo paginationInfo = new PaginationInfo();

		Map<String, Object> map = hrListService.HrselectList(hpa100tDto);
		ModelAndView modelAndView = new ModelAndView("jsonView",map);

		return modelAndView;
    }

    @RequestMapping(value="reportsample.do", method=RequestMethod.GET)
    public ResponseEntity<byte[]> helloWorldReport2(HttpServletRequest request, HttpServletResponse response, HttpSession session, @ModelAttribute("hpa100tDto") hpa100tDto hpa100tDto, ModelMap model) throws Exception {
/*
    	 InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Blank_A4_1.jasper");
   	     Map<String,Object> params = new HashMap<>();
   	     JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

    	 final OutputStream outStream = response.getOutputStream();

    	 response.setContentType("application/x-pdf");
    	 response.setHeader("Content-disposition", "attachment; filename=helloWorldReport.pdf");

    	 JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
*/


    	 File reportFile = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/reports/Blank_A4_1.jasper")); // jasper 파일 위치 지정
    	 byte[] bytes = null;

		 bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), new HashMap(), dataSource.getConnection()); // HashMap에 map.put(“para1”, value1)로 파라미터를 지정

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentLength(bytes.length);

		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
	    return responseEntity;

    }
}
