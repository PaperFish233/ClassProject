package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TapsType;
import factory.DAOFactory;

public class ewer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		try{
		//ִ��findAllBookInfo()
			List<TapsType> alltapstype=DAOFactory.getTapsTypeDAOInstance().FindAllTapsType();
		//�Ự
			request.getSession().setAttribute("alltapstype", alltapstype);
		//��ת
			request.getRequestDispatcher("admins_taps_add.jsp").forward(request, response);
		}catch(Exception e){e.printStackTrace();}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       this.doGet(request, response);

	}

}
