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
    
    <title>�޸Ĺ�����Ϣ</title>
 
<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
  </head>
  
  <body>
<form name="form1" method="post" action="Admins_PublicsUpServlet"  style="text-align: center">
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
  <legend>�������ϵͳ�����޸Ĺ���</legend>
</fieldset>
  
<div class="layui-form-item"  style="margin-top:5%;">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">ԭ���Ϊ��</label>
    <div class="layui-input-inline">
      <input type="text" name="Pno" required  lay-verify="required" placeholder="������ԭ���" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>

<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">�޸Ĺ���Ϊ��</label>
    <div class="layui-input-inline">
      <input type="text" name="Pcontent" required  lay-verify="required" placeholder="�������޸Ĺ���" autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
  
  <div class="layui-form-item">
            <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">�����ߣ�</label>
    <div class="layui-input-inline">
      <input type="text" name="Pname" required  lay-verify="required" value=${sessionScope.Uname} readonly autocomplete="off" class="layui-input" >
    </div>
  </div>
    </div>

 <div class="layui-form-item">
           <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">��ǰʱ��Ϊ��</label>
    <div class="layui-input-inline">
      <input type="text" name="Ptime" required  lay-verify="required" autocomplete="off" value="!${time}" readonly class="layui-input">
    </div>
  </div>
    </div>


<div class="layui-form-item">

      <button type="submit" class="layui-btn lay-submit">����</button>
      <button type="button" class="layui-btn layui-btn-primary" onclick="backAndFresh()" >ȡ��</button>
    </div>

 <script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});
</script>

  </body>
</html>
