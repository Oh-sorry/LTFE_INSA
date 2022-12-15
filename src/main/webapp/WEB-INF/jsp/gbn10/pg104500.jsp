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
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/css/newStyle.css'/>">
<link rel="stylesheet" href="/css/jquery-ui.css" />
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>

<title>(주)엠씨에스텍 인사급여시스템</title>

</head>
<body>
<script language="javascript">

$(document).ready(function() {
	$("#grid").jqGrid({
	   	url:"<c:url value='/gbn10/pg104500List.ajax' />",
	   	mtype: "POST",
		datatype: "json",
		locale : "kr",
		/* postData : {'searchMenuGubn1':'10'}, */
		jsonReader : {
			root: "rowData",
			repeatitems: false
		},
		colModel:[
			{label:'사번', name:'pernNo', align:'center', width:100},
			{label:'성명', name:'name', align:'center', width:100},
			{label:'성별', name:'sexCode', align:'center', width:50},
			{label:'부서코드', name:'deptCode', align:'center', hidden:true},
			{label:'부서', name:'deptName', align:'center', width:150},
			{label:'직위코드', name:'postCode', align:'center', hidden:true},
			{label:'직위', name:'postName', align:'center', width:100},
			{label:'직급코드', name:'payGrade', align:'center', hidden:true},
			{label:'직급', name:'payName', align:'center', hidden:true},
			{label:'입사구분코드', name:'joinCode', align:'center', hidden:true},
			{label:'입사구분', name:'joinName', align:'center', width:100},
			{label:'사원구분코드', name:'employType', align:'center', hidden:true},
			{label:'사원구분', name:'employName', align:'center', width:100},
			{label:'급여구분코드', name:'salaryName', align:'center', hidden:true},
			{label:'급여구분', name:'salaryCode', align:'center', hidden:true},
			/* {label:'연봉구분', name:'wagesAmt', align:'center'}, */
			{label:'연봉구분', name:'stringWagesAmt', align:'center', width:100},
			{label:'입사일자', name:'joinDate', align:'center', width:150},
			{label:'퇴사일자', name:'retrDate', align:'center', width:150},
			{label:'근무지코드', name:'workArea', align:'center', hidden:true},
			{label:'근무지', name:'workAreaName', align:'center', width:100},
			{label:'핸드폰', name:'phoneNo', align:'center', width:150},
			{label:'상조회', name:'mutualYn', align:'center', width:50},
			{label:'재퇴직코드', name:'detailCode', align:'center', hidden:true},
			{label:'재퇴직', name:'detailCodeName', align:'center', hidden:true}
	   	],
	   	loadonce: true,
	   	sortable : true,
	   	showpage : false,
        rownumbers : true,
	   	rowNum: 9007199254740992,
	   	width: $('#contents').width() -42,
        height: 500,
	   	beforeRequest : function () {loadingOn();},
	   	loadComplete: function (data) {if($('#grid').getGridParam("records")== 0) alert('조회된 내용이 없습니다.');loadingOff();}
	});
});

$(window).bind('resize', function() {
	$("#grid").setGridWidth($('#contents').width() -42, true);
}).trigger('resize');

//To.do : menuGubn1, searchMenuGubn1 수정필요
function goReload() {

	$('[id=inputForm] #deptCode').val($('#searchMenuGubn1').val());
	$('[id=inputForm] #postCode').val($('#searchMenuGubn2').val());
	$('[id=inputForm] #payGrade').val($('#searchMenuGubn3').val());
	$('[id=inputForm] #salaryCode').val($('#searchMenuGubn4').val());
	
	var formData = $('#searchForm').serializeArray();

	console.log(formData);
	
	$('#grid').clearGridData();
	$('#grid').setGridParam({datatype : "json",
		                     postData : formData }).trigger("reloadGrid");
}

</script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="/WEB-INF/jsp/top.jsp" flush="true"/>
        <div id="content_wrap">
            <jsp:include page="/WEB-INF/jsp/left.jsp" flush="true"/>
            <div id="contents">
				<div class="inner">
					<div class="path">
						<div class="inner">
							<ul>
								<li><a href="#"><img src="<c:url value='/images/ico_home.png' />" alt="" /></a></li>
								<li><a href="#">인사관리</a></li>
								<li><a href="#">기본검색</a></li>
							</ul>
						</div>
					</div>
					<h3>기본검색</h3>
					<div class="section">
						<div class="search_Area m_b_20">
						    <form name="searchForm" id="searchForm">
                            <table>
                                <colgroup>
                                    <col style="width:7%" />
                                    <col style="" />
                                </colgroup>
                                <tbody>
                                    <tr>
                                    	<!-- TO.Do 연결 어캐하지 미침 그냥 터짐 -->
                                        <th>재/퇴직</th>
                                        <td>
                                            <label></label>
                                              <select id="joinDateCode" name="joinDateCode">
								     	   	  	<option value="" selected>--선택--</option>
								     	   	  	<c:forEach var="gbnJoin" items="${gbnJoin}" varStatus="status">
                                        			<option value="${gbnJoin.detailCode}">${gbnJoin.detailCodeName}</option>
                                        		</c:forEach>
								      		  </select>
                                        </td>
                                        <!-- TO.Do 연결 어캐하지 미침 그냥 터짐 -->
                                        <th>부서</th>
                                        <td>
                                        	<label></label>
                                        		<select id="deptCode" name="deptCode">
                                        		<option value="">전체</option>
                                        		<c:forEach var="gbnList" items="${gbnList}" varStatus="status">
                                        			<option value="${gbnList.deptCode}">${gbnList.deptName}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>직위</th>
                                        <td>
                                        	<label></label>
                                        		<select id="postCode" name="postCode">
                                        		<option value="">전체</option>
                                        		<c:forEach var="gbnList2" items="${gbnList2}" varStatus="status">
                                        			<option value="${gbnList2.postCode}">${gbnList2.postName}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>직급</th>
                                        <td>
                                        	<label></label>
                                        		<select id="payGrade" name="payGrade">
                                        		<option value="">전체</option>
                                        		<c:forEach var="gbnList3" items="${gbnList3}" varStatus="status">
                                        			<option value="${gbnList3.payGrade}">${gbnList3.payName}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>급여구분</th>
                                        <td>
                                        	<label></label>
                                        		<select id="salaryCode" name="salaryCode">
                                        		<option value="">전체</option>
                                        		<c:forEach var="gbnList4" items="${gbnList4}" varStatus="status">
                                        			<option value="${gbnList4.salaryCode}">${gbnList4.salaryName}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        <th>사번/성명</th>
                                        <td>
                                        	<label></label>
                                        	<input type="text" id="pernno" name="pernno">
                                        	<a href="javascript:goReload()" class="btn_small bt_grey">검색</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>
                        </div>
						<div><table id="grid"></table></div>
                    </div>
                    <div class="btn_group">
                        <div class="right">
                            <a href="" class="btn_large bt_blue" href="">엑셀</a>
                        </div>
                    </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="hidden" name="pernNo" id="pernNo">
				<input type="hidden" name="name" id="name">
				<input type="hidden" name="sexCode" id="sexCode">
				<input type="hidden" name="deptCode" id="deptCode" value="150100">
				<input type="hidden" name="deptName" id="deptName">
				<input type="hidden" name="postCode" id="postCode" value="60">
				<input type="hidden" name="postName" id="postName">
				<input type="hidden" name="payGrade" id="payGrade" value="01">
				<input type="hidden" name="payName" id="payName">
				<input type="hidden" name="joinCode" id="joinCode">
				<input type="hidden" name="joinName" id="joinName">
				<input type="hidden" name="employType" id="employType">
				<input type="hidden" name="employName" id="employName">
				<input type="hidden" name="salaryCode" id="salaryCode" value="01">
				<input type="hidden" name="salaryName" id="salaryName">
				<input type="hidden" name="stringWagesAmt" id="stringWagesAmt">
				<!-- <input type="hidden" name="wagesAmt" id="wagesAmt"> -->
				<input type="hidden" name="joinDate" id="joinDate">
				<input type="hidden" name="retrDate" id="retrDate">
				<input type="hidden" name="workArea" id="workArea">
				<input type="hidden" name="workAreaName" id="workAreaName">
				<input type="hidden" name="phoneNo" id="phoneNo">
				<input type="hidden" name="mutualYn" id="mutualYn">
				<input type="hidden" name="detailCode" id="detailCode">
				<input type="hidden" name="detailCodeName" id="detailCodeName">
				
			</form>
        </div>
    </div>
</body>
</html>