<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Romina
  Date: 14/12/2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />

<div class="page-body">

    <c:url var="url" value="/vehicle/insertVehicle" />

    <form action="${url}" method="get" ModelAttribute="vehicle">
        Brand       <input type="text" name="brand"/> <br/><br/>
        Model       <input type="text" name="model"/> <br/><br/>
        Fuel        <input type="text" name="fuel"/> <br/><br/>
        Version     <input type="text" name="version"/> <br/><br/>
        Capacity    <input type="text" name="capacity"/> <br/><br/>
        <input type="submit" value="Conferma" />
    </form>

</div>

<jsp:include page="footer.jsp" />




