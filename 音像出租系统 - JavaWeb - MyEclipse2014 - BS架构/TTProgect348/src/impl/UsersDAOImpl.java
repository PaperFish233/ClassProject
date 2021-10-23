package impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Users;
import dao.UsersDAO;
import dbc.DBConnection;

public class UsersDAOImpl implements UsersDAO {
	DBConnection dbc=new DBConnection();
	Connection conn=dbc.getConnection();
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	boolean flag=false;
	@Override
	public boolean FindLogin(Users users) throws Exception {
		try{
		String sql="SELECT Uname,Uauthority FROM Users WHERE Uaccount=? AND Upassword=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,users.getUaccount());
		pstmt.setString(2,users.getUpassword());
		rs=pstmt.executeQuery();
		if(rs.next()){
			users.setUname(rs.getString("Uname"));
			users.setUauthority(rs.getInt("Uauthority"));
			flag=true;
		}
		rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
		dbc.connClose();	
		}
		
		return flag;
	}
	@Override
	public List<Users> FindAllUsers() throws Exception {
		//查询全部
	List<Users> allusers=new ArrayList<Users>();
	try{
 String sql="select * from Users"; 
 pstmt=conn.prepareStatement(sql);
 rs=pstmt.executeQuery();
 while(rs.next()){
	 Users users=new Users();//打包
	 users.setUno(rs.getInt("Uno"));
	 users.setUaccount(rs.getString("Uaccount"));
	 users.setUname(rs.getString("Uname")); 
	 users.setUpassword(rs.getString("Upassword")); 
	 users.setUauthority(rs.getInt("Uauthority")); 
	 allusers.add(users);
 }
	 
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		dbc.connClose();
	}
	return allusers;
}
	@Override
	public boolean doCreate(Users users) throws Exception {
		try{
			String sql="Insert into Users values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUno());
			pstmt.setString(2, users.getUaccount());
			pstmt.setString(3, users.getUname());
			pstmt.setString(4, users.getUpassword());
			pstmt.setInt(5, users.getUauthority());
			int i=pstmt.executeUpdate();
	    	if(i>0){ flag=true;}
			pstmt.close();
			}
			catch(Exception e)
			{ e.printStackTrace();}
			finally
			{
				dbc.connClose();
			}
			return flag;
		}
	@Override
	public boolean doDelete(int Uno) throws Exception {
		try{
			String sql="delete from Users where Uno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Uno);
			int i=pstmt.executeUpdate();
			if(i>0){
				flag=true;
			}
			pstmt.close();
		}catch(Exception e){e.printStackTrace();}
		finally{
			dbc.connClose();
		}	
		return flag;
	}
	@Override
	public boolean doUpdate(Users users) throws Exception {
		// TODO Auto-generated method stub
		try{
			String sql="update Users set Uaccount=?,Uname=?,Upassword=?,Uauthority=? where Uno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, users.getUaccount());
			pstmt.setString(2, users.getUname());
			pstmt.setString(3, users.getUpassword());
			pstmt.setInt(4, users.getUauthority());
			pstmt.setInt(5, users.getUno());
			int i=pstmt.executeUpdate();
	    	if(i>0){ flag=true;}
			pstmt.close();
			}
			catch(Exception e)
			{ e.printStackTrace();}
			finally
			{
				dbc.connClose();
			}
			return flag;
		}



}