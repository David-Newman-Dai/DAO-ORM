package com.hp.util.dao;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.hp.util.BeanValueUtils;

public class ResultSetToVOUtil {
	private ResultSetToVOUtil() {
	}
	public static Object converteStat(PreparedStatement pstmt) throws Exception {
		ResultSet rs = pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getString(1) ;
		}
		return "0" ;
	}
 
	/**
	 * 将ResultSet中的内容进行一个转换处理
	 * 
	 * @param pstmt
	 *            包含有元数据以及可以执行查询的处理对象
	 * @param cls
	 *            要转换的VO对象
	 * @return
	 */
	public static <T> T convertSingle(PreparedStatement pstmt, Class<T> cls) throws Exception {
		ResultSetMetaData rsmd = pstmt.getMetaData();
		ResultSet rs = pstmt.executeQuery(); // 发出查询命令
		T t = null;
		if (rs.next()) { // 有数据
			t = cls.newInstance();
			for (int x = 1; x <= rsmd.getColumnCount(); x++) {
				try {
					Field field = cls.getDeclaredField(rsmd.getColumnLabel(x).toLowerCase());
					String type = field.getType().getSimpleName();
					if ("String".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getString(rsmd.getColumnLabel(x)));
					} else if ("int".equals(type) || "Integer".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getInt(rsmd.getColumnLabel(x)));
					} else if ("double".equals(type) || "Double".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getDouble(rsmd.getColumnLabel(x)));
					} else if ("Date".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getDate(rsmd.getColumnLabel(x)));
					}
				} catch (Exception e) {
				}
			}
		}
		return t;
	}

	public static <T> List<T> convert(PreparedStatement pstmt, Class<T> cls) throws Exception {
		ResultSetMetaData rsmd = pstmt.getMetaData();
		ResultSet rs = pstmt.executeQuery(); // 发出查询命令
		List<T> all = new ArrayList<T>();
		while (rs.next()) { // 有数据
			T t = cls.newInstance();
			for (int x = 1; x <= rsmd.getColumnCount(); x++) {
				try {
					Field field = cls.getDeclaredField(rsmd.getColumnLabel(x).toLowerCase());
					String type = field.getType().getSimpleName();
					if ("String".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getString(rsmd.getColumnLabel(x)));
					} else if ("int".equals(type) || "Integer".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getInt(rsmd.getColumnLabel(x)));
					} else if ("double".equals(type) || "Double".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getDouble(rsmd.getColumnLabel(x)));
					} else if ("Date".equals(type)) {
						BeanValueUtils.setValue(t, rsmd.getColumnLabel(x).toLowerCase(),
								rs.getDate(rsmd.getColumnLabel(x)));
					}
				} catch (Exception e) {
				}
			}
			all.add(t);
		}
		return all;
	}
}
