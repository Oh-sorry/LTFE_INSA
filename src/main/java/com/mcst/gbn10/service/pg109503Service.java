package com.mcst.gbn10.service;

import java.util.List;
import java.util.Map;

import com.mcst.dto.gbn10.pg109503Dto;

public interface pg109503Service {

	public List<pg109503Dto> selectPg109503OrgList(pg109503Dto pg109503Dto) throws Exception;

	public List<pg109503Dto> selectPg109503DeptList1(pg109503Dto pg109503Dto) throws Exception;

	public List<pg109503Dto> selectPg109503DeptList2(pg109503Dto pg109503Dto) throws Exception;

	public List<Map<String, Object>> excelList(pg109503Dto pg109503Dto) throws Exception;

}
