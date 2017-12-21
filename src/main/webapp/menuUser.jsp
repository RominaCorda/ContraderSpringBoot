<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerUser.jsp" />

<img id ="underNav" src="/gommastore/css/img/menuu.jpg">

<c:if test="${msg!=null}">
    <div id="msg" class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
    </div>
</c:if>

<div class="page-body">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-2 col-sm-2 col-xs-12">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a data-toggle="pill" href="#auto" onclick="myFunction1()"><img src="/gommastore/css/img/car.png" > Auto</a></li>
                    <li><a data-toggle="pill" href="#moto" onclick="myFunction2()"><img src="/gommastore/css/img/motorcycle.png"> Moto</a></li>
                    <li><a data-toggle="pill" href="#commerciale" onclick="myFunction3()"><img src="/gommastore/css/img/trucking.png"> Commerciali</a></li>
                </ul>
            </div>
            <div class="col-lg-9 col-md-10 col-sm-10 col-xs-12">
                <div id="auto">
                    <ul class="nav nav-pills">
                        <li class="active"><a data-toggle="pill" href="#dimensioneAuto">Dimensione</a></li>
                        <li><a data-toggle="pill" href="#veicoloAuto">Veicolo</a></li>
                        <li><a data-toggle="pill" href="#brandAuto">Brand</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="dimensioneAuto" class="tab-pane fade in active">
                            <form action="/gommastore/gomme/gommeForSizeAuto" method="get" ModelAttribute="gomma">
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex1">Larghezza</label>
                                        <input class="form-control" id="ex1" type="text" name="width" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex2">Altezza</label>
                                        <input class="form-control" id="ex2" type="text" name="height" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex3">Diametro</label>
                                        <input class="form-control" id="ex3" type="text" name="diameter" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex4">Stagione</label>
                                        <select class="form-control" id="ex4" name="season" required>
                                            <option value="invernali">Invernali</option>
                                            <option value="estive">Estive</option>
                                            <option value="quattro stagioni">Quattro Stagioni</option>
                                        </select>
                                    </div>
                                </div>
                                <input type="text" value="auto" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                        <div id="veicoloAuto" class="tab-pane fade">
                            <form action="/gommastore/vehicle/searchVehicle" method="get">
                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <label for="ex5">Marca</label>
                                        <input class="form-control" id="ex5" type="text" name="brand" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex6">Modello</label>
                                        <input class="form-control" id="ex6" type="text" name="model" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex7">Alimentazione</label>
                                        <input class="form-control" id="ex7" type="text" name="fuel" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex8">Versione</label>
                                        <input class="form-control" id="ex8" type="text" name="version" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex9">Motorizzazione</label>
                                        <input class="form-control" id="ex9" type="text" name="capacity" required>
                                    </div>
                                </div>
                                <input type="text" value="auto" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                        <div id="brandAuto" class="tab-pane fade">
                            <c:url var="url" value="/gomme/allgommeManufacturer" />
                            <form action="${url}">
                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <label for="ex10">Produttore</label>
                                        <input class="form-control" id="ex10" type="text" name="manufacturer">
                                    </div>
                                </div>
                                <input type="text" value="auto" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div id="moto">
                    <ul  class="nav nav-pills">
                        <li class="active"><a data-toggle="pill" href="#dimensioneMoto">Dimensione</a></li>
                        <li><a data-toggle="pill" href="#brandMoto">Brand</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="dimensioneMoto" class="tab-pane fade in active">
                            <form action="/gommastore/gomme/gommeForSize" method="get" ModelAttribute="gomma">
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex11">Larghezza</label>
                                        <input class="form-control" id="ex11" type="text" name="width" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex12">Altezza</label>
                                        <input class="form-control" id="ex12" type="text" name="height" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex13">Diametro</label>
                                        <input class="form-control" id="ex13" type="text" name="diameter" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex14">Carico</label>
                                        <input class="form-control" id="ex14" type="text" name="weight" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex15">Velocità</label>
                                        <input class="form-control" id="ex15" type="text" name="speed" required>
                                    </div>
                                </div>
                                <input type="text" value="moto" name="typeVehicle" aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                        <div id="brandMoto" class="tab-pane fade">
                            <form action="/gommastore/gomme/allgommeManufacturer">
                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <label for="ex16">Produttore</label>
                                        <input class="form-control" id="ex16" type="text" name="manufacturer">
                                    </div>
                                </div>
                                <input type="text" value="moto" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div id="commerciale">
                    <ul class="nav nav-pills">
                        <li class="active"><a data-toggle="pill" href="#dimensioneCommerciale">Dimensione</a></li>
                        <li><a data-toggle="pill" href="#brandCommerciale">Brand</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="dimensioneCommerciale" class="tab-pane fade in active">
                            <form action="/gommastore/gomme/gommeForSize" method="get" ModelAttribute="gomma">
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex17">Larghezza</label>
                                        <input class="form-control" id="ex17" type="text" name="width" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex18">Altezza</label>
                                        <input class="form-control" id="ex18" type="text" name="height" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex19">Diametro</label>
                                        <input class="form-control" id="ex19" type="text" name="diameter" required>
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="ex20">Carico</label>
                                        <input class="form-control" id="ex20" type="text" name="weight" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-xs-4">
                                        <label for="ex21">Velocità</label>
                                        <input class="form-control" id="ex21" type="text" name="speed" required>
                                    </div>
                                </div>
                                <input type="text" value="commerciale" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                        <div id="brandCommerciale" class="tab-pane fade">
                            <form action="/gommastore/gomme/allgommeManufacturer">
                                <div class="form-group row">
                                    <div class="col-xs-8">
                                        <label for="ex22">Produttore</label>
                                        <input class="form-control" id="ex22" type="text" name="manufacturer">
                                    </div>
                                </div>
                                <input type="text" value="commerciale" name="typeVehicle"  aria-checked="true" hidden>
                                <button type="submit" class="btn btn-default">Conferma</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <script src="/gommastore/css/subMenu.js"></script>
<jsp:include page="footer.jsp" />