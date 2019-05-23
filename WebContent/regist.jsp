<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册页面</title>
</head>
<body>

	<form action="/chapter01/insertServlet" method="post">  
		用户名：<input type="text" name="name"><br>
		密码：<input type="password" name="password"><br>
		邮箱：<input type="text" name="email"><br>
		生日：<input type="text" name="date"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>