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

    <title>������Ϣ����</title>
    <script type="text/javascript">
    function confirmDel(param)
    {
      if(window.confirm("ȷ��ɾ��?")){
        document.location="Admins_TapsDeleteServlet?Tno="+param
      }
    }
  </script>
  </head>
  
  <body>
<%@include file="admins_menu.jsp" %>

<td><a href="ewer" class="layui-btn layui-btn-fluid">���������</a> </td>
<table width="100%"  class="layui-table">
  <tr align="center">
  <td width="5%">���</td>
    <td width="20%">��������</td>
    <td width="20%">�������</td>
        <td width="20%">����״̬</td>

    <td width="10%">����</td>
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

  
     <td align="center"><a href="ewer1" class="layui-btn layui-btn-xs">�޸�</a>
		<a href="javascript:void(0)" onclick="confirmDel(<%=taps.getTno()%>)" class="layui-btn layui-btn-xs">ɾ��</a></td> 

  </tr>
<%
 }
%> 
 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
