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
    
    <title>修改匿名留言版信息</title>
  <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
 

  </head>
  
  <body>
<form name="form1" method="post" action="Admins_MessagessUpServlet"  style="text-align: center">
  <script>
	function backAndFresh(){
	var url =document.referrer;
	window.location=url;
	}
</script>
  
  <jsp:useBean id="time" class="java.util.Date">  

          <jsp:setProperty name="time" property="hours" param="hh"/>  
          <jsp:setProperty name="time" property="minutes" param="mm"/>  
          <jsp:setProperty name="time" property="seconds" param="ss"/>  
     </jsp:useBean> 
  
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>音像出租系统——修改匿名留言板信息</legend>
</fieldset>
  
<div class="layui-form-item"  style="margin-top:5%;">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">原编号为：</label>
    <div class="layui-input-inline">
      <input type="text" name="Mno" required  lay-verify="required" placeholder="请输入原编号" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
  
  <div class="layui-form-item">
            <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">修改留言板为：</label>
    <div class="layui-input-inline">
      <input type="text" name="Mcontent" required  lay-verify="required" placeholder="请输入修改留言板信息" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>

 <div class="layui-form-item">
           <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">当前时间为：</label>
    <div class="layui-input-inline">
      <input type="text" name="Mtime" required  lay-verify="required" autocomplete="off" value="!${time}" readonly class="layui-input">
    </div>
  </div>
    </div>

<div class="layui-form-item">
      <button type="submit" class="layui-btn lay-submit">更新</button>
      <button type="button" class="layui-btn layui-btn-primary" onclick="backAndFresh()" >取消</button>
    </div>

 <script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});
</script>


  </body>
</html>
