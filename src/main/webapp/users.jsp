<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 13/12/2017
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />

<div class="page-body">

<c:forEach items="${users}" var="users">
    ${users}<br>
</c:forEach>

</div>

<jsp:include page="footer.jsp" />

