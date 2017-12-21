<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Romina
  Date: 14/12/2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="headerAdmin.jsp" />

<c:if test="${msg!=null}">
    <div id="msg" class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
    </div>
</c:if>
<img id ="underNav" src="/gommastore/css/img/insertvei.jpg">
<div class="page-body">
    <c:url var="url" value="/vehicle/insertVehicle" />
    <form action="${url}" method="get" ModelAttribute="vehicle">
        <fieldset>
            <div class="container">
                <div class="row">
                    <div class="col-xs-1 col-sm-2 col-md-3 col-lg-3" >
                    </div>
                    <div class="col-xs-10 col-sm-8 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="brand">Produttore</label>
                            <input type="text" class="form-control" name="brand" id="brand" placeholder="Inserisci produttore" required>

                            <label for="model">Modello</label>
                            <input type="text" class="form-control" name="model" id="model" placeholder="Inserisci modello" required>

                            <label for="fuel">Alimentazione</label>
                            <input type="text" class="form-control" name="fuel" id="fuel" placeholder="Inserisci alimentazione" required>

                            <label for="version">Versione</label>
                            <input type="text" class="form-control" name="version" id="version" placeholder="Inserisci versione" required>

                            <label for="capacity">Cilindrata</label>
                            <input type="text" class="form-control" name="capacity" id="capacity" placeholder="Inserisci cilindrata" required>
                        </div>
                        <button type="submit" class="btn btn-default">Conferma</button>
                    </div>


                    <div class="col-xs-1 col-sm-2 col-md-3 col-lg-3" >
                    </div>
                </div>
            </div>
        </fieldset>
    </form>

</div>

<jsp:include page="footer.jsp" />




