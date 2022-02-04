package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("memverService 에서 select 진");
		return memberDAO.selectOne(vo);
	}
}
