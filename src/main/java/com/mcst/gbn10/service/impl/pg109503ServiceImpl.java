package com.mcst.gbn10.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.gbn10.service.pg109503Service;
import com.mcst.dto.gbn10.pg109503Dto;
import com.mcst.gbn10.dao.pg109503Dao;

@Service("pg109503Service")
public class pg109503ServiceImpl extends EgovAbstractServiceImpl implements pg109503Service {
	
	@Resource(name = "pg109503Dao")
    private pg109503Dao pg109503Dao;

	public List<pg109503Dto> selectPg109503OrgList(pg109503Dto pg109503Dto) throws Exception {
		return pg109503Dao.selectPg109503OrgList(pg109503Dto);
	}

	public List<pg109503Dto> selectPg109503DeptList1(pg109503Dto pg109503Dto) throws Exception {
		return pg109503Dao.selectPg109503DeptList1(pg109503Dto);
	}

	public List<pg109503Dto> selectPg109503DeptList2(pg109503Dto pg109503Dto) throws Exception {
		return pg109503Dao.selectPg109503DeptList2(pg109503Dto);
	}

	public List<Map<String, Object>> excelList(pg109503Dto pg109503Dto) throws Exception {		
		return pg109503Dao.excelList(pg109503Dto);
	}

}
