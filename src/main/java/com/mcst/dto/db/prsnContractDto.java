package com.mcst.dto.db;

import java.io.Serializable;

public class prsnContractDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 782559135089474670L;

	private int seqOrg;
	private int seqDep;
	private String contNm;
	private String contYmdSt;
	private String contYmdEnd;
	private String jumin;
	private String workNm;
	private String workArea;
	private int payMonth;
	private int payTot;
	private String endYn;
	/**
	 * @return the seqOrg
	 */
	public int getSeqOrg() {
		return seqOrg;
	}
	/**
	 * @param seqOrg the seqOrg to set
	 */
	public void setSeqOrg(int seqOrg) {
		this.seqOrg = seqOrg;
	}
	/**
	 * @return the seqDep
	 */
	public int getSeqDep() {
		return seqDep;
	}
	/**
	 * @param seqDep the seqDep to set
	 */
	public void setSeqDep(int seqDep) {
		this.seqDep = seqDep;
	}
	/**
	 * @return the contNm
	 */
	public String getContNm() {
		return contNm;
	}
	/**
	 * @param contNm the contNm to set
	 */
	public void setContNm(String contNm) {
		this.contNm = contNm;
	}
	/**
	 * @return the contYmdSt
	 */
	public String getContYmdSt() {
		return contYmdSt;
	}
	/**
	 * @param contYmdSt the contYmdSt to set
	 */
	public void setContYmdSt(String contYmdSt) {
		this.contYmdSt = contYmdSt;
	}
	/**
	 * @return the contYmdEnd
	 */
	public String getContYmdEnd() {
		return contYmdEnd;
	}
	/**
	 * @param contYmdEnd the contYmdEnd to set
	 */
	public void setContYmdEnd(String contYmdEnd) {
		this.contYmdEnd = contYmdEnd;
	}
	/**
	 * @return the jumin
	 */
	public String getJumin() {
		return jumin;
	}
	/**
	 * @param jumin the jumin to set
	 */
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	/**
	 * @return the workNm
	 */
	public String getWorkNm() {
		return workNm;
	}
	/**
	 * @param workNm the workNm to set
	 */
	public void setWorkNm(String workNm) {
		this.workNm = workNm;
	}
	/**
	 * @return the workArea
	 */
	public String getWorkArea() {
		return workArea;
	}
	/**
	 * @param workArea the workArea to set
	 */
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	/**
	 * @return the payMonth
	 */
	public int getPayMonth() {
		return payMonth;
	}
	/**
	 * @param payMonth the payMonth to set
	 */
	public void setPayMonth(int payMonth) {
		this.payMonth = payMonth;
	}
	/**
	 * @return the payTot
	 */
	public int getPayTot() {
		return payTot;
	}
	/**
	 * @param payTot the payTot to set
	 */
	public void setPayTot(int payTot) {
		this.payTot = payTot;
	}
	/**
	 * @return the endYn
	 */
	public String getEndYn() {
		return endYn;
	}
	/**
	 * @param endYn the endYn to set
	 */
	public void setEndYn(String endYn) {
		this.endYn = endYn;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
