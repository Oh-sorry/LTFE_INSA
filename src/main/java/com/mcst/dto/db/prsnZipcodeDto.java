package com.mcst.dto.db;

import java.io.Serializable;

public class prsnZipcodeDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6040717649861512218L;

	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the sido
	 */
	public String getSido() {
		return sido;
	}
	/**
	 * @param sido the sido to set
	 */
	public void setSido(String sido) {
		this.sido = sido;
	}
	/**
	 * @return the gugun
	 */
	public String getGugun() {
		return gugun;
	}
	/**
	 * @param gugun the gugun to set
	 */
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	/**
	 * @return the dong
	 */
	public String getDong() {
		return dong;
	}
	/**
	 * @param dong the dong to set
	 */
	public void setDong(String dong) {
		this.dong = dong;
	}
	/**
	 * @return the bunji
	 */
	public String getBunji() {
		return bunji;
	}
	/**
	 * @param bunji the bunji to set
	 */
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
