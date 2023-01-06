package com.mcst.gbn10.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.db.hzz140tDto;
import com.mcst.dto.gbn10.pg103000Dto;
import com.mcst.gbn10.dao.pg103000Dao;
import com.mcst.gbn10.service.pg103000Service;

@Service("pg103000Service")
public class pg103000ServiceImpl extends EgovAbstractServiceImpl implements pg103000Service {

	@Resource(name = "pg103000Dao")
    private pg103000Dao pg103000Dao;
	
	public List<pg103000Dto> selectPg103000List(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000List(pg103000Dto);
	}
	
	public List<pg103000Dto> selectPg103000DetpList1(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000DetpList1(pg103000Dto);
	}

	public List<pg103000Dto> selectPg103000DetpList2(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000DetpList2(pg103000Dto);
	}
	
	public List<pg103000Dto> selectPg103000CertGbn(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000CertGbn(pg103000Dto);
	}
	
	public int pageListCnt(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.pageListCnt(pg103000Dto);
	}

	public int selectPg103000Check(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000Check(pg103000Dto);
	}
	
	public int updatePg103000(hzz140tDto hzz140tDto) throws Exception {
		return pg103000Dao.updatePg103000(hzz140tDto);
	}
	
	public List<pg103000Dto> selectPg103000SearchList(pg103000Dto pg103000Dto) throws Exception {
		return pg103000Dao.selectPg103000SearchList(pg103000Dto);
	}
}
