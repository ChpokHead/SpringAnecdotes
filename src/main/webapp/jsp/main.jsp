<%--
  Created by IntelliJ IDEA.
  User: danilihsanov
  Date: 29/08/2020
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Главная</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="text-style">

        <div id="anec">
            <p>${anec.text}</p>
        </div>
        <form method="post" class="text-style">
            <input type="submit" class="button" value="Следующий">
        </form>

        <a href="${pageContext.request.contextPath}/main/like" type="button" class="button" style="top:70%;">Нравится</a>
    </div>
    <c:if test="${not empty user.username}">
        <a href="userPage" class="signUp">${user.username}</a>
        <a href="logout" class="login">Выйти</a>
    </c:if>
    <c:if test="${empty user.username}">
        <a href="login" class="login">Войти</a>
        <a href="signUp" class="signUp">Регистрация</a>
    </c:if>


</body>
</html>