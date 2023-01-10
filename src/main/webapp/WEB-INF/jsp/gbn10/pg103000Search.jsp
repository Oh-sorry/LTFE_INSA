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

<title>사원 검색</title>

<script language="javascript">

$(document).ready(function() {
	if($('#sStr').val() == "") {
		$('#sStr').val(opener.document.getElementById("srcTxt").value);
		document.searchForm.action = "<c:url value='/gbn10/pg103000Search.do'/>";
		document.searchForm.submit();
		
		
		if($("input:checkbox[name='check']:checked").length == 1) {
			cnt = 1;
			selectData();
		}
	} 
});

function goReload() {
	if ($('[id=searchForm] #sStr').val().trim() == '') {
		alert("사번/성명을 입력하세요");
		$('[id=searchForm] #sStr').focus();
		return;	
	}
	document.searchForm.action = "<c:url value='/gbn10/pg103000Search.do'/>";
	document.searchForm.submit();		
}

function selectData() {
	
	var form = document.searchForm;
	var ChBox = $('[name="check"]');
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
	
	$('input:checkbox[name=check]').each(function (index) {
		if($(this).is(":checked") == true) {
			var str = $(this).val().split('.');
			
			$('[id=inputForm] #pernNo').val(str[0]);
			$('[id=inputForm] #usrname').val(str[1]);
			$('[id=inputForm] #usrrepreNum').val(str[2]);
			
			if(str[4] == null || str[4] == ' ') {
				$('[id=inputForm] #workPeriod1').val(str[3] + ' ~ 현재');
				opener.document.getElementById('workPeriod1').value = str[3] + ' ~ 현재';
			} else {
				$('[id=inputForm] #workPeriod1').val(str[3] + ' ~ ' + str[4]);
				opener.document.getElementById('workPeriod1').value = str[3] + ' ~ ' + str[4];
			}
			$('[id=inputForm] #usrfield1').val('직     위');
			$('[id=inputForm] #usrfield2').val(str[5]);
			$('[id=inputForm] #usrbirth').val(str[6]);
			$('[id=inputForm] #usraddr').val(str[7]);
			
			opener.document.getElementById('pernNo').value = str[0];
			opener.document.getElementById('usrname').value = str[1];
			opener.document.getElementById('usrrepreNum').value = str[2];
			opener.document.getElementById('usrfield1').value = '직     위';
			opener.document.getElementById('usrfield2').value = str[5];
			opener.document.getElementById('usrbirth').value = str[6];
			opener.document.getElementById('usraddr').value = str[7];
			
			checked = true;
		}
	});
	
	if(checked == false) {
		alert("사용할 데이터를 선택하세요");
		return;
	}
	document.searchForm.submit();
	self.close();
}
</script>

</head>
<body>
	<form:form modelAttribute="pg103000Dto" id="searchForm" name="searchForm" method="post">	
		<input type="hidden" id="pernNo" name="pernNo"/>
    	<input type="hidden" id="usrname" name="usrname"/>
    	<input type="hidden" id="usrrepreNum" name="usrrepreNum"/>
    	<input type="hidden" id="usrfield2" name="usrfield2"/>
    	<input type="hidden" id="usraddr" name="usraddr"/>     
    	<input type="hidden" id="usrbirth" name="usrbirth"/>
    	
		<div class="pop_warp">
	        <div class="p_title">
	            <h2>사원 검색</h2>
	            <p class="pop_down">
	                <a href="javascript:self.close();" title="닫기" class="closeX"><img src="<c:url value='/images/pop_close.png' />" alt="닫기"></a>
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
		                                        <th>사번</th>
		                                        <th>성명</th>
		                                        <th>주민등록번호</th>
		                                        <th>입사일자</th>
		                                        <th>퇴사일자</th>
		                                        <th>직위</th>
		                                        <th>직급</th>
		                                        <th>부서</th>
		                                    </tr>
		                                </thead>
		                                <tbody>
		                                	<c:forEach var="result" items="${searchList}" varStatus="status">
		                                		<tr>
		                                			<td>
		                                				<label></label>
		                                				<input type="checkbox" id="check" name="check" onclick='checkOnlyOne(this)' value="${result.pernNo}.${result.usrname}.${result.usrrepreNum}.${result.joinDate}.${result.retrDate}.${result.postName}.${result.usrbirth}.${result.usraddr}" checked>
		                                			</td>
		                                			<td><c:out value="${result.usrname}" /></td>
		                                			<td id="s_bun"><c:out value="${result.pernNo}" /></td>
		                                			<td><c:out value="${result.usrrepreNum}" /></td>
		                                			<td><c:out value="${result.joinDate}" /></td>
		                                			<td><c:out value="${result.retrDate}" /></td>
		                                			<td><c:out value="${result.postName}" /></td>
		                                			<td><c:out value="${result.payName}" /></td>
		                                			<td><c:out value="${result.deptName}" /></td>
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
	                    <a href="javascript:selectData();" class="btn_large bt_blue">선택</a>
	                    <a href="javascript:self.close();" class="btn_large bt_blue">닫기</a>
	                </div>
	            </div>
	    	</div>
		</div>
    </form:form>
</body>
</html>