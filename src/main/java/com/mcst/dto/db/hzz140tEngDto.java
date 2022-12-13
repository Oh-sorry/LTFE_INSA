package com.mcst.dto.db;

import java.io.Serializable;

public class hzz140tEngDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2028670647787469423L;

	private int seq;
	private String presentaddress;
	private String position;
	private String belongs;
	private String usrengname;
	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return the presentaddress
	 */
	public String getPresentaddress() {
		return presentaddress;
	}
	/**
	 * @param presentaddress the presentaddress to set
	 */
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the belongs
	 */
	public String getBelongs() {
		return belongs;
	}
	/**
	 * @param belongs the belongs to set
	 */
	public void setBelongs(String belongs) {
		this.belongs = belongs;
	}
	/**
	 * @return the usrengname
	 */
	public String getUsrengname() {
		return usrengname;
	}
	/**
	 * @param usrengname the usrengname to set
	 */
	public void setUsrengname(String usrengname) {
		this.usrengname = usrengname;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
