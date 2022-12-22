package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.gbn10.pg104500Dto;

public interface pg104500Service {

	public List<pg104500Dto> selectPg104500GbnList(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500List(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500GbnList2(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500GbnList3(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500GbnList4(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500GbnJoinList(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> excelDownload(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectSearchName(pg104500Dto pg104500Dto) throws Exception;

	public pg104500Dto selectPernInfo(String pernNo) throws Exception;

	public List<pg104500Dto> selectPg104500DeptList1(pg104500Dto pg104500Dto) throws Exception;

	public List<pg104500Dto> selectPg104500DeptList2(pg104500Dto pg104500Dto) throws Exception;



}
