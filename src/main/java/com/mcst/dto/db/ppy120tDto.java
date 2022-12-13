package com.mcst.dto.db;

import java.io.Serializable;

public class ppy120tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8317980592630459184L;

	private String payYm;
	private String pernNo;
	private int basicPay;
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
	 * @return the basicPay
	 */
	public int getBasicPay() {
		return basicPay;
	}
	/**
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
