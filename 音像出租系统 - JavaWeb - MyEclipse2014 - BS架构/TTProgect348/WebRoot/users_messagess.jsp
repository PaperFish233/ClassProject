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

    
    <title>�������԰�</title>

  </head>
  
  <body>
<%@include file="users_menu.jsp" %>

<td><a href="users_messagess_add.jsp" class="layui-btn layui-btn-fluid">���������԰���Ϣ</a> </td>
<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">���</td>
    <td width="40%">������������</td>
      <td width="20%">��������</td>
  </tr>
   <%
 List<Messagess> allmessagess=(List<Messagess>)session.getAttribute("allmessagess");
 for(int i=0;i<allmessagess.size();i++){
 Messagess messagess=allmessagess.get(i);
 %> 
  <tr>
  <td style="padding:5px;" align="center"><%=messagess.getMno()%></td>
    <td style="padding:5px;" align="center"><%=messagess.getMcontent()%></td>
    <td style="padding:5px;" align="center"><%=messagess.getMtime()%></td>

  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
