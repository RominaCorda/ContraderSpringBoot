<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="headerAdmin.jsp" />

<c:if test="${msg!=null}">
    <div id="msg" class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
    </div>
</c:if>

<img id ="underNav" src="/gommastore/css/img/inseriscipneu.jpg">

 <div class="page-body">
        <c:url var="url" value="/gomme/insertGomme" />
        <form action="${url}" method="post">
            <div class="container">
                <div class="row">
                    <div class="col-xs-1 col-sm-2 col-md-3 col-lg-3" >
                    </div>
                    <div class="col-xs-10 col-sm-8 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="model">Modello</label>
                            <input type="text" class="form-control" name="model" id="model" placeholder="Inserisci modello" required>

                            <label for="manufacturer">Produttore</label>
                            <input type="text" class="form-control" name="manufacturer" id="manufacturer" placeholder="Inserisci produttore" required>

                            <label for="price">Prezzo</label>
                            <input type="text" class="form-control" name="price" id="price" placeholder="Inserisci prezzo" required>

                            <label for="width">Larghezza</label>
                            <input type="text" class="form-control" name="width" id="width" placeholder="Inserisci larghezza" required>

                            <label for="height">Altezza</label>
                            <input type="text" class="form-control" name="height" id="height" placeholder="Inserisci altezza" required>

                            <label for="diameter">Diametro</label>
                            <input type="text" class="form-control" name="diameter" id="diameter" placeholder="Inserisci diametro" required>

                            <label for="weight">Carico</label>
                            <input type="text" class="form-control" name="weight" id="weight" placeholder="Inserisci carico" required>

                            <label for="speed">Velocità</label>
                            <input type="text" class="form-control" name="speed" id="speed" placeholder="Inserisci velocità" required>

                            <label for="typeVehicle">Tipo veicolo</label>
                            <select class="form-control" id="typeVehicle" name="typeVehicle" required>
                                <option value="auto">auto</option>
                                <option value="moto">moto</option>
                                <option value="commerciale">commerciale</option>
                            </select>

                            <label for="season">Stagione</label>
                            <select class="form-control" id="season" name="season" required>
                                <option value="invernali">invernali</option>
                                <option value="estive">estive</option>
                                <option value="quattro stagioni">quattro stagioni</option>
                            </select>

                            <label for="quantity">Quantità</label>
                            <input type="text" class="form-control" name="quantity" id="quantity" placeholder="Inserisci quantità" required>

                        </div>
                        <button type="submit" class="btn btn-default">Inserisci</button>
                    </div>


                    <div class="col-xs-1 col-sm-2 col-md-3 col-lg-3" >
                    </div>
                </div>
            </div>
        </form>
 </div>

        <!--
            <table>
                <tr>
                    <td>Modello</td>
                    <td><input type="text" name="model" required/></td>
                </tr>
                <tr>
                    <td>Produttore</td>
                    <td><input type="text" name="manufacturer" required /></td>
                </tr>
                <tr>
                    <td>Prezzo</td>
                    <td><input type="text" name="price" required/></td>
                </tr>
                <tr>
                    <td>Larghezza</td>
                    <td><input type="text" name="width" required /></td>
                </tr>
                <tr>
                    <td>Altezza</td>
                    <td><input type="text" name="height" required/></td>
                </tr>
                <tr>
                    <td>Diametro</td>
                    <td><input type="text" name="diameter" required /></td>
                </tr>
                <tr>
                    <td>Carico</td>
                    <td><input type="text" name="weight" required/></td>
                </tr>
                <tr>
                    <td>Velocita</td>
                    <td><input type="text" name="speed" required /></td>
                </tr>
                <tr>
                    <td>Tipo veicolo</td>
                    <td>
                        <select name="typeVehicle" required>
                            <option value="moto">moto</option>
                            <option value="auto">auto</option>
                            <option value="commericiale">commericiale</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Stagione</td>
                    <td>
                        <select name="season" required>
                            <option value="invernale">invernale</option>
                            <option value="estive">estive</option>
                            <option value="quattro stagioni">quattro stagioni</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Quantit&agrave</td>
                    <td><input type="text" name="quantity" required /></td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Inserisci" /></td>
                    <td><input type="reset"></td>
                </tr>

            </table>
        </form>
 </div>-->

<jsp:include page="footer.jsp" />
</html>
