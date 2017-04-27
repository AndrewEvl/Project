<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2017
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание нового пользователя</title>
</head>
<body>
<%@include file="../header.jsp"%>
<form action="${pageContext.request.contextPath}/usersave" method="post">
    <label for="firstName">Имя</label>
    <input type="text" name="firstName"><br>
    <label for="lastName">Фимилия</label>
    <input type="text" name="lastName"><br>
    <label for="nickName">Псевдоним</label>
    <input type="text" name="nickName"><br>
    <label for="birthday">Дата рождения</label>
    <input type="date" name="birthday"><br>
    <label for="password">Пароль</label>
    <input type="password" name="password" title="password"><br>
    <label for="mail">Электронная почта</label>
    <input type="email" name="mail"><br>
    <button type="submit">Save</button>
</form>
<a href="${pageContext.request.contextPath}/">На главную</a>
<%@include file="../footer.jsp"%>
</body>
</html>
