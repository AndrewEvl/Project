<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.04.2017
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film</title>
</head>
<body>
<%@include file="header.jsp"%>
<a href="${pageContext.request.contextPath}/usersave">Добавить пользователя</a>
<a href="${pageContext.request.contextPath}/filmsave">Добавить фильм</a>
<a href="${pageContext.request.contextPath}/actdirsave">Добавить сьёмочную группу</a>
<%@include file="footer.jsp"%>
</body>
</html>
