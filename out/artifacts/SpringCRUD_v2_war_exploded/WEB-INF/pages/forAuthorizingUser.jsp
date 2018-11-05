<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 24/10/2018
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Привет!

<form action="/logout" method="post">
    <input type="submit" value="Выйти">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<form action="/" method="post">
    <input type="submit" value="Назад">
</form>
</body>
</html>
