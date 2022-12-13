package com.mcst.dto.db;

import java.io.Serializable;

public class prsnBankDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1012831607854137585L;

	private String bankCd;
	private String bankNm;
	/**
	 * @return the bankCd
	 */
	public String getBankCd() {
		return bankCd;
	}
	/**
	 * @param bankCd the bankCd to set
	 */
	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}
	/**
	 * @return the bankNm
	 */
	public String getBankNm() {
		return bankNm;
	}
	/**
	 * @param bankNm the bankNm to set
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
