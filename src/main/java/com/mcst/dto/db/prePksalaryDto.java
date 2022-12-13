package com.mcst.dto.db;

import java.io.Serializable;

public class prePksalaryDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4145633590194828853L;

	private String payYm;
	private String salaryGb;
	private String empNo;
	private int bohemAmt;
	/**
	 * @return the payYm
	 */
	public String getPayYm() {
		return payYm;
	}
	/**
	 * @param payYm the payYm to set
	 */
	public void setPayYm(String payYm) {
		this.payYm = payYm;
	}
	/**
	 * @return the salaryGb
	 */
	public String getSalaryGb() {
		return salaryGb;
	}
	/**
	 * @param salaryGb the salaryGb to set
	 */
	public void setSalaryGb(String salaryGb) {
		this.salaryGb = salaryGb;
	}
	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}
	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	/**
	 * @return the bohemAmt
	 */
	public int getBohemAmt() {
		return bohemAmt;
	}
	/**
	 * @param bohemAmt the bohemAmt to set
	 */
	public void setBohemAmt(int bohemAmt) {
		this.bohemAmt = bohemAmt;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}