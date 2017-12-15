<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<c:url var="url" value="/gomme/gommeForSize" />
<form action="${url}" method="get">

    Larghezza <input type="text" name="width"><br>
    Altezza <input type="text" name="height"><br>
    Diametro <input type="text" name="diameter"><br>
    Peso <input type="text" name="weight"><br>
    Velocita  <input type="text" name="speed"><br>
    Stagioni <input type="text" name="season"><br>
    Tipo di veicolo <input type="text" name="typeVehicle"><br>
    <input type="submit" value="Cerca">

</form>
</body>
</html>
