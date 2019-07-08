/**
 * 
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhifengfei 用来连接和关闭数据库连接
 */
public class MySqlManager {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取Connection
	public static Connection getConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/flightreservation";
		try {
			con = DriverManager.getConnection(url, "root", "6003");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 关闭连接
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
