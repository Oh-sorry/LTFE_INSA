package com.mcst.dto.gbn10;

import java.io.Serializable;

public class pg101000Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 184580364459775383L;

	private String sStr; 			// 성명/사번 검색	
	private int cnt;				// 조회 인원 수
	
	private String iframeGbn = "1";	// iframe 구분
	private String srcUrl;			// iframe url
	
	private String pernNo;			// 사번
	private String name;			// 성명
	private String repreNum;		// 주민등록번호
	private String sexCode;			// 성별
	private String joinDate;		// 입사일자
	private String expireDate;		// 정식발령일자
	private String postCode;		// 직급
	private String payGrade2;		// 호봉
	private String payGradeDate;	// 승급일
	private String payGradeDate2;   // 승호일
	private String payGrade;		// 직위
	private String salaryCode;		// 급여구분
	private String wagesAmt;		// 월급여
	private String wagesDate;		// 연봉조정일
	private String schshipCode; 	// 최종학력
	private String deptName;		// 부서명
	private String totalCarrYears;	// 전체해당경력 년수
	private String totalCarrMonths; // 전체해당경력 달수
	private String pastCarrYears;	// 이전해당경력 년수
	private String pastCarrMonths;  // 이전해당경력 달수
	private String joinCode;		// 입사구분
	private String employType;		// 사원구분
	private String retrDate;		// 퇴직일자
	private String retrResn;		// 퇴직사유
	
	
	public String getsStr() {
		return sStr;
	}
	public void setsStr(String sStr) {
		this.sStr = sStr;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	public String getIframeGbn() {
		return iframeGbn;
	}
	public void setIframeGbn(String iframeGbn) {
		this.iframeGbn = iframeGbn;
	}
	public String getSrcUrl() {
		return srcUrl;
	}
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}
	
	
	
	public String getPernNo() {
		return pernNo;
	}
	public void setPernNo(String pernNo) {
		this.pernNo = pernNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRepreNum() {
		return repreNum;
	}
	public void setRepreNum(String repreNum) {
		this.repreNum = repreNum;
	}
	public String getSexCode() {
		return sexCode;
	}
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPayGrade2() {
		return payGrade2;
	}
	public void setPayGrade2(String payGrade2) {
		this.payGrade2 = payGrade2;
	}
	public String getPayGradeDate() {
		return payGradeDate;
	}
	public void setPayGradeDate(String payGradeDate) {
		this.payGradeDate = payGradeDate;
	}
	public String getPayGradeDate2() {
		return payGradeDate2;
	}
	public void setPayGradeDate2(String payGradeDate2) {
		this.payGradeDate2 = payGradeDate2;
	}
	public String getPayGrade() {
		return payGrade;
	}
	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	public String getSalaryCode() {
		return salaryCode;
	}
	public void setSalaryCode(String salaryCode) {
		this.salaryCode = salaryCode;
	}
	public String getWagesAmt() {
		return wagesAmt;
	}
	public void setWagesAmt(String wagesAmt) {
		this.wagesAmt = wagesAmt;
	}	
	public String getWagesDate() {
		return wagesDate;
	}
	public void setWagesDate(String wagesDate) {
		this.wagesDate = wagesDate;
	}
	public String getSchshipCode() {
		return schshipCode;
	}
	public void setSchshipCode(String schshipCode) {
		this.schshipCode = schshipCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTotalCarrYears() {
		return totalCarrYears;
	}
	public void setTotalCarrYears(String totalCarrYears) {
		this.totalCarrYears = totalCarrYears;
	}
	public String getTotalCarrMonths() {
		return totalCarrMonths;
	}
	public void setTotalCarrMonths(String totalCarrMonths) {
		this.totalCarrMonths = totalCarrMonths;
	}
	public String getPastCarrYears() {
		return pastCarrYears;
	}
	public void setPastCarrYears(String pastCarrYears) {
		this.pastCarrYears = pastCarrYears;
	}
	public String getPastCarrMonths() {
		return pastCarrMonths;
	}
	public void setPastCarrMonths(String pastCarrMonths) {
		this.pastCarrMonths = pastCarrMonths;
	}
	public String getJoinCode() {
		return joinCode;
	}
	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}
	public String getEmployType() {
		return employType;
	}
	public void setEmployType(String employType) {
		this.employType = employType;
	}
	public String getRetrDate() {
		return retrDate;
	}
	public void setRetrDate(String retrDate) {
		this.retrDate = retrDate;
	}
	public String getRetrResn() {
		return retrResn;
	}
	public void setRetrResn(String retrResn) {
		this.retrResn = retrResn;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}
