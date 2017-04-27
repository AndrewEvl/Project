<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Добавление фильма</title>
</head>
<body>
<%@include file="../header.jsp"%>
<form action="${pageContext.request.contextPath}/filmsave" method="post">
    <label for="name" id="name">Название</label>
    <input type="text" name="name" title="Название"><br>
    <label for="releaseDay" id="releaseDay">Дата выхода</label>
    <input type="date" name="releaseDay" title="Дата выхода"><br>
    <label for="country" id="country">Страна выпуска</label>
    <input type="text" name="country" title="Страна выпуска"><br>
    <label class="form-lable" for="genres">Ganre</label>
    <select id="genres" class="form-control" name="genre">
        <c:forEach items="${requestScope.genres}" var="genre">
            <option value="${genre.id}">${genre.name}</option>
        </c:forEach>
    </select>
    <br>
    Добавить актера<br>
    <label for="actorFirstName">Имя</label>
    <input id="actorFirstName" type="text" name="actorFirstName"><br>
    <label for="actorLastName">Фамилия</label>
    <input id="actorLastName" type="text" name="actorLastName"><br>
    <label for="birthday">Дата рождения</label>
    <input id="birthday" type="date" name="birthday"><br>
    <select id="roleOne" class="form-control" name="roleOne">
        <c:forEach items="${requestScope.role}" var="role">
            <option value="${role.id}">${role.role}</option>
        </c:forEach>
    </select>
    <br>
    Добавить режисёра<br>
    <label for="directorFirstName">Имя</label>
    <input id="directorFirstName" type="text" name="directorFirstName"><br>
    <label for="directorLastName">Фамилия</label>
    <input id="directorLastName" type="text" name="directorLastName"><br>
    <label for="directorBirthday">Дата рождения</label>
    <input id="directorBirthday" type="date" name="directorBirthday"><br>
    <select id="role" class="form-control" name="role">
        <c:forEach items="${requestScope.role}" var="role">
            <option value="${role.id}">${role.role}</option>
        </c:forEach>
    </select>
    <button type="submit">Save</button>
</form>
<%@include file="../footer.jsp"%>
</body>
</html>
