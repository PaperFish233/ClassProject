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
  
      <title>��¼</title>
  
  <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
  
  </head>
  
  <body>


  <form name="form" method="post" action="LoginServlet" style="text-align: center">
  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>�������ϵͳ������½</legend>
</fieldset>

  <div class="layui-form-item" style="margin-top:8%;"> 
          <div class="layui-inline">
    <label class="layui-form-label">�˺ţ�</label>
    <div class="layui-input-inline">
      <input type="text" name="AUno" value="111" required  lay-verify="required" placeholder="�������˺�" autocomplete="off" class="layui-input">
    </div>
  </div>
</div>
  
   <div class="layui-form-item" style="margin-top:2%;">
             <div class="layui-inline">
    <label class="layui-form-label">���룺</label>
    <div class="layui-input-inline">
      <input type="password" name="AUupw" value="111" required lay-verify="required" placeholder="����������" autocomplete="off" class="layui-input">
    </div>
        </div>
</div>

    <div class="layui-form-item" style="margin-top:2%;">
      <button type="submit" class="layui-btn lay-submit">��¼</button>
      <button type="reset" class="layui-btn layui-btn-primary">����</button>
    </div>


      
<a style="color:blue" href="login_add.jsp" >ע���˺�</a><br>


    <div class="layui-form-item" style="margin-top:12%;">
    <div class="layui-input-block">
    
        </div>
  </div>
     
 <script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});
</script>
  

   </form>  
   <%@ include file="copyright.jsp"%>

  </body>

</html>
