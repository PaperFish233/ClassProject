package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	/*SQLServer ���ݿ������ַ���*/
	private static final  String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/*���ݿ�汾  SQLEXPRESS   ʹ�ö�̬�˿� TCPIP���� ��IPAll ��̬�˿ں� */
	//private static final String URL = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:52768; DatabaseName=BMS";
	private static final  String URL="jdbc:sqlserver://localhost:1433;DatabaseName=TTaps";
	private static final String NAME="sa";
	private static final String PWD="sqlserver2008";

	/*MySQL5.5 ���ݿ������ַ���*/
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL= "jdbc:mysql://localhost:3306/BMS";
	private static  final String NAME="root";
                private static  final String PWD="root";*/

	/*MySQL8.0 ���ݿ������ַ���*/
	/*private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL= "jdbc:mysql://localhost:3306/BMS?useUnicode=true&amp;serverTimezone=GMT&amp;characterEncoding=UTF-8&amp;useSSL=false";
	private static  final String NAME="root";
                private static  final String PWD="root";*/

	private Connection conn=null;
	 /** 
     * @���� �������ݿ����� 
     * @����ֵ connection��ֵ 
     */     
	public  Connection  getConnection(){
		try{
			    Class.forName(DRIVER);
		    }
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("������������ʧ�ܡ�");
			}
	     try{
			   conn =DriverManager.getConnection(URL, NAME, PWD);
		}catch(Exception ex){
			   ex.printStackTrace();
			   System.out.println("��ȡ���Ӷ���ʧ�ܡ�");
		}
		return conn;	
	}
	 /** 
     * @���� �ر����ݿ�����
     */
	public void  connClose(){
		if(conn!=null)
		try {
			conn.close();
		} catch (Exception ex) {
			  ex.printStackTrace();
			  System.out.println("�ر����Ӷ���ʧ�ܡ�");
		}	
	}
	
}
