<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Romina
  Date: 13/12/2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerAdmin.jsp" />

<div class="page-body">

    <div class="container">

        <table class="table table-striped" >
            <caption>Lista Veicoli</caption>
            <thead>
                <tr>
                    <th>Produttore</th>
                    <th>Modello</th>
                    <th>Alimentazione</th>
                    <th>Versione</th>
                    <th>Cilindrata</th>
                </tr>
            </thead>
            <c:forEach items="${allVehicles}" var="allVehicle">
            <tbody>
                <tr>
                    <td>${allVehicle.brand}</td>
                    <td>${allVehicle.model}</td>
                    <td>${allVehicle.fuel}</td>
                    <td>${allVehicle.version}</td>
                    <td>${allVehicle.capacity}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="footer.jsp" />
