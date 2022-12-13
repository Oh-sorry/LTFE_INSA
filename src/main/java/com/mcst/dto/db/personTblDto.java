package com.mcst.dto.db;

import java.io.Serializable;

public class personTblDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4755939449049720792L;

	private int pers_no;
	private String pers_nm;
	private int cont_no;
	private String pers_grade;
	/**
	 * @return the pers_no
	 */
	public int getPers_no() {
		return pers_no;
	}
	/**
	 * @param pers_no the pers_no to set
	 */
	public void setPers_no(int pers_no) {
		this.pers_no = pers_no;
	}
	/**
	 * @return the pers_nm
	 */
	public String getPers_nm() {
		return pers_nm;
	}
	/**
	 * @param pers_nm the pers_nm to set
	 */
	public void setPers_nm(String pers_nm) {
		this.pers_nm = pers_nm;
	}
	/**
	 * @return the cont_no
	 */
	public int getCont_no() {
		return cont_no;
	}
	/**
	 * @param cont_no the cont_no to set
	 */
	public void setCont_no(int cont_no) {
		this.cont_no = cont_no;
	}
	/**
	 * @return the pers_grade
	 */
	public String getPers_grade() {
		return pers_grade;
	}
	/**
	 * @param pers_grade the pers_grade to set
	 */
	public void setPers_grade(String pers_grade) {
		this.pers_grade = pers_grade;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
