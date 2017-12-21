<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 711367
  Date: 14/12/2017
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerUser.jsp" />

<img id ="underNav" src="/gommastore/css/img/listapneu.jpg">

<div class="page-body">

    <div class="container">

        <table class="table table-striped" >
            <thead>
            <tr>
                <th>Modello</th>
                <th>Produttore</th>
                <th>Prezzo</th>
                <th>Larghezza</th>
                <th>Altezza</th>
                <th>Diametro</th>
                <th>Carico</th>
                <th>Velocità</th>
                <th>Stagioni</th>
                <th>Tipo di veicolo</th>
                <th>Quantità</th>
            </tr>
            </thead>
            <c:forEach items="${listgomme}" var="gomma">
            <tbody>
            <tr>
                <td>${gomma.model}</td>
                <td>${gomma.manufacturer}</td>
                <td>${gomma.price}</td>
                <td>${gomma.width}</td>
                <td>${gomma.height}</td>
                <td>${gomma.diameter}</td>
                <td>${gomma.weight}</td>
                <td>${gomma.speed}</td>
                <td>${gomma.season}</td>
                <td>${gomma.typeVehicle}</td>
                <td>${gomma.quantity}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp" />