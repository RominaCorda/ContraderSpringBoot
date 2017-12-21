<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerAdmin.jsp" />

<img id ="underNav" src="/gommastore/css/img/listut.jpg">

<div class="page-body">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di Nascita</th>
                <th>Ragione Sociale</th>
                <th>P.IVA</th>
                <th>CAP</th>
                <th>Città</th>
                <th>Telefono</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="users">
                <tr>
                    <td>${users.firstname}</td>
                    <td>${users.lastname}</td>
                    <td>${users.dateofbirth}</td>
                    <td>${users.businessname}</td>
                    <td>${users.vat}</td>
                    <td>${users.post}</td>
                    <td>${users.city}</td>
                    <td>${users.telephone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="footer.jsp" />

