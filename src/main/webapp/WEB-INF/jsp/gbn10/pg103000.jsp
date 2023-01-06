<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/css/newStyle_back.css'/>">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>

<script language="javascript">

/* 검색 기능 */
function goReload() {
	if($('[id=listForm] #expStartDate').val().trim() != '') {
		if($('[id=listForm] #expEndDate').val().trim() == '') {
			alert("종료 날짜를 입력해주세요.");
		} else {
			goSelect();
		}
	} else if($('[id=listForm] #expStartDate').val().trim() == '') {
		if($('[id=listForm] #expEndDate').val().trim() != '') {
			alert("시작 날짜를 입력해주세요.");
		}
		else {
			goSelect();
		}
	}
}
function goSelect() {
	document.listForm.action = "<c:url value='/gbn10/pg103000.do'/>";
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

function fn_go_page(pageNo) {
	$("#pageIndex").val(pageNo);
	$("#listForm").submit();
	return false;
}

function chkAll(obj){
	var form = document.listForm;
	var len = document.getElementsByName("Check");
	
	for(i=0;i<len.length;i++){
		document.getElementsByName("Check")[i].checked = obj.checked;
	}
}

function showPop() {
	
	var form = document.listForm;
	var ChBox = $('[name="Check"]');
	var cnt = 0;
	for(i=0;i<ChBox.length;i++){
		if(ChBox[i].checked == true){
			cnt++;
		}			
	}
	if(cnt == 0){
		alert("항목을 선택해 주십시오.");
		return;
	}else if(cnt > 1){
		alert("항목을 하나만 선택해 주십시오.");
		return;
	}
	
	var sb = $('[id="s_bun"]');
	var pern_no = 0;
	for(i=0;i<ChBox.length;i++){
		if(ChBox[i].checked == true){
			pern_no=sb[i].outerText;
			break;
		}
	}
	
	loadingOn();
	
	popup = window.open('about:blank', 'input', 'width=2500px,height=725px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes');
	/* 나중에 인사기본정보로 변경 예정  pg101000.do*/
	$('#inputForm').attr("action", "<c:url value='/gbn10/pg101000.do'/>");
	$('#inputForm').attr("target", "input");
	inputForm.submit();
	
	POPUP_INTERVAL = setInterval(function() {
		console.log(1);
		if(typeof(popup)=='undefined' || popup.closed) {
			clearInterval(POPUP_INTERVAL);
			loadingOff();
		}		
	}, 250);
}

function write() {
	loadingOn();
	
	pops = window.open('about:blank', 'input', 'width=800px,height=725px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes');
	
	$('#inputForm').attr("action", "<c:url value='/gbn10/pg103000Input.do'/>");
	$('#inputForm').attr("target", "input");
	inputForm.submit();
	
	POPUP_INTERVAL = setInterval(function() {
		console.log(1);
		if(typeof(popup)=='undefined' || popup.closed) {
			clearInterval(POPUP_INTERVAL);
			loadingOff();
		}		
	}, 250);
}

</script>

</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/top.jsp" flush="true" />
		<div id="content_wrap">
			<jsp:include page="/WEB-INF/jsp/left.jsp" flush="true" />
			<div id="contents">
				<div class="inner">
					<div class="path">
						<div class="inner">
							<ul>
								<li><a href="#"><img src="images/ico_home.png" alt="" /></a></li>
								<li><a href="#">인사관리</a></li>
								<li><a href="#">증명서 발급</a></li>
							</ul>
						</div>
					</div>
					<form:form modelAttribute="pg103000Dto" id="listForm" name="listForm" method="post">
					<h3>증명서 발급</h3>
					<div class="search_Area m_b_20">
                        <dl>
                            <dt>성명</dt>
                            <dd> <input type="text" id="usrname" name="usrname"></dd>
                        </dl>
                        <dl>
                            <dt>사번</dt>
                            <dd> <input type="text" id="pernNo" name="pernNo"></dd>
                        </dl>
							<dl>
								<dt>부서</dt>
								<dd>
									<form:select path="deptCode" value="${searchFormData.deptCode}">
										<ul class="deptList1">
											<li>
												<ul class="hidden">
													<form:option value="" label="전체" />
													<c:forEach var="deptList1" items="${deptList1}" varStatus="status">
														<li><form:option value="${deptList1.deptCode1}" label="${deptList1.deptName1}" />
															<ul class="deptList3">
																<c:forEach var="deptList2" items="${deptList2}" varStatus="status">
																	<c:if test="${deptList1.deptCode1 == deptList2.deptCode1}">
																		<li>
																			<form:option value="${deptList2.deptCode2}" label="  ↳     ${deptList2.deptName2}" />
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
								</dd>
							</dl>
							<dl>
                            <dt>일자</dt>
                            <dd>
                                <form:input type="date" path="expStartDate" value="${searchFormData.expStartDate}" />
                                <span class="m_5px_lr">~</span>
                                <form:input type="date" path="expEndDate" value="${searchFormData.expEndDate}" />
                            </dd>
                        </dl>
                        <dl>
                            <dt>증명구분</dt>
								<dd>
									<form:select path="certGbn" value="${searchFormData.certGbn}">
										<form:option value="" label="전체" />
										<c:forEach var="certList" items="${certList}" varStatus="status">
											<form:option value="${certList.certGbn}" label="${certList.certName}" />
										</c:forEach>
									</form:select>
									<a href="javascript:goReload()" class="btn_small bt_grey">검색</a>
								</dd>
							</dl>
                    </div>
					<div class="section">
                        <div class="table-scroll" style="margin:0;">
                            <table class="row_table">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" name="CheckAll" style="border:none" onclick="chkAll(this);" /></th>
                                        <th>신청일</th>
                                        <th>사번</th>
                                        <th>성명</th>
                                        <th>주민번호</th>
                                        <th>입사일</th>
                                        <th>퇴사일</th>
                                        <th>부서명</th>
                                        <th>증명구분</th>
                                        <th>신청사유</th>
                                        <th>신청통수</th>
                                        <th>처리일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="result" items="${pernList}" varStatus="status">
	                                    <tr>
	                                        <td><input type="checkbox" id="Check" name="Check" value=""></td>
	                                        <td><c:out value="${result.expDate}"/></td>
	                                        <td id="s_bun"><c:out value="${result.pernNo}"/></td>
	                                        <td><c:out value="${result.usrname}"/></td>
	                                        <td><c:out value="${result.usrrepreNum}"/></td>
	                                        <td><c:out value="${result.joinDate}"/></td>
	                                        <td><c:out value="${result.retrDate}"/></td>
	                                        <td><c:out value="${result.deptName}"/></td>
	                                        <td><c:out value="${result.certGbn}"/></td>
	                                        <td><c:out value="${result.expResn}"/></td>
	                                        <td><c:out value="${result.expCnt}"/></td>
	                                        <td><c:out value="${result.hanDate}"/></td>
	                                    </tr>
	                            	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
						<div class="btn_group m_t_20">
							<div class="left">
							<!-- To.DO 수정해야함  -->
								<div class="paging" id="paging">
									<c:if test="${pg103000Dto.prev}">
										<a href="javascript:void(0);" onclick="fn_go_page(${pg103000Dto.startDate - 1}); return false;" >◀</a>
									</c:if>
									<c:forEach var="num" begin="${pg103000Dto.startDate}" end="${pg103000Dto.endDate}">
										<a href="javascript:void(0);" onclick="fn_go_page(${num}); return false;" class="num${num}" title="${num}">${num}</a>
									</c:forEach>
									<c:if test="${pg103000Dto.next}">
										<a href="javascript:void(0);"  onclick="fn_go_page(${pg103000Dto.endDate + 1}); return false;" >▶</a>
									</c:if>
									<form:hidden path="pageIndex" id="pageIndex" val=""/>
								</div>
							</div>
							<div class="right">
								<a href="javascript:showPop();" class="btn_large bt_grey">사원정보</a>
								<a href="javascript:write();" class="btn_large bt_grey">증명서신청/등록</a>
								<a href="javascript:del();" class="btn_large bt_grey">삭제</a>
								<a href="javascript:view();" class="btn_large bt_grey">수정</a>
								<select>
									<option>직인</option>
									<option>직인 제거</option>
									<option>인감(2번)</option>
									<option>인감(3번)</option>
									<option>인감(5번)</option>
								</select>
								<select>
									<option>주민번호 표시</option>
									<option>주민번호 생략</option>
								</select>
								<a href="javascript:printDocu();" class="btn_large bt_blue">증명서 발행</a>
								<a href="javascript:pdf();" class="btn_large bt_blue">PDF 저장</a>
								<a href="javascript:email();" class="btn_large bt_blue">메일발송</a>
							</div>
						</div>
					</form:form>			
					<span>총게시물 ${totCnt} / 페이지 (${pg103000Dto.pageIndex} / ${totalPageCnt}) / 시작/끝 (${pg103000Dto.startDate} / ${pg103000Dto.endDate})</span>
				</div>
				<jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true" />
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="hidden" id="pernNo" name="pernNo"/>
                <input type="hidden" id="seq" name="seq" value="0"/>
			</form>
		</div>
	</div>
</body>
</html>