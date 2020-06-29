package com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}

	/*appCtx-LifeCycle.xml 파일에 initMethod , destoryMethod 설정되어있음(Bean 객체가 생성될 때와 소멸될 떄)*/
	private void initMethod() {
		System.out.println("initMethod");
	}
	
	private void destroyMethod() {
		System.out.println("destroyMethod");
	}
}
