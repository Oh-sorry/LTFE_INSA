package com.mcst.gbn10.service;

import java.util.List;
import java.util.Map;

import com.mcst.dto.db.hte100tDto;
import com.mcst.dto.gbn10.pg102000Dto;

public interface pg102000Service {
	
	public List<pg102000Dto> selectPg102000EduList(pg102000Dto pg102000Dto) throws Exception;

	public List<pg102000Dto> selectPg102000EduTypeList(pg102000Dto pg102000Dto) throws Exception;
	
	public List<pg102000Dto> selectPg102000SearchList(pg102000Dto pg102000Dto) throws Exception;

	public pg102000Dto selectPg102000Info(pg102000Dto pg102000Dto) throws Exception;

	public int selectPg102000Check(pg102000Dto pg102000Dto) throws Exception;
	
	public int updatePg102000(hte100tDto hte100tDto) throws Exception;

	public int deletePg102000(pg102000Dto pg102000Dto) throws Exception;
	
	
	public List<Map<String, Object>> excelList(pg102000Dto pg102000Dto) throws Exception;

	
	

	/*
	 * public List<pg102000Dto> selectPg102000DayList1(pg102000Dto pg102000Dto)
	 * throws Exception;
	 * 
	 * public List<pg102000Dto> selectPg102000DayList2(pg102000Dto pg102000Dto)
	 * throws Exception;
	 */

}
