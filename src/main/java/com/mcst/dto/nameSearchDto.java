package com.mcst.dto;

import java.io.Serializable;

public class nameSearchDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 852113555412393000L;

	private String pernNo;
	private String name;
	private String searchName;
	private String joinGubun;


	/**
	 * @return the joinGubun
	 */
	public String getJoinGubun() {
		return joinGubun;
	}
	/**
	 * @param joinGubun the joinGubun to set
	 */
	public void setJoinGubun(String joinGubun) {
		this.joinGubun = joinGubun;
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
	 * @return the searchName
	 */
	public String getSearchName() {
		return searchName;
	}
	/**
	 * @param searchName the searchName to set
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
