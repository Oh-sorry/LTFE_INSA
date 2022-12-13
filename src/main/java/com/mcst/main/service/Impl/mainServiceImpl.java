package com.mcst.main.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.loginDto;
import com.mcst.dto.loginMenuAuthDto;
import com.mcst.dto.nameSearchDto;
import com.mcst.main.dao.mainDao;
import com.mcst.main.service.mainService;

@Service("mainService")
public class mainServiceImpl extends EgovAbstractServiceImpl implements mainService {

    @Resource(name = "mainDao")
    private mainDao mainDao;

    public loginDto selectLoginInfo(loginDto loginDto) throws Exception {
    	return mainDao.selectLoginInfo(loginDto);
    }

    public int selectLoginChk(loginDto loginDto) throws Exception {
    	return mainDao.selectLoginChk(loginDto);
    }

    public List<loginMenuAuthDto> selectMenuAuth(loginDto loginDto) throws Exception {
    	return mainDao.selectMenuAuth(loginDto);
    }
}
