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
    
    <title>注册</title>
 <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>

  </head>

  <body>
<form name="form1" method="post" action="LoginAddServlet"  style="text-align: center" style="text-align: center">
  <script>
	function backAndFresh(){
	var url =document.referrer;
	window.location=url;
	}
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>音像出租系统——注册</legend>
</fieldset>

<div class="layui-form-item"  style="margin-top:5%;">
          <div class="layui-inline">
    <label class="layui-form-label">编号：</label>
    <div class="layui-input-inline">
      <input type="text" name="Uno" required  lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>

<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label">账号：</label>
    <div class="layui-input-inline">
      <input type="text" name="Uaccount" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
    </div>
  </div>
  </div>
  
<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label">姓名：</label>
    <div class="layui-input-inline">
      <input type="text" name="Uname" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>

<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label">密码：</label>
    <div class="layui-input-inline">
      <input type="text" name="Upassword" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>

<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label">权限：</label>
    <div class="layui-input-inline">
      <input type="text" name="Uauthority" required  lay-verify="required" placeholder="请输入权限" autocomplete="off" class="layui-input">
    </div>
  </div>
  </div>

<div class="layui-form-item">
      <button type="submit" class="layui-btn lay-submit">注册</button>
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
