package com.mcst.dto.db;

import java.io.Serializable;

public class ntxcodeDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3039315979079435245L;

	private String code1;
	private int code2;
	private String text1;
	private String text2;
	/**
	 * @return the code1
	 */
	public String getCode1() {
		return code1;
	}
	/**
	 * @param code1 the code1 to set
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	/**
	 * @return the code2
	 */
	public int getCode2() {
		return code2;
	}
	/**
	 * @param code2 the code2 to set
	 */
	public void setCode2(int code2) {
		this.code2 = code2;
	}
	/**
	 * @return the text1
	 */
	public String getText1() {
		return text1;
	}
	/**
	 * @param text1 the text1 to set
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}
	/**
	 * @return the text2
	 */
	public String getText2() {
		return text2;
	}
	/**
	 * @param text2 the text2 to set
	 */
	public void setText2(String text2) {
		this.text2 = text2;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
