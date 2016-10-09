package com.hp.oracle.test.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hp.oracle.factory.ServiceFactory;
import com.hp.oracle.service.IMemberService;
import com.hp.oracle.service.impl.MemberServiceImpl;
import com.hp.oracle.vo.Member;

public class TestMemberList {
	public static void main(String[] args) throws Exception {
		IMemberService service = ServiceFactory.getInstance(MemberServiceImpl.class);
		Map<String, Object> map = service.list("name", "黄", 1, 10);
		long count = (Long) map.get("memberCount") ;
		System.out.println("总数据量：" + count);
		List<Member> all = (List<Member>) map.get("allMembers") ;
		Iterator<Member> iter = all.iterator() ;
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
