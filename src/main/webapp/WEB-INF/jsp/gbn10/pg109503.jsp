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
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="<c:url value='/css/style.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script> <!-- css 파일 교체함  -->
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script> <!-- 쿠키 사용을 위해 추가 -->

<title>(주)엠씨에스텍 인사급여시스템</title>


<script language="javascript">
	$(document).ready(function() {
		var deptGbn = $('[id=listForm] #rank').val();
		$('#deptList'+deptGbn).addClass("on").next("ul").slideDown("fast");
	});
	
	function goReload() {
		document.listForm.action = "<c:url value='/gbn10/pg109503.do'/>";
		document.listForm.submit();
	}
	
	function searchDept(deptNo, rank) {		
		$('[id=listForm] #searchKeyword').val(deptNo);
		$('[id=listForm] #rank').val(rank);
		document.listForm.action = "<c:url value='/gbn10/pg109503.do'/>";
		document.listForm.submit();
	}
	
	function excelDown() { // 데이터가 너무 많으면 오래 걸림 - 이때 다른 버튼 못누르게 막도록 작성
		document.listForm.action = "<c:url value='/gbn10/pg109503excelDownload.do'/>";
		document.listForm.submit();

		loadingOn();

		FILEDOWNLOAD_INTERVAL = setInterval(function() {
			console.log($.cookie("fileDownloadToken"));
			if ($.cookie("fileDownloadToken") != null) {
				$.removeCookie('fileDownloadToken');
		        clearInterval(FILEDOWNLOAD_INTERVAL);
		        loadingOff();
		    }
		}, 500);
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
								<li><a href="#"><img src="<c:url value='/images/ico_home.png' />" alt=""></a></li>
								<li><a href="#">인사관리</a></li>
								<li><a href="#">조직도 검색</a></li>
							</ul>
						</div>
					</div>
					
					<form:form modelAttribute="pg109503Dto" id="listForm" name="listForm" method="post">
						<h3>조직도 검색</h3>
						<div class="section">
							<div class="search_Area m_b_20">
							    <form:hidden path="searchKeyword" value="${searchFormData.searchKeyword}"/>
							    <form:hidden path="rank" value="${searchFormData.rank}"/>
	                            <table>
	                                <colgroup>
	                                    <col style="width:7%" />
	                                    <col style="" />
	                                </colgroup>
	                                <tbody>
										<tr>
	                                        <th>재/퇴직구분</th>
	                                        <td>
	                                            <label></label>
	                                            <!-- 재직인 경우 퇴직인 경우 -->
									      		<form:select path="searchJoinGbn1" value="${searchFormData.searchJoinGbn1}" onchange="javascript:goReload()">
													<form:option value="0" label="전체" />
													<form:option value="1" label="재직" />
													<form:option value="2" label="퇴직" />
												</form:select>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                    </div>
						<div class="section">
	                        <div class="cols_area d_flex">
	                            <div id="dtree" class="w_20p">
	                                <ul class="depth1">
	                                    <li>
	                                        <a href="#">MCST</a>
	                                        <ul class="depth2">
	                                        	<c:forEach var="result1" items="${deptList1}" varStatus="status">                                        	
	                                        		<li>
	                                                	<a href="" id="deptList${result1.rank}">${result1.deptList1}</a>
	                                                	<ul class="depth3">
	                                                		<li><a href="javascript:searchDept('${result1.deptNo}', '${result1.rank}')">${result1.deptList1}</a></li>
		                                                	<c:forEach var="result2" items="${deptList2}" varStatus="status">
		                                                		<c:if test="${result1.rank == result2.rank}">
		                                                			<li><a href="javascript:searchDept('${result2.deptNo}', '${result1.rank}')">${result2.deptList2}</a></li>
		                                                		</c:if>
		                                                	</c:forEach>
	                                                	</ul>
	                                        		</li>
	                                        	</c:forEach>
	                                        </ul>
	                                    </li>
	                                </ul>
	                            </div>
	                            <div id="table-scroll" class="table-scroll" style="height:577px; margin:0;">
	                                <table class="row_table">
	                                    <thead>
	                                        <tr>
	                                            <th rowspan="2">No</th>
	                                            <th>사번</th>
	                                            <th rowspan="2">부서</th>
	                                            <th rowspan="2">직위</th>
	                                            <th>직급</th>
	                                            <th>입사구분</th>
	                                            <th>급여구분</th>
	                                            <th>입사일자</th>
	                                            <th rowspan="2">근무지</th>
	                                            <th>승급일</th>
	                                            <th>전화번호</th>
	                                        </tr>
	                                        <tr>
	                                            <th>성명</th>
	                                            <th>호봉</th>
	                                            <th>사원구분</th>
	                                            <th>연봉구분</th>
	                                            <th>퇴직일</th>
	                                            <th>승호일</th>
	                                            <th>핸드폰번호</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
		                                    <c:forEach var="result" items="${organizationList}" varStatus="status">
		                                    	<tr>
		                                            <td rowspan="2"><c:out value="${result.rnum}" /></td>
		                                            <td><c:out value="${result.pernNo}" /></td>
		                                            <td rowspan="2">${result.deptFullName}</td>
		                                            <td rowspan="2"><c:out value="${result.postCode}" /></td>
		                                            <td><c:out value="${result.payGrade}" /></td>
		                                            <td><c:out value="${result.joinCode}" /></td>
		                                            <td><c:out value="${result.salaryCode}" /></td>
		                                            <td><c:out value="${result.joinDate}" /></td>
		                                            <td rowspan="2">${result.workArea}</td>
		                                            <td><c:out value="${result.payGradeDate}" /></td>
		                                            <td><c:out value="${result.telephone}" /></td>
		                                        </tr>
		                                        <tr>
		                                            <td><c:out value="${result.name}" /></td>
		                                            <td><c:out value="${result.payGrade2}" /></td>
		                                            <td><c:out value="${result.employType}" /></td>
		                                            <td><c:out value="${result.wagesAmt}" /></td>
		                                            <td><c:out value="${result.retrDate}" /></td>
		                                            <td><c:out value="${result.payGradeDate2}" /></td>
		                                            <td><c:out value="${result.phoneNo}" /></td>
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
                            <a href="javascript:excelDown()" class="btn_large bt_blue">엑셀</a>
                        </div>
                    </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
        </div>
    </div>
</body>
</html>