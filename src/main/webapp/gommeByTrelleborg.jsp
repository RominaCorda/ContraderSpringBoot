<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lorenzovalente
  Date: 10/12/17
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="header.jsp" />

<div class="page-body">
<c:forEach items="${gommeByTrelleborg}" var="gomma">
    ${gomma}<br>
</c:forEach>
</div>
<jsp:include page="footer.jsp" />



