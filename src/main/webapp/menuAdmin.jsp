<%@ taglib prefix="href" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerAdmin.jsp" />
<html>
<head>
    <title>MenuAdmin </title>
</head>
<body>
<img id ="underNav" src="/gommastore/css/img/menuad.jpg">

<c:if test="${msg!=null}">
    <div id="msg" class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
    </div>
</c:if>
<div class="container">

    <c:url var="url" value="/insertGomma.jsp" />
    <form action="${url}">
    <button type="submit" class="btn btn-default btn-block">Inserisci pneumatico <img class="iconmenu" src="/gommastore/css/img/pneumatic.png"></button>
    </form>
    <br>

    <c:url var="url2" value="/insertVehicle.jsp" />
    <form action="${url2}">
    <button type="submit" class="btn btn-default btn-block">Inserisci veicolo <img class="iconmenu" src="/gommastore/css/img/auto.png"></button>
    </form>
    <br>

    <c:url var="url3" value="/gomme/allgomme" />
    <form action="${url3}">
    <button type="submit" class="btn btn-default btn-block">Visualizza pneumatici <img class="iconmenu" src="/gommastore/css/img/pneumatic.png"></button>
    </form>
    <br>

    <c:url var="url4" value="/users/getUsers" />
    <form action="${url4}">
    <button type="submit" class="btn btn-default btn-block">Visualizza utenti <img class="iconmenu" src="/gommastore/css/img/user.png"></button>
    </form>
    <br>

    <c:url var="url5" value="/vehicle/allvehicles" />
    <form action="${url5}">
    <button type="submit" class="btn btn-default btn-block">Visualizza veicoli <img class="iconmenu" src="/gommastore/css/img/auto.png"></button>
    </form>
    <br>
</div>
</body>
</html>

<jsp:include page="footer.jsp" />
