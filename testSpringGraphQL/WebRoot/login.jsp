<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="jquery/bootstrap.min.css">
	<link rel="stylesheet" href="jquery/bootstrap-theme.min.css">
	
  </head>
  
  <body>
   <a href="${pageContext.request.contextPath}/index.jsp">back</a>
   <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/register" method="post"
		style="margin-top: 200px;">
		<div class="form-group">
			<label for="username" class="col-xs-4 control-label">用户名</label>
			<div class="col-xs-3">
				<input name="username" class="form-control" id="username"
					placeholder="请输入你的用户名">
			</div>
		</div>


		<div class="form-group">
			<label for="password" class="col-xs-4 control-label">密码</label>
			<div class="col-xs-3">
				<input type="password" name="password" class="form-control" id="password" placeholder="请输入你的密码" />
			</div>
		</div>
		<br>
		
		<div class="form-group">
			<div class="col-xs-offset-4 col-xs-5">
				<button type="submit" class="btn btn-default" onclick="return check();">登陆</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default">重置</button>
			</div>
		</div>
	</form>
   
   
	


  </body>
  <script src="jquery/bootstrap.min.js"></script>
  <script src="jquery/jquery.min.js"></script>
</html>
