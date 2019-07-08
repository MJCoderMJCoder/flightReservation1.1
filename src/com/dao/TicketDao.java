package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Ticket;
import com.util.MySqlManager;

public class TicketDao {
	
	//添加机票
	public static int insert(Ticket ticket){
		int i = 0;
		String sql = "insert into ticket values(?,?,?,?,?);";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getTicketID());
			ps.setString(2, ticket.getCtiy01());
			ps.setString(3, ticket.getCtiy02());
			ps.setString(4, ticket.getEntTime());
			ps.setInt(5, ticket.getTicketCount());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, null);
		}
		return i;
	}
	
	//查询机票
	public static List<Ticket> select(Ticket ticket){
		String sql = "select * from ticket where Ctiy01 like ?, Ctiy02 like ?, EntTime like?";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getCtiy01());
			ps.setString(2, ticket.getCtiy02());
			ps.setString(3, ticket.getEntTime());
			rs = ps.executeQuery();
			while (rs.next()){
				String ticketID = rs.getString("ticketID");
				String Ctiy01 = rs.getString("Ctiy01");
				String Ctiy02 = rs.getString("Ctiy02");
				String EntTime = rs.getString("EntTime");
				int ticketCount = rs.getInt("ticketCount");
				Ticket ticket2 = new Ticket(ticketID, Ctiy01, Ctiy02, EntTime, ticketCount);
				tickets.add(ticket2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, null);
		}
		return tickets;
	}
	
	//更新机票
	public static int update(Ticket ticket){
		int i = 0;
		String sql = "update ticket set ticketCount=? where ticketID = ?;";
		Connection con = MySqlManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTicketCount());
			ps.setString(2, ticket.getTicketID());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlManager.close(con, ps, null);
		}
		return i;
	}
}
