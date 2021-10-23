package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publics;
import factory.DAOFactory;

public class Users_PublicsQueryAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		try{
		//执行findAllPublics()
			List<Publics> allpublics=DAOFactory.getPublicsDAOInstance().FindAllPublics();
		//会话
			request.getSession().setAttribute("allpublics", allpublics);
		//跳转
			request.getRequestDispatcher("users_publics.jsp").forward(request, response);
		}catch(Exception e){e.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  this.doGet(request, response);
	}

}
