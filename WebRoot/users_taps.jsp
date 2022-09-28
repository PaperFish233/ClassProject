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
    
    <title>音像信息</title>

  </head>
  
  <body>
<%@include file="users_menu.jsp" %>

<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">编号</td>
    <td width="20%">音像名称</td>
    <td width="20%">音像类别</td>
        <td width="10%">音像状态</td>

    <td width="5%">操作</td>

  </tr>
   <%
 List<Taps>  alltaps=(List<Taps>)session.getAttribute("alltaps"); 
            for(int i=0;i<alltaps.size();i++){
               Taps taps= alltaps.get(i);
	%> 
  <tr>
  <td style="padding:5px;" align="center"><%=taps.getTno()%></td>
   <td style="padding:5px;" align="center"><%=taps.getTname()%></td>
    <td style="padding:5px;" align="center"><%=taps.getTTTypename()%></td>
        <td style="padding:5px;" align="center"><%=taps.getTstate()%></td>

     <td align="center"><a href="Users_FindTapsByIdServlet?Lno=<%=taps.getTno()%>" class="layui-btn layui-btn-xs">租赁</a></td>
  </tr>
<%
 }
%> 


 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
