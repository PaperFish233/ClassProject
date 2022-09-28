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
    <base href="<%=basePath%>">
    
    <title>添加新音像类别</title>
 <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>

  </head>
  
  <body>
<form name="form1" method="post" action="Admins_TapsTypeAddServlet" style="text-align: center"
>
  <script>
	function backAndFresh(){
	var url =document.referrer;
	window.location=url;
	}
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>音像出租系统——音像类别添加</legend>
</fieldset>

<div class="layui-form-item" style="margin-top:5%;">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">编号：</label>
    <div class="layui-input-inline">
      <input type="text" name="TTno" required  lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">填写音像类型：</label>
    <div class="layui-input-inline">
      <input type="text" name="TTTypename" required  lay-verify="required" placeholder="请输入音像类型" autocomplete="off" class="layui-input" >
    </div>
  </div>


<div class="layui-form-item">

      <button type="submit" class="layui-btn lay-submit">提交</button>
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
