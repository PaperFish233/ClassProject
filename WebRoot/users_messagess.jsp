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

    
    <title>匿名留言板</title>

  </head>
  
  <body>
<%@include file="users_menu.jsp" %>

<td><a href="users_messagess_add.jsp" class="layui-btn layui-btn-fluid">发布新留言板信息</a> </td>
<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">编号</td>
    <td width="40%">匿名留言内容</td>
      <td width="20%">发布日期</td>
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
