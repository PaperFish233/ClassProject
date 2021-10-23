package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TapsType;
import factory.DAOFactory;

public class Admins_TapsTypeAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		//1.��ȡ����Ϣ
		 int TTno=Integer.parseInt(request.getParameter("TTno"));
		  String TTTypename=request.getParameter("TTTypename");


		//2.����model
		  TapsType tapstype=new TapsType();
		  tapstype.setTTno(TTno);
		  tapstype.setTTTypename(TTTypename);


		//3.ִ��doCreate()
			try {
				if(DAOFactory.getTapsTypeDAOInstance().doCreate(tapstype)){ 
					//4.�Ự
				   request.getSession().setAttribute("tapstype", tapstype);		
					//5.��תBookTypeQueryAllServlet
				   request.getRequestDispatcher("Admins_TapsTypeQueryServlet").forward(request, response);
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
