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
	window.resizeTo($('#pop_warp').width() + 20,$('#pop_warp').height() + 100);
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

	//opener.loadingOn();

});

$(window).bind("beforeunload", function (e){
	opener.loadingOff();
});

function inputFormSub() {
	/*
	if($('#menuGubn1').val() == ""){
		alert('구분코드를 입력하십시오.');
		return;
	}
	if($('#menuNm').val() == ""){
		alert('프로그램(구분)명을 입력하십시오.');
		return;
	}
	*/
	inputForm.submit();

	console.log("111111");
	console.log(document.inputForm.menuId.value);
	console.log(document.inputForm.menuAuth.value);
}


$( function() {
    $( "#nameSearch" ).autocomplete({
      source: "<c:url value='/nameSearch.ajax' />",
      minLength: 1,
      select: function( event, ui ) {
        $('#pernNum').val(ui.item.value.substring(0,7));
        $('#inputForm').attr("action", "<c:url value='/gbn30/pg309502Modify.do'/>");
        inputForm.submit();
      }
    });
  } );

</script>
</head>
<body>
	<form name="inputForm" id="inputForm" action="<c:url value='/gbn30/pg309502Save.do'/>" method="post">
	<input type="hidden" name="processType" id="processType" value="${processType}">
	<input type="hidden" name="msg" id="msg" value="${msg}">
	<input type="hidden" name="close" id="close" value="${close}">
	<input type="text" name="pernNum" id="pernNum" value="${pernInfo.pernNo}">
	<div class="pop_warp" id="pop_warp">
        <div class="p_title" id="p_title">
            <h2>권한 관리</h2>
            <p class="pop_down">
                <a href="javascript:self.close();" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
            </p>
        </div>
        <div class="pop_content" id="pop_content">
        	<div class="search_Area m_b_20">
                <c:if test="${pernInfo != null}">
                    <table>
	                    <colgroup>
	                        <col style="width:10%" />
	                        <col style="" />
	                        <col style="width:10%" />
	                        <col style="" />
	                    </colgroup>
	                    <tbody>
	                        <tr>
	                            <th>사번 :</th>
	                            <td>${pernInfo.pernNo}</td>
	                            <th>성명 :</th>
	                            <td>${pernInfo.name}</td>
	                        </tr>
	                    </tbody>
	                </table>
                </c:if>
                <c:if test="${pernInfo == null}">
	                <table>
	                    <colgroup>
	                        <col style="width:15%" />
	                        <col style="" />
	                    </colgroup>
	                    <tbody>
	                        <tr>
	                            <th>성명/사번</th>
	                            <td>
	                                <input type="text" id="nameSearch">
	                                <!-- label>※ 2자 이상 입력</label -->
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
                </c:if>
            </div>
            <div class="pop_input_Area m_b_20">
                <table class="table table_list">
                    <colgroup>
                        <col style="width:30%" />
                        <col style="width:80%" />
                    </colgroup>
				    <tbody>
				   		<tr>
                           <th>구분</th>
                           <th>권한</th>
				    	</tr>
				  		<c:forEach var="pg309502List" items="${pg309502Info}" varStatus="status">
				  			<input type="hidden" name="menuId" id="menuId" value="${pg309502List.menuId}" />
				  			<tr>
						    	<td>${pg309502List.menuNm}</td>
				            	<td>
				            	    <select name="menuAuth" id="menuAuth">
					            		<c:if test="${pg309502List.menuAuth == '0'}">
					            			<option value="0" selected>권한없음
					            		</c:if>
					            		<c:if test="${pg309502List.menuAuth != '0'}">
					            			<option value="0">권한없음
					            		</c:if>
					            	    <c:if test="${pg309502List.menuAuth == '1'}">
					            			<option value="1" selected>쓰기
					            		</c:if>
					            		<c:if test="${pg309502List.menuAuth != '1'}">
					            			<option value="1">쓰기
					            		</c:if>
					            		<c:if test="${pg309502List.menuAuth == '2'}">
					            			<option value="2" selected>읽기
					            		</c:if>
					            		<c:if test="${pg309502List.menuAuth != '2'}">
					            			<option value="2">읽기
					            		</c:if>
				            	    </select>
				            	</td>
				            </tr>
				  		</c:forEach>
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
