package com.mcst.gbn30.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg301100Dto;
import com.mcst.gbn30.dao.pg301100Dao;
import com.mcst.gbn30.service.pg301100Service;


@Service("pg301100Service")
public class pg301100ServiceImpl extends EgovAbstractServiceImpl implements pg301100Service {

    @Resource(name = "pg301100Dao")
    private pg301100Dao pg301100Dao;

    public List<pg301100Dto> selectPg309501GbnList(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.selectPg309501GbnList(pg301100Dto);
    }

    public List<pg301100Dto> selectPg301100List(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.selectPg301100List(pg301100Dto);
    }

    public pg301100Dto selectPg309501GbnName(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.selectPg309501GbnName(pg301100Dto);
    }

    public pg301100Dto selectPg301100Info(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.selectPg301100Info(pg301100Dto);
    }

    public String selectpg301100MenuId(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.selectpg301100MenuId(pg301100Dto);
    }

    public int updatePg301100(usr200tDto usr200tDto) throws Exception {
    	return pg301100Dao.updatePg301100(usr200tDto);
    }

    public int deletePg301100(pg301100Dto pg301100Dto) throws Exception {
    	return pg301100Dao.deletePg301100(pg301100Dto);
    }
}
