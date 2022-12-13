package com.mcst.main.service;

import java.util.List;

import com.mcst.dto.loginDto;
import com.mcst.dto.loginMenuAuthDto;
import com.mcst.dto.nameSearchDto;

public interface mainService {

    @SuppressWarnings("unchecked")
    public loginDto selectLoginInfo(loginDto loginDto) throws Exception;

    public int selectLoginChk(loginDto loginDto) throws Exception;

    public List<loginMenuAuthDto> selectMenuAuth(loginDto loginDto) throws Exception;
}