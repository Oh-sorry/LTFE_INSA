package com.mcst.gbn10.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.gbn10.pg101000Dto;
import com.mcst.gbn10.dao.pg101000Dao;
import com.mcst.gbn10.service.pg101000Service;

@Service("pg101000Service")
public class pg101000ServiceImpl extends EgovAbstractServiceImpl implements pg101000Service {

	@Resource(name = "pg101000Dao")
    private pg101000Dao pg101000Dao;

	
	public pg101000Dto selectPg101000PernInfo(pg101000Dto pg101000Dto) throws Exception {
		return pg101000Dao.selectPg101000PernInfo(pg101000Dto);
	}
	
	public List<pg101000Dto> selectPg101000SearchList(pg101000Dto pg101000Dto) throws Exception {
		return pg101000Dao.selectPg101000SearchList(pg101000Dto);
	}

	
}
