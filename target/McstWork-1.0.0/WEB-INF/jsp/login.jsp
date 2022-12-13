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
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.min.css' />" />
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script src="<c:url value='/js/jquery-ui.min.js' />"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>

<script type="text/javascript">
function loginDo() {
	if ($('#pernNo').val().trim() == "") {
		alert("사용자 아이디를 입력하세요");
		$('#userid').focus();
		return;
	}
	if ($('#pernPwd').val().trim() == "") {
		alert("사용자 비밀번호를 입력하세요");
		$('#userpass').focus();
		return;
	}

	$('#inputform').submit();
}

$(document).ready(function() {
    if (opener != null) {
    	opener.location.reload();
    	self.close();
    } else {
        var message = $('#message').val();
        if (message != "") {
            alert(message);
        }
    }
});
</script>
</head>

<body>
	<form id="inputform" name="inputform" action="<c:url value='/loginChk.do'/>" method="post">
	<input type="hidden" id="message" name="message" value="${message}">
	<div id="login_wrap">
		<div class="login_area">
			<h1><img src="<c:url value='/images/login_logo.png'/>" alt="logo"/></h1>
			<h2>인사급여시스템</h2>
			<div class="form_area">
				<input type="text" id="pernNo" name="pernNo" placeholder="아이디" value="1999069"/>
				<input type="password" id="pernPwd" name="pernPwd" placeholder="비밀번호" value="1999069"/>
				<span><a href="javascript:loginDo();" class="log_btn">로그인</a></span>
			</div>
			<span class="login_info">아이디/비밀번호 입력해주세요</span>
		</div>
	</div>
	</form>
</body>
</html>
