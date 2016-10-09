package cn.mldn.util.dao.support;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.util.BeanValueUtils;
import cn.mldn.util.Resource;
import cn.mldn.util.dao.PreparedStatementUtils;

public class EditSupport {
	private Object vo ;	// 操作的VO对象
	private Map<Integer,String> columnsMap = new HashMap<Integer,String>() ;
	public EditSupport(Object vo) {
		this.vo = vo ;
	}
	public String createSQL() {
		StringBuffer buf = new StringBuffer() ;
		String idColumn = Resource.getId(this.vo.getClass().getName()) ;
		String tableName = this.vo.getClass().getSimpleName() ;
		buf.append(" UPDATE ").append(tableName).append(" SET ") ;
		int foot = 1 ;
		Field fields [] = this.vo.getClass().getDeclaredFields() ;
		for (int x = 0 ; x < fields.length ; x ++) {
			if (!idColumn.equals(fields[x].getName())) {	// 不是id列的才可以进行判断
				if (BeanValueUtils.getValue(this.vo, fields[x].getName(), fields[x].getType()) != null) {
					this.columnsMap.put(foot ++, fields[x].getName()) ;
					buf.append(fields[x].getName()).append("=?,") ;
				}
			}
		}
		buf.delete(buf.length() - 1, buf.length()) ;
		buf.append(" WHERE ").append(idColumn).append("=?") ;
		this.columnsMap.put(foot ++, idColumn) ;
		return buf.toString() ;
	} 
	public void setPreparedStatement(PreparedStatement pstmt) throws Exception {
		for (int x = 1 ; x <= this.columnsMap.size() ; x ++) {
			PreparedStatementUtils.setPreparedStatement(x, pstmt, this.vo, this.columnsMap.get(x));
		}
	}
}
