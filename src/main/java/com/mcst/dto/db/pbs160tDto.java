package com.mcst.dto.db;

import java.io.Serializable;

public class pbs160tDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8597571832125918900L;

	private String clubCode;
	private String clubPern;
	private String clubStartDate;
	private String clubEndDate;
	private int clubAmt;
	private String clubEtc;
	/**
	 * @return the clubCode
	 */
	public String getClubCode() {
		return clubCode;
	}
	/**
	 * @param clubCode the clubCode to set
	 */
	public void setClubCode(String clubCode) {
		this.clubCode = clubCode;
	}
	/**
	 * @return the clubPern
	 */
	public String getClubPern() {
		return clubPern;
	}
	/**
	 * @param clubPern the clubPern to set
	 */
	public void setClubPern(String clubPern) {
		this.clubPern = clubPern;
	}
	/**
	 * @return the clubStartDate
	 */
	public String getClubStartDate() {
		return clubStartDate;
	}
	/**
	 * @param clubStartDate the clubStartDate to set
	 */
	public void setClubStartDate(String clubStartDate) {
		this.clubStartDate = clubStartDate;
	}
	/**
	 * @return the clubEndDate
	 */
	public String getClubEndDate() {
		return clubEndDate;
	}
	/**
	 * @param clubEndDate the clubEndDate to set
	 */
	public void setClubEndDate(String clubEndDate) {
		this.clubEndDate = clubEndDate;
	}
	/**
	 * @return the clubAmt
	 */
	public int getClubAmt() {
		return clubAmt;
	}
	/**
	 * @param clubAmt the clubAmt to set
	 */
	public void setClubAmt(int clubAmt) {
		this.clubAmt = clubAmt;
	}
	/**
	 * @return the clubEtc
	 */
	public String getClubEtc() {
		return clubEtc;
	}
	/**
	 * @param clubEtc the clubEtc to set
	 */
	public void setClubEtc(String clubEtc) {
		this.clubEtc = clubEtc;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
