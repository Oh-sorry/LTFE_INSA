package com.mcst.dto.db;

import java.io.Serializable;

public class prsnHrFileDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4259770718940104941L;

	private String jumin;
	private int seq;
	private String fileName;
	private String fileNameOrg;
	private String filePath;
	private String fileType;
	/**
	 * @return the jumin
	 */
	public String getJumin() {
		return jumin;
	}
	/**
	 * @param jumin the jumin to set
	 */
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileNameOrg
	 */
	public String getFileNameOrg() {
		return fileNameOrg;
	}
	/**
	 * @param fileNameOrg the fileNameOrg to set
	 */
	public void setFileNameOrg(String fileNameOrg) {
		this.fileNameOrg = fileNameOrg;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
