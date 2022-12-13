package com.mcst.dto.db;

import java.io.Serializable;

public class usr300tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7892187501889956045L;

	private String pernNum;
	private String menuId;
	private String menuAuth;
	private String instDate;
	/**
	 * @return the pernNum
	 */
	public String getPernNum() {
		return pernNum;
	}
	/**
	 * @param pernNum the pernNum to set
	 */
	public void setPernNum(String pernNum) {
		this.pernNum = pernNum;
	}
	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the menuAuth
	 */
	public String getMenuAuth() {
		return menuAuth;
	}
	/**
	 * @param menuAuth the menuAuth to set
	 */
	public void setMenuAuth(String menuAuth) {
		this.menuAuth = menuAuth;
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
