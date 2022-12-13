package com.mcst.main.service;

import java.util.List;

import com.mcst.dto.nameSearchDto;
import com.mcst.dto.pernInfoDto;

public interface commonService {

    @SuppressWarnings("unchecked")
    public List<nameSearchDto> selectSearchName(nameSearchDto nameSearchDto) throws Exception;

    public pernInfoDto selectPernInfo(String pernNo) throws Exception;
}