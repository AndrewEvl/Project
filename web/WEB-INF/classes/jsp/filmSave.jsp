<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2017
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/filmsave" method="post">
    <label for="name">Название</label>
    <input type="text" name="name"><br>
    <label for="releaseDay">Дата выхода</label>
    <input type="date" name="releaseDay"><br>
    <label for="country">Страна выпуска</label>
    <input type="text" name="country"><br>
    <label for="genre">Жанр</label>
    <input type="text" name="genre"><br>
    <button type="submit">Save</button>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
