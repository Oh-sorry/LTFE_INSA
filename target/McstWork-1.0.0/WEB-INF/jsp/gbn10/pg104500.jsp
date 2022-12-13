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
		postData : {'searchMenuGubn1':'10'},
		jsonReader : {
			root: "rowData",
			repeatitems: false
		},
		colModel:[
			{label:'사번', name:'menuSeq', align:'center'},
			{label:'성명', name:'menuNm', align:'center'},
			{label:'성별', name:'menuSrc', align:'center'},
			{label:'부서', name:'menuId', align:'center'},
			{label:'직위', name:'usedGubn', align:'center'},
			{label:'입사구분', name:'menuGubn1', align:'center'},
			{label:'사원구분', name:'menuGubn1', align:'center'},
			{label:'급여구분', name:'menuGubn1', align:'center'},
			{label:'연봉구분', name:'menuGubn1', align:'center'},
			{label:'입사일자', name:'menuGubn1', align:'center'},
			{label:'퇴사일자', name:'menuGubn1', align:'center'},
			{label:'근무지', name:'menuGubn1', align:'center'},
			{label:'핸드폰', name:'menuGubn1', align:'center'},
			{label:'상조회', name:'menuGubn1', align:'center'}
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
								<li><a href="#">시스템관리</a></li>
								<li><a href="#">프로그램(구분)관리</a></li>
							</ul>
						</div>
					</div>
					<h3>프로그램(메뉴)관리</h3>
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
                                        <th>업무구분</th>
                                        <td>
                                            <label></label>
                                              <select id="searchMenuGubn1" name="searchMenuGubn1">
								     	   	  <c:forEach var="gbnList" items="${gbnList}" varStatus="status">
								     	   	  	<option value="${gbnList.menuGubn1}">${gbnList.menuNm}</option>
								        	  </c:forEach>
								      		</select>
                                            <a href="javascript:goReload()" class="btn_small bt_grey">검색</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>
                        </div>
						<div><table id="grid"></table></div>
                    </div>
                    <div class="section">

                        <div class="btn_area right">
                            <a class="btn_medium bt_blue" href="">엑셀</a>
                            <!-- <a class="btn_medium bt_grey" href="javascript:goModify()">수정</a>
                            <a class="btn_medium bt_grey" href="javascript:goDelete()">삭제</a> -->
                        </div>
                    </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="text" name="menuGubn1" id="menuGubn1" value="10">
				<input type="hidden" name="menuSeq" id="menuSeq" value="0">
				<input type="hidden" name="menuNm" id="menuNm">
				<input type="hidden" name="menuSrc" id="menuSrc">
				<input type="hidden" name="menuId" id="menuId">
				<input type="hidden" name="usedGubn" id="usedGubn">
			</form>
        </div>
    </div>
</body>
</html>
</body>
</html>