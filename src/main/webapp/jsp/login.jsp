
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Вход</title>
    <link href="${pageContext.request.contextPath}/css/signUp.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading"> Please Login In </div>
    <form method="post" action="login">
        <label for="username">Username:
            <input type="text" id="username" name="username" class="input-field">
        </label>
        <label for="password">Password:
            <input type="password" id="password" name="password" class="input-field">
        </label>
        <input type="submit" value="Login">

    </form>

</div>
</body>
</html>
