package com.mcst.dto.gbn10;

import java.io.Serializable;

/**
 * @author aug2322
 *
 */
public class pg103000Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1779623296847940584L;

	private int seq;
	private String processType;
	
	private String expDate;			//신청일
	private String pernNo;			//사번
	private String usrname;			//성명
	private String usrrepreNum;		//주민번호
	private String joinDate;		//입사일
	private String retrDate;		//퇴사일
	private String deptCode;		//부서 코드
	private String deptName;		//부서 이름
	private String deptCode1;			//부모 부서 코드
	private String deptName1;			//부모 부서 이름
	private String deptCode2;			//자식 부서 코드
	private String deptName2;			//자식 부서 이름
	private String workPeriod1;		//재직 근무 기간1
	private String workPeriod2;		//재직 근무 기간2
	private String workPeriod3;		//재직 근무 기간3
	private String usrfield1;		//사용자입력타이틀
	private String usrfield2;		//사용자입력내용
	private String usraddr;			//주소
	private String usrbirth;		//생년월일
	private String recpDate;		//접수일
	private String printGbn;		//출력여부
	private String certNo;			//일련번호
	private String jobName;			//담당업무
	private String workArea;		//근무지
	private String certGbn;			//증명 구분
	private String certName;		//증명 구분 이름 (ex. 신규, 경력)
	private String expResn;			//신청 사유
	private int expCnt;				//신청 통수
	private String hanDate;			//처리일
	
	private String expStartDate; 	//신청일 시작
	private String expEndDate;		//신청일 종료
	
	private int pageIndex = 1;					//현재페이지
	private int pageUnit = 16;					//페이지갯수
	private int pageSize = 10;					//페이지사이즈
	private int firstIndex = 0;					//firstIndex
	private int lastIndex = 1;					//lastIndex
	private int recordCountPerPage = 16;		//recordCountPerPage
	private int totCnt = 0;				    	//총갯수
	private int startDate = 0;			    	//시작데이터
	private int endDate = 0;					//종료데이터
	private int realEnd = 0;					//페이징 마지막 숫자
	private boolean prev, next;	    			//이전,다음버튼
	
	private String postCode;		//직위 코드
	private String postName;		//직위 이름
	private String payGrade;		//직급 코드
	private String payName;			//직급 이름
	private String sJoinRetr = "1";			// 재/퇴직 검색 
	private String sStr; 					// 성명/사번 검색

	
	
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getPernNo() {
		return pernNo;
	}
	public void setPernNo(String pernNo) {
		this.pernNo = pernNo;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsrrepreNum() {
		return usrrepreNum;
	}
	public void setUsrrepreNum(String usrrepreNum) {
		this.usrrepreNum = usrrepreNum;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getRetrDate() {
		return retrDate;
	}
	public void setRetrDate(String retrDate) {
		this.retrDate = retrDate;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCode1() {
		return deptCode1;
	}
	public void setDeptCode1(String deptCode1) {
		this.deptCode1 = deptCode1;
	}
	public String getDeptName1() {
		return deptName1;
	}
	public void setDeptName1(String deptName1) {
		this.deptName1 = deptName1;
	}
	public String getDeptCode2() {
		return deptCode2;
	}
	public void setDeptCode2(String deptCode2) {
		this.deptCode2 = deptCode2;
	}
	public String getDeptName2() {
		return deptName2;
	}
	public void setDeptName2(String deptName2) {
		this.deptName2 = deptName2;
	}
	public String getWorkPeriod1() {
		return workPeriod1;
	}
	public void setWorkPeriod1(String workPeriod1) {
		this.workPeriod1 = workPeriod1;
	}
	public String getWorkPeriod2() {
		return workPeriod2;
	}
	public void setWorkPeriod2(String workPeriod2) {
		this.workPeriod2 = workPeriod2;
	}
	public String getWorkPeriod3() {
		return workPeriod3;
	}
	public void setWorkPeriod3(String workPeriod3) {
		this.workPeriod3 = workPeriod3;
	}
	public String getUsrfield1() {
		return usrfield1;
	}
	public void setUsrfield1(String usrfield1) {
		this.usrfield1 = usrfield1;
	}
	public String getUsrfield2() {
		return usrfield2;
	}
	public void setUsrfield2(String usrfield2) {
		this.usrfield2 = usrfield2;
	}
	public String getUsraddr() {
		return usraddr;
	}
	public void setUsraddr(String usraddr) {
		this.usraddr = usraddr;
	}
	public String getUsrbirth() {
		return usrbirth;
	}
	public void setUsrbirth(String usrbirth) {
		this.usrbirth = usrbirth;
	}
	public String getRecpDate() {
		return recpDate;
	}
	public void setRecpDate(String recpDate) {
		this.recpDate = recpDate;
	}
	public String getPrintGbn() {
		return printGbn;
	}
	public void setPrintGbn(String printGbn) {
		this.printGbn = printGbn;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getWorkArea() {
		return workArea;
	}
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	public String getCertGbn() {
		return certGbn;
	}
	public void setCertGbn(String certGbn) {
		this.certGbn = certGbn;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getExpResn() {
		return expResn;
	}
	public void setExpResn(String expResn) {
		this.expResn = expResn;
	}
	public int getExpCnt() {
		return expCnt;
	}
	public void setExpCnt(int expCnt) {
		this.expCnt = expCnt;
	}
	public String getHanDate() {
		return hanDate;
	}
	public void setHanDate(String hanDate) {
		this.hanDate = hanDate;
	}
	public String getExpStartDate() {
		return expStartDate;
	}
	public void setExpStartDate(String expStartDate) {
		this.expStartDate = expStartDate;
	}
	public String getExpEndDate() {
		return expEndDate;
	}
	public void setExpEndDate(String expEndDate) {
		this.expEndDate = expEndDate;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
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
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPayGrade() {
		return payGrade;
	}
	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
