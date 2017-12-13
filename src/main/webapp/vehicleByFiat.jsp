<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Romina
  Date: 13/12/2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicle By Fiat</title>
</head>
<body>

<c:forEach items="${vehicleByFiat}" var="veicolo">
    ${veicolo}<br>
</c:forEach>

</body>
</html>
