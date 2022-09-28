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
    
    <title>租赁信息</title>
    <link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
    
    
 <script type="text/javascript">
    function confirmDel(param)
    {
      if(layer.msg('已更新！')){
        document.location="Users_TapsdoDeleteServlet?Lno="+param
      }
    }
  </script>

  </head>
  
  <body>

  
<form name="form1" method="post" action="Users_LetTapsServlet" style="text-align: center">
  <script>
	function backAndFresh(){
	var url =document.referrer;
	window.location=url;
	}
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>音像出租系统——租赁</legend>
</fieldset>

 <jsp:useBean id="time" class="java.util.Date">  

          <jsp:setProperty name="time" property="hours" param="hh"/>  
          <jsp:setProperty name="time" property="minutes" param="mm"/>  
          <jsp:setProperty name="time" property="seconds" param="ss"/>  
     </jsp:useBean> 
	
  <%
       	LetTaps lettaps=(LetTaps)session.getAttribute("lettaps");
       %>
       
       
       <div class="layui-form-item" style="margin-top:5%;">
                 <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">编号：</label>
    <div class="layui-input-inline">
      <input type="text" name="Lno" required  lay-verify="required" value="<%=lettaps.getLno()%>" readonly autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
       
   
<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label"  style="width: 120px; ">租赁人：</label>
    <div class="layui-input-inline">
      <input type="text" name="Lname" required  lay-verify="required" value="${sessionScope.Uname}" readonly autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
  
  <div class="layui-form-item">
            <div class="layui-inline">
    <label class="layui-form-label"  style="width: 120px; ">已选择音像信息：</label>
    <div class="layui-input-inline">
      <input type="text" name="LTaps" required  lay-verify="required" value="<%=lettaps.getLTaps()%>" readonly autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
  
  <div class="layui-form-item">
            <div class="layui-inline">
    <label class="layui-form-label"  style="width: 120px; ">已选择音像类别：</label>
    <div class="layui-input-inline">
      <input type="text" name="LTTypename" required  lay-verify="required" value="<%=lettaps.getLTTypename()%>" readonly autocomplete="off" class="layui-input">
    </div>
  </div>
    </div>
  
  <div class="layui-form-item">
            <div class="layui-inline">
    <label class="layui-form-label"  style="width: 120px; ">当前时间为：</label>
    <div class="layui-input-inline">
      <input type="text" name="LTime" required  lay-verify="required" autocomplete="off" value="!${time}" readonly class="layui-input">
    </div>
  </div>
    </div>
    
    <a style="color:blue" href="javascript:void(0)" onclick="confirmDel(<%=lettaps.getLno()%>)">更新</a><br>
    
 <div class="layui-form-item" style="margin-top:1%;">
      <button type="submit" class="layui-btn lay-submit">租赁</button>
      <button type="button" class="layui-btn layui-btn-primary" onclick="backAndFresh()" >取消</button>
    </div>     

</form>
  </body>
</html>
