package com.mcst.dto.db;

import java.io.Serializable;

public class companyTblDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6540638119898205315L;

	private int compNo;
	private String compNm;
	/**
	 * @return the compNo
	 */
	public int getCompNo() {
		return compNo;
	}
	/**
	 * @param compNo the compNo to set
	 */
	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}
	/**
	 * @return the compNm
	 */
	public String getCompNm() {
		return compNm;
	}
	/**
	 * @param compNm the compNm to set
	 */
	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
