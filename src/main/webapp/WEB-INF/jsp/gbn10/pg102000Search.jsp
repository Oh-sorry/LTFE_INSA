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
<link rel="stylesheet" href="<c:url value='/css/resetN.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="<c:url value='/css/styleN.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous">
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

$(document).ready(function() {
	
	if ($('#sStr').val() == "") {
		$('#sStr').val(opener.document.getElementById("srcTxt").value);
		document.searchForm.action = "<c:url value='/gbn10/pg102000Search.do'/>";
		document.searchForm.submit();
	}
	
});

/* $(window).bind("beforeunload", function (e){
	opener.loadingOff();
}); */

function goReload() {
	
	if ($('[id=searchForm] #sStr').val().trim() == '') {
		alert("사번/성명을 입력하세요");
		$('[id=searchForm] #sStr').focus();
		return;	
	}
	
	document.searchForm.action = "<c:url value='/gbn10/pg102000Search.do'/>";
	document.searchForm.submit();		
}

function checkOnlyOne(element) {
	
	if(element.checked == false) {
		element.checked = false; 
		return;
	}
	
	const checkboxes = document.getElementsByName("check");

	checkboxes.forEach((cb) => {
		cb.checked = false;
	})
	
	element.checked = true;
}

function selectData() {

	var checked = false;
	
	$('input:checkbox[name=check]').each(function (index) {
		if($(this).is(":checked")==true){		    	
	    	var str = $(this).val().split(',');
	    	
	    	$('[id=inputForm] #pernNo').val(str[0]);
	    	$('[id=inputForm] #name').val(str[1]);	
	    	
	    	opener.document.getElementById('pernNo').value = str[0];
	    	opener.document.getElementById('name').value = str[1];
	    	
	    	checked = true;
	    }
	});
	
	if(checked == false) {
		alert("수정할 데이터를 선택하세요");
		return;
	}

	document.searchForm.submit();
	popupClose();
}
function popupClose(){
	/* opener.loadingOff(); */
	self.close();
}


</script>

</head>
<body>
	<form:form modelAttribute="pg102000Dto" id="searchForm" name="searchForm" method="post">	
		<input type="hidden" id="pernNo" name="pernNo"/>
    	<input type="hidden" id="name" name="name"/>                
		<div class="pop_warp">
	        <div class="p_title">
	            <h2>사번/성명 검색</h2>
	            <p class="pop_down">
	                <a href="javascript:popupClose()" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
	            </p>
	        </div>
	        <div class="pop_content">
	            <div class="pop_search_Area m_b_20">
	                <div class="section">
	                        <div class="cols_area">
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
					                            <form:input size="8" path="sStr" value="${searchFormData.sStr}" onkeypress="javascript:if(event.keyCode==13)goReload();"/>
					                            <a href="javascript:goReload();" class="btn_small bt_grey">검색</a>
					                        </td>
					                    </tr>
					                </tbody>
					            </table>
				                <div id="table-scroll" class="table-scroll" style="height:400px; margin:0;">
		                            <table class="row_table">
		                                <thead>
		                                    <tr>
		                                        <th></th>
		                                        <th>성명</th>
		                                        <th>사번</th>
		                                    </tr>
		                                </thead>
		                                <tbody>
		                                	<c:forEach var="result" items="${searchList}" varStatus="status">
		                                		<tr>
		                                			<td>
		                                				<label></label>
		                                				<input type="checkbox" id="check" name="check" onclick='checkOnlyOne(this)' value="${result.pernNo}, ${result.name}">
		                                			</td>
		                                			<td><c:out value="${result.name}" /></td>
		                                			<td><c:out value="${result.pernNo}" /></td>
		                                		</tr>
		                                	</c:forEach>
		                                </tbody>
		                            </table>
	                            </div>
	                        </div>
	                    </div>
	            </div>
	            <div class="btn_group">
	                <div class="right">
	                    <a href="javascript:selectData()" class="btn_large bt_blue">선택</a>
	                    <a href="javascript:popupClose()" class="btn_large bt_blue">닫기</a>
	                </div>
	            </div>
	    	</div>
		</div>
    </form:form>
</body>
</html>