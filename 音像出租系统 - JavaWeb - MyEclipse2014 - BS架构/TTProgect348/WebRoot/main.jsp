<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
    <base href="<%=basePath%>">
    
    <title>主界面</title>


  </head>
  
  <body>
<!--根据用户类型不同，选择不同导航栏-->
<%
    if((Integer)session.getAttribute("Uauthority")==1){%>
    
     <%@include file="admins_menu.jsp" %>
       <h1 style="margin-top:12%;" align="center">欢迎<font color=Red>管理员：${sessionScope.Uname}</font>登录音像出租系统！</h1><br>
     <%
    }else{%>
       <%@include file="users_menu.jsp" %>
       <h1 style="margin-top:12%;" align="center">欢迎<font color=Blue>用户：${sessionScope.Uname}</font>登录音像出租系统！</h1><br>
    <% 
    }
    %>
    
 <div class="layui-form-item" style="margin-top:15%;">
 </div>
    
       <%@ include file="copyright.jsp"%>
  </body>
</html>
