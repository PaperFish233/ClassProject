package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	/*SQLServer 数据库连接字符串*/
	private static final  String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/*数据库版本  SQLEXPRESS   使用动态端口 TCPIP属性 —IPAll 动态端口号 */
	//private static final String URL = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:52768; DatabaseName=BMS";
	private static final  String URL="jdbc:sqlserver://localhost:1433;DatabaseName=TTaps";
	private static final String NAME="sa";
	private static final String PWD="sqlserver2008";

	/*MySQL5.5 数据库连接字符串*/
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL= "jdbc:mysql://localhost:3306/BMS";
	private static  final String NAME="root";
                private static  final String PWD="root";*/

	/*MySQL8.0 数据库连接字符串*/
	/*private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL= "jdbc:mysql://localhost:3306/BMS?useUnicode=true&amp;serverTimezone=GMT&amp;characterEncoding=UTF-8&amp;useSSL=false";
	private static  final String NAME="root";
                private static  final String PWD="root";*/

	private Connection conn=null;
	 /** 
     * @功能 创建数据库连接 
     * @返回值 connection型值 
     */     
	public  Connection  getConnection(){
		try{
			    Class.forName(DRIVER);
		    }
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("加载驱动程序失败。");
			}
	     try{
			   conn =DriverManager.getConnection(URL, NAME, PWD);
		}catch(Exception ex){
			   ex.printStackTrace();
			   System.out.println("获取连接对象失败。");
		}
		return conn;	
	}
	 /** 
     * @功能 关闭数据库连接
     */
	public void  connClose(){
		if(conn!=null)
		try {
			conn.close();
		} catch (Exception ex) {
			  ex.printStackTrace();
			  System.out.println("关闭连接对象失败。");
		}	
	}
	
}
