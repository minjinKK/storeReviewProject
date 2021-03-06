package project.com.model;

import java.util.Date;

public class ReviewVO {
	private int rnum;
	private int pnum;
	private String rtext;
	private int rtaste;
	private int rprice;
	private int rdistance;
	private int rcircul;
	private int rtotal;
	private String rWdate;
	private String memberid;
	private String pname;
	
	public String getrWdate() {
		return rWdate;
	}
	public void setrWdate(String rWdate) {
		this.rWdate = rWdate;
	}
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public int getRtaste() {
		return rtaste;
	}
	public void setRtaste(int rtaste) {
		this.rtaste = rtaste;
	}
	public int getRprice() {
		return rprice;
	}
	public void setRprice(int rprice) {
		this.rprice = rprice;
	}
	public int getRdistance() {
		return rdistance;
	}
	public void setRdistance(int rdistance) {
		this.rdistance = rdistance;
	}
	public int getRcircul() {
		return rcircul;
	}
	public void setRcircul(int rcircul) {
		this.rcircul = rcircul;
	}
	public int getRtotal() {
		return rtotal;
	}
	public void setRtotal(int rtotal) {
		this.rtotal = rtotal;
	}
	@Override
	public String toString() {
		return "ReviewVO [rnum=" + rnum + ", pnum=" + pnum + ", rtext=" + rtext + ", rtaste=" + rtaste + ", rprice="
				+ rprice + ", rdistance=" + rdistance + ", rcircul=" + rcircul + ", rtotal=" + rtotal + ", rWdate="
				+ rWdate + ", memberid=" + memberid + ", pname=" + pname + "]";
	}
	
	
	
}
