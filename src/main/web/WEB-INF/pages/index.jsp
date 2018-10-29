<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 28/10/2018
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
<body>
<form action="/enter" method="post">
   Login: <input type="text" name="login">
   Password: <input type="text" name="password">
    <input type="submit" value="Войти">
</form>

<form action="/regist">
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
