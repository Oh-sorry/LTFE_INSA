package com.mcst.gbn10.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.gbn10.service.pg104500Service;
import com.mcst.dto.gbn10.pg104500Dto;
import com.mcst.gbn10.dao.pg104500Dao;

@Service("pg104500Service")
public class pg104500ServiceImpl extends EgovAbstractServiceImpl implements pg104500Service {

	@Resource(name = "pg104500Dao")
    private pg104500Dao pg104500Dao;
	
	public List<pg104500Dto> selectPg104500GbnList(pg104500Dto pg104500Dto) throws Exception {
		return pg104500Dao.selectPg104500GbnList(pg104500Dto);
	}
	public List<pg104500Dto> selectPg104500GbnList2(pg104500Dto pg104500Dto) throws Exception {
		return pg104500Dao.selectPg104500GbnList2(pg104500Dto);
	}
	public List<pg104500Dto> selectPg104500GbnList3(pg104500Dto pg104500Dto) throws Exception {
		return pg104500Dao.selectPg104500GbnList3(pg104500Dto);
	}
	public List<pg104500Dto> selectPg104500GbnList4(pg104500Dto pg104500Dto) throws Exception {
		return pg104500Dao.selectPg104500GbnList4(pg104500Dto);
	}

	public List<pg104500Dto> selectPg104500List(pg104500Dto pg104500Dto) throws Exception {
		return pg104500Dao.selectPg104500List(pg104500Dto);
	}
}
