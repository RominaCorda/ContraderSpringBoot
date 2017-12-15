<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 14/12/2017
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="headerReg.jsp" />

<div class="page-body">
    <c:url var="url" value="/users/newUser" />
    <form action="${url}" method="get" ModelAttribute="User">
        <h1><p>REGISTRAZIONE NUOVO UTENTE</p></h1>
        <p>Riempire i vari campi</p><br>
        Username <input type="text" name="username"><br>
        Password <input type="text" name="password"><br>
        Nome <input type="text" name="firstname"><br>
        Cognome <input type="text" name="lastname"><br>
        Data di Nascita <input type="text" name="dateofbirth"><br>
        Codice Fiscale <input type="text" name="fiscalcode"><br>
        Regione Sociale <input type="text" name="businessname"><br>
        P.IVA <input type="text" name="vat"><br>
        Comune <input type="text" name="municipality"><br>
        CAP <input type="text" name="post"><br>
        Città <input type="text" name="city"><br>
        Indirizzo <input type="text" name="address"><br>
        Telefono <input type="text" name="telephone"><br>
        <input type="submit" value="REGISTRATI">
        </form>

</div>



<jsp:include page="footer.jsp" />