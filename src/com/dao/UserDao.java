/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.util.MySqlManager;

/**
 * @author zhifengfei
 *
 */
public class UserDao {
	// 注册新用户
	public static int register(User user) {
		int rowCount = 0;
		String sql = "insert into user values(?,?,?,?);";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, null);
		}
		return rowCount;
	}

	// 查询单个用户
	public static User query(String userID) {
		User user = null;
		String sql = "select * from user where userID = ?";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserID(rs.getString("userID"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, rs);
		}
		return user;
	}
	
	//更新用户.....待修改中
	public static int update(User user) {
		int i = 0;
		String sql = "update user set password = ?, phone = ?, email = ? where userID = ?";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUserID());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, null);
		}
		return i;
	}
}
