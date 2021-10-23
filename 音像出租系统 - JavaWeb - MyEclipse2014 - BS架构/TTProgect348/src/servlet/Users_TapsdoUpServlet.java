package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

public class Users_TapsdoUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.获取用户请求信息（有没有值要传递 要去A里面的参数的值）
		int Tno=Integer.parseInt(request.getParameter("Lno"));
		//2.设置model（1个数据不需要设置model）
		//3.执行工厂实现类的方法doDelete
		//4.会话 不用跳转
		try {
			if(DAOFactory.getLetTapsDAOInstance().doUp(Tno)){	
				//5.跳转BookTypeQueryAllServlet
				request.getRequestDispatcher("Users_LetTapsQueryAllServlet").forward(request, response);
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
