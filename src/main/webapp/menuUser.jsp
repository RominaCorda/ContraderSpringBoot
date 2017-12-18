<%--
  Created by IntelliJ IDEA.
  User: 711367
  Date: 15/12/2017
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerUser.jsp" />

<div class="page-body container">
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
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex1">Larghezza</label>
                                    <input class="form-control" id="ex1" type="text" name="width">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex2">Altezza</label>
                                    <input class="form-control" id="ex2" type="text" name="height">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex3">Diametro</label>
                                    <input class="form-control" id="ex3" type="text" name="diameter">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex4">Stagione</label>
                                    <input class="form-control" id="ex4" type="text" name="season">
                                </div>
                            </div>
                            <input type="text" value="auto" name="tipevehicle" hidden>
                            <button type="submit" class="btn btn-default">Conferma</button>
                        </form>
                    </div>
                    <div id="veicoloAuto" class="tab-pane fade">
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-8">
                                    <label for="ex5">Marca</label>
                                    <input class="form-control" id="ex5" type="text" name="brand">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex6">Modello</label>
                                    <input class="form-control" id="ex6" type="text" name="model">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex7">Alimentazione</label>
                                    <input class="form-control" id="ex7" type="text" name="fuel">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex8">Versione</label>
                                    <input class="form-control" id="ex8" type="text" name="version">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex9">Motorizzazione</label>
                                    <input class="form-control" id="ex9" type="text" name="capacity">
                                </div>
                            </div>
                            <input type="text" value="auto" name="tipevehicle" hidden>
                            <button type="submit" class="btn btn-default">Conferma</button>
                        </form>
                    </div>
                    <div id="brandAuto" class="tab-pane fade">
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-8">
                                    <label for="ex10">Produttore</label>
                                    <input class="form-control" id="ex10" type="text" name="manufacturer">
                                </div>
                            </div>
                            <input type="text" value="auto" name="tipevehicle" hidden>
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
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex11">Larghezza</label>
                                    <input class="form-control" id="ex11" type="text" name="width">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex12">Altezza</label>
                                    <input class="form-control" id="ex12" type="text" name="height">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex13">Diametro</label>
                                    <input class="form-control" id="ex13" type="text" name="diameter">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex14">Carico</label>
                                    <input class="form-control" id="ex14" type="text" name="weight">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex15">Velocità</label>
                                    <input class="form-control" id="ex15" type="text" name="speed">
                                </div>
                            </div>
                            <input type="text" value="moto" name="tipevehicle" hidden>
                            <button type="submit" class="btn btn-default">Conferma</button>
                        </form>
                    </div>
                    <div id="brandMoto" class="tab-pane fade">
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-8">
                                    <label for="ex16">Produttore</label>
                                    <input class="form-control" id="ex16" type="text" name="manufacturer">
                                </div>
                            </div>
                            <input type="text" value="moto" name="tipevehicle" hidden>
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
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex17">Larghezza</label>
                                    <input class="form-control" id="ex17" type="text" name="width">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex18">Altezza</label>
                                    <input class="form-control" id="ex18" type="text" name="height">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex19">Diametro</label>
                                    <input class="form-control" id="ex19" type="text" name="diameter">
                                </div>
                                <div class="col-xs-4">
                                    <label for="ex20">Carico</label>
                                    <input class="form-control" id="ex20" type="text" name="weight">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xs-4">
                                    <label for="ex21">Velocità</label>
                                    <input class="form-control" id="ex21" type="text" name="speed">
                                </div>
                            </div>
                            <input type="text" value="commerciale" name="tipevehicle" hidden>
                            <button type="submit" class="btn btn-default">Conferma</button>
                        </form>
                    </div>
                    <div id="brandCommerciale" class="tab-pane fade">
                        <form>
                            <div class="form-group row">
                                <div class="col-xs-8">
                                    <label for="ex22">Produttore</label>
                                    <input class="form-control" id="ex22" type="text" name="manufacturer">
                                </div>
                            </div>
                            <input type="text" value="commerciale" name="tipevehicle" hidden>
                            <button type="submit" class="btn btn-default">Conferma</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/gommastore/css/subMenu.js"></script>
<jsp:include page="footer.jsp" />