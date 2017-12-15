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

<form action="">
    <fieldset>
        <legend>Menu Admin ${username} ${password}</legend><br>
        <input type="radio" name="choice" value="Inserisci pneumatico"/> Inserisci pneumatico
        <br />
        <input type="radio" name="choice" value="Inserisci veicolo"/> Inserisci veicolo
        <br />
        <input type="radio" name="choice" value="Visualizza pneumatico"/> Visualizza pneumatico
        <br />
        <input type="radio" name="choice" value="Visualizza utenti"/> Visualizza utenti
        <br />
        <input type="radio" name="choice" value="Visualizza veicoli"/> Visualizza veicoli
        <br /><br />
        <input type="submit" value="Conferma" />
    </fieldset>
</form>
</body>
</html>

<jsp:include page="footer.jsp" />
