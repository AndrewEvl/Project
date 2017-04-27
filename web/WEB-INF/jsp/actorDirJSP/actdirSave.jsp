<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.04.2017
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление Актёра</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/actdirsave" method="post">
    <label for="firstName">Имя</label>
    <input id="firstName" type="text" name="firstName"><br>
    <label for="lastName">Фамилия</label>
    <input id="lastName" type="text" name="lastName"><br>
    <label for="birthday">Дата рождения</label>
    <input id="birthday" type="date" name="birthday"><br>
    <select id="role" class="form-control" name="role" title="role">
        <c:forEach items="${requestScope.roles}" var="role">
            <option value="${role.id}">${role.role}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Save</button>
    <a href="${pageContext.request.contextPath}/">На главную</a>
</form>
</body>
</html>
