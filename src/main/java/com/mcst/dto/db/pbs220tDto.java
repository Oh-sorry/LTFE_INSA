package com.mcst.dto.db;

import java.io.Serializable;

public class pbs220tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2027021404001338907L;

	private String pernNo;
	private String etc;
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
	 * @return the etc
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
