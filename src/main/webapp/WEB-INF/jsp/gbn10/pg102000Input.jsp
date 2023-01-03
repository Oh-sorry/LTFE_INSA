<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/jqgrid/css/ui.jqgrid.css'/>">
<link rel="stylesheet" href="<c:url value='/css/resetN.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="<c:url value='/css/styleN.css'/>"> <!-- css 파일 교체함  -->
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/scriptN.js'/>"></script> <!-- css 파일 교체함  -->
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script> <!-- 쿠키 사용을 위해 추가 -->

<title>(주)엠씨에스텍 인사급여시스템</title>

<script language="javascript">

var popup;
window.onunload = function() { popup.close(); } // 현재 팝업 새로고침 또는 닫기 시 자식 팝업도 함께 닫히도록

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

$(window).bind("beforeunload", function (e){
	opener.loadingOff();
});

function search() {
	
	var srcTxt = $('[id=inputForm] #srcTxt').val();
	
	if($('#srcTxt').val() == "") {
		alert('검색할 사원의 이름 또는 사번을 입력하세요.');
		$('#srcTxt').focus();
		return;
	}
	
	loadingOn();
	
	popup = window.open('${pageContext.request.contextPath}/gbn10/pg102000Search.do','search','width=800px,height=725px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes');
	
	POPUP_INTERVAL = setInterval(function() {
		console.log(1);
		if(typeof(popup)=='undefined' || popup.closed) {
			clearInterval(POPUP_INTERVAL);
			loadingOff();
		}		
	}, 250);
}

function inputFormSub() {
	if($('#name').val() == ""){
		alert('성명을 입력하십시오.');
		$('#name').focus();
		return;
	}
	if($('#pernNo').val() == ""){
		alert('사번을 입력하십시오.');
		$('#pernNo').focus();
		return;
	}
	if($('#eduStartDate').val() == ""){
		alert('시작일을 입력하십시오.');
		$('#eduStartDate').focus();
		return;
	}
	if($('#eduEndDate').val() == ""){
		alert('종료일을 입력하십시오.');
		$('#eduEndDate').focus();
		return;
	} else if ($('#eduStartDate').val() > $('#eduEndDate').val()) {
		alert("종료일이 시작일 보다 이릅니다.");
		$('#eduEndDate').focus();
		return;
	}
	if($('#eduTitle').val() == ""){
		alert('교육명을 입력하십시오.');
		$('#eduTitle').focus();
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
            <h2>교육사항등록</h2>
            <p class="pop_down">
                <a href="javascript:self.close();" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
            </p>
        </div>
        <div class="pop_content">
            <div class="pop_search_Area m_b_20">
                <table class="col_table w_50_p m_b_10"> 
                    <colgroup>
                        <col style="width:15%">
                        <col style="width:35%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>사번/성명</th>
                            <td>
                                <label></label>                                
                                <input type="text" size="15" id="srcTxt" name="srcTxt" onkeypress="javascript:if(event.keyCode==13)search();">
                                <a href="javascript:search();" class="btn_small bt_grey">검색</a>
                                <input type="hidden" name="sPernNo">
								<input type="hidden" name="sName">
                            </td>
                        </tr>
                    </tbody>
                </table>
                <form name="inputForm" id="inputFrom" action="<c:url value='/gbn10/pg102000Save.do' />" method="post">
                <table class="col_table m_b_20">
                    <colgroup>
                        <col style="width:15%">
                        <col style="width:35%">
                        <col style="width:15%">
                        <col style="width:35%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>성명</th>
                            <td>
                                <label></label>
                                <input type="hidden" name="seq" id="seq" value="${pg102000Info.seq}">
                                <input type="text" name="name" id="name" value="${pg102000Info.name}" readonly>
                            </td>
                            <th>사번</th>
                            <td>
                                <label></label>
                                <input type="text" name="pernNo" id="pernNo" value="${pg102000Info.pernNo}" readonly>
                            </td>
                        </tr>
                        <tr>
                            <th>시작일</th>
                            <td><input type="date" name="eduStartDate" id="eduStartDate" value="${pg102000Info.eduStartDate}"></td>
                            <th>종료일</th>
                            <td><input type="date" name="eduEndDate" id="eduEndDate" value="${pg102000Info.eduEndDate}"></td>
                        </tr>
                        <tr>
                            <th>교육명</th>
                            <td>
                                <label></label>
                                <input type="text" name="eduTitle" id="eduTitle" value="${pg102000Info.eduTitle}">
                            </td>
                            <th>교육기관</th>
                            <td>
                                <label></label>
                                <input type="text" name="eduSponsor" id="eduSponsor" value="${pg102000Info.eduSponsor}">
                            </td>
                        </tr>
                        <tr>
                            <th>입사구분</th>
                            <td>
                                <label></label>
                                <input type="radio" id="joinBa" name="joinBa" value="1"<c:if test="${pg102000Info.joinBa == '1'}">checked="checked"</c:if>>전
                                <label></label>
                                <input type="radio" id="joinBa" name="joinBa" value="2"<c:if test="${pg102000Info.joinBa == '2'}">checked="checked"</c:if>>후
                            </td>
                            <th>교육유형</th>
                            <td>
                                <label></label>
                                <select name="eduTypeCode" id="eduTypeCode">                                
                                    <option value="" <c:if test="${pg102000Info.eduTypeCode == ''}">selected="selected"</c:if>>없음</option>
                                    <option value="1" <c:if test="${pg102000Info.eduTypeCode == '1'}">selected="selected"</c:if>>사외</option>
                                    <option value="2" <c:if test="${pg102000Info.eduTypeCode == '2'}">selected="selected"</c:if>>사내</option>
                                    <option value="3" <c:if test="${pg102000Info.eduTypeCode == '3'}">selected="selected"</c:if>>통신</option>
                                    <option value="9" <c:if test="${pg102000Info.eduTypeCode == '9'}">selected="selected"</c:if>>기타</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>교육방법</th>
                            <td>
                                <label></label>
                                <select name="eduMethodCode" id="eduMethodCode">
                                	<option value="" <c:if test="${pg102000Info.eduMethodCode == ''}">selected="selected"</c:if>>없음</option>
                                	<option value="1" <c:if test="${pg102000Info.eduMethodCode == '1'}">selected="selected"</c:if>>개인</option>
                                	<option value="2" <c:if test="${pg102000Info.eduMethodCode == '2'}">selected="selected"</c:if>>회사</option>
                                	<option value="9" <c:if test="${pg102000Info.eduMethodCode == '9'}">selected="selected"</c:if>>기타</option>
                                </select>
                            </td>
                            <th>교육비</th>
                            <td>
                            	<label></label>
                                <input type="number" name="eduExpense" id="eduExpense" value="${pg102000Info.eduExpense}">
                            </td>
                        </tr>
                        <tr>
                            <th>고용보험환급</th>
                            <td>
                            	<label></label>
                                <input type="number" name="eduRefund" id="eduRefund" value="${pg102000Info.eduRefund}">
                            </td>
                            <th>실비용</th>
                            <td>
                            	<label></label>
                                <input type="number" name="eduRealExpense" id="eduRealExpense" value="${pg102000Info.eduRealExpense}">
                            </td>
                        </tr>
                        <tr>
                            <th>교육목적</th>
                            <td colspan="4">
                                <label></label>
                                <textarea class="w_100p" name="eduObject" id="eduObject">${pg102000Info.eduObject}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>교육내용</th>
                            <td colspan="4">
                                <label></label>
                                <textarea class="w_100p" name="eduContents" id="eduContents">${pg102000Info.eduContents}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td colspan="4">
                                <label></label><input type="file" name="realfile" id="realfile" value="${pg102000Info.realfile}">
                            </td>
                        </tr>
                    </tbody>
                </table>
                </form>
            </div>
            <div class="btn_group">
                <div class="right">
                    <a href="javascript:inputFormSub()" class="btn_large bt_blue">등록</a>
                    <a href="javascript:self.close();" class="btn_large bt_blue">닫기</a>
                </div>
            </div>
    	</div>
	</div>
    
</body>
</html>