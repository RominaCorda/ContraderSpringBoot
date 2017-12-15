<%@ taglib prefix="href" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Silverio
  Date: 14/12/2017
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerAdmin.jsp" />
<html>
<head>
    <title>MenuAdmin </title>
</head>
<body>
<div class="container">
    <h2>Menu Admin ${username} ${password}</h2>
    <form action="">
    <button type="submit" class="btn btn-primary btn-block">Inserisci pneumatico</button>
    <button type="submit" class="btn btn-default btn-block">Inserisci veicolo</button>
    <button type="submit" class="btn btn-default btn-block">Visualizza pneumatico</button>
    <button type="submit" class="btn btn-default btn-block">Visualizza utentio</button>
    <button type="submit" class="btn btn-default btn-block">Visualizza veicoli</button>
</form>
</div>
</body>
</html>

<jsp:include page="footer.jsp" />
