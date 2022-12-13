package com.mcst.dto.db;

import java.io.Serializable;

public class findvalueDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5262243683225138410L;

	private String tableNm;
	private String columnNm;
	/**
	 * @return the tableNm
	 */
	public String getTableNm() {
		return tableNm;
	}
	/**
	 * @param tableNm the tableNm to set
	 */
	public void setTableNm(String tableNm) {
		this.tableNm = tableNm;
	}
	/**
	 * @return the columnNm
	 */
	public String getColumnNm() {
		return columnNm;
	}
	/**
	 * @param columnNm the columnNm to set
	 */
	public void setColumnNm(String columnNm) {
		this.columnNm = columnNm;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
