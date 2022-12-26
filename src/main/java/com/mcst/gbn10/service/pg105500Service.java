package com.mcst.gbn10.service;

import java.util.List;

import com.mcst.dto.gbn10.pg105500Dto;
import com.mcst.dto.gbn10.pg105500Dto;

public interface pg105500Service {

	public List<pg105500Dto> selectPg105500List(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> selectPg105500GbnList2(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> selectPg105500GbnList4(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> selectPg105500GbnList3(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> selectPg105500DeptList1(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> selectPg105500DeptList2(pg105500Dto pg105500Dto) throws Exception;

	public List<pg105500Dto> excelDownload(pg105500Dto pg105500Dto) throws Exception;

}
