package com.mcst.dto.gbn10;

import java.io.Serializable;

public class pg102000Dto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1892904156922576971L;
	
	
	private String sJoinRetr = "1";			// 재/퇴직 검색 
	private String sStr; 					// 성명/사번 검색
	private String sJoinBa;					// 입사전후 검색
	private String sEduType;				// 교육유형 검색
	private String eduCode;					// 교육유형 코드
	private String sStartDate;				// 교육 시작일 검색
	private String sEndDate;				// 교육 종료일 검색
	private String sTitle;					// 교육명 검색
	
	private int seq;
	private String processType;
	
	private String name;					// 성명
	private String deptFullName;			// 부서명
	private String eduStartDate;			// 시작일
	private String eduTitle;				// 교육명
	private String eduSponsor;				// 교육기관	
	private String eduTypeCode;				// 교육유형
	private String joinBa;					// 입사구분
	private String eduExpense;				// 교육비
	private String eduRefund;				// 환급금액
	private String realfile;				// 진짜 파일 이름
	private String servfile;				// 서브 파일 이름
	
	private String pernNo;					// 사번
	private String postCode;				// 직위
	private String eduEndDate;				// 종료일
	private String eduMethodCode;			// 교육방법
	private String eduRealExpense;			// 실비용
	
	private String eduContents;
	private String eduObject;	
	
	public String getsJoinRetr() {
		return sJoinRetr;
	}
	public void setsJoinRetr(String sJoinRetr) {
		this.sJoinRetr = sJoinRetr;
	}
	public String getsStr() {
		return sStr;
	}
	public void setsStr(String sStr) {
		this.sStr = sStr;
	}
	public String getsJoinBa() {
		return sJoinBa;
	}
	public void setsJoinBa(String sJoinBa) {
		this.sJoinBa = sJoinBa;
	}
	public String getsEduType() {
		return sEduType;
	}
	public void setsEduType(String sEduType) {
		this.sEduType = sEduType;
	}
	public String getEduCode() {
		return eduCode;
	}
	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}
	public String getsStartDate() {
		return sStartDate;
	}
	public void setsStartDate(String sStartDate) {
		this.sStartDate = sStartDate;
	}
	public String getsEndDate() {
		return sEndDate;
	}
	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}
	public String getsTitle() {
		return sTitle;
	}
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptFullName() {
		return deptFullName;
	}
	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}
	public String getEduStartDate() {
		return eduStartDate;
	}
	public void setEduStartDate(String eduStartDate) {
		this.eduStartDate = eduStartDate;
	}
	public String getEduTitle() {
		return eduTitle;
	}
	public void setEduTitle(String eduTitle) {
		this.eduTitle = eduTitle;
	}
	public String getEduSponsor() {
		return eduSponsor;
	}
	public void setEduSponsor(String eduSponsor) {
		this.eduSponsor = eduSponsor;
	}
	public String getEduTypeCode() {
		return eduTypeCode;
	}
	public void setEduTypeCode(String eduTypeCode) {
		this.eduTypeCode = eduTypeCode;
	}
	public String getJoinBa() {
		return joinBa;
	}
	public void setJoinBa(String joinBa) {
		this.joinBa = joinBa;
	}
	public String getEduExpense() {
		return eduExpense;
	}
	public void setEduExpense(String eduExpense) {
		this.eduExpense = eduExpense;
	}
	public String getEduRefund() {
		return eduRefund;
	}
	public void setEduRefund(String eduRefund) {
		this.eduRefund = eduRefund;
	}
	public String getRealfile() {
		return realfile;
	}
	public void setRealfile(String realfile) {
		this.realfile = realfile;
	}
	public String getServfile() {
		return servfile;
	}
	public void setServfile(String servfile) {
		this.servfile = servfile;
	}
	public String getPernNo() {
		return pernNo;
	}
	public void setPernNo(String pernNo) {
		this.pernNo = pernNo;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getEduEndDate() {
		return eduEndDate;
	}
	public void setEduEndDate(String eduEndDate) {
		this.eduEndDate = eduEndDate;
	}
	public String getEduMethodCode() {
		return eduMethodCode;
	}
	public void setEduMethodCode(String eduMethodCode) {
		this.eduMethodCode = eduMethodCode;
	}
	public String getEduRealExpense() {
		return eduRealExpense;
	}
	public void setEduRealExpense(String eduRealExpense) {
		this.eduRealExpense = eduRealExpense;
	}
	public String getEduContents() {
		return eduContents;
	}
	public void setEduContents(String eduContents) {
		this.eduContents = eduContents;
	}
	public String getEduObject() {
		return eduObject;
	}
	public void setEduObject(String eduObject) {
		this.eduObject = eduObject;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
