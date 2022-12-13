package com.mcst.gbn30.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309501Dto;
import com.mcst.gbn30.dao.pg309501Dao;
import com.mcst.gbn30.service.pg309501Service;


@Service("pg309501Service")
public class pg309501ServiceImpl extends EgovAbstractServiceImpl implements pg309501Service {

    @Resource(name = "pg309501Dao")
    private pg309501Dao pg309501Dao;

    public List<pg309501Dto> selectPg309501List(pg309501Dto pg309501Dto) throws Exception {
    	return pg309501Dao.selectPg309501List(pg309501Dto);
    }

    public pg309501Dto selectPg309501Info(pg309501Dto pg309501Dto) throws Exception {
    	return pg309501Dao.selectPg309501Info(pg309501Dto);
    }

    public int selectPg309501Check(pg309501Dto pg309501Dto) throws Exception {
    	return pg309501Dao.selectPg309501Check(pg309501Dto);
    }

    public int updatePg309501(usr200tDto usr200tDto) throws Exception {
    	return pg309501Dao.updatePg309501(usr200tDto);
    }

    public int selectPg309501DelCheck(pg309501Dto pg309501Dto) throws Exception {
    	return pg309501Dao.selectPg309501DelCheck(pg309501Dto);
    }

    public int deletePg309501(pg309501Dto pg309501Dto) throws Exception {
    	return pg309501Dao.deletePg309501(pg309501Dto);
    }
}
