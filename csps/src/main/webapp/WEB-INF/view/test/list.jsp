<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>南昌城市配送平台</title>
    <script src="/js/jquery-1.12.1.min.js"></script>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <table border="2px">
    	<tr>
    		<th>name</th>
    		<th>gender</th>
    		<th>salary</th>
    		<th>email</th>
    	</tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.name}</td>
                <td>${user.gender == 1 ? '男' : '女'}</td>
                <td>${user.salary}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>
