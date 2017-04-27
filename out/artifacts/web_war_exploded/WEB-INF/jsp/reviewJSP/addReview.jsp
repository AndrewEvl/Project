<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.04.2017
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление отзыва о фильме</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/reviewadd" method="post">
    <label for="review">Review</label>
    <input type="text" name="review"><br>
    <label for="mark">mark</label>
    <input type="text" name="mark"><br>
    <label for="userId">userId</label>
    <input type="text" name="userId"><br>
    <label for="filmId">filmId</label>
    <input type="text" name="filmId"><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
