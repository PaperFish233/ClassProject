package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

public class Users_TapsdoDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ�û�������Ϣ����û��ֵҪ���� ҪȥA����Ĳ�����ֵ��
		int Tno=Integer.parseInt(request.getParameter("Lno"));
		//2.����model��1�����ݲ���Ҫ����model��
		//3.ִ�й���ʵ����ķ���doDelete
		//4.�Ự ������ת
		try {
			if(DAOFactory.getLetTapsDAOInstance().doDelete(Tno)){	
				//5.��תBookTypeQueryAllServlet
				request.getRequestDispatcher("users_taps_let.jsp").forward(request, response);
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