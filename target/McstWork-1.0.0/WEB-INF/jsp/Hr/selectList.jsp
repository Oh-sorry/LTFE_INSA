<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>test</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>css/ui.jqgrid.css" />
<script src="<c:url value='/'/>js/jquery.min.js" type="text/javascript"></script>
<script src="<c:url value='/'/>js/jquery-ui.min.js" type="text/javascript"></script>
<script src="<c:url value='/'/>js/jquery.migrate.min.js" type="text/javascript"></script>
<script src="<c:url value='/'/>js/jquery.jqGrid.min.js" type="text/javascript"></script>

<script language="javascript">
	$(document).ready(function(){
		$("#list2").jqGrid({
		   	url:'<c:url value='/'/>/hr/selectListAjax.ajax',
		   	mtype: "GET",
			datatype: "json",
			jsonReader : {
				root: "resultList",
				repeatitems: false
			},
			loadtext : '조회 중 입니다.',
			colModel:[
		   		{label:'사번', name:'pernNo', width:100},
		   		{label:'성명', name:'name', width:120},
		   		{label:'부서', name:'deptName', width:200}
		   	],
		   	loadonce: true,
		   	width: 780,
            height: 450,
            rownumbers : true,
		   	rowNum: -1
		});
	});
</script>
</head>

<body>
<div id="wrap">
<table id="list2"></table>
</div>
</body>
</html>

