package cn.mldn.oracle.test.main;

import java.util.Date;
import java.util.Random;

import cn.mldn.oracle.factory.ServiceFactory;
import cn.mldn.oracle.service.IMemberService;
import cn.mldn.oracle.service.impl.MemberServiceImpl;
import cn.mldn.oracle.vo.Member;

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
