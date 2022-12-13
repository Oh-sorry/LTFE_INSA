package com.mcst.dto.db;

import java.io.Serializable;

public class ovatelDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7041868553539364904L;

	private String kname;
	private String ename;
	private String eno;
	/**
	 * @return the kname
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * @param kname the kname to set
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the eno
	 */
	public String getEno() {
		return eno;
	}
	/**
	 * @param eno the eno to set
	 */
	public void setEno(String eno) {
		this.eno = eno;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
