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
    
    <title>�޸�������Ϣ</title>
 
<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script src="//unpkg.com/layui@2.6.8/dist/layui.js"></script>
  </head>
  
  <body>
<form name="form1" method="post" action="Admins_TapsUpServlet" style="text-align: center">
  <script>
	function backAndFresh(){
	var url =document.referrer;
	window.location=url;
	}
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>�������ϵͳ�����޸�����</legend>
</fieldset>

<div class="layui-form-item" style="margin-top:5%;">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">ԭ���Ϊ��</label>
    <div class="layui-input-inline">
      <input type="text" name="Tno" required  lay-verify="required" placeholder="������ԭ���" autocomplete="off" class="layui-input" style="width: 215px; ">
    </div>
  </div>
    </div>
  
<div class="layui-form-item">
          <div class="layui-inline">
    <label class="layui-form-label" style="width: 120px; ">�޸�������ϢΪ��</label>
    <div class="layui-input-inline">
      <input type="text" name="Tname" required  lay-verify="required" placeholder="�������޸�������Ϣ" autocomplete="off" class="layui-input"  style="width: 215px; ">
    </div>
  </div>
    </div>
  
		<div class="x-body layui-form">
              <div class="layui-inline">
        <label class="layui-form-label" style="width: 120px; ">�޸���������Ϊ��</label>
           <div class="layui-input-inline">
      <select name="TTypeno" id="TTypeno" lay-verify="required">
      
		<option value="">��ѡ��</option>
      <%
			List<TapsType> alltapstype=(List<TapsType>)session.getAttribute("alltapstype"); 
            for(int i=0;i<alltapstype.size();i++){
            TapsType tapstype= alltapstype.get(i);
			
			 %>
                <option value=<%=tapstype.getTTTypename()%>><%=tapstype.getTTTypename()%></option>
        	<%
			   }   
			 %>      
        </select>
    </div>
  </div>
    </div>

 
    
    
		<div class="x-body layui-form"  style="margin-top:1%;">
              <div class="layui-inline">
        <label class="layui-form-label" style="width: 120px; ">�޸�����״̬Ϊ��</label>
           <div class="layui-input-inline">
      <select name="Tstate" id=""Tstate"" lay-verify="required">
        <option value="">��ѡ��</option>
   		<option value="�ڿ�">�ڿ�</option>
   		<option value="���ڿ�">���ڿ�</option>
        </select>
    </div>
  </div>
    </div>
    
  
 <div class="layui-form-item" style="margin-top:1%;">

      <button type="submit" class="layui-btn lay-submit">����</button>
      <button type="button" class="layui-btn layui-btn-primary" onclick="backAndFresh()" >ȡ��</button>
    </div>

 <script>
//Demo
layui.use('form', function(){
  var form = layui.form;
form.render("select");
});
</script>    

  </body>
</html>
