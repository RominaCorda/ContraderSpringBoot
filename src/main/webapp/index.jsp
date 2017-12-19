<%@ taglib prefix="href" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerIndex.jsp" />
<html>
<head>
    <title>Welcome Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/gommastore/css/headerAdmin.css" type="text/css">
    <link rel="stylesheet" href="/gommastore/css/index.css" type="text/css">
    <link rel="stylesheet" href="/gommastore/css/footer.css" type="text/css">
</head>
<body>
            <div id="carousel-example-generic" class="carousel slide" >
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/gommastore/css/img/index1.jpg" alt="...">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="/gommastore/css/img/index2.jpg" alt="..." >
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="/gommastore/css/img/index3.jpg" alt="...">
                        <div class="carousel-caption"></div>
                    </div>
                </div>


                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"><span class="icon-prev"></span></a>
                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"><span class="icon-next"></span></a>
            </div>

<div class="jumbotron">
    <h1>Vivi la tua passione</h1>
    <h2>Riponi la tua fiducia in noi</h2>
</div>

<!-- jQuery e plugin JavaScript  -->
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.carousel').carousel({
            interval: 3000
        })
    });
</script>
<script
        src="https://code.jquery.com/jquery-1.12.4.min.js"
        integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<jsp:include page="footer.jsp" />
</body>
</html>

