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
        document.location="Admins_PublicsDeleteServlet?Pno="+param
      }
    }
  </script>
    <title>�������</title>
<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>


  </head>
  
  <body>
<%@include file="admins_menu.jsp" %>

<td><a href="admins_publics_add.jsp" class="layui-btn layui-btn-fluid">�����¹���</a> </td>
<table width="100%" class="layui-table">
  <tr align="center">
  <td width="5%">���</td>
    <td width="10%">������</td>
    <td width="40%">��������</td>
        <td width="20%">����ʱ��</td>

    <td width="10%">����</td>

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

  
     <td align="center"><a href="admins_publics_up.jsp" class="layui-btn layui-btn-xs">�޸�</a>
    <a href="javascript:void(0)" onclick="confirmDel(<%=publics.getPno()%>)" class="layui-btn layui-btn-xs">ɾ��</a></td> 
  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
