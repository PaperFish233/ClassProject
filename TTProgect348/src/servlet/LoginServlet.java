package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;
import model.Users;

public class LoginServlet extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  response.setContentType("text/html;charset=gb18030");
  request.setCharacterEncoding("gb18030");

  String Uaccount=request.getParameter("AUno");
  String Upassword=request.getParameter("AUupw");

  Users users=new Users();
  users.setUaccount(Uaccount);
  users.setUpassword(Upassword);

  try {
	   if(DAOFactory.getUsersDAOInstance().FindLogin(users)){//界面往数据库传
	   //会话
	    request.getSession().setAttribute("Uname",users.getUname());
	    request.getSession().setAttribute("Uauthority",users.getUauthority());
	    //跳转
	    request.getRequestDispatcher("main.jsp").forward(request, response);
	   }
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	 }
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  this.doGet(request, response);
 }

}
