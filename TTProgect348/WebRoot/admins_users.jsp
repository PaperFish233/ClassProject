<%@ page language="java" import="java.util.*,model.*" pageEncoding="GB18030"%>
<% 
	    request.setCharacterEncoding("gb18030"); 
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
    function confirmDel(param)
    {
      if(window.confirm("ȷ��ɾ��?")){
        document.location="Admins_UsersDeleteServlet?Uno="+param
      }
    }
  </script>
    <title>�û�����</title>

  </head>
  
  <body>
<%@include file="admins_menu.jsp" %>
<td><a href="admins_users_add.jsp" class="layui-btn layui-btn-fluid">������û�</a> </td>
<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">���</td>
    <td width="20%">����</td>
    <td width="20%">�˺�</td>
    <td width="20%">����</td>
    <td width="10%">Ȩ��</td>
    <td width="10%">����</td>

  </tr>
   <%
 List<Users> allusers=(List<Users>)session.getAttribute("allusers");
 for(int i=0;i<allusers.size();i++){
 Users users=allusers.get(i);
 %> 
  <tr>
  <td style="padding:5px;" align="center"><%=users.getUno()%></td>
   <td style="padding:5px;" align="center"><%=users.getUname()%></td>
      <td style="padding:5px;" align="center"><%=users.getUaccount()%></td>
    <td style="padding:5px;" align="center"><%=users.getUpassword()%></td>
        <td style="padding:5px;" align="center"><%=users.getUauthority()%></td>

  
     <td align="center"><a href="admins_users_up.jsp" class="layui-btn layui-btn-xs">�޸�</a>
<a href="javascript:void(0)" onclick="confirmDel(<%=users.getUno()%>)" class="layui-btn layui-btn-xs">ɾ��</a></td> 
  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
