package cn.mldn.util.dao.support;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.util.Resource;
import cn.mldn.util.dao.PreparedStatementUtils;

/**
 * 此类主要完善增加操作的SQL语句创建、动态PreparedStatement内容设置、更新执行
 * @author mldn
 */
public class CreateSupport {
	private Object vo ;
	public CreateSupport(Object vo) {
		this.vo = vo ;
	}
	// 定义序号以及列名称的关系
	private Map<Integer,String> columnsMap = new HashMap<Integer,String>() ;
	public void setPreparedStatement(PreparedStatement pstmt) throws Exception {
		for (int x = 1 ; x <= columnsMap.size() ; x ++) {
			PreparedStatementUtils.setPreparedStatement(x, pstmt, this.vo, this.columnsMap.get(x));
		}
	}
	/**
	 * 创建增加数据的SQL语句
	 * @param vo
	 * @return 复合于当前VO类的SQL语句
	 */
	public String createSQL() {
		int foot = 1 ;
		StringBuffer buf = new StringBuffer() ;
		StringBuffer bufHead = new StringBuffer() ;
		StringBuffer bufTail = new StringBuffer() ;
		String tableName = this.vo.getClass().getSimpleName() ;	// 取得类名称，就是表名称
		String idColumn = Resource.getId(vo.getClass().getName()) ;	// 取得主键
		buf.append(" INSERT INTO ").append(tableName).append("(") ;
		bufHead.append(idColumn).append(",") ;	// 主键列名称
		bufTail.append("?").append(",") ;	// 追加主键列的“?”
		this.columnsMap.put(foot ++,idColumn) ;	// 保存对应关系
		// 随后需要取出所有的其它字段的对应关系，但是这些关系里面不应该再包含有主键列
		Field voFields [] = this.vo.getClass().getDeclaredFields() ;
		// 依次将内容保存到集合里面，同时生成SQL语句
		for (int x = 0; x < voFields.length; x++) {
			if (!idColumn.equals(voFields[x].getName())) {	// 属性不是主键列
				bufHead.append(voFields[x].getName()).append(",") ;
				bufTail.append("?").append(",") ;
				this.columnsMap.put(foot ++,voFields[x].getName()) ;
			}
		}
		// 实现最后的SQL拼凑，首先删除最后的“,”
		bufHead.delete(bufHead.length() - 1, bufHead.length()) ;
		bufTail.delete(bufTail.length() - 1, bufTail.length()) ;
		buf.append(bufHead).append(") VALUES (").append(bufTail).append(")") ;
		return buf.toString() ;
	} 
}
