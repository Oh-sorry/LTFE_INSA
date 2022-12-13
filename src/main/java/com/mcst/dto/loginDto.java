package com.mcst.dto;

import java.io.Serializable;

public class loginDto implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = -6563622194262791367L;
	private String pernNo;
	private String name;
	private String pernAuth;
	private String pernPwd;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
