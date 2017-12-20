
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WheelsStore</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="/gommastore/css/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/gommastore/css/menuUser.css" type="text/css">
    <link rel="stylesheet" href="/gommastore/css/main.css" type="text/css">
</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/gommastore/">WheelsStore</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">Store</a></li>
            <li><a href="/gommastore/menuUser.jsp">Ricerca</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${FirstName} ${LastName}</a></li>
            <li><a href="/gommastore/"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
        </ul>

    </div>
</nav>

</body>
</html>