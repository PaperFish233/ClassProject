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

    <title>公告</title>

  </head>
  
  <body>
<%@include file="users_menu.jsp" %>

<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">编号</td>
    <td width="10%">发布者</td>
    <td width="40%">公告内容</td>
        <td width="20%">发布日期</td>
  </tr>
   <%
 List<Publics> allpublics=(List<Publics>)session.getAttribute("allpublics");
 for(int i=0;i<allpublics.size();i++){
 Publics publics=allpublics.get(i);
 %> 
  <tr>
  <td style="padding:5px;" align="center"><%=publics.getPno()%></td>
   <td style="padding:5px;" align="center"><%=publics.getPname()%></td>
    <td style="padding:5px;" align="center"><%=publics.getPcontent()%></td>
        <td style="padding:5px;" align="center"><%=publics.getPtime()%></td>
  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
