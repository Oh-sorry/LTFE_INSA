package com.mcst.dto.gbn10;

import java.io.Serializable;

public class pg109503Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8279570342292124845L;

	private String searchJoinGbn1 = "1";	// 재/퇴직 구분
	private String deptList1;		// 부서 리스트1 (목록)
	private String deptList2;		// 부서 리스트2 (세부 목록)
	private int rank;				// 리스트 구분용 변수
	private String searchKeyword;	// 검색어
	private String deptNo;
	
	
	private int rnum;				// No
	private String pernNo;			// 사번
	private String deptFullName;	// 부서명(전체)
	private String deptName1;		// 부서명(앞)
	private String deptName2;		// 부서명(뒤)
	private String postCode;		// 직위
	private String payGrade;		// 직급
	private String joinCode;		// 입사구분
	private String salaryCode;		// 급여구분
	private String joinDate;		// 입사일자
	private String workArea;		// 근무지
	private String payGradeDate;	// 승급일
	private String telephone;		// 전화번호
	private String name;			// 성명
	private String payGrade2;		// 호봉
	private String employType;		// 사원구분
	private String wagesAmt;		// 연봉구분
	private String retrDate;		// 퇴직일
	private String payGradeDate2;	// 승호일
	private String phoneNo;			// 핸드폰 번호
	
	
	public String getSearchJoinGbn1() {
		return searchJoinGbn1;
	}
	public void setSearchJoinGbn1(String searchJoinGbn1) {
		this.searchJoinGbn1 = searchJoinGbn1;
	}	
	public String getDeptList1() {
		return deptList1;
	}
	public void setDeptList1(String deptList1) {
		this.deptList1 = deptList1;
	}
	public String getDeptList2() {
		return deptList2;
	}
	public void setDeptList2(String deptList2) {
		this.deptList2 = deptList2;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getPernNo() {
		return pernNo;
	}
	public void setPernNo(String pernNo) {
		this.pernNo = pernNo;
	}	
	public String getDeptFullName() {
		return deptFullName;
	}
	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}
	public String getDeptName1() {
		return deptName1;
	}
	public void setDeptName1(String deptName1) {
		this.deptName1 = deptName1;
	}
	public String getDeptName2() {
		return deptName2;
	}
	public void setDeptName2(String deptName2) {
		this.deptName2 = deptName2;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPayGrade() {
		return payGrade;
	}
	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	public String getJoinCode() {
		return joinCode;
	}
	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}
	public String getSalaryCode() {
		return salaryCode;
	}
	public void setSalaryCode(String salaryCode) {
		this.salaryCode = salaryCode;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getWorkArea() {
		return workArea;
	}
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	public String getPayGradeDate() {
		return payGradeDate;
	}
	public void setPayGradeDate(String payGradeDate) {
		this.payGradeDate = payGradeDate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPayGrade2() {
		return payGrade2;
	}
	public void setPayGrade2(String payGrade2) {
		this.payGrade2 = payGrade2;
	}
	public String getEmployType() {
		return employType;
	}
	public void setEmployType(String employType) {
		this.employType = employType;
	}
	public String getWagesAmt() {
		return wagesAmt;
	}
	public void setWagesAmt(String wagesAmt) {
		this.wagesAmt = wagesAmt;
	}
	public String getRetrDate() {
		return retrDate;
	}
	public void setRetrDate(String retrDate) {
		this.retrDate = retrDate;
	}
	public String getPayGradeDate2() {
		return payGradeDate2;
	}
	public void setPayGradeDate2(String payGradeDate2) {
		this.payGradeDate2 = payGradeDate2;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
