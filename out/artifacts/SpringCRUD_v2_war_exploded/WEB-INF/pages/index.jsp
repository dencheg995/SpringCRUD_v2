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

<form action="/list">
    <input type="submit" value="Для админа">
</form>

<form action="/registred">
    <input type="submit" value="для юзера">
</form>
<form action="/logout" method="post">
    <input type="submit" value="Выйти">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

</body>
</html>
