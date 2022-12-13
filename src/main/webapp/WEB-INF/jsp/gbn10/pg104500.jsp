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
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="/js/newScript.js"></script>

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
			{label:'사번', name:'pernNo', align:'center'},
			{label:'성명', name:'name', align:'center'},
			{label:'성별', name:'sexCode', align:'center'},
			{label:'부서코드', name:'deptCode', align:'center', hidden:true},
			{label:'부서', name:'deptName', align:'center'},
			{label:'직위', name:'postCode', align:'center'},
			{label:'입사구분', name:'joinCode', align:'center'},
			{label:'사원구분', name:'employType', align:'center'},
			{label:'급여구분', name:'salaryCode', align:'center'},
			{label:'연봉구분', name:'wagesAmt', align:'center'},
			{label:'입사일자', name:'joinDate', align:'center'},
			{label:'퇴사일자', name:'retrDate', align:'center'},
			{label:'근무지', name:'workArea', align:'center'},
			{label:'핸드폰', name:'phoneNo', align:'center'},
			{label:'상조회', name:'mutualYn', align:'center'}
	   	],
	   	loadonce: true,
	   	sortable : true,
	   	showpage : false,
        rownumbers : true,
	   	rowNum: 9007199254740992,
	   	width: $('#contents').width() -42,
        height: 430,
	   	beforeRequest : function () {loadingOn();},
	   	loadComplete: function (data) {if($('#grid').getGridParam("records")== 0) alert('조회된 내용이 없습니다.');loadingOff();}
	});
});

$(window).bind('resize', function() {
	$("#grid").setGridWidth($('#contents').width() -42, true);
}).trigger('resize');

//To.do : menuGubn1, searchMenuGubn1 수정필요
function goReload() {

	$('[id=inputForm] #menuGubn1').val($('#searchMenuGubn1').val());
	var formData = $('#searchForm').serializeArray();

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
                                        <th>재/퇴직</th>
                                        <td>
                                            <label></label>
                                              <select id="searchWorkGubn1" name="searchWorkGubn1">
								     	   	  	<option value="" selected>--선택--</option>
								     	   	  	<option value="">재직</option>
								     	   	  	<option value="">퇴직</option>
								      		  </select>
                                        </td>
                                        
                                        <th>부서</th>
                                        <td>
                                        	<label></label>
                                        		<select id="searchWorkGubn2" name="searchWorkGubn2">
                                        		<c:forEach var="gbnList" items="${gbnList}" varStatus="status">
                                        			<option value="${gbnList.deptCode}">${gbnList.deptCodeName}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>직위</th>
                                        <td>
                                        	<label></label>
                                        		<select id="searchWorkGubn3" name="searchWorkGubn3">
                                        		<c:forEach var="gbnList" items="${gbnList}" varStatus="status">
                                        			<option value="${gbnList.postCode}">${gbnList.postCode}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>직급</th>
                                        <td>
                                        	<label></label>
                                        		<select id="searchWorkGubn4" name="searchWorkGubn4">
                                        		<c:forEach var="gbnList" items="${gbnList}" varStatus="status">
                                        			<option value="${gbnList.payGrade}">${gbnList.payGrade}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        
                                        <th>급여구분</th>
                                        <td>
                                        	<label></label>
                                        		<select id="searchWorkGubn5" name="searchWorkGubn5">
                                        		<c:forEach var="gbnList" items="${gbnList}" varStatus="status">
                                        			<option value="${gbnList.salaryCode}">${gbnList.salaryCode}</option>
                                        		</c:forEach>
                                        		</select>
                                        </td>
                                        <th>사번/성명</th>
                                        <td>
                                        	<input type="text" id="pernno" name="pernno">
                                        </td>
                                        <th>
                                        	<a href="javascript:goReload()" class="btn_small bt_grey">검색</a>
                                        </th>
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
                    <!-- <div class="section">

                        <div class="btn_area right">
                            <a class="btn_large bt_blue" href="">엑셀</a>
                            <a class="btn_medium bt_grey" href="javascript:goModify()">수정</a>
                            <a class="btn_medium bt_grey" href="javascript:goDelete()">삭제</a>
                        </div>
                    </div> -->
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="hidden" name="pernNo" id="pernNo">
				<input type="hidden" name="name" id="name">
				<input type="hidden" name="sexCode" id="sexCode">
				<input type="hidden" name="deptCode" id="deptCode">
				<input type="hidden" name="deptName" id="deptName">
				<input type="hidden" name="postCode" id="postCode">
				<input type="hidden" name="joinCode" id="joinCode">
				<input type="hidden" name="employType" id="employType">
				<input type="hidden" name="salaryCode" id="salaryCode">
				<input type="hidden" name="wagesAmt" id="wagesAmt">
				<input type="hidden" name="joinDate" id="joinDate">
				<input type="hidden" name="retrDate" id="retrDate">
				<input type="hidden" name="workArea" id="workArea">
				<input type="hidden" name="phoneNo" id="phoneNo">
				<input type="hidden" name="mutualYn" id="mutualYn">
				<input type="hidden" name="useYn" id="useYn">
			</form>
        </div>
    </div>
</body>
</html>