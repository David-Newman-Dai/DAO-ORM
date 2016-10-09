package com.hp.oracle.test.main;

import java.util.Date;
import java.util.Random;

import com.hp.oracle.factory.ServiceFactory;
import com.hp.oracle.service.IMemberService;
import com.hp.oracle.service.impl.MemberServiceImpl;
import com.hp.oracle.vo.Member;

public class TestMemberAdd {
	public static void main(String[] args) throws Exception {
		Random rand = new Random() ;
		Member mem = new Member();
		mem.setMid("dahuang - " + rand.nextInt(1000));
		mem.setPhone("110 - " + rand.nextInt(1000));
		mem.setAge(-20);
		mem.setName("黄司令");
		mem.setBirthday(new Date());
		mem.setNote("不是什么好人的烂人。");
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class);
		System.out.println(service.add(mem));
	}
}
