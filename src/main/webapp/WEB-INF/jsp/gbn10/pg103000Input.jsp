<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>

<title>제증명 신청/접수</title>

<script language="javascript">

var popup;
window.onunload = function() { popup.close(); } 

$(document).ready(function() {
	/* window.resizeTo($('#pop_warp').width() + 20,$('#pop_warp').height() + 80); */
	window.focus();

	if ($('#msg').val() != "") {
		alert($('#msg').val());
	}

	if ($('#close').val() == "true") {
		opener.goReload();
		self.close();
	}
	
	if ($('#seq').val() == "") {
		$('#seq').val(0);
	}
});

function search() {
	
	if($('#srcTxt').val() == "") {
		alert('검색할 사원의 이름 또는 사번을 입력하세요.');
		$('#srcTxt').focus();
		return;
	}
	
	loadingOn();
	
	popup = window.open('${pageContext.request.contextPath}/gbn10/pg103000Search.do','search','width=1000px,height=650px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes');
	
	POPUP_INTERVAL = setInterval(function() {
		console.log(1);
		if(typeof(popup)=='undefined' || popup.closed) {
			clearInterval(POPUP_INTERVAL);
			loadingOff();
		}		
	}, 250);
}

function inputFormSub() {
	if($('#expDate').val() == ""){
		alert('신청일을 입력하십시오.');
		$('#expDate').focus();
		return;
	}
	if($('#hanDate').val() == ""){
		alert('처리일을 입력하십시오.');
		$('#hanDate').focus();
		return;
	}
	if($('#certGbn').val() == ""){
		alert('증명구분을 선택하십시오.');
		$('#certGbn').focus();
		return;
	}
	if($('#expCnt').val() == ""){
		alert('신청통수를 입력하십시오.');
		$('#expCnt').focus();
		return;
	}
	if($('#expResn').val() == ""){
		alert('신청사유를 선택하십시오.');
		$('#expResn').focus();
		return;
	}
	if(($('#pernNo').val() == "") || ($('#usrname').val() == "") || ($('#usrrepreNum').val() == "") || ($('#usraddr').val() == "") || ($('#usrbirth').val() == "")) {
		alert('위에서 사원을 선택하십시오.');
		return;
	}
	
	inputForm.submit();
}
</script>

</head>
<body>
	<input type="hidden" name="processType" id="processType" value="${processType}">
	<input type="hidden" name="msg" id="msg" value="${msg}">
	<input type="hidden" name="close" id="close" value="${close}">
	<div class="pop_warp">
		<div class="p_title">
			<h2>증명서 발급</h2>
			<p class="pop_down">
                <a href="javascript:self.close();" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
            </p>
		</div>
		<div class="pop_content">
			<div class="pop_search_Area m_b_20">
				<table class="col_table w_60_p m_b_10">
					<colgroup>
						<col style="width: 20%">
						<col style="width: 10%">
						<col style="width: 20%">
						<col style="width: 60%">
					</colgroup>
					<tbody>
						<tr>
							<th>퇴직포함</th>
							<td><input type="checkbox" id="srcCheck" name="srcCheck" class="input"></td>
							<th>성명/사번</th>
							<td>
								<input type="text" size="15" id="srcTxt" name="srcTxt" onkeypress="javascript:if(event.keyCode==13)search();">
								<a href="javascript:search();" class="btn_small bt_grey">검색</a>
								<input type="hidden" name="sPernNo">
								<input type="hidden" name="sName">
							</td>
						</tr>
					</tbody>
				</table>
				<form name="inputForm" id="inputFrom" action="<c:url value='/gbn10/pg103000Save.do' />" method="post"  enctype="multipart/form-data">
					<table class="col_table m_b_20">
						<colgroup>
							<col style="width: 15%">
							<col style="width: 35%">
							<col style="width: 15%">
							<col style="width: 35%">
						</colgroup>
						<tbody>
							<tr>
								<th>성명</th>
								<td><input type="text" id="usrname" name="usrname"></td>
								<th>사번</th>
								<td><input type="text" id="pernNo" name="pernNo"></td>
							</tr>
							<tr>
								<th>신청일</th>
								<td><input type="date" id="expDate" name="expDate"></td>
								<th>처리일</th>
								<td><input type="date" id="hanDate" name="hanDate"></td>
							</tr>
							<tr>
								<th>증명구분</th>
								<td colspan="3">
									<select name="certGbn" class="input">
											<!-- value 값 추후 수정 -->
											<option value="">선택</option>
											<option value="1">신입</option>
											<option value="2">경력</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>신청통수</th>
								<td colspan="3"><input type="text" id="expCnt" name="expCnt"></td>
							</tr>
							<tr>
								<th>주민등록번호</th>
								<td colspan="3"><input type="text" id="usrrepreNum" name="usrrepreNum"></td>
							</tr>
							<tr>
								<th>재직기간</th>
								<td colspan="3">
									1. <input type="text" id="workPeriod1" name="workPeriod1"> <br> 
									2. <input type="text" id="workPeriod2" name="workPeriod2"> <br>
									3. <input type="text" id="workPeriod3" name="workPeriod3"> <br>
								</td>
							</tr>
							<tr>
								<th><input type="text" id="usrfield1" name="usrfield1" class="input"></th>
								<td colspan="3"><input type="text" id="usrfield2" name="usrfield2"></td>
							</tr>
							<tr>
								<th>신청사유</th>
								<td colspan="3">
									<select name="expResn" class="input">
											<!-- value 값 추후 수정 -->
											<option value="">선택</option>
											<option value="타업체 제출용">타업체 제출용</option>
											<option value="은행제출용">은행제출용</option>
											<option value="교육기관 제출용">교육기관 제출용</option>
											<option value="기타">기타</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>주소</th>
								<td colspan="3"><input type="text" id="usraddr" name="usraddr"></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td colspan="3"><input type="text" id="usrbirth" name="usrbirth"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="btn_group">
				<div class="right">
					<a href="javascript:inputFormSub()" class="btn_large bt_blue">저장</a>
					<a href="javascript:self.close();" class="btn_large bt_blue">닫기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>