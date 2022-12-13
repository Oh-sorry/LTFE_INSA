<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

            <div id="lnb">
                <div class="menu_all">
                    <div class="list">
                    <ul>
               	    <c:forEach var="loginMenu" items="${sessionScope.loginMenuListDto}" varStatus="status">
           	    	<c:if test="${status.index == 0}">
           	    		<li>
           	    		<a href="" id="leftMenu${loginMenu.menuGubn1}"><c:out value="${loginMenu.menuNm}" escapeXml="true"/></a>
                            <ul>
           	    	</c:if>
           	     	<c:if test="${status.index > 0 && loginMenu.menuGubn2 == '00'}">
           	    			</ul>
           	    		</li>
           	    		<li>
           	    		<a href="" id="leftMenu${loginMenu.menuGubn1}"><c:out value="${loginMenu.menuNm}" escapeXml="true"/></a>
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
            </div>