<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Silverio
  Date: 14/12/2017
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />

    <c:url var="url" value="/login/test" />

    <form action="${url}" method="post">
        Username<input type="text" name="username" /> <br />
        Password<input type="text" name="password" />
        <input type="submit" value="submit" />
    </form>


