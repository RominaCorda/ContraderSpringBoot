<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WheelsStoree</a>
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
            <li><a href="loginPage.jsp"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
            <li><a href="insertUser.jsp"><span class="glyphicon glyphicon-user"></span> Registrati</a></li>
        </ul>
    </div>
</nav>