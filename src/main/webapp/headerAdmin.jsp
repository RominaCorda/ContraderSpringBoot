<%--
  Created by IntelliJ IDEA.
  User: Romina
  Date: 15/12/2017
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GommaStore</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/gommastore/css/headerAdmin.css" type="text/css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">GommaStore</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Inserisci <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Inserisci gomma</a></li>
                    <li><a href="#">Inserisci veicolo</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Visualizza<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Visualizza gomme </a></li>
                    <li><a href="#">Visualizza utenti </a></li>
                    <li><a href="#">Visualizza veicoli </a></li>
                </ul>
            </li>
        </ul>
            <ul class="nav navbar-nav navbar-right">
            <li><a href="/gommastore"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>

    </div>
</nav>

</body>
</html>

