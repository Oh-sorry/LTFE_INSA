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
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>"> <!-- css 파일 교체함  -->
<link rel="stylesheet" href="<c:url value='/css/style.css'/>"> <!-- css 파일 교체함  -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous"> -->
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/jqgrid/jquery.jqgrid.src.js'/>"></script>
<script src="<c:url value='/jqgrid/i18n/grid.locale-kr.js'/>"></script>
<script src="<c:url value='/js/loadingoverlay.min.js'/>"></script>
<script src="<c:url value='/js/script.js'/>"></script> <!-- css 파일 교체함  -->
<script src="<c:url value='/js/common.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script> <!-- 쿠키 사용을 위해 추가 -->

<title>(주)엠씨에스텍 인사급여시스템</title>

<style>
#notLast1 {border-right: 1px solid #ccc;}
#notLast2 {border-right: 1px solid #ccc;}
#last {border-right:none}
</style>

<script language="javascript">
	var popup;
	window.onunload = function() { popup.close(); } // 현재 팝업 새로고침 또는 닫기 시 자식 팝업도 함께 닫히도록

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
	
	function goReload() {
		if ($('[id=listForm] #sStartDate').val().trim() != '') {
			if ($('[id=listForm] #sEndDate').val().trim() == '') {				
				alert("종료일자를 입력하세요");
				$('[id=dataForm] #sEndDate').focus();
				return;
			}			
		} else if ($('[id=listForm] #sEndDate').val().trim() != '') {
			if ($('[id=listForm] #sStartDate').val().trim() == '') {				
				alert("시작일자를 입력하세요");
				$('[id=dataForm] #sStartDate').focus();
				return;
			}			
		}
		document.listForm.action = "<c:url value='/gbn10/pg102000.do'/>";
		document.listForm.submit();
	}
	/* function showPop(){

		var form = document.listForm;		
		var ChBox = document.getElementsByName("Check");
		var sb=document.getElementsByName("s_bun");
		var pern_no=0;
		for(i=0;i<ChBox.length;i++){
			if(ChBox[i].checked == true){
				pern_no=sb[i].outerText;
						
			}
		}		
		var w = "1080";
		var h = "580";

		pop = window.open('', 'detail', 'width=' + w + ' height=' + h + ' left=' + (screen.width-w)/2 +' top=' + (screen.height-h)/4 + ' ');

		pop.document.write("<form name=detail method=post action=>");
		pop.document.write("<input type=hidden name=s_pern_no value='"+pern_no+"'>");
		pop.document.write("<input type=hidden name=window_id value=pop>");
		pop.document.write("</form>");
		pop.document.write("<script>document.detail.submit();<\/script>");		

	} */
	
	function fileDownload(realfile, servfile) {
		window.open("${pageContext.request.contextPath}/gbn10/fileDownload.do?realfile="+realfile + "&servfile="+servfile);
	}
	function excelDown() { // 데이터가 너무 많으면 오래 걸림 - 이때 다른 버튼 못누르게 막도록 작성
		document.listForm.action = "<c:url value='/gbn10/pg102000excelDownload.do'/>";
		document.listForm.submit();

		loadingOn();

		FILEDOWNLOAD_INTERVAL = setInterval(function() {
			console.log($.cookie("fileDownloadToken"));
			if ($.cookie("fileDownloadToken") != null) {
				$.removeCookie('fileDownloadToken');
		        clearInterval(FILEDOWNLOAD_INTERVAL);
		        loadingOff();
		    }
		}, 500);
	}
	
	function goInput() {
		loadingOn();
		
		popup = window.open('about:blank','input','width=800px,height=725px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes')
		$('#inputForm').attr("action", "<c:url value='/gbn10/pg102000Input.do'/>");
		$('#inputForm').attr("target", "input");
		inputForm.submit();
		
		POPUP_INTERVAL = setInterval(function() {
			console.log(1);
			if(typeof(popup)=='undefined' || popup.closed) {
				clearInterval(POPUP_INTERVAL);
				loadingOff();
			}		
		}, 250);
	}
	function goModify() {
		
		var checked = false;
		
		$('input:checkbox[name=check]').each(function (index) {
			if($(this).is(":checked")==true){		    	
		    	var str = $(this).val().split(',');
		    	
		    	$('[id=inputForm] #pernNo').val(str[0]);
		    	$('[id=inputForm] #seq').val(str[1]);		    	
		    	
		    	checked = true;
		    }
		});
		
		if(checked == false) {
			alert("수정할 데이터를 선택하세요");
			return;
		}
						
		loadingOn();

		popup = window.open('about:blank','input','width=800px,height=725px,top=0,left=0,toolbar=no,status=no,menubar=no,location=no,scrollbars=yes')
		$('#inputForm').attr("action", "<c:url value='/gbn10/pg102000Modify.do'/>");
		$('#inputForm').attr("target", "input");
		inputForm.submit();
		
		POPUP_INTERVAL = setInterval(function() {
			console.log(1);
			if(typeof(popup)=='undefined' || popup.closed) {
				clearInterval(POPUP_INTERVAL);
				goReload();
				loadingOff();
			}		
		}, 250);
	}
	function goDelete() {
		var checked = false;
		
		$('input:checkbox[name=check]').each(function (index) {
			if($(this).is(":checked")==true){		    	
		    	var str = $(this).val().split(',');
		    	
		    	$('[id=inputForm] #pernNo').val(str[0]);
		    	$('[id=inputForm] #seq').val(str[1]);		    	
		    	
		    	checked = true;
		    }
		});
		
		if(checked == false) {
			alert("삭제할 데이터를 선택하세요");
			return;
		}
		
		if (!confirm("정말로 삭제하시겠습니까?")) {
			return;
		}
		
		var pernNo = $('[id=inputForm] #pernNo').val();
		var seq = $('[id=inputForm] #seq').val();
		
		
		loadingOn();

		$.ajax({
	         type : "POST",
	         url : "<c:url value='/gbn10/pg102000Delete.ajax' />",
	         contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	         data : {"pernNo":pernNo, "seq":seq},	         
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
								<li><a href="#"><img src="<c:url value='/images/ico_home.png' />" alt=""></a></li>
								<li><a href="#">인사관리</a></li>
								<li><a href="#">교육사항</a></li>
							</ul>
						</div>
					</div>
					
					<form:form modelAttribute="pg102000Dto" id="listForm" name="listForm" method="post">
					<h3>교육사항</h3>
					<div class="search_Area m_b_20">
                        <dl>
                            <dt>재/퇴직</dt>
                            <dd>                                
                                <form:select path="sJoinRetr" value="${searchFormData.sJoinRetr}">
									<form:option value="" label="전체" />
									<form:option value="1" label="재직" />
									<form:option value="2" label="퇴직" />
								</form:select>
                            </dd>
                        </dl>
                        <dl>
                            <dt>성명/사번</dt>
                            <dd>
                                <label></label>
                                <form:input size="8" path="sStr" value="${searchFormData.sStr}" onkeypress="javascript:if(event.keyCode==13)goReload();"/>
                            </dd>
                        </dl>
                        <dl>
                            <dt>입사전후</dt>
                            <dd>
                            	<form:select path="sJoinBa" value="${searchFormData.sJoinBa}">
									<form:option value="" label="선택" />
									<form:option value="1" label="전" />
									<form:option value="2" label="후" />
								</form:select>
                            </dd>
                        </dl>
                        <dl>
                            <dt>교육유형</dt>
                            <dd>
                            	<form:select path="sEduType" value="${searchFormData.sEduType}">
									<form:option value="" label="선택" />
									<c:forEach var="list" items="${eduTypeList}" varStatus="status">
										<form:option value="${list.eduCode}">${list.eduTypeCode}</form:option>
									</c:forEach>
								</form:select>
                            </dd>
                        </dl>
                        <dl>
                            <dt>교육기간</dt>
                            <dd>
                                <form:input type="date" path="sStartDate" value="${searchFormData.eduStartDate}"/>
                                &nbsp;~&nbsp;
                                <form:input type="date" path="sEndDate" value="${searchFormData.eduEndDate}"/>
                            </dd>
                        </dl>
                        <dl>
                            <dt>교육명</dt>
                            <dd>
                                <label></label>
                                <form:input path="sTitle" value="${searchFormData.sTitle}" onkeypress="javascript:if(event.keyCode==13)goReload();"/>
                                <a href="javascript:goReload()" class="btn_small bt_grey">검색</a> 
                            </dd>
                        </dl>
                    </div>
					<div class="section">
                        <div class="cols_area">
                        <div id="table-scroll" class="table-scroll" style="height:577px; margin:0;">
                            <table class="row_table">
                                <colgroup>
                                    
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th rowspan="2"></th>
                                        <th>성명</th>
                                        <th>부서</th>
                                        <th>시작일</th>
                                        <th rowspan="2">교육명</th>
                                        <th rowspan="2">교육기관</th>
                                        <th>교육유형</th>
                                        <th rowspan="2">입사구분</th>
                                        <th rowspan="2">교육비</th>
                                        <th>환급금액</th>
                                        <th rowspan="2" id="last">첨부파일</th>
                                    </tr>
                                    <tr>
                                        <th>사번</th>
                                        <th>직위</th>
                                        <th>종료일</th>
                                        <th>교육방법</th>
                                        <th id="notLast1">실비용</th>                                        
                                    </tr>
                                </thead>                                
                                <tbody>                                
                                	<c:forEach var="result" items="${educationList}" varStatus="status">
                                		<tr>
                                			<td rowspan="2">
                                				<label></label>
                                				<input type="checkbox" id="check" name="check" onclick='checkOnlyOne(this)' value="${result.pernNo},${result.seq}">
                                			</td>
                                			<td><c:out value="${result.name}" /></td>
                                			<td><c:out value="${result.deptFullName}" /></td>
                                			<td><c:out value="${result.eduStartDate}" /></td>
                                			<td rowspan="2"><c:out value="${result.eduTitle}" /></td>
                                			<td rowspan="2"><c:out value="${result.eduSponsor}" /></td>                                			
                                			<td><c:out value="${result.eduTypeCode}" /></td>
                                			<td rowspan="2"><c:out value="${result.joinBa}" /></td>
                                			<td rowspan="2"><c:out value="${result.eduExpense}" /></td>
                                			<td><c:out value="${result.eduRefund}" /></td>
                                			<c:choose>
										    	<c:when test="${result.realfile == null}">
										    		<td rowspan="2" id="last"></td>
										    	</c:when>
										    	<c:otherwise>
											    	<td rowspan="2" id="last">
											    		<a href="javascript:fileDownload('${result.realfile}', '${result.servfile}')">
											    			<img src="<c:url value='/images/ico_attachfile.png' />" alt="첨부파일">
											    		</a>
											    	</td>    	
										    	</c:otherwise>
											</c:choose>
                                		</tr>
                                		<tr>
                                        	<td><c:out value="${result.pernNo}" /></td>
                                        	<td><c:out value="${result.postCode}" /></td>
                                        	<td><c:out value="${result.eduEndDate}" /></td>
                                        	<td><c:out value="${result.eduMethodCode}" /></td>
                                        	<td id="notLast2"><c:out value="${result.eduRealExpense}" /></td>
                                    	</tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                        </div>
                    </div>
                    </form:form>
                    <div class="btn_group">
                        <div class="right">
                            <a href="" onclick="javascript:showPop();" class="btn_large bt_blue">사원정보</a>
                            <a href="javascript:excelDown()" class="btn_large bt_blue">엑셀</a>
                            <a href="javascript:goInput()" class="btn_large bt_blue">등록</a>
                            <a href="javascript:goModify()" class="btn_large bt_blue">수정</a>
                            <a href="javascript:goDelete()" class="btn_large bt_blue">삭제</a>
                        </div>
                    </div>
				</div>
                <jsp:include page="/WEB-INF/jsp/bottom.jsp" flush="true"/>
			</div>
			<form name="inputForm" id="inputForm" method="post">
				<input type="hidden" id="pernNo" name="pernNo"/>
                <input type="hidden" id="seq" name="seq" value="0"/>
			</form>
        </div>
    </div>
</body>
</html>