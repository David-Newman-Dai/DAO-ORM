package com.hp.oracle.test.junit;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.hp.oracle.factory.ServiceFactory;
import com.hp.oracle.service.IMemberService;
import com.hp.oracle.service.impl.MemberServiceImpl;
import com.hp.oracle.vo.Member;

import junit.framework.TestCase;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IMemberServiceTest { 
	private static String mid ;
	private static String phone ;
	static {	// 静态块
		Random rand = new Random() ;
		int temp = rand.nextInt(1000) ;
		mid = "测试ID - " + temp ;
		phone = "测试PHONE - " + temp ;
	}
	@Test
	public void test1Add() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		Member mem = new Member() ;
		mem.setMid(mid);
		mem.setPhone(phone);
		mem.setAge(10);
		mem.setBirthday(new Date());
		mem.setName("啊黄啊黄");
		mem.setNote("不是人");
		try {
			TestCase.assertTrue(service.add(mem));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2Edit() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		Member mem = new Member() ;
		mem.setMid("测试ID - 197");
		mem.setPhone(phone);
		mem.setAge(300);
		//mem.setBirthday(new Date());
		//mem.setName("不黄");
		mem.setNote("cai guai");
		try {
			TestCase.assertTrue(service.edit(mem));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test7Remove() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		try {
			Set<String> set = new HashSet<String>() ;
			set.add("测试ID - 637") ;
			TestCase.assertTrue(service.remove(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3Get() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		try {
			Object obj = service.get("测试ID - 197") ;
			System.out.println(obj);
			TestCase.assertNotNull(service.get("测试ID - 197"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test4List() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		try {
			List<Member> all = service.list() ;
			System.out.println(all);
			TestCase.assertTrue(all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5ListIntInt() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		try {
			Map<String,Object> map = service.list(1,10) ;
			long count = (Long) map.get("memberCount") ;
			System.out.println(count);
			List<Member> all = (List<Member>) map.get("allMembers") ;
			TestCase.assertTrue(count > 0 && all.size() > 0	);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test6ListStringStringIntInt() {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class) ;
		try {
			Map<String,Object> map = service.list("name","黄",1,10) ;
			long count = (Long) map.get("memberCount") ;
			System.out.println("   *  * ** " + count);
			List<Member> all = (List<Member>) map.get("allMembers") ;
			TestCase.assertTrue(count > 0 && all.size() > 0	);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
