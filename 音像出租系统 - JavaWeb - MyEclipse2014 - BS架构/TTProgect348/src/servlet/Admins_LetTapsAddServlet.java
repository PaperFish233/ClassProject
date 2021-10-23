package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LetTaps;
import factory.DAOFactory;

public class Admins_LetTapsAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ����Ϣ
		 int Lno=Integer.parseInt(request.getParameter("Lno"));
		  String Lname=request.getParameter("Lname");
		  String LTaps=request.getParameter("LTaps");
		  String LTTypename=request.getParameter("LTTypename");
		  String LTime=request.getParameter("LTime");

		//2.����model
		 LetTaps lettaps=new LetTaps();
		 lettaps.setLno(Lno);
		 lettaps.setLname(Lname);
		 lettaps.setLTaps(LTaps);
		 lettaps.setLTTypename(LTTypename);
		 lettaps.setLTime(LTime);

		//3.ִ��doCreate()
			try {
				if(DAOFactory.getLetTapsDAOInstance().doCreate(lettaps)){ 
					//4.�Ự
				   request.getSession().setAttribute("lettaps", lettaps);	
					//5.��תBookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_LetTapsQueryAllServlet").forward(request, response);
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
