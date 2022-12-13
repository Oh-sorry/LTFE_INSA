package com.mcst.dto.db;

import java.io.Serializable;

public class ovaproductDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3049336525029309932L;

	private int seq;
	private String partnumber;
	private String quantity;
	private String condition;
	private String st;
	private String leadtime;
	private String ecy;
	private String regdate;
	private String isuse;
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
	 * @return the partnumber
	 */
	public String getPartnumber() {
		return partnumber;
	}
	/**
	 * @param partnumber the partnumber to set
	 */
	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the st
	 */
	public String getSt() {
		return st;
	}
	/**
	 * @param st the st to set
	 */
	public void setSt(String st) {
		this.st = st;
	}
	/**
	 * @return the leadtime
	 */
	public String getLeadtime() {
		return leadtime;
	}
	/**
	 * @param leadtime the leadtime to set
	 */
	public void setLeadtime(String leadtime) {
		this.leadtime = leadtime;
	}
	/**
	 * @return the ecy
	 */
	public String getEcy() {
		return ecy;
	}
	/**
	 * @param ecy the ecy to set
	 */
	public void setEcy(String ecy) {
		this.ecy = ecy;
	}
	/**
	 * @return the regdate
	 */
	public String getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return the isuse
	 */
	public String getIsuse() {
		return isuse;
	}
	/**
	 * @param isuse the isuse to set
	 */
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
