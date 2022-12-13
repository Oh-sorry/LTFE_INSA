package com.mcst.hr100000.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import com.mcst.dto.db.hpa100tDto;
import com.mcst.hr100000.dao.HrListDao;
import com.mcst.hr100000.service.HrListService;

/**
 * 게시물 관리를 위한 서비스 구현 클래스
 * @author 공통 서비스 개발팀 한성곤
 * @since 2009.03.19
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.19  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Service("hrListService")
public class HrListServiceImpl extends EgovAbstractServiceImpl implements HrListService {

    @Resource(name = "HrListDao")
    private HrListDao hrListDao;

	/**
     * 조건에 맞는 게시물 목록을 조회 한다.
     *
     * @see egovframework.let.cop.bbs.brd.service.EgovBBSManageService#selectBoardArticles(egovframework.let.cop.bbs.brd.service.BoardVO)
     */
    public Map<String, Object> HrselectList(hpa100tDto hpa100tDto)throws Exception {

    	List<hpa100tDto> list = hrListDao.selectHrList(hpa100tDto);

    	Map<String, Object> map = new HashMap<String, Object>();

    	map.put("resultList", list);

    	return map;
    }

}
