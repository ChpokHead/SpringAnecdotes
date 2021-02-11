<%--
  Created by IntelliJ IDEA.
  User: danilihsanov
  Date: 05/09/2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Личный кабинет</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>

    <h1 style="text-align: center;">Вам понравилось</h1>
    <ul class="form-style-2-heading">
        <c:if test="${not empty anecList}">
            <c:forEach items="${anecList}" var="anec">
                <li>${anec.text}</li>
                <br>
                <br>
            </c:forEach>
        </c:if>

        <c:if test="${empty anecList}">
            <h1 style="text-align: center;">У вас нет понравившихся анекдотов!</h1>
        </c:if>
    </ul>
</body>
</html>
