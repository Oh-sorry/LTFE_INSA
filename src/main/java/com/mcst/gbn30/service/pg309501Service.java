package com.mcst.gbn30.service;

import java.util.List;

import com.mcst.dto.db.usr200tDto;
import com.mcst.dto.gbn30.pg309501Dto;

public interface pg309501Service {

    @SuppressWarnings("unchecked")
    public List<pg309501Dto> selectPg309501List(pg309501Dto pg309501Dto) throws Exception;

    public pg309501Dto selectPg309501Info(pg309501Dto pg309501Dto) throws Exception;

    public int selectPg309501Check(pg309501Dto pg309501Dto) throws Exception;

    public int updatePg309501(usr200tDto usr200tDto) throws Exception;

    public int selectPg309501DelCheck(pg309501Dto pg309501Dto) throws Exception;

    public int deletePg309501(pg309501Dto pg309501Dto) throws Exception;
}