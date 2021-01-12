package com.gsitm.career.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gsitm.career.dto.MemberDTO;

@Repository
@Mapper
public interface MemberMapper {
	/* 계정 생성 */
	public int memberInsert(MemberDTO member) throws Exception;

	/* 계정 검색 */
	public MemberDTO memberSearch(String userID)throws Exception;

}
