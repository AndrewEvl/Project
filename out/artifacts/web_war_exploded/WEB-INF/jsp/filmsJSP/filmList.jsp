<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.04.2017
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label for="name">Поиск фильма</label>
<input type="text" name="name"><br>
<button type="submit">Поиск
    <a href="${pageContext.request.contextPath}/filminfo"></a>
</button>
<br>
Film name: ${requestScope.filmName}
</body>
</html>
