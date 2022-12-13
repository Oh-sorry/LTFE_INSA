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
	$("#grid").jqGrid({
	   	url:"<c:url value='/gbn30/pg309502List.ajax' />",
	   	mtype: "POST",
		datatype: "json",
		locale : "kr",
		//postData : {'code':'00000'},
		jsonReader : {
			root: "rowData",
			repeatitems: false
		},
		colModel:[
			{label:'사번', name:'pernNum', align:'center'},
			{label:'성명', name:'name', align:'center'},
			{label:'인사관리', name:'menuAuth10', align:'center'},
			{label:'급여관리', name:'menuAuth20', align:'center'},
			{label:'OP급여관리', name:'menuAuth21', align:'center'},
			{label:'상여관리', name:'menuAuth23', align:'center'},
			{label:'동호회/건강/상조', name:'menuAuth24', align:'center'},
			{label:'급여세액관리', name:'menuAuth26', align:'center'},
			{label:'퇴직관리', name:'menuAuth27', align:'center'},
			{label:'시스템관리', name:'menuAuth30', align:'center'}
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

function goInput() {
	loadingOn();
	window.open('about:blank','input','width=600px,height=600px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes')
	$('#inputForm').attr("action", "<c:url value='/gbn30/pg309502Input.do'/>");
	$('#inputForm').attr("target", "input");
	inputForm.submit();
}

function goModify() {
	var rowid = $("#grid").getGridParam( "selrow" );

	if (rowid == null || rowid < 1) {
		alert("수정할 데이터를 선택하세요");
		return;
	}

	var rowData = $("#grid").getRowData(rowid);
	var formData = $('#inputForm').serializeArray();

	setData(formData, rowData, 'inputForm');

	loadingOn();

	window.open('about:blank','input','width=600px,height=600px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes')
	$('#inputForm').attr("action", "<c:url value='/gbn30/pg309502Modify.do'/>");
	$('#inputForm').attr("target", "input");
	inputForm.submit();
}

function goDelete() {
	var rowid = $("#grid").getGridParam( "selrow" );

	if (rowid == null || rowid < 1) {
		alert("삭제할 데이터를 선택하세요");
		return;
	}

	var rowData = $("#grid").getRowData(rowid);

	if (!confirm("정말로 삭제하시겠습니까?")) {
		return;
	}

	loadingOn();

	$.ajax({
         type : "POST",
         url : "<c:url value='/gbn30/pg309502Delete.ajax' />",
         contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
         data : rowData,
         async: false,
         success : function(data){
        	 if(data != null) {
        		var Ca = /\+/g;
        	 	alert(decodeURIComponent(data.replace(Ca, " ")));
        	 	console.log(data);
             	goReload();
           		loadingOff();
        	 }
         },
         error : function(XMLHttpRequest, textStatus, errorThrown){
    		 var Ca = /\+/g;
        	 alert(decodeURIComponent(XMLHttpRequest.responseText.replace(Ca, " ")));
             loadingOff();
         }
     });
}

function goReload() {
	$('#grid').clearGridData();
	$('#grid').setGridParam({datatype : "json"}).trigger("reloadGrid");
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
								<li><a href="#">권한관리</a></li>
							</ul>
						</div>
					</div>
					<h3>권한관리</h3>
					<div class="section">
						<div><table id="grid"></table></div>
                    </div>
                    <div class="section">

                        <div class="btn_area right">
                            <a class="btn_medium bt_grey" href="javascript:goInput();">신규</a>
                            <a class="btn_medium bt_grey" href="javascript:goModify()">수정</a>
                            <a class="btn_medium bt_grey" href="javascript:goDelete()">삭제</a>
                        </div>
                    </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="hidden" name="pernNum" id="pernNum">
				<input type="hidden" name="menuNm" id="menuNm">
			</form>
        </div>
    </div>
</body>
</html>
