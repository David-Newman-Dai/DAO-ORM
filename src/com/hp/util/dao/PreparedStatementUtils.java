package com.hp.util.dao;

import java.sql.PreparedStatement;
import java.sql.Types;

import com.hp.util.BeanValueUtils;

public class PreparedStatementUtils {
	private PreparedStatementUtils() {
	}

	/**
	 * 设置指定序号的PreparedStatement的内容
	 * @param seq 序号
	 * @param pstmt PreparedStatement对象
	 * @param obj 要取得属性内容的对象
	 * @param attribute 属性的名称
	 */
	public static void setPreparedStatement(int seq, PreparedStatement pstmt, Object obj, String attribute) throws Exception {
		String type = obj.getClass().getDeclaredField(attribute).getType().getSimpleName(); // 取得属性类型
		if ("int".equals(type) || "Integer".equals(type)) {
			pstmt.setInt(seq, BeanValueUtils.getValue(obj, attribute, Integer.class));
		} else if ("double".equalsIgnoreCase(type)) {
			pstmt.setDouble(seq, BeanValueUtils.getValue(obj, attribute, Double.class));
		} else if ("String".equals(type)) {
			pstmt.setString(seq, BeanValueUtils.getValue(obj, attribute, String.class));
		} else if ("Date".equals(type)) { // java.util.Date
			pstmt.setDate(seq,
					new java.sql.Date(BeanValueUtils.getValue(obj, attribute, java.util.Date.class).getTime()));
		} else {
			pstmt.setNull(seq, Types.NULL); // 不知道的类型
		}
	}
}
