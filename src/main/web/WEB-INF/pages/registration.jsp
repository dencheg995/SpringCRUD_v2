<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 29/10/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute = "registAttribute" method="post" >
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">Age:</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><form:label path="login">Login:</form:label> </td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label> </td>
            <td><form:input path="password"/></td>
        </tr>
    </table>
    <input type="submit" value="Зарегистрироваться">
</form:form>
</body>
</html>
