<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>南昌城市配送平台</title>
    <script src="/js/jquery-1.12.1.min.js"></script>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <table>
    	<tr>
    		<td>name</td>
    		<td>${test.name }</td>
    	</tr>
    	<tr>
    		<td>gender</td>
    		<td>${test.gender == 1 ? "男" : "女" }</td>
    	</tr>
    	<tr>
    		<td>salary</td>
    		<td>￥${test.salary }</td>
    	</tr>
    	<tr>
    		<td>email</td>
    		<td>${test.email }</td>
    	</tr>
    	
    </table>
</body>

</html>
