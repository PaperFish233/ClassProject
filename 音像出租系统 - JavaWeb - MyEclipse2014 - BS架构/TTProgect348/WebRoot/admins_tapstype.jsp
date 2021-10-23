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
    
    <title>音像类别管理</title>
    <script type="text/javascript">
    function confirmDel(param)
    {
      if(window.confirm("确定删除?")){
        document.location="Admins_TapsTypeDeleteServlet?TTno="+param
      }
    }
  </script>
  </head>
  
  <body>
<%@include file="admins_menu.jsp" %>
<td><a href="admins_tapstype_add.jsp" class="layui-btn layui-btn-fluid">添加新音像类别</a> </td>
<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">编号</td>
    <td width="20%">音像类别</td>

    <td width="10%">操作</td>

  </tr>
   <%
 List<TapsType> alltapstype=(List<TapsType>)session.getAttribute("alltapstype"); 
            for(int i=0;i<alltapstype.size();i++){
               TapsType tapstype= alltapstype.get(i);
	%> 
  <tr>
  <td style="padding:5px;" align="center"><%=tapstype.getTTno()%></td>
    <td style="padding:5px;" align="center"><%=tapstype.getTTTypename()%></td>

  
     <td align="center"><a href="admins_tapstype_up.jsp" class="layui-btn layui-btn-xs">修改</a>
	<a href="javascript:void(0)" onclick="confirmDel(<%=tapstype.getTTno()%>)" class="layui-btn layui-btn-xs">删除</a></td> 

  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
