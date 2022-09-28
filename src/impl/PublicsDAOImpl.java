package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Publics;
import dao.PublicsDAO;
import dbc.DBConnection;

public class PublicsDAOImpl implements PublicsDAO {
	//五步走zaiDBC里面所以调用
		DBConnection dbc=new DBConnection();
	    Connection conn=dbc.getConnection();//驱动，连接
	    private PreparedStatement pstmt=null;
	    private ResultSet rs=null;
	    boolean flag=false;
		@Override
		public List<Publics> FindAllPublics() throws Exception {
			//查询全部
		List<Publics> allpublics=new ArrayList<Publics>();
		try{
     String sql="select * from Publics"; 
     pstmt=conn.prepareStatement(sql);
     rs=pstmt.executeQuery();
     while(rs.next()){
    	 Publics publics=new Publics();//打包
    	 publics.setPno(rs.getInt("Pno"));
    	 publics.setPname(rs.getString("Pname"));
    	 publics.setPcontent(rs.getString("Pcontent")); 
    	 publics.setPtime(rs.getString("Ptime")); 
    	 allpublics.add(publics);
     }
    	 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.connClose();
		}
		return allpublics;
	}
		@Override
		public boolean doCreate(Publics publics) throws Exception {
			try{
				String sql="Insert into Publics values(?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, publics.getPno());
				pstmt.setString(2, publics.getPname());
				pstmt.setString(3, publics.getPcontent());
				pstmt.setString(4, publics.getPtime());
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
		public boolean doDelete(int Pno) throws Exception {
			try{
				String sql="delete from Publics where Pno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, Pno);
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
		public boolean doUpdate(Publics publics) throws Exception {
			try{
				String sql="update Publics set Pcontent=?,Pname=?,Ptime=? where Pno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, publics.getPcontent());
				pstmt.setString(2, publics.getPname());
				pstmt.setString(3, publics.getPtime());
				pstmt.setInt(4, publics.getPno());
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