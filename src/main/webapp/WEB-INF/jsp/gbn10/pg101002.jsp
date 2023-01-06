<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<!-- css 파일 교체함  -->
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<!-- css 파일 교체함  -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous"> -->
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script>
<!-- css 파일 교체함  -->
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- 쿠키 사용을 위해 추가 -->

<title>(주)엠씨에스텍 인사급여시스템</title>
</head>
<div class="cols_area">
	<table class="row_table">
		<colgroup>
			<col style="width: 5%">
			<col style="width: 10%">
			<col style="width: 10%">
			<col style="width: 10%">
			<col style="">
			<col style="width: 10%">
			<col style="width: 10%">
			<col style="width: 10%">
			<col style="width: 10%">
			<col style="width: 10%">
		</colgroup>
		<tbody>
			<tr>
				<th></th>
				<th>발령일자</th>
				<th>순번</th>
				<th>발령</th>
				<th>부서</th>
				<th>직위</th>
				<th>직급</th>
				<th>호봉</th>
				<th>월급여</th>
				<th>세부발령사유</th>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
			<tr>
				<td><label></label><input type="checkbox"></td>
				<td>2020.02.02</td>
				<td>1</td>
				<td>해임</td>
				<td>정보시스템 사업본부 SI사업팀</td>
				<td>대리</td>
				<td></td>
				<td></td>
				<td>3,000,000</td>
				<td>개인사정</td>
			</tr>
		</tbody>
	</table>
</div>
</html>