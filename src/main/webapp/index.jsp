<%@ taglib prefix="href" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="headerIndex.jsp" />


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
    <h1> WheelsStore </h1>

    <h2> VI AUGURA BUON DIVERTIMENTO NELLA SCELTA DEL PRODOTTO GIUSTO!</h2><br><br>
    <h4> Qui troverete tutte le migliori marche, i fornitori con il miglior rapporto prezzo/prestazioni e le migliori offerte.</h4>
    <h4>Oltre ai migliori pneumatici estivi e pneumatici invernali troverete anche pneumatici per tutto l'anno e pneumatici speciali per ogni occasione.</h4>
    <h4> Rappresentiamo i principali produttori di pneumatici Bridgestone, Continental, Pirelli, Goodyear, Dunlop e Michelin, e molti altri.</h4>
    <h4> Dopo aver inserito la misura del pneumatico (larghezza, altezza, indice di carico e velocità) identifichiamo il prodotto giusto per Voi, in modo facile e veloce.</h4>
</div>





            <div class="container">
                <div class="row">
                    <h1>WheelsStore</h1>
                    <br><br>
                </div>

                <div class="row">
                    <!-- The carousel -->
                    <div id="transition-timer-carousel" class="carousel slide transition-timer-carousel" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#transition-timer-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#transition-timer-carousel" data-slide-to="1"></li>
                            <li data-target="#transition-timer-carousel" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="/gommastore/css/img/Bridgestone1.jpg" />
                                <div class="carousel-caption">
                                    <h1 class="carousel-caption-header">Winter is coming</h1>
                                    <p class="carousel-caption-text hidden-sm hidden-xs">
                                        Choose the best.
                                    </p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="/gommastore/css/img/Dunlop.jpg" />
                                <div class="carousel-caption">
                                    <h1 class="carousel-caption-header">Passion</h1>
                                    <p class="carousel-caption-text hidden-sm hidden-xs">
                                        Make Sure your passion.
                                    </p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="/gommastore/css/img/Pirelli.jpg" />
                                <div class="carousel-caption">
                                    <h1 class="carousel-caption-header">Stop</h1>
                                    <p class="carousel-caption-text hidden-sm hidden-xs">
                                        Never Stop.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#transition-timer-carousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#transition-timer-carousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>

                        <!-- Timer "progress bar" -->
                        <hr class="transition-timer-carousel-progress-bar animate" />
                    </div>
                </div>
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

            <div align="center" class="jumbotron">
                <h2>Le migliori marche di pneumatici </h2>
                <br>
            </div>
            <div align="center" class="container">
                <a href=""><img src="/gommastore/css/img/1.jpg"></a>
                <a href=""><img src="/gommastore/css/img/2.jpg"></a>
                <a href=""><img src="/gommastore/css/img/3.jpg"></a>
            </div>
<jsp:include page="footer.jsp" />
</body>
</html>

