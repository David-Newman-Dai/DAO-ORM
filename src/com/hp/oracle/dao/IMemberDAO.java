package com.hp.oracle.dao;

import com.hp.oracle.vo.Member;

/**
 * 定义member数据表的数据层操作标准
 * @author mldn
 */
public interface IMemberDAO extends IDAO<String,Member> {
	/**
	 * 根据电话查找用户信息是否存在
	 * @param phone 要查找的电话
	 * @return 查找到数据返回Member，否则返回null
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public Member findByPhone(String phone) throws Exception ;
}
