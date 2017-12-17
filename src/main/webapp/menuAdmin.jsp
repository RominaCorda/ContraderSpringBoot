<%@ taglib prefix="href" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h2>Menu Admin ${FirstName} ${LastName}</h2>

    <c:url var="url" value="/insertGomma.jsp" />
    <form action="${url}">
    <button type="submit" class="btn btn-primary btn-block">Inserisci pneumatico</button>
    </form>

    <c:url var="url2" value="/insertVehicle.jsp" />
    <form action="${url2}">
    <button type="submit" class="btn btn-default btn-block">Inserisci veicolo</button>
    </form>

    <c:url var="url3" value="/gomme/allgomme" />
    <form action="${url3}">
    <button type="submit" class="btn btn-default btn-block">Visualizza pneumatici</button>
    </form>

    <c:url var="url4" value="/users/getUsers" />
    <form action="${url4}">
    <button type="submit" class="btn btn-default btn-block">Visualizza utenti</button>
    </form>

    <c:url var="url5" value="/vehicle/allvehicles" />
    <form action="${url5}">
    <button type="submit" class="btn btn-default btn-block">Visualizza veicoli</button>
    </form>
</div>
</body>
</html>

<jsp:include page="footer.jsp" />
