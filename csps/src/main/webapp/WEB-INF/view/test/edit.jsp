<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>南昌城市配送平台</title>
    <script src="/js/jquery-1.12.1.min.js"></script>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/csps/edit" method="post">
		<input type = "hidden" name="id" />
		name:<input type = "text" name="name" />
		gender:<input type = "text" name="gender" />
		salary:<input type="text" name="salary" />
		email:<input type="text" name = "email" />
		<input type = "submit" value="提交" />
	</form>
</body>
</html>