package com.mcst.gbn30.service;

import java.util.List;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg301100Dto;

public interface pg301100Service {

    @SuppressWarnings("unchecked")
    public List<pg301100Dto> selectPg309501GbnList(pg301100Dto pg301100Dto) throws Exception ;

    public List<pg301100Dto> selectPg301100List(pg301100Dto Pg301100Dto) throws Exception;

    public pg301100Dto selectPg309501GbnName(pg301100Dto pg301100Dto) throws Exception;

    public pg301100Dto selectPg301100Info(pg301100Dto Pg301100Dto) throws Exception;

    public String selectpg301100MenuId(pg301100Dto pg301100Dto) throws Exception;

    public int updatePg301100(usr200tDto usr200tDto) throws Exception;

    public int deletePg301100(pg301100Dto Pg301100Dto) throws Exception;
}