<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.04.2017
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<%@include file="../header.jsp"%>
 First name: ${requestScope.user}
<a href="${pageContext.request.contextPath}/">На главную</a>
<%@include file="../footer.jsp"%>
</body>
</html>
