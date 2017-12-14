<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

 <div class="page-body">
        <c:url var="url" value="/gomme/insertGomme" />
        <form action="${url}" method="post">
            <table>
                <caption align="center">Nuova gomma</caption>
                <tr>
                    <td>Modello</td>
                    <td><input type="text" name="model" /></td>
                </tr>
                <tr>
                    <td>Produttore</td>
                    <td><input type="text" name="manufacturer" /></td>
                </tr>
                <tr>
                    <td>Prezzo</td>
                    <td><input type="text" name="price" /></td>
                </tr>
                <tr>
                    <td>Larghezza</td>
                    <td><input type="text" name="width" /></td>
                </tr>
                <tr>
                    <td>Diametro</td>
                    <td><input type="text" name="diameter" /></td>
                </tr>
                <tr>
                    <td>Carico</td>
                    <td><input type="text" name="weight" /></td>
                </tr>
                <tr>
                    <td>Velocita</td>
                    <td><input type="text" name="speed" /></td>
                </tr>
                <tr>
                    <td>Tipo veicolo</td>
                    <td>
                        <select name="typeVehicle">
                            <option value="moto">moto</option>
                            <option value="auto">auto</option>
                            <option value="commericiale">commericiale</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Stagione</td>
                    <td>
                        <select name="season">
                            <option value="invernale">invernale</option>
                            <option value="estive">estive</option>
                            <option value="quattro stagioni">quattro stagioni</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Quantita</td>
                    <td><input type="text" name="quantity" /></td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Inserisci" /></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>
 </div>
<jsp:include page="footer.jsp" />
</html>
