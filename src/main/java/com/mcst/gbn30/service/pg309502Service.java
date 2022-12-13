package com.mcst.gbn30.service;

import java.util.List;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309502Dto;

public interface pg309502Service {

    @SuppressWarnings("unchecked")
    public List<pg309502Dto> selectPg309502List(pg309502Dto pg309502Dto) throws Exception;

    public List<pg309502Dto> selectPg309502Info(pg309502Dto pg309502Dto) throws Exception;

    public int selectPg309502Check(pg309502Dto pg309502Dto) throws Exception;

    public int updatePg309502(usr200tDto usr200tDto) throws Exception;

    public int selectPg309502DelCheck(pg309502Dto pg309502Dto) throws Exception;

    public int deletePg309502(pg309502Dto pg309502Dto) throws Exception;
}