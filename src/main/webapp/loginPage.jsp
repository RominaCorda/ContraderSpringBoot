<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Silverio
  Date: 14/12/2017
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>WheelsStore</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/gommastore/css/main.css" type="text/css">
    <link rel="icon" href="/gommastore/css/img/favicon.ico" type="image/x-icon"/>
</head>
<body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/gommastore/">WheelsStore</a>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/gommastore/">Home</a></li>
                    <li><a href="/gommastore/users/registrazione">Registrati</a></li>
                </ul>
            </div>
        </nav>

    <div class="page-body">
        <div class="container">
            <div class="card card-container">
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <div class="imgProfile" align="center">
                    <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                </div>
                <p id="profile-name" class="profile-name-card"></p>

                <c:url var="url" value="/login/menu" />

                <form class="form-signin" action="${url}" method="post">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="text" name ="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
                    <input type="password" name ="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Ricordami
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Accedi</button>
                </form><!-- /form -->
                <a href="#" class="forgot-password">
                    Password dimenticata?
                </a>
            </div><!-- /card-container -->

            <c:if test="${msg!=null}">
                <div id="msg" class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${msg}
                </div>
            </c:if>


        </div><!-- /container -->

    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
