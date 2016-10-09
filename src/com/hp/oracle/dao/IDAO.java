package com.hp.oracle.dao;

import java.util.List;
import java.util.Set;

/**
 * 定义member数据表的数据层操作标准
 * @author mldn 
 */
public interface IDAO<K,V> {
	/**
	 * 保存member数据表中的数据
	 * @param vo 要保存数据的VO对象
	 * @return 保存成功返回true，否则返回false
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public boolean doCreate(V vo) throws Exception ;
	/**
	 * 进行member表数据的修改，本次修改是基于id的修改处理
	 * @param vo 要修改的全部数据
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public boolean doUpdate(V vo) throws Exception ;
	/**
	 * 数据的删除处理，会将所有要删除的数据保存在Set集合之中
	 * @param ids 所有要删除的ID编号
	 * @return 如果要删除的数量符合于最终的执行标准返回true，否则返回false
	 * @throws Exception  数据库未连接，或者数据库操作错误
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception ;
	/**
	 * 根据id查询出一个用户的完整信息
	 * @param id 要查询的用户id
	 * @return 如果数据找到则以VO类对象的形式返回，返回null
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public V findById(K id) throws Exception ;
	/**
	 * 查询数据表中的全部数据
	 * @return 会返回多个Member对象，将以List的集合形式返回。
	 * 如果表中没有数据则返回的List集合长度为0（size() == 0）
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public List<V> findAll() throws Exception ;
	/**
	 * 数据的分页显示处理
	 * @param currentPage 当前所在页
	 * @param lineSize 每页显示的数据行数
	 * @return 会返回多个Member对象，将以List的集合形式返回。
	 * 如果表中没有数据则返回的List集合长度为0（size() == 0）
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public List<V> findAllSplit(Integer currentPage,Integer lineSize) throws Exception ;
	/**
	 * 数据的分页查询显示处理
	 * @param column 需要进行查询的数据列
	 * @param keyWord 要查询的关键字，如果关键字为空字符串表示查询全部
	 * @param currentPage 当前所在页
	 * @param lineSize 每页显示的数据行数
	 * @return 会返回多个Member对象，将以List的集合形式返回。
	 * 如果表中没有数据则返回的List集合长度为0（size() == 0）
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public List<V> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception;
	/**
	 * 统计数据表中的全部数据量
	 * @return 使用COUNT()函数的统计结果
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public Long getAllCount() throws Exception ;
	/**
	 * 统计模糊查询的数据量
	 * @param column需要进行查询的数据列
	 * @param keyWord 要查询的关键字，如果关键字为空字符串表示查询全部
	 * @return 使用COUNT()函数的统计结果
	 * @throws Exception 数据库未连接，或者数据库操作错误
	 */
	public Long getAllCount(String column,String keyWord) throws Exception ;
}
