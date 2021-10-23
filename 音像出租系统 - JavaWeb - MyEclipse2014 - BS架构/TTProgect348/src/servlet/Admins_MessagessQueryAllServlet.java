package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Messagess;
import factory.DAOFactory;

public class Admins_MessagessQueryAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		try{
		//ִ��findAllPublics()
			List<Messagess> allmessagess=DAOFactory.getMessagessDAOInstance().FindAllMessagess();
		//�Ự
			request.getSession().setAttribute("allmessagess", allmessagess);
		//��ת
			request.getRequestDispatcher("admins_messagess.jsp").forward(request, response);
		}catch(Exception e){e.printStackTrace();}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  this.doGet(request, response);
	}

}
