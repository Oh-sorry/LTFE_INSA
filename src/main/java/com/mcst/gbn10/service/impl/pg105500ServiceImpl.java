package com.mcst.gbn10.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.gbn10.pg105500Dto;
import com.mcst.gbn10.dao.pg105500Dao;
import com.mcst.gbn10.service.pg105500Service;

@Service("pg105500Service")
public class pg105500ServiceImpl extends EgovAbstractServiceImpl implements pg105500Service {

	@Resource(name = "pg105500Dao")
    private pg105500Dao pg105500Dao;
	
	public List<pg105500Dto> selectPg105500List(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500List(pg105500Dto);
	}
	
	public List<pg105500Dto> selectPg105500GbnList2(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500GbnList2(pg105500Dto);
	}
	
	public List<pg105500Dto> selectPg105500GbnList3(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500GbnList3(pg105500Dto);
	}
	
	public List<pg105500Dto> selectPg105500GbnList4(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500GbnList4(pg105500Dto);
	}
	
	public List<pg105500Dto> selectPg105500DeptList1(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500DeptList1(pg105500Dto);
	}

	public List<pg105500Dto> selectPg105500DeptList2(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.selectPg105500DeptList2(pg105500Dto);
	}
	
	public List<pg105500Dto> excelDownload(pg105500Dto pg105500Dto) throws Exception {
		return pg105500Dao.excelDownload(pg105500Dto);
	}
}
