package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Taps;
import factory.DAOFactory;

public class Admins_TapsAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ����Ϣ
		 int Tno=Integer.parseInt(request.getParameter("Tno"));
		  String Tname=request.getParameter("Tname");
		  String TTTo=request.getParameter("TTypeno");
		  String Tstate=request.getParameter("Tstate");

		//2.����model
		 Taps taps=new Taps();
		 taps.setTno(Tno);
		 taps.setTname(Tname);
		 taps.setTTTo(TTTo);
		 taps.setTstate(Tstate);

		//3.ִ��doCreate()
			try {
				if(DAOFactory.getTapsDAOInstance().doCreate(taps)){ 
					//4.�Ự
				   request.getSession().setAttribute("taps", taps);	
					//5.��תBookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_TapsQueryServlet").forward(request, response);
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
