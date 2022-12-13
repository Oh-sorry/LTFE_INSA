package com.mcst.main.dao;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import com.mcst.dto.nameSearchDto;
import com.mcst.dto.pernInfoDto;

@Repository("commonDao")
public class commonDao extends EgovAbstractMapper {

    @SuppressWarnings("unchecked")
    public List<nameSearchDto> selectSearchName(nameSearchDto nameSearchDto) throws Exception {
    	return selectList("commonSql.selectSearchName", nameSearchDto);
    }

    public pernInfoDto selectPernInfo(String pernNo) throws Exception {
    	return selectOne("commonSql.selectPernInfo", pernNo);
    }

}
