package com.mcst.dto.db;

import java.io.Serializable;

public class medRemarkDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8388789708972999487L;

	private String empno;
	private String remark1;
	private String remark2;
	private String remark3;
	private String gozdt;
	/**
	 * @return the empno
	 */
	public String getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	/**
	 * @return the remark1
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * @param remark1 the remark1 to set
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	/**
	 * @return the remark2
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * @param remark2 the remark2 to set
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	/**
	 * @return the remark3
	 */
	public String getRemark3() {
		return remark3;
	}
	/**
	 * @param remark3 the remark3 to set
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	/**
	 * @return the gozdt
	 */
	public String getGozdt() {
		return gozdt;
	}
	/**
	 * @param gozdt the gozdt to set
	 */
	public void setGozdt(String gozdt) {
		this.gozdt = gozdt;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
