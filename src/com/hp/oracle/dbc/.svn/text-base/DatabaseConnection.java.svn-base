package cn.mldn.oracle.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.crypto.Data;

/**
 * 本类负责Oracle数据库的连接与打开操作处理
 * 一旦实例化本类对象，将自动取得相对应的数据库连接
 * @author mldn
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() ;
	private DatabaseConnection() {}
	/**
	 * 取得一个Connection接口对象
	 * @return Connection对象
	 */
	private static Connection rebuildConnection() {
		try {
			Class.forName(DBDRIVER) ;
			return DriverManager.getConnection(DBURL, DBUSER, PASSWORD) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	/**
	 * 取得一个Connection对象，是通过ThreadLocal类对象取得，每一个线程存放自己的对象
	 * @return 返回一个连接对象
	 */
	public static Connection getConnection() {
		Connection conn = threadLocal.get() ;	// 取得一个Connection
		if (conn == null) {	// 表示现在还没有创建Connection，ThreadLocal没有保存数据
			conn = rebuildConnection() ;	// 建立新的数据库连接对象
			threadLocal.set(conn);	// 保存对象
		}
		return conn ;
	}
	/**
	 * 关闭数据库连接
	 */
	public static void close() {
		Connection conn = threadLocal.get() ;	// 取得保存的对象
		if (conn != null) {	// 现在还有连接对象
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadLocal.remove(); // 清空ThreadLocal原本的内容
		}
	}

}
