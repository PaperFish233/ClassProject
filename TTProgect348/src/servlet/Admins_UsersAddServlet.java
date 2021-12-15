package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import factory.DAOFactory;

public class Admins_UsersAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ����Ϣ
		  int Uno=Integer.parseInt(request.getParameter("Uno"));
		  String Uaccount=request.getParameter("Uaccount");
		  String Uname=request.getParameter("Uname");
		  String Upassword=request.getParameter("Upassword");
		  int Uauthority=Integer.parseInt(request.getParameter("Uauthority"));

		//2.����model
		  Users users=new Users();
		  users.setUno(Uno);
		  users.setUaccount(Uaccount);
		  users.setUname(Uname);
		  users.setUpassword(Upassword);
		  users.setUauthority(Uauthority);

		//3.ִ��doCreate()
			try {
				if(DAOFactory.getUsersDAOInstance().doCreate(users)){ 
					//4.�Ự
				   request.getSession().setAttribute("users", users);		
					//5.��תBookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_UsersQueryServlet").forward(request, response);
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
