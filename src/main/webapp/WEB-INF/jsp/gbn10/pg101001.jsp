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
<body>
	<div class="cols_area">
		<table class="table table_right_row">
			<colgroup>
				<col style="width: 5%">
				<col style="width: 5%">
				<col style="width: 23.5%">
				<col style="width: 5%">
				<col style="width: 5%">
				<col style="width: 23.5%">
				<col style="width: 5%">
				<col style="width: 5%">
				<col style="">
			</colgroup>
			<tbody>
				<tr>
					<th rowspan="2">성명</th>
					<th>한글</th>
					<td><label></label> <input type="text"></td>
					<th colspan="2">연락처</th>
					<td><label></label> <input type="text"></td>
					<th rowspan="2">퇴직금</th>
					<th>지급사유</th>
					<td><label></label> <input type="radio">여 <label></label>
						<input type="radio">부</td>
				</tr>
				<tr>
					<th>영문</th>
					<td><label></label> <input type="text"></td>
					<th colspan="2">생년월일</th>
					<td><label></label> <input type="date" id=""> <label></label>
						<input type="radio">양 <label></label> <input type="radio">음
					</td>
					<th>미지급사유</th>
					<td><label></label> <input type="text"></td>
				</tr>
				<tr>
					<th rowspan="2">e-mail</th>
					<th>회사</th>
					<td><label></label> <input type="text">@mcst.co.kr</td>
					<th rowspan="2">비상연락망</th>
					<th>연락처</th>
					<td><label></label> <input type="text" style="width: 15%">
						<label></label> <input type="text"></td>
					<th rowspan="2">4대보험</th>
					<th>가입일</th>
					<td><input type="date" id=""></td>
				</tr>
				<tr>
					<th>개인</th>
					<td><label></label> <input type="text"></td>
					<th>비고</th>
					<td><label></label> <input type="text"></td>
					<th>해지일</th>
					<td><input type="date" id=""></td>
				</tr>
				<tr>
					<th rowspan="2">현주소</th>
					<th>신주소</th>
					<td colspan="4"><label></label> <input type="text"> <label></label>
						<input type="text"></td>
					<th colspan="2">경력시작일</th>
					<td><input type="date" id=""></td>
				</tr>
				<tr>
					<th>구주소</th>
					<td colspan="4"><label></label> <input type="text"> <label></label>
						<input type="text"></td>
					<th colspan="2">원가구분</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
				</tr>
				<tr>
					<th rowspan="2">주거래은행</th>
					<th>은행명</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
					<th colspan="2">계좌번호</th>
					<td><label></label> <input type="text"></td>
					<th rowspan="2">상조회</th>
					<th>가입여부</th>
					<td><label></label> <input type="radio">가입 <label></label>
						<input type="radio">미가입</td>
				</tr>
				<tr>
					<th>비고</th>
					<td colspan="4"><label></label> <input type="text"></td>
					<th>비고</th>
					<td><label></label> <input type="text"></td>
				</tr>
				<tr>
					<th colspan="2">근무지</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
					<th colspan="2">소속사업장</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
					<th colspan="2">입사구분</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
				</tr>
				<tr>
					<th colspan="2">기술자 등급/IT직무수준</th>
					<td><label></label> <select>
							<option></option>
					</select> <label></label> <select>
							<option></option>
					</select></td>
					<th colspan="2">신고사업장</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
					<th colspan="2">건강보혐료 면제</th>
					<td><label></label> <select>
							<option></option>
					</select></td>
				</tr>
				<tr>
					<th colspan="2">첨부파일</th>
					<td colspan="7"><a href=""
						class="btn_small bt_white border_1px">첨부파일 추가</a></td>
				</tr>
				<tr>
					<th colspan="2">기본인적사항 비고</th>
					<td colspan="7"><label></label> <input type="text"></td>
				</tr>
			</tbody>
		</table>
		<div class="btn_area right">
			<a class="btn_medium bt_grey" href="">저장</a>
		</div>
</body>
</html>