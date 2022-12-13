package com.mcst.main.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.nameSearchDto;
import com.mcst.dto.pernInfoDto;
import com.mcst.main.dao.commonDao;
import com.mcst.main.service.commonService;

@Service("commonService")
public class commonServiceImpl extends EgovAbstractServiceImpl implements commonService {

    @Resource(name = "commonDao")
    private commonDao commonDao;

    public List<nameSearchDto> selectSearchName(nameSearchDto nameSearchDto) throws Exception {
    	return commonDao.selectSearchName(nameSearchDto);
    }

    public pernInfoDto selectPernInfo(String pernNo) throws Exception {
    	return commonDao.selectPernInfo(pernNo);
    }
}
