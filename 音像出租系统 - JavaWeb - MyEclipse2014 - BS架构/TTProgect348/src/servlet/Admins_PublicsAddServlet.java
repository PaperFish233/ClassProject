package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publics;
import factory.DAOFactory;

public class Admins_PublicsAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ����Ϣ
		 int Pno=Integer.parseInt(request.getParameter("Pno"));
		  String Pname=request.getParameter("Pname");
		  String Pcontent=request.getParameter("Pcontent");
		  String Ptime=request.getParameter("Ptime");
		  
		//2.����model
		  Publics publics=new Publics();
		  publics.setPno(Pno);
		  publics.setPname(Pname);
		  publics.setPcontent(Pcontent);
		  publics.setPtime(Ptime);

		//3.ִ��doCreate()
			try {
				if(DAOFactory.getPublicsDAOInstance().doCreate(publics)){ 
					//4.�Ự
				   request.getSession().setAttribute("publics", publics);		
					//5.��תBookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_PublicsQueryAllServlet").forward(request, response);
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
