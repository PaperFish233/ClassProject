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
  
      <title>µÇÂ¼</title>
  
  <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
  
  </head>
  
  <body>


  <form name="form" method="post" action="LoginServlet" style="text-align: center">
  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>ÒôÏñ³ö×âÏµÍ³¡ª¡ªµÇÂ½</legend>
</fieldset>

  <div class="layui-form-item" style="margin-top:8%;"> 
          <div class="layui-inline">
    <label class="layui-form-label">ÕËºÅ£º</label>
    <div class="layui-input-inline">
      <input type="text" name="AUno" value="111" required  lay-verify="required" placeholder="ÇëÊäÈëÕËºÅ" autocomplete="off" class="layui-input">
    </div>
  </div>
</div>
  
   <div class="layui-form-item" style="margin-top:2%;">
             <div class="layui-inline">
    <label class="layui-form-label">ÃÜÂë£º</label>
    <div class="layui-input-inline">
      <input type="password" name="AUupw" value="111" required lay-verify="required" placeholder="ÇëÊäÈëÃÜÂë" autocomplete="off" class="layui-input">
    </div>
        </div>
</div>

    <div class="layui-form-item" style="margin-top:2%;">
      <button type="submit" class="layui-btn lay-submit">µÇÂ¼</button>
      <button type="reset" class="layui-btn layui-btn-primary">ÖØÖÃ</button>
    </div>


      
<a style="color:blue" href="login_add.jsp" >×¢²áÕËºÅ</a><br>


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
