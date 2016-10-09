package com.hp.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Set;

import com.hp.oracle.dbc.DatabaseConnection;
import com.hp.util.dao.support.CreateSupport;
import com.hp.util.dao.support.EditSupport;
import com.hp.util.dao.support.FindSupport;
import com.hp.util.dao.support.RemoveSupport;

/**
 * 该类的主要功能是提供常规的数据层实现子类的操作方法支持
 * @author mldn
 */
public abstract class AbstractDAO {
	protected Connection conn ;
	protected PreparedStatement pstmt ;
	public AbstractDAO() {
		this.conn = DatabaseConnection.getConnection() ;
	}
	/**
	 * 实现数据的增加处理操作
	 * @param vo 要进行增加数据处理的VO类对象
	 * @return 增加成功返回true，否则返回false
	 */
	public boolean createSupport(Object vo) throws Exception {
		CreateSupport support = new CreateSupport(vo) ;
		this.pstmt = this.conn.prepareStatement(support.createSQL()) ;
		support.setPreparedStatement(pstmt);
		return pstmt.executeUpdate() > 0 ; 
	}
	public <T> boolean removeSupport(Set<?> ids,Class<T> cls) throws Exception {
		RemoveSupport support = new RemoveSupport() ;
		String idType = ids.toArray()[0].getClass().getSimpleName();
		this.pstmt = this.conn.prepareStatement(support.createSQL( ids, cls)) ;
		support.setPreparedStatement(this.pstmt,idType);
		return this.pstmt.executeUpdate() == ids.size() ;
	}
	/**
	 * 对数据的查询进行控制
	 * @param sql 要执行的根据ID查询的SQL语句
	 * @param value 要查询的id数据
	 * @param cls 要处理的VO类型
	 * @return 查询到数据则将ResultSet的内容自动转换为VO对象返回
	 * @throws Exception
	 */
	public <T,V> T findByIdSupport(String sql,V value,Class<T> cls) throws Exception {
		FindSupport support = new FindSupport() ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		support.setPreparedStatement(this.pstmt, value); 
		return ResultSetToVOUtil.convertSingle(this.pstmt, cls) ; 
	} 
	public <T> T getSupport(String sql,Class<T> cls,Object ...args) throws Exception {
		this.pstmt = this.conn.prepareStatement(sql) ;
		if (args.length > 0 ) {
			FindSupport support = new FindSupport() ;
			support.setPreparedStatement(this.pstmt, args);
		}
		Object val = ResultSetToVOUtil.converteStat(this.pstmt) ;
		if ("Long".equalsIgnoreCase(cls.getSimpleName())) {
			val = Long.parseLong(val.toString()) ;
		} else if ("int".equals(cls.getSimpleName()) || "Integer".equals(cls.getSimpleName())) {
			val = Integer.parseInt(val.toString()) ;
		}
		return (T) val  ;
	}
	/**
	 * 这个方法将负责查询全部以及模糊或者是分页查询的整体控制
	 * @param sql 要执行的SQL语句
	 * @param args 表示参数
	 * @return
	 */
	public <T> List<T> findAllSupport(String sql, Class<T> cls, Object... args) throws Exception {
		this.pstmt = this.conn.prepareStatement(sql) ;
		if (args.length > 0) {	// 此处不需要设置任何的参数
			FindSupport support = new FindSupport() ;
			support.setPreparedStatement(this.pstmt, args);
		}
		return ResultSetToVOUtil.convert(this.pstmt, cls) ;
	}
	/**
	 * 实现数据的修改处理操作
	 * @param vo 要修改的数据，此数据之中一定要包含有id
	 * @return
	 */
	public boolean updateSupport(Object vo) throws Exception {
		EditSupport support = new EditSupport(vo) ;
		this.pstmt = this.conn.prepareStatement(support.createSQL()) ;
		support.setPreparedStatement(pstmt);
		return this.pstmt.executeUpdate() > 0 ;
	} 
}
