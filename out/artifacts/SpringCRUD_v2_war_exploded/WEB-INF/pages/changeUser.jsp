<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 28/10/2018
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form  method="post" action="/changeUser">
    <table>
        <tr>
            <td> ID: <input type="text", name="idChange" value="${idChange}"></td>
            <tr>
             <td>Name: <input type="text", name="nameChange" value="${nameChange}"></td>
            </tr>
            <tr>
             <td>Age: <input type="text", name="ageChange" value="${ageChange}"></td>
            </tr>
            <tr>
             <td>Login: <input type="text", name="loginChange" value="${loginChange}"></td>
            </tr>
            <tr>
             <td>Password: <input type="password", name="passwordChange" value="${passwordChange}"></td>
            </tr>
        </tr>
    </table>
    <input type="submit" value="Изменить">
</form:form>
</body>
</html>
