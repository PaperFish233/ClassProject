<%@ page language="java" import="java.util.*" pageEncoding="GB18030" 
contentType="text/html; charset=GB18030" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�û�������</title>
    
	<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js">
		</script>
<script language="javascript">
			function quit(){
				if(confirm("���Ҫ�˳�ϵͳ��?")){
					window.location.href="logout.jsp";
				}
			}
			
		</script>
  </head>
  
  <body>

<script>
//ע�⣺���� ���� element ģ�飬�����޷����й����Բ���
layui.use('element', function(){
  var element = layui.element;
  
  //��
});
</script>

<ul class="layui-nav" lay-filter="">
  <li class="layui-nav-item"> <a href="main.jsp">��ҳ</a></li>
  <li class="layui-nav-item"><a href="Users_PublicsQueryAllServlet">����</a></li>
  <li class="layui-nav-item"><a href="Users_MessagessQueryAllServlet">�������԰�</a></li>
    <li class="layui-nav-item"><a href="Users_TapsQueryAllServlet">�����ѯ</a></li>
  <li class="layui-nav-item"><a href="Users_LetTapsQueryAllServlet">�ҵ�����</a></li>
    <li class="layui-nav-item"><a href="login.jsp" onClick="quit()">�˳��˺�</a></li>
</ul>
        
  </body>
</html>
