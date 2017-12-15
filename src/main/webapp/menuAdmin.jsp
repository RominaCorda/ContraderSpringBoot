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
<br />
${username}
${password}
<form action="">
    <fieldset>
        <legend>Menu Admin</legend><br>
        <input type="checkbox" name="Inserisci pneumatico" value="html"/> Inserisci pneumatico
        <br />
        <input type="checkbox" name="Inserisci veicolo" value="css"/> Inserisci veicolo
        <br />
        <input type="checkbox" name="Visualizza pneumatico" value="javascript"/> Visualizza pneumatico
        <br />
        <input type="checkbox" name="Visualizza utenti" value="css"/> Visualizza utenti
        <br />
        <input type="checkbox" name="Visualizza veicoli" value="css"/> Visualizza veicoli
        <br /><br />
        <input type="submit" value="Conferma" />
    </fieldset>
</form>
</body>
</html>

<jsp:include page="footer.jsp" />
