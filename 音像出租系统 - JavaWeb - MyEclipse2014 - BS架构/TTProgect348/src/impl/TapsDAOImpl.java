package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Taps;
import dao.TapsDAO;
import dbc.DBConnection;

public class TapsDAOImpl implements TapsDAO {
	//五步走zaiDBC里面所以调用
		DBConnection dbc=new DBConnection();
	    Connection conn=dbc.getConnection();//驱动，连接
	    private PreparedStatement pstmt=null;
	    private ResultSet rs=null;
	    boolean flag=false;
		@Override
		public List<Taps> FindAllTaps() throws Exception {
			//查询全部
		List<Taps> alltaps=new ArrayList<Taps>();
		try{
     String sql="select Tno,Tname,TTTypename,Tstate from Taps LEFT join TapsType on Taps.TTypeno=TapsType.TTno"; 
     pstmt=conn.prepareStatement(sql);
     rs=pstmt.executeQuery();
     while(rs.next()){
    	 Taps taps=new Taps();//打包
    	 taps.setTno(rs.getInt("Tno"));
    	 taps.setTname(rs.getString("Tname")); 
    	 taps.setTTTypename(rs.getString("TTTypename")); 
    	 taps.setTstate(rs.getString("Tstate")); 
    	 alltaps.add(taps);
     }
    	 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.connClose();
		}
		return alltaps;
	}
		@Override
		public boolean doDelete(int Tno) throws Exception {
			try{
				String sql="delete from Taps where Tno=?";
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
		public boolean doCreate(Taps taps) throws Exception {
			try{
				 String sql1="select TTno from TapsType where TTTypename=?";
				   pstmt=conn.prepareStatement(sql1);
				   pstmt.setString(1,taps.getTTTo());
			       rs=pstmt.executeQuery();

				   while(rs.next()){
			     
				   String sql="insert into Taps values(?,?,?,?)";
				   pstmt=conn.prepareStatement(sql);
				   pstmt.setInt(1,taps.getTno());
				   pstmt.setString(2,taps.getTname());
				   pstmt.setInt(3,rs.getInt("TTno"));
				   pstmt.setString(4,taps.getTstate());
				   
				   int i=pstmt.executeUpdate();
				   if(i>0){
					   flag=true;
				   }
				   }
				   
				   pstmt.close();
		}catch(Exception e){e.printStackTrace();}
		finally{
				  dbc.connClose();
		}
					return flag;
		}
		@Override
		public boolean doUpdate(Taps taps) throws Exception {
			try{
				 String sql1="select TTno from TapsType where TTTypename=?";
				   pstmt=conn.prepareStatement(sql1);
				   pstmt.setString(1,taps.getTTTo());
			       rs=pstmt.executeQuery();

				   while(rs.next()){
			     
				   String sql="update Taps set Tname=?,TTypeno=?,Tstate=? where Tno=?";
				   pstmt=conn.prepareStatement(sql);
				   pstmt.setString(1,taps.getTname());
				   pstmt.setInt(2,rs.getInt("TTno"));
				   pstmt.setString(3,taps.getTstate());
				   pstmt.setInt(4,taps.getTno());

				   int i=pstmt.executeUpdate();
				   if(i>0){
					   flag=true;
				   }
				   }
				   
				   pstmt.close();
		}catch(Exception e){e.printStackTrace();}
		finally{
				  dbc.connClose();
		}
					return flag;
		}
}