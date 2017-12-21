<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WheelsStore</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/gommastore/css/main.css" type="text/css">
    <link rel="icon" href="/gommastore/css/img/favicon.ico" type="image/x-icon"/>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top"
>
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/gommastore/">WheelsStore</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/gommastore/menuAdmin.jsp">Menu</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Inserisci <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/gommastore/insertGomma.jsp">Inserisci pneumatico</a></li>
                    <li><a href="/gommastore/insertVehicle.jsp">Inserisci veicolo</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Visualizza<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/gommastore/gomme/allgomme">Visualizza pneumatici </a></li>
                    <li><a href="/gommastore/users/getUsers">Visualizza utenti </a></li>
                    <li><a href="/gommastore/vehicle/allvehicles">Visualizza veicoli </a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right" >
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${FirstName} ${LastName}</a></li>
            <li><a href="/gommastore"><span class="glyphicon glyphicon-log-out"></span> Log-out</a></li>
        </ul>

    </div>
</nav>

</body>
</html>

