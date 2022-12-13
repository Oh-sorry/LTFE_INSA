package com.mcst.hr100000.service;

import java.util.Map;

import com.mcst.dto.db.hpa100tDto;

/**
 * 게시물 관리를 위한 서비스 인터페이스  클래스
 * @author 공통 서비스 개발팀 이삼섭
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
public interface HrListService {

	/**
	 * 조건에 맞는 게시물 목록을 조회 한다.
	 * @return
	 *
	 * @param boardVO
	 * @param attrbFlag
	 * @exception Exception Exception
	 */
	public Map<String, Object> HrselectList(hpa100tDto boardVO) throws Exception;


}