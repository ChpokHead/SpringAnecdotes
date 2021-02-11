<%--
  Created by IntelliJ IDEA.
  User: danilihsanov
  Date: 05/09/2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Test</title>
</head>
<body>
    <ul>
        <c:forEach items="${anecList}" var="anec">
           <li>
                   ${anec}
           </li>
        </c:forEach>
    </ul>

</body>
</html>
