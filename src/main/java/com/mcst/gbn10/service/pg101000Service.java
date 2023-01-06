package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.gbn10.pg101000Dto;

public interface pg101000Service {
	
	public pg101000Dto selectPg101000PernInfo(pg101000Dto pg101000Dto) throws Exception;

	public List<pg101000Dto> selectPg101000SearchList(pg101000Dto pg101000Dto) throws Exception;

	

}
