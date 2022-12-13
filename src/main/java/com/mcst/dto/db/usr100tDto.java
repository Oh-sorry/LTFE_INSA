package com.mcst.dto.db;

import java.io.Serializable;

public class usr100tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7963179469254144445L;

	private String pernNo;
	private String pernPwd;
	private String pernAuth;
	private String usedGubn;
	private String instDate;
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
	 * @return the pernPwd
	 */
	public String getPernPwd() {
		return pernPwd;
	}
	/**
	 * @param pernPwd the pernPwd to set
	 */
	public void setPernPwd(String pernPwd) {
		this.pernPwd = pernPwd;
	}
	/**
	 * @return the pernAuth
	 */
	public String getPernAuth() {
		return pernAuth;
	}
	/**
	 * @param pernAuth the pernAuth to set
	 */
	public void setPernAuth(String pernAuth) {
		this.pernAuth = pernAuth;
	}
	/**
	 * @return the usedGubn
	 */
	public String getUsedGubn() {
		return usedGubn;
	}
	/**
	 * @param usedGubn the usedGubn to set
	 */
	public void setUsedGubn(String usedGubn) {
		this.usedGubn = usedGubn;
	}
	/**
	 * @return the instDate
	 */
	public String getInstDate() {
		return instDate;
	}
	/**
	 * @param instDate the instDate to set
	 */
	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
