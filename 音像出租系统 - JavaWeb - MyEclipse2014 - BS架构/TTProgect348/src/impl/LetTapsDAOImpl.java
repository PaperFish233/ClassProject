package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import model.LetTaps;
import model.Publics;
import dao.LetTapsDAO;
import dbc.DBConnection;

public class LetTapsDAOImpl implements LetTapsDAO {
	//五步走zaiDBC里面所以调用
	DBConnection dbc=new DBConnection();
    Connection conn=dbc.getConnection();//驱动，连接
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    boolean flag=false;

	@Override
	public boolean doLetTaps(LetTaps lettaps) throws Exception {
		try{
			   String sql="insert into LetTaps values(?,?,?,?,?)";
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setInt(1,lettaps.getLno());
			   pstmt.setString(2,lettaps.getLname());
			   pstmt.setString(3,lettaps.getLTaps());
			   pstmt.setString(4,lettaps.getLTTypename());
			   pstmt.setString(5,lettaps.getLTime());
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
	public LetTaps FindTapsById(int Lno) throws Exception {
	     LetTaps lettaps =new LetTaps();
	      try{
	    	  String sql ="select Tno,Tname,TTTypename from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno where Tno=?";
	    	  pstmt=conn.prepareStatement(sql);
	    	  pstmt.setInt(1,Lno);
	    	  rs=pstmt.executeQuery();
	    	  while(rs.next()){
	    		  lettaps.setLno(rs.getInt("Tno"));
	    		  lettaps.setLTaps(rs.getString("Tname"));
	    		  lettaps.setLTTypename(rs.getString("TTTypename"));
	    	  }
	      }
	    	  catch(Exception e)
	  		{
	  			e.printStackTrace();
	  		}
	  		finally{ 
	  			dbc.connClose();
	  			}
	      return lettaps;
	  }

	@Override
	public List<LetTaps> FindAllLetTaps() throws Exception {
		//查询全部
	List<LetTaps> alllettaps=new ArrayList<LetTaps>();
	try{
 String sql="select * from LetTaps"; 
 pstmt=conn.prepareStatement(sql);
 rs=pstmt.executeQuery();
 while(rs.next()){
	 LetTaps lettaps=new LetTaps();//打包
	 lettaps.setLno(rs.getInt("Lno"));
	 lettaps.setLname(rs.getString("Lname")); 
	 lettaps.setLTaps(rs.getString("LTaps")); 
	 lettaps.setLTTypename(rs.getString("LTTypename")); 
	 lettaps.setLTime(rs.getString("LTime")); 
	 alllettaps.add(lettaps);
 }
	 
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		dbc.connClose();
	}
	return alllettaps;
}

	@Override
	public boolean doDelete(int Tno) throws Exception {
		try{
			String sql="update Taps set Tstate='不在库' where Tno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Tno);
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
	public boolean doDelete1(int Lno) throws Exception {
		try{
			String sql="delete from LetTaps where Lno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Lno);
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
	public boolean doUpdate(LetTaps lettaps) throws Exception {
		try{
			String sql="update LetTaps set Lname=?,LTaps=?,LTTypename=?,LTime=? where Lno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lettaps.getLname());
			pstmt.setString(2, lettaps.getLTaps());
			pstmt.setString(3, lettaps.getLTTypename());
			pstmt.setString(4, lettaps.getLTime());
			pstmt.setInt(5, lettaps.getLno());
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
	public boolean doUp(int Tno) throws Exception {
		try{
			String sql="update Taps set Tstate='在库' where Tno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Tno);
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
	public boolean doCreate(LetTaps lettaps) throws Exception {
		try{
			String sql="Insert into LetTaps values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			   pstmt.setInt(1,lettaps.getLno());
			   pstmt.setString(2,lettaps.getLname());
			   pstmt.setString(3,lettaps.getLTaps());
			   pstmt.setString(4,lettaps.getLTTypename());
			   pstmt.setString(5,lettaps.getLTime());
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
