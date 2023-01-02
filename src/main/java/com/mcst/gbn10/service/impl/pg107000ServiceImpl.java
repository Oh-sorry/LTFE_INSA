package com.mcst.gbn10.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.gbn10.pg107000Dto;
import com.mcst.gbn10.dao.pg107000Dao;
import com.mcst.gbn10.service.pg107000Service;

@Service("pg107000Service")
public class pg107000ServiceImpl extends EgovAbstractServiceImpl implements pg107000Service {

	@Resource(name = "pg107000Dao")
    private pg107000Dao pg107000Dao;
	
	public List<pg107000Dto> selectPg107000List(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectPg107000List(pg107000Dto);
	}
	
	public List<pg107000Dto> selectPg107000GbnJoinList(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectPg107000GbnJoinList(pg107000Dto);
	}
	
	public List<pg107000Dto> selectpg107000DtoYearList(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectpg107000DtoYearList(pg107000Dto);
	}
	
	public List<pg107000Dto> selectpg107000DtoMonthList(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectpg107000DtoMonthList(pg107000Dto);
	}
	
	public List<pg107000Dto> excelDownload(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.excelDownload(pg107000Dto);
	}
	
	public List<pg107000Dto> selectpg107000DtoJoinCount(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectpg107000DtoJoinCount(pg107000Dto);
	}

	public List<pg107000Dto> selectpg107000DtoRetrCount(pg107000Dto pg107000Dto) throws Exception {
		return pg107000Dao.selectpg107000DtoRetrCount(pg107000Dto);
	}
}
