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
    
    <title>�ҵ�����</title>
    <script type="text/javascript">
    function confirmDel(param)
    {
      if(window.confirm("ȷ��ɾ��?")){
        document.location="Users_LetTapsDeleteServlet?Lno="+param
      }
    }
  </script>
  
   <script type="text/javascript">
    function confirmUp(param)
    {
      if(layer.msg('�Ѹ��£�')){
        document.location="Users_TapsdoUpServlet?Lno="+param
      }
    }
  </script>
  
  </head>
  
  <body>
<%@include file="users_menu.jsp" %>

<table width="100%"  class="layui-table" >
  <tr align="center">
  <td width="5%">���</td>
    <td width="5%">������</td>
    <td width="20%">��������</td>
    <td width="20%">�������</td>
        <td width="10%">��������</td>

    <td width="10%">����</td>

  </tr>
   <%
 List<LetTaps>  alllettaps=(List<LetTaps>)session.getAttribute("alllettaps"); 
            for(int i=0;i<alllettaps.size();i++){
               LetTaps lettaps= alllettaps.get(i);
	%> 
  <tr>
  <td style="padding:5px;" align="center"><%=lettaps.getLno()%></td>
    <td style="padding:5px;" align="center"><%=lettaps.getLname()%></td>
   <td style="padding:5px;" align="center"><%=lettaps.getLTaps()%></td>
    <td style="padding:5px;" align="center"><%=lettaps.getLTTypename()%></td>
        <td style="padding:5px;" align="center"><%=lettaps.getLTime()%></td>
        
   <td align="center"><a href="javascript:void(0)" onclick="confirmUp(<%=lettaps.getLno()%>)" class="layui-btn layui-btn-xs">����</a>
     <a href="javascript:void(0)" onclick="confirmDel(<%=lettaps.getLno()%>)" class="layui-btn layui-btn-xs">�黹</a></td>
  </tr>
<%
 }
%> 



 </table>
   <%@ include file="copyright.jsp"%>
  </body>
</html>
