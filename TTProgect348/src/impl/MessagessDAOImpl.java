package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Messagess;
import dao.MessagessDAO;
import dbc.DBConnection;

public class MessagessDAOImpl implements MessagessDAO {
	//五步走zaiDBC里面所以调用
		DBConnection dbc=new DBConnection();
	    Connection conn=dbc.getConnection();//驱动，连接
	    private PreparedStatement pstmt=null;
	    private ResultSet rs=null;
	    boolean flag=false;
		@Override
		public List<Messagess> FindAllMessagess() throws Exception {
			//查询全部
		List<Messagess> allpublics=new ArrayList<Messagess>();
		try{
     String sql="select * from Messagess"; 
     pstmt=conn.prepareStatement(sql);
     rs=pstmt.executeQuery();
     while(rs.next()){
    	 Messagess messagess=new Messagess();//打包
    	 messagess.setMno(rs.getInt("Mno"));
    	 messagess.setMcontent(rs.getString("Mcontent")); 
    	 messagess.setMtime(rs.getString("Mtime")); 
    	 allpublics.add(messagess);
     }
    	 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.connClose();
		}
		return allpublics;
	}
		@Override
		public boolean doDelete(int Mno) throws Exception {
			try{
				String sql="delete from Messagess where Mno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, Mno);
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
		public boolean doCreate(Messagess messagess) throws Exception {
			try{
				String sql="Insert into Messagess values(?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, messagess.getMno());
				pstmt.setString(2, messagess.getMcontent());
				pstmt.setString(3, messagess.getMtime());
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
		public boolean doUpdate(Messagess messagess) throws Exception {
			// TODO Auto-generated method stub
			try{
				String sql="update Messagess set Mcontent=?,Mtime=? where Mno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, messagess.getMcontent());
				pstmt.setString(2, messagess.getMtime());
				pstmt.setInt(3, messagess.getMno());

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