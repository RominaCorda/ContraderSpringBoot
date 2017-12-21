<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="headerReg.jsp" />
<body>
<img id ="underNav" src="/gommastore/css/img/registrazionenuvoutente.jpg">

<div class="page-body">
    <c:url var="url" value="/login/regControl" />
    <c:if test="${msg!=null}">
        <div id="msg" class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
        </div>
    </c:if>


    <form action="${url}" method="post" ModelAttribute="User">
        <fieldset>
        <div class="container" style=" width: 400px" >


            <div class="row">
                <div class=" col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Inserisci un username..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="text" class="form-control" name="password" id="password" placeholder="Inserisci una password..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="firstname">Nome</label>
                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Inserisci il tuo nome..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="lastname">Cognome</label>
                        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Inserisci il tuo cognome ..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="dateofbirth">Data di nascita</label>
                        <input type="text" class="form-control" name="dateofbirth" id="dateofbirth" placeholder="Inserisci data di nascita ..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="fiscalcode">Codice Fiscale</label>
                        <input type="text" class="form-control" name="fiscalcode" id="fiscalcode" placeholder="Inserisci codice fiscale..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="businessname">Ragione Sociale</label>
                        <input type="text" class="form-control" name="businessname"id="businessname" placeholder="Inserisci ragione sociale...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="vat">P.IVA</label>
                        <input type="text" class="form-control" name="vat"id="vat" placeholder="Inserisci partita IVA...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="municipality">Comune</label>
                        <input type="text" class="form-control" name="municipality" id="municipality" placeholder="Inserisci il tuo comune...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="post">CAP</label>
                        <input type="text" class="form-control" name="post" id="post" placeholder="Inserisci il CAP..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="city">Luogo di nascita</label>
                        <input type="text" class="form-control" name="city" id="city" placeholder="Inserisci luogo di nascita..."required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="address">Indirizzo</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Inserisci l'indirizzo...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-8 col-md-10 col-lg-12">
                    <div class="form-group">
                        <label for="telephone">Telefono</label>
                        <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Inserisci numero telefono...">
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-default">Invia</button>



        </div>
        </fieldset>
    </form>



</div>
</div>
</body>

<jsp:include page="footer.jsp" />