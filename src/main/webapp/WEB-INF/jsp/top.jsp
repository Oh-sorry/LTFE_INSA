<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<script language="javascript">
			function goProgram(menuGbn, menuId, programUrl) {
				sessionStorage.setItem("leftMenuGbn",menuGbn);
				sessionStorage.setItem("leftMenuId",menuId);
				$('#programForm').attr("action",programUrl);
				$('#programForm')[0].submit();
			}

			$(document).ready(function() {
				var menuGbn = sessionStorage.getItem("leftMenuGbn");
				var menuId = sessionStorage.getItem("leftMenuId");
				$('#leftMenu'+menuGbn).addClass("on").next("ul").slideDown("fast");

			});
		</script>
		<form id="programForm" name="programForm" methd="post"></form>

        <div id="header">
            <h1><a href="<c:url value='/main.do' />"><img src="<c:url value='/images/logo.png' />" alt="(주)엠씨에스텍"></a></h1>
            <div class="top_info">
                <ul>
                    <li><b>${sessionScope.loginDto.name}</b> 님 반갑습니다.</li>
                    <li><a href="<c:url value='/logOut.do' />">로그아웃</a></li>
                    <li><a href="">비밀번호 변경</a></li>
                </ul>
            </div>
        </div>