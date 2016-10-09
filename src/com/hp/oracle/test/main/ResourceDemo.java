package com.hp.oracle.test.main;

import com.hp.oracle.vo.Member;
import com.hp.util.Resource;

public class ResourceDemo {
	public static void main(String[] args) {
		System.out.println(Resource.getId(Member.class.getName()));
	}
}
