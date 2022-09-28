<%@ page language="java" import="java.util.*" pageEncoding="GB18030" 
contentType="text/html; charset=GB18030" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户导航条</title>
    
	<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js">
		</script>
<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="logout.jsp";
				}
			}
			
		</script>
  </head>
  
  <body>

<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>

<ul class="layui-nav" lay-filter="">
  <li class="layui-nav-item"> <a href="main.jsp">首页</a></li>
  <li class="layui-nav-item"><a href="Users_PublicsQueryAllServlet">公告</a></li>
  <li class="layui-nav-item"><a href="Users_MessagessQueryAllServlet">匿名留言板</a></li>
    <li class="layui-nav-item"><a href="Users_TapsQueryAllServlet">音像查询</a></li>
  <li class="layui-nav-item"><a href="Users_LetTapsQueryAllServlet">我的租赁</a></li>
    <li class="layui-nav-item"><a href="login.jsp" onClick="quit()">退出账号</a></li>
</ul>
        
  </body>
</html>
