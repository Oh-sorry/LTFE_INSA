package com.mcst.gbn30.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309502Dto;
import com.mcst.gbn30.dao.pg309502Dao;
import com.mcst.gbn30.service.pg309502Service;


@Service("pg309502Service")
public class pg309502ServiceImpl extends EgovAbstractServiceImpl implements pg309502Service {

    @Resource(name = "pg309502Dao")
    private pg309502Dao pg309502Dao;

    public List<pg309502Dto> selectPg309502List(pg309502Dto pg309502Dto) throws Exception {
    	return pg309502Dao.selectPg309502List(pg309502Dto);
    }

    public List<pg309502Dto> selectPg309502Info(pg309502Dto pg309502Dto) throws Exception {
    	return pg309502Dao.selectPg309502Info(pg309502Dto);
    }

    public int selectPg309502Check(pg309502Dto pg309502Dto) throws Exception {
    	return pg309502Dao.selectPg309502Check(pg309502Dto);
    }

    public int updatePg309502(usr200tDto usr200tDto) throws Exception {
    	return pg309502Dao.updatePg309502(usr200tDto);
    }

    public int selectPg309502DelCheck(pg309502Dto pg309502Dto) throws Exception {
    	return pg309502Dao.selectPg309502DelCheck(pg309502Dto);
    }

    public int deletePg309502(pg309502Dto pg309502Dto) throws Exception {
    	return pg309502Dao.deletePg309502(pg309502Dto);
    }
}
