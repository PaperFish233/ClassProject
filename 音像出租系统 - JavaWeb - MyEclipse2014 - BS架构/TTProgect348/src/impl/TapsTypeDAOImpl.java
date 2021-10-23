package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.TapsType;
import dao.TapsTypeDAO;
import dbc.DBConnection;

public class TapsTypeDAOImpl implements TapsTypeDAO {
	//五步走zaiDBC里面所以调用
		DBConnection dbc=new DBConnection();
	    Connection conn=dbc.getConnection();//驱动，连接
	    private PreparedStatement pstmt=null;
	    private ResultSet rs=null;
	    boolean flag=false;
		@Override
		public List<TapsType> FindAllTapsType() throws Exception {
			//查询全部
		List<TapsType> alltapstype=new ArrayList<TapsType>();
		try{
     String sql="select * from TapsType"; 
     pstmt=conn.prepareStatement(sql);
     rs=pstmt.executeQuery();
     while(rs.next()){
    	 TapsType tapstype=new TapsType();//打包
    	 tapstype.setTTno(rs.getInt("TTno"));
    	 tapstype.setTTTypename(rs.getString("TTTypename"));
    	 alltapstype.add(tapstype);
     }
    	 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbc.connClose();
		}
		return alltapstype;
	}
		@Override
		public boolean doDelete(int TTno) throws Exception {
			try{
				String sql="delete from TapsType where TTno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, TTno);
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
		public boolean doCreate(TapsType tapstype) throws Exception {
			try{
				String sql="Insert into TapsType values(?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, tapstype.getTTno());
				pstmt.setString(2, tapstype.getTTTypename());
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
		public boolean doUpdate(TapsType tapstype) throws Exception {
			try{
				String sql="update TapsType set TTTypename=? where TTno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(2, tapstype.getTTno());
				pstmt.setString(1, tapstype.getTTTypename());
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