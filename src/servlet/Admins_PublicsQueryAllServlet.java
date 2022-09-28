package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import model.Publics;

public class Admins_PublicsQueryAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		try{
		//ִ��findAllPublics()
			List<Publics> allpublics=DAOFactory.getPublicsDAOInstance().FindAllPublics();
		//�Ự
			request.getSession().setAttribute("allpublics", allpublics);
		//��ת
			request.getRequestDispatcher("admins_publics.jsp").forward(request, response);
		}catch(Exception e){e.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  this.doGet(request, response);
	}

}
