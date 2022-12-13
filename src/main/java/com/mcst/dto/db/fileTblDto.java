package com.mcst.dto.db;

import java.io.Serializable;

public class fileTblDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6385138728407227461L;

	private int fileNo;
	private int contNo;
	private String fileNm;
	private String pathNm;
	private String delFlag;
	/**
	 * @return the fileNo
	 */
	public int getFileNo() {
		return fileNo;
	}
	/**
	 * @param fileNo the fileNo to set
	 */
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	/**
	 * @return the contNo
	 */
	public int getContNo() {
		return contNo;
	}
	/**
	 * @param contNo the contNo to set
	 */
	public void setContNo(int contNo) {
		this.contNo = contNo;
	}
	/**
	 * @return the fileNm
	 */
	public String getFileNm() {
		return fileNm;
	}
	/**
	 * @param fileNm the fileNm to set
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	/**
	 * @return the pathNm
	 */
	public String getPathNm() {
		return pathNm;
	}
	/**
	 * @param pathNm the pathNm to set
	 */
	public void setPathNm(String pathNm) {
		this.pathNm = pathNm;
	}
	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
