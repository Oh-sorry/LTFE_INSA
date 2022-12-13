<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/jqgrid/css/ui.jqgrid.css'/>">
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>

<script language="javascript">

$(document).ready(function() {
	window.resizeTo($('#pop_warp').width() + 20,$('#pop_warp').height() + 80);
	window.focus();

	if ($('#msg').val() != "") {
		alert($('#msg').val());
	}

	if ($('#processType').val() == "UPDATE") {
		$('#menuGubn1').attr("readonly",true);
	}

	if ($('#close').val() == "true") {
		opener.goReload();
		self.close();
	}

});

$(window).bind("beforeunload", function (e){
	opener.loadingOff();
});

function inputFormSub() {
	if($('#menuGubn1').val() == ""){
		alert('구분코드를 입력하십시오.');
		return;
	}
	if($('#menuNm').val() == ""){
		alert('프로그램(구분)명을 입력하십시오.');
		return;
	}

	inputForm.submit();
}



</script>
</head>
<body>
	<form name="inputForm" action="<c:url value='/gbn30/pg309501Save.do' />" method="post">
	<input type="hidden" name="processType" id="processType" value="${processType}">
	<input type="hidden" name="msg" id="msg" value="${msg}">
	<input type="hidden" name="close" id="close" value="${close}">
	<div class="pop_warp" id="pop_warp">
        <div class="p_title" id="p_title">
            <h2>프로그램(메뉴) 관리</h2>
            <p class="pop_down">
                <a href="javascript:self.close();" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
            </p>
        </div>
        <div class="pop_content" id="pop_content">
            <div class="pop_search_Area m_b_20">
                <table class="main-table">
                    <colgroup>
                        <col style="width:30%" />
                        <col style="width:80%" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>구분코드</th>
                            <td>
                                <input type="text" name="menuGubn1" id="menuGubn1" maxlength="2" value="${pg309501Info.menuGubn1}" onkeydown="isOnlyNum(event)">
                            </td>
                        </tr>
                        <tr>
                            <th>프로그램(구분)명</th>
                            <td>
                                <label></label>
                                <input type="text" name="menuNm" id="menuNm" value="${pg309501Info.menuNm}" maxlength="25">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn_group" id="btn_group">
                <div class="right">
                    <a href="javascript:inputFormSub()" class="btn_large bt_blue">등록</a>
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
