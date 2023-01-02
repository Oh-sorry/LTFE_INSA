<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/jqgrid/css/ui.jqgrid.css'/>">
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/css/newStyle.css'/>">
<%-- <link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>"> --%>
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>

<script language="javascript">

/* 검색 기능 */
function goReload() {
	document.listForm.action = "<c:url value='/gbn10/pg107000.do'/>";
	document.listForm.submit();
}

/* 엑셀 다운로드 */
function goExcel() {
	document.listForm.action = "<c:url value='/gbn10/pg107000Excel.do'/>";
	document.listForm.submit();
	
}

</script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="/WEB-INF/jsp/top.jsp" flush="true"/>
        <div id="content_wrap">
            <jsp:include page="/WEB-INF/jsp/left.jsp" flush="true"/>
            <div id="contents">
				<div class="inner">
					<div class="path">
						<div class="inner">
							<ul>
								<li><a href="#"><img src="<c:url value='/images/ico_home.png' />" alt="" /></a></li>
								<li><a href="#">인사관리</a></li>
								<li><a href="#">입/퇴사자 현황</a></li>
							</ul>
						</div>
					</div>
					
					<form:form modelAttribute="pg107000Dto" id="listForm" name="listForm" method="post">
						<h3>입/퇴사자 현황</h3>
						<div class="section">
							<div class="search_Area m_b_20">
	                            <table>
	                                <colgroup>
	                                    <col style="width:7%" />
	                                    <col style="" />
	                                </colgroup>
	                                <tbody>
	                                    <tr>
	                                       <td>
	                                        		<form:select path="joinYear" value="${searchFormData.joinYear}">
	                                        			<form:option value="" label="선택" />
		                                        		<c:forEach var="yearList" items="${yearList}" varStatus="status">
		                                        			<form:option value="${yearList.joinYear}" label="${yearList.joinYear}" />
		                                        		</c:forEach>
	                                        		</form:select>
	                                        </td>
	                                        <th>년</th>
	                                        
	                                        <td>
	                                        		<form:select path="joinMonth" value="${searchFormData.joinMonth}">
	                                        			<form:option value="" label="선택" />
		                                        		<c:forEach var="monthList" items="${monthList}" varStatus="status">
		                                        			<form:option value="${monthList.joinMonth}" label="${monthList.joinMonth}" />
		                                        		</c:forEach>
	                                        		</form:select>
	                                        </td>
	                                        <th>월</th>
	                                        
	                                        	                                        
	                                        <th>입/퇴사 구분</th>
	                                        <td>
	                                            <label></label>
	                                              <form:select path="detailCode" value="${searchFormData.detailCode}">
									     	   	  	<form:option value="0" label="전체" />
	                                        		<form:option value="1" label="입사" />
	                                        		<form:option value="2" label="퇴사" />
									      		  </form:select>
									      		  <a href="javascript:goReload()" class="btn_small bt_grey">검색</a>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
							<div class="section">
	                        	<div id="table-scroll" class="table-scroll" style="height:577px; margin:0;">
									<table class="row_table">
										<thead>
											<tr>
												<th rowspan="2">구분</th>
	                                            <th rowspan="2">No</th>
	                                            <th>사번</th>
	                                            <th rowspan="2">부서</th>
	                                            <th>직위</th>
	                                            <th>직급</th>
	                                            <th rowspan="2">근무지</th>
	                                            <th>입사일</th>
	                                            <th rowspan="2">주소</th>
	                                            <th>급여구분</th>
											</tr>
											<tr>
	                                            <th>성명</th>
	                                            <th>주민번호</th>
	                                            <th>호봉</th>
	                                            <th>퇴직일</th>
	                                            <th>월급여</th>
	                                        </tr>
										</thead>
										<tbody>
											<c:forEach var="result" items="${pernList}" varStatus="status">
												<tr>
														<td rowspan="2"><c:out value="${result.gubun}" /></td>
														<td rowspan="2"><c:out value="${result.rnum}" /></td>
														<td><c:out value="${result.pernNo}" /></td>
														<td rowspan="2"><c:out value="${result.deptName}" /></td>
														<td><c:out value="${result.postName}" /></td>
														<td><c:out value="${result.payName}" /></td>
														<td rowspan="2"><c:out value="${result.workAreaName}" /></td>
														<td><c:out value="${result.joinDate}" /></td>
														<td rowspan="2"><c:out value="${result.korAddr}" /></td>
														<td><c:out value="${result.salaryName}" /></td>
												</tr>
												<tr>
														<td><c:out value="${result.name}" /></td>
														<td><c:out value="${result.repreNum}" /></td>
														<td><c:out value="${result.payGrade2}" /></td>
														<td><c:out value="${result.retrDate}" /></td>
														<td><c:out value="${result.stringWagesAmt}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
	                    </div>
                    </form:form>
                    <div class="btn_group">
                        <div class="right">
                            <a class="btn_large bt_blue" href="javascript:goExcel()">엑셀</a>
                        </div>
                    </div>
                    <div class="w_100p" style="display:block; overflow:hidden;">
                                <table class="col_table w_50p" style="float:right;">
                                    <tbody>
                                        <tr>
                                            <th>입사인원</th>
                                            <td>${joinCount} 명</td>
                                            <th>퇴직인원</th>
                                            <td>${retrCount} 명</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>

        </div>
    </div>
</body>
</html>