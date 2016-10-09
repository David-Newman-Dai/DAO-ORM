package cn.mldn.util.dao.support;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.Resource;

public class RemoveSupport {
	private Map<Integer,Object> valueMap = new HashMap<Integer,Object>() ;
	/**
	 * 为删除语句之中的PreparedStatement对象设置内容
	 * @param pstmt
	 * @param type
	 */
	public void setPreparedStatement(PreparedStatement pstmt,String type) throws Exception {
		for (int x = 1 ; x <= this.valueMap.size() ; x ++) {
			if ("String".equals(type)) {
				pstmt.setString(x, this.valueMap.get(x).toString());
			} else if ("Integer".equals(type)) {
				pstmt.setInt(x, Integer.parseInt(this.valueMap.get(x).toString()));
			}
		} 
	}
	/**
	 * 创建要删除的SQL语句
	 * @param ids 所有的ID数据
	 * @param cls VO类型
	 * @return
	 */
	public <T> String createSQL(Set<?> ids,Class<T> cls) {
		StringBuffer buf = new StringBuffer() ;
		String tableName = cls.getSimpleName() ;
		String idColumn = Resource.getId(cls.getName()) ;
		buf.append("DELETE FROM ").append(tableName).append(" WHERE ").append(idColumn).append(" IN (") ;
		Iterator<?> iter = ids.iterator() ;
		int foot = 1 ;
		while (iter.hasNext()) {
			buf.append("?,") ;
			this.valueMap.put(foot ++, iter.next()) ;
		}
		buf.delete(buf.length() - 1, buf.length()) ;
		buf.append(")") ;
		return buf.toString() ;
	}
}
