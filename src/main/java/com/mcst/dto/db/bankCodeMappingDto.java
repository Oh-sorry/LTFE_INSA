package com.mcst.dto.db;

import java.io.Serializable;

public class bankCodeMappingDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2912469008368710901L;

	private String bankCd;
	private String bankNm;
	private String bankNmBigo;
	private String bankDetailCode;
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
	 * @return the bankNmBigo
	 */
	public String getBankNmBigo() {
		return bankNmBigo;
	}
	/**
	 * @param bankNmBigo the bankNmBigo to set
	 */
	public void setBankNmBigo(String bankNmBigo) {
		this.bankNmBigo = bankNmBigo;
	}
	/**
	 * @return the bankDetailCode
	 */
	public String getBankDetailCode() {
		return bankDetailCode;
	}
	/**
	 * @param bankDetailCode the bankDetailCode to set
	 */
	public void setBankDetailCode(String bankDetailCode) {
		this.bankDetailCode = bankDetailCode;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
