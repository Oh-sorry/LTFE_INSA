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

</head>
<body>
 <script language="javascript">

/* 검색 기능 */
function goReload() {
	document.listForm.action = "<c:url value='/gbn10/pg105500.do'/>";
	document.listForm.submit();
}
/* 엑셀 다운로드 */
function goExcel() {
	document.listForm.action = "<c:url value='/gbn10/pg105500Excel.do'/>";
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
								<li><a href="#">경력 현황</a></li>
							</ul>
						</div>
					</div>
					
					<form:form modelAttribute="pg105500Dto" id="listForm" name="listForm" method="post">
						<h3>경력 현황</h3>
						<div class="section">
							<div class="search_Area m_b_20">
	                            <table>
	                                <colgroup>
	                                    <col style="width:7%" />
	                                    <col style="" />
	                                </colgroup>
	                                <tbody>
	                                    <tr>
	                                        <th>부서</th>
	                                        <td>
	                                        	<label></label>
	                                        		<form:select path="deptCode" value="${searchFormData.deptCode}">
														<ul class="deptList1">
															<li>
																<ul class="hidden">
																	<form:option value="" label="전체" />
																	<c:forEach var="deptList1" items="${deptList1}" varStatus="status">
																		<li>
																			<form:option value="${deptList1.deptCode1}" label="${deptList1.deptName1}" />
																			<ul class="deptList3">
																				<c:forEach var="deptList2" items="${deptList2}" varStatus="status">
																					<c:if test="${deptList1.deptCode1 == deptList2.deptCode1}">
																						<li>
																							<form:option value="${deptList2.deptCode2}" label="  ↳    ${deptList2.deptName2}" />
																						</li>
																					</c:if>
																				</c:forEach>
																			</ul>
																		</li>
																	</c:forEach>
																</ul>
															</li>
														</ul>
	                                        		</form:select>
	                                        </td>
	                                        
	                                        <th>직위</th>
	                                        <td>
	                                        	<label></label>
	                                        		<form:select path="postCode" value="${searchFormData.postCode}">
	                                        			<form:option value="" label="전체" />
		                                        		<c:forEach var="gbnList2" items="${gbnList2}" varStatus="status">
		                                        			<form:option value="${gbnList2.postCode}" label="${gbnList2.postName}" />
		                                        		</c:forEach>
	                                        		</form:select>
	                                        </td>
	                                    
	                                        <th>근무처</th>
	                                        <td>
	                                        	<label></label>
	                                        		<form:select path="workArea" value="${searchFormData.workArea}">
	                                        			<form:option value="" label="전체" />	
		                                        		<c:forEach var="gbnList3" items="${gbnList3}" varStatus="status">
		                                        			<form:option value="${gbnList3.workArea}" label="${gbnList3.workAreaName}" />
		                                        		</c:forEach>
	                                        		</form:select>
	                                        </td>

	                                        <th>급여구분</th>
	                                        <td>
	                                        	<label></label>
	                                        		<form:select path="salaryCode" value="${searchFormData.salaryCode}">
	                                        			<form:option value="" label="전체" />
		                                        		<c:forEach var="gbnList4" items="${gbnList4}" varStatus="status">
		                                        			<form:option value="${gbnList4.salaryCode}" label="${gbnList4.salaryName}" />
		                                        		</c:forEach>
	                                        		</form:select>
	                                        </td>
	                                        
	                                        <th>성명</th>
	                                        <td>
	                                        	<label></label>
	                                        	<input type="text" id="name" name="name">
	                                        </td>
	                                        <th>사번</th>
	                                        <td>
	                                        	<label></label>
	                                        	<input type="text" id="pernNo" name="pernNo">
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
												<th>No</th>
		                                        <th>사번</th>
		                                        <th>성명</th>
		                                        <th>부서</th>
		                                        <th>직위</th>
		                                        <th>급여구분</th>
		                                        <th>직급</th>
		                                        <th>호봉</th>
		                                        <th>나이</th>
		                                        <th>입사일</th>
		                                        <th>승급일</th>
		                                        <th>승호일</th>
		                                        <th>경력시작일</th>
		                                        <th>경력</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="result" items="${pernList}" varStatus="status">
												<tr>
													<td><c:out value="${result.rnum}" /></td>
													<td><c:out value="${result.pernNo}" /></td>
													<td><c:out value="${result.name}" /></td>
													<td><c:out value="${result.deptName}" /></td>
													<td><c:out value="${result.postName}" /></td>
													<td><c:out value="${result.salaryName}" /></td>
													<td><c:out value="${result.payName}" /></td>
													<td><c:out value="${result.hobong}" /></td>
													<td><c:out value="${result.age}" /></td>
													<td><c:out value="${result.joinDate}" /></td>
													<td><c:out value="${result.payGradeDate}" /></td>
													<td><c:out value="${result.payGrade2Date}" /></td>
													<td><c:out value="${result.careerSDate}" /></td>
													<td><c:out value="${result.career}" /></td>
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
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>

        </div>
    </div>
</body>
</html>