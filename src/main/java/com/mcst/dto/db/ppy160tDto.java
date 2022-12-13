package com.mcst.dto.db;

import java.io.Serializable;

public class ppy160tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1029711930052508738L;

	private String payYm;
	private String suppType;
	private String pernNo;
	private String pernKorNm;
	private int suppAmount;
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
	 * @return the pernKorNm
	 */
	public String getPernKorNm() {
		return pernKorNm;
	}
	/**
	 * @param pernKorNm the pernKorNm to set
	 */
	public void setPernKorNm(String pernKorNm) {
		this.pernKorNm = pernKorNm;
	}
	/**
	 * @return the suppAmount
	 */
	public int getSuppAmount() {
		return suppAmount;
	}
	/**
	 * @param suppAmount the suppAmount to set
	 */
	public void setSuppAmount(int suppAmount) {
		this.suppAmount = suppAmount;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
