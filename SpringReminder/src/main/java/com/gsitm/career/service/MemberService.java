package com.gsitm.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	MemberMapper mMemberMapper;

	/* 계정 생성 */
	public int memberInsert(MemberDTO member) throws Exception{
		return mMemberMapper.memberInsert(member);
	}

	/* 계정 검색 */
	public MemberDTO memberSearch(String id)throws Exception{
		return mMemberMapper.memberSearch(id);
	}
}
