package com.mcst.main.service;

import java.util.List;
import java.util.Map;

import com.mcst.dto.nameSearchDto;
import com.mcst.dto.pernInfoDto;

public interface commonService {

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectSearchName(nameSearchDto nameSearchDto) throws Exception;

    public pernInfoDto selectPernInfo(String pernNo) throws Exception;
}