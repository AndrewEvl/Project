<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.04.2017
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.films}" var="film">
    <p><a href="${pageContext.request.contextPath}/films-info?id${film.id}">${film.name}</a> </p>
</c:forEach>
</body>
</html>
