package com.mcst.dto.db;

import java.io.Serializable;

public class ppy220tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8379942368698706934L;

	private String payYm;
	private String suppType;
	private String pernNo;
	private String wagesCode;
	private int stdAmountI;
	private String calcuType;
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
	 * @return the suppType
	 */
	public String getSuppType() {
		return suppType;
	}
	/**
	 * @param suppType the suppType to set
	 */
	public void setSuppType(String suppType) {
		this.suppType = suppType;
	}
	/**
	 * @return the pernNo
	 */
	public String getPernNo() {
		return pernNo;
	}
	/**
	 * @param pernNo the pernNo to set
	 */
	public void setPernNo(String pernNo) {
		this.pernNo = pernNo;
	}
	/**
	 * @return the wagesCode
	 */
	public String getWagesCode() {
		return wagesCode;
	}
	/**
	 * @param wagesCode the wagesCode to set
	 */
	public void setWagesCode(String wagesCode) {
		this.wagesCode = wagesCode;
	}
	/**
	 * @return the stdAmountI
	 */
	public int getStdAmountI() {
		return stdAmountI;
	}
	/**
	 * @param stdAmountI the stdAmountI to set
	 */
	public void setStdAmountI(int stdAmountI) {
		this.stdAmountI = stdAmountI;
	}
	/**
	 * @return the calcuType
	 */
	public String getCalcuType() {
		return calcuType;
	}
	/**
	 * @param calcuType the calcuType to set
	 */
	public void setCalcuType(String calcuType) {
		this.calcuType = calcuType;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
