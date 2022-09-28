package model;

public class Users {
	
	public int getUno() {
		return Uno;
	}
	public void setUno(int uno) {
		Uno = uno;
	}
	public String getUaccount() {
		return Uaccount;
	}
	public void setUaccount(String uaccount) {
		Uaccount = uaccount;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpassword() {
		return Upassword;
	}
	public void setUpassword(String upassword) {
		Upassword = upassword;
	}
	public int getUauthority() {
		return Uauthority;
	}
	public void setUauthority(int uauthority) {
		Uauthority = uauthority;
	}
	private int Uno;
	private String Uaccount;
	private String Uname;
	private String Upassword;
	private int Uauthority;
}
