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
<link rel="stylesheet" href="<c:url value='/css/reset.css' />">
<link rel="stylesheet" href="<c:url value='/css/style.css' />">
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script src="<c:url value='/js/jquery-ui.min.js' />"></script>
<script src="<c:url value='/js/script.js' />"></script>
<script src="<c:url value='/js/common.js' />"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>
</head>
<body>
	<div id="wrap">
        <jsp:include page="/WEB-INF/jsp/top.jsp" flush="true"/>
        <div id="content_wrap">
            <div id="allMenu">
                <div class="allList">
                    <ul>
               	    <c:forEach var="loginMenu" items="${sessionScope.loginMenuListDto}" varStatus="status">
           	    	<c:if test="${status.index == 0}">
           	    		<li>
           	    		<p><c:out value="${loginMenu.menuNm}" escapeXml="true"/></p>
                            <ul>
           	    	</c:if>
           	     	<c:if test="${status.index > 0 && loginMenu.menuGubn2 == '00'}">
           	    			</ul>
           	    		</li>
           	    		<li>
           	    		<p><c:out value="${loginMenu.menuNm}" escapeXml="true"/></p>
                            <ul>
           	    	</c:if>
           	    	<c:if test="${status.index > 0 && loginMenu.menuGubn2 != '00'}">
           	    		<li><a href="javascript:goProgram('${loginMenu.menuGubn1}','${loginMenu.menuId}','<c:url value="${loginMenu.menuSrc}"/>')"><c:out value="${loginMenu.menuNm}" escapeXml="true" /></a></li>
           	    	</c:if>
    				</c:forEach>
    					</ul>
    				   </li>
	                </ul>
                </div>
            </div>
            <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
        </div>
    </div>
</body>
</html>
