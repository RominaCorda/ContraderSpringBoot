<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 14/12/2017
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="headerReg.jsp" />


<div class="page-body">
    <c:url var="url" value="/users/newUser" />
    <!--<form action="${url}" method="get" ModelAttribute="User">
        <h1><p>REGISTRAZIONE NUOVO UTENTE</p></h1>
        <p>Riempire i vari campi</p><br>
        Username <input type="text" name="username"><br>
        Password <input type="text" name="password"><br>
        Nome <input type="text" name="firstname"><br>
        Cognome <input type="text" name="lastname"><br>
        Data di Nascita <input type="text" name="dateofbirth"><br>
        Codice Fiscale <input type="text" name="fiscalcode"><br>
        Regione Sociale <input type="text" name="businessname"><br>
        P.IVA <input type="text" name="vat"><br>
        Comune <input type="text" name="municipality"><br>
        CAP <input type="text" name="post"><br>
        Città <input type="text" name="city"><br>
        Indirizzo <input type="text" name="address"><br>
        Telefono <input type="text" name="telephone"><br>
        <input type="submit" value="REGISTRATI">
        </form> -->

    <form action="${url}" method="post" ModelAttribute="User">
        <fieldset>
        <div class="container" style=" width: 400px" >
            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Inserisci un username...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="text" class="form-control" name="password" id="password" placeholder="Inserisci una password...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="firstname">Nome</label>
                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Inserisci il tuo nome...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="lastname">Cognome</label>
                        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Inserisci il tuo cognome ...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="dateofbirth">Data di nascita</label>
                        <input type="text" class="form-control" name="dateofbirth" id="dateofbirth" placeholder="Inserisci data di nascita ...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="fiscalcode">Codice Fiscale</label>
                        <input type="text" class="form-control" name="fiscalcode" id="fiscalcode" placeholder="Inserisci codice fiscale...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="businessname">Ragione Sociale</label>
                        <input type="text" class="form-control" name="businessname"id="businessname" placeholder="Inserisci ragione sociale...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="vat">P.IVA</label>
                        <input type="text" class="form-control" name="vat"id="vat" placeholder="Inserisci partita IVA...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="municipality">Comune</label>
                        <input type="text" class="form-control" name="municipality" id="municipality" placeholder="Inserisci il tuo comune...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="post">CAP</label>
                        <input type="text" class="form-control" name="post" id="post" placeholder="Inserisci il CAP...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="city">Luogo di nascita</label>
                        <input type="text" class="form-control" name="city" id="city" placeholder="Inserisci luogo di nascita...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
                    <div class="form-group">
                        <label for="address">Indirizzo</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Inserisci l'indirizzo...">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5 col-lg-12">
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



<jsp:include page="footer.jsp" />