package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

public class Admins_TapsTypeDeleteServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ�û�������Ϣ����û��ֵҪ���� ҪȥA����Ĳ�����ֵ��
		int TTno=Integer.parseInt(request.getParameter("TTno"));
		//2.����model��1�����ݲ���Ҫ����model��
		//3.ִ�й���ʵ����ķ���doDelete
		//4.�Ự ������ת
		try {
			if(DAOFactory.getTapsTypeDAOInstance().doDelete(TTno)){	
				//5.��תBookTypeQueryAllServlet
				request.getRequestDispatcher("Admins_TapsTypeQueryServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doGet(request, response);
	}

}