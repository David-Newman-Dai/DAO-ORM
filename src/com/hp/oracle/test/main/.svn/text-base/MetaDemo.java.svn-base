package cn.mldn.oracle.test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MetaDemo {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER) ;
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD) ;
		String sql = "SELECT mid,name,age,birthday,note FROM member" ;
		PreparedStatement pstmt = conn.prepareStatement(sql) ;
		ResultSetMetaData rsmd = pstmt.getMetaData() ;
		System.out.println(rsmd.getColumnLabel(1) + " = " + rsmd.getColumnTypeName(1));
		System.out.println(rsmd.getColumnLabel(2) + " = " + rsmd.getColumnTypeName(2));
		System.out.println(rsmd.getColumnLabel(3) + " = " + rsmd.getColumnTypeName(3));
		System.out.println(rsmd.getColumnLabel(4) + " = " + rsmd.getColumnTypeName(4));
		System.out.println(rsmd.getColumnLabel(5) + " = " + rsmd.getColumnTypeName(5));
		ResultSet rs = pstmt.executeQuery() ;
		while (rs.next()) {} 
		conn.close();  
	}
}
