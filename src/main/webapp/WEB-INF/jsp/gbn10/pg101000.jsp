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
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous"> -->
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
	var popup;
	window.onunload = function() { popup.close(); } // 현재 팝업 새로고침 또는 닫기 시 자식 팝업도 함께 닫히도록

	$(document).ready(function() {		
		var iframeGbn = $('[id=searchForm] #iframeGbn').val();		
		$('#iframe'+iframeGbn).addClass("on");
				
		document.getElementById("list1").src =  $('[id=searchForm] #srcUrl').val();		
	});
	
	function iframeCall(url, iframeGbn) {
		$('[id=searchForm] #iframeGbn').val(iframeGbn);
		$('[id=searchForm] #srcUrl').val("${pageContext.request.contextPath }/gbn10/" + url);		
		document.searchForm.submit();
	}
	
	function search() {
		var sStr = $('[id=searchForm] #sStr').val();
		if (sStr.trim() == '') {
			alert("검색할 사원의 이름 또는 사번을 입력하세요");
			$('[id=searchForm] #sStr').focus();
			return;
		}else{
			if(isNaN(sStr)) {
				if(sStr.length > 0 && sStr.length < 2){
					alert("이름은 두자 이상 입력해야 합니다.");
					$('[id=searchForm] #sStr').focus();
					return;
				}
			} else {
				if(sStr.length<4 && sStr.length>0){
					alert("사번은 4자릿수 이상 입니다.");
					$('[id=searchForm] #sStr').focus();
					return;
				}
			}
		}
		
		loadingOn();
		
		popup = window.open('${pageContext.request.contextPath}/gbn10/pg101000Search.do','search','width=1000px,height=550px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes');
		
		POPUP_INTERVAL = setInterval(function() {
			console.log(1);
			if(typeof(popup)=='undefined' || popup.closed) {
				clearInterval(POPUP_INTERVAL);
				loadingOff();
			}
		}, 250);
		//document.searchForm.action = "<c:url value='/gbn10/pg101000.do'/>";
		//document.searchForm.submit();
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
								<li><a href="#">인사기본정보</a></li>
							</ul>
						</div>
					</div>
					<h3>인사기본정보</h3>
					<form:form modelAttribute="pg101000Dto" id="searchForm" name="searchForm" method="post">
					<div class="search_Area m_b_20">
                        <div class="s_btn">
                            <a href="" class="btn_small bt_deep_blue">신입사원 등록</a>
                            <a href="" class="btn_small bt_deep_blue">사원 삭제</a>
                            <a href="" class="btn_small bt_deep_blue">기본정보수정</a>
                        </div>
                        <dl>
                            <dt>성명/사번</dt>
                            <dd>
                                <label></label>
                                <form:input size="15" path="sStr" value="${searchFormData.sStr}" onkeypress="javascript:if(event.keyCode==13)search();"/>                                
                                <form:hidden path="pernNo" value="${searchFormData.pernNo}" />
								<form:input path="name" value="${searchFormData.name}" />
                                <a href="javascript:search()" class="btn_small bt_grey">검색</a> 
                            </dd>
                        </dl>
                    </div>
                    <%-- </form:form>  --%>                   
					<div class="section">
                        <div class="cols_area">
                            <table class="table table_right_row">
                                <colgroup>
                                    <col style="">
                                    <col style="width:8%">
                                    <col style="width:15%">
                                    <col style="width:8%">
                                    <col style="width:15%">
                                    <col style="width:8%">
                                    <col style="width:15%">
                                    <col style="width:8%">
                                    <col style="width:15%">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <td rowspan="5" class="img"><img src="images/sample_photo02.png" alt="증명사진"></td>
                                        <th>사번/성명</th>
                                        <td><b>${pernInfo.pernNo} ${pernInfo.name}</b></td>
                                        <th>주민번호</th>
                                        <td>
                                        	${pernInfo.repreNum}
	                                        <c:choose>
	                                        	<c:when test="${pernInfo.sexCode == '1'}">(남)</c:when>
	                                        	<c:when test="${pernInfo.sexCode == '2'}">(여)</c:when>	                                        	
	                                        </c:choose>
                                        </td>
                                        <th>입사일자</th>
                                        <td>${pernInfo.joinDate}</td>
                                        <th>정식발령일</th>
                                        <td>${pernInfo.expireDate}</td>
                                    </tr>
                                    <tr>
                                        <th>직급</th>
                                        <td>${pernInfo.postCode}</td>
                                        <th>호봉</th>
                                        <td>${pernInfo.payGrade2}</td>
                                        <th>승급일</th>
                                        <td>${pernInfo.payGradeDate}</td>
                                        <th>승호일</th>
                                        <td>${pernInfo.payGradeDate2}</td>
                                    </tr>
                                    <tr>
                                        <th>직위</th>
                                        <td>${pernInfo.payGrade}</td>
                                        <th>급여부분</th>
                                        <td>${pernInfo.salaryCode}</td>
                                        <th>월급여</th>
                                        <td>${pernInfo.wagesAmt} (${pernInfo.wagesDate})</td>
                                        <th>최종학력</th>
                                        <td>${pernInfo.schshipCode}</td>
                                    </tr>
                                    <tr>
                                        <th>부서</th>
                                        <td colspan="3">${pernInfo.deptName}</td>
                                        <c:choose>
	                                        	<c:when test="${pernInfo.totalCarrYears == null}">
	                                        		<th>전체해당경력</th>
			                                        <td><b><span class="orange">0 년 0 개월</span></b></td>
			                                        <th>이전해당경력</th>
			                                        <td>0 년 0 개월</td>
	                                        	</c:when>
	                                        	<c:otherwise>
	                                        		<th>전체해당경력</th>
			                                        <td><b><span class="orange">${pernInfo.totalCarrYears} 년 ${pernInfo.totalCarrMonths} 개월</span></b></td>
			                                        <th>이전해당경력</th>
			                                        <td>${pernInfo.pastCarrYears} 년 ${pernInfo.pastCarrMonths} 개월</td>
	                                        	</c:otherwise>
                                        </c:choose>
                                    </tr>
                                    <tr>
                                        <th>입사구분</th>
                                        <td>${pernInfo.joinCode}</td>
                                        <th>사원구분</th>
                                        <td>${pernInfo.employType}</td>
                                        <th>퇴직일자</th>
                                        <td><b><span class="orange">${pernInfo.retrDate}</span></b></td>
                                        <th>퇴직사유</th>
                                        <td>${pernInfo.retrResn}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%-- <form:form modelAttribute="pg101000Dto" id="inputForm" name="inputForm" method="post"> --%>
                    <form:hidden path="iframeGbn" value="${searchFormData.iframeGbn}"/>
                    <form:hidden path="srcUrl" value="${searchFormData.srcUrl}"/>                    
                    <div class="section">
                        <div class="tab_area t_11">
                            <ul>
                                <li><a href="javascript:iframeCall('pg101001.do', 1);" id="iframe1">기본인적</a></li>
                                <li><a href="javascript:iframeCall('pg101002.do', 2);" id="iframe2">발령이력</a></li>
                                <li><a href="javascript:iframeCall('', 3);" id="iframe3">학력사항</a></li>
                                <li><a href="javascript:iframeCall('', 4);" id="iframe4">경력사항</a></li>
                                <li><a href="javascript:iframeCall('', 5);" id="iframe5">자격면허</a></li>
                                <li><a href="javascript:iframeCall('', 6);" id="iframe6">보증보험</a></li>
                                <li><a href="javascript:iframeCall('', 7);" id="iframe7">교육사항</a></li>
                                <li><a href="javascript:iframeCall('', 8);" id="iframe8">업무현황</a></li>
                                <li><a href="javascript:iframeCall('', 9);" id="iframe9">퇴직금</a></li>
                                <li><a href="javascript:iframeCall('', 10);" id="iframe10">원천징수영수증</a></li>
                            </ul>
                        </div>
                        <!-- 작업 중인 부분 -->
                        <%-- <jsp:include page="/WEB-INF/jsp/gbn10/pg101002.jsp" flush="true"/> --%>
                        <iframe width="100%" height="600" src="${pageContext.request.contextPath }/gbn10/pg101002.do" name="list1" id="list1"></iframe>
                    </div>
                    </form:form>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
            
        </div>
    </div>


</body>
</html>