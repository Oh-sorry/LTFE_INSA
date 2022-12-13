package com.mcst.dto.db;

import java.io.Serializable;

public class ppy130tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3823764727840857378L;

	private String payYm;
	private String suppType;
	private String dedCode;
	private String pernNo;
	private int dedAmountI;
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
	 * @return the dedCode
	 */
	public String getDedCode() {
		return dedCode;
	}
	/**
	 * @param dedCode the dedCode to set
	 */
	public void setDedCode(String dedCode) {
		this.dedCode = dedCode;
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
	 * @return the dedAmountI
	 */
	public int getDedAmountI() {
		return dedAmountI;
	}
	/**
	 * @param dedAmountI the dedAmountI to set
	 */
	public void setDedAmountI(int dedAmountI) {
		this.dedAmountI = dedAmountI;
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
