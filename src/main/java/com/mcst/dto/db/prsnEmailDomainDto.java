package com.mcst.dto.db;

import java.io.Serializable;

public class prsnEmailDomainDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5378258544837894105L;

	private String domain;

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
