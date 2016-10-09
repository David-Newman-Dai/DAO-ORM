package cn.mldn.util.dao.support;

import java.sql.PreparedStatement;
import java.util.Date;

public class FindSupport {
	public <V> void setPreparedStatement(PreparedStatement pstmt,V value) throws Exception {
		String type = value.getClass().getSimpleName() ;
		if ("String".equals(type)) {
			pstmt.setString(1, value.toString());
		} else if ("int".equals(type) || "Integer".equals(type)) {
			pstmt.setInt(1, Integer.parseInt(value.toString()));
		}
	}
	public void setPreparedStatement(PreparedStatement pstmt,Object ...args) throws Exception {
		for (int x = 0 ; x < args.length ; x ++) {
			String type = args[x].getClass().getSimpleName();
			if ("String".equals(type)) {
				pstmt.setString(x + 1, args[x].toString());
			} else if ("int".equals(type) || "Integer".equals(type)) {
				pstmt.setInt(x + 1, Integer.parseInt(args[x].toString()));
			}  else if ("double".equals(type) || "Double".equals(type)) {
				pstmt.setDouble(x + 1, Double.parseDouble(args[x].toString()));
			}  else if ("Date".equals(type)) {
				Date date = (Date) args[x] ;
				pstmt.setDate(x + 1, new java.sql.Date(date.getTime()));
			}
		}
	}
}
