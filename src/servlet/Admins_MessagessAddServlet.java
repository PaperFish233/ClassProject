package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Messagess;
import factory.DAOFactory;

public class Admins_MessagessAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.获取表单信息
		 int Mno=Integer.parseInt(request.getParameter("Mno"));
		  String Mcontent=request.getParameter("Mcontent");
		  String Mtime=request.getParameter("Mtime");

		//2.设置model
		  Messagess messagess=new Messagess();
		  messagess.setMno(Mno);
		  messagess.setMcontent(Mcontent);
		  messagess.setMtime(Mtime);

		//3.执行doCreate()
			try {
				if(DAOFactory.getMessagessDAOInstance().doCreate(messagess)){ 
					//4.会话
				   request.getSession().setAttribute("messagess", messagess);		
					//5.跳转BookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_MessagessQueryAllServlet").forward(request, response);
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
