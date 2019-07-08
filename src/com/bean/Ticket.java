/**
 * 
 */
package com.bean;

/**
 * @author zhifengfei
 *
 */
public class Ticket {
	private String ticketID; //主键
	private String Ctiy01; //始发地
	private String Ctiy02; //目的地
	private String EntTime; //出发日期
	private int ticketCount; //票数
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public String getCtiy01() {
		return Ctiy01;
	}
	public void setCtiy01(String ctiy01) {
		Ctiy01 = ctiy01;
	}
	public String getCtiy02() {
		return Ctiy02;
	}
	public void setCtiy02(String ctiy02) {
		Ctiy02 = ctiy02;
	}
	public String getEntTime() {
		return EntTime;
	}
	public void setEntTime(String entTime) {
		EntTime = entTime;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public Ticket() {
		super();
	}
	public Ticket(String ticketID, String ctiy01, String ctiy02,
			String entTime, int ticketCount) {
		super();
		this.ticketID = ticketID;
		Ctiy01 = ctiy01;
		Ctiy02 = ctiy02;
		EntTime = entTime;
		this.ticketCount = ticketCount;
	}
	
	
}
