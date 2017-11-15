<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Fuel Result</title>
<style>
input[type=text], select {
    margin-right: 10px;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body>

    <h2>${fuel[0].username} Fuel</h2>
    <form:form>
        <fieldset>
            <legend>${fuel[0].car}</legend>
            <input type="hidden" name="_flowExecutionKey"
                value="${flowExecutionKey}" />
            <label for="car">Car</label>
            <select name="car">
                <c:forEach items="${cars}" var="car">
                    <option ${fuel[0].car == car ? 'selected' : ''} value="${car}">${car}</option><c:if test = "${salary > 2000}"></c:if>
                </c:forEach>
            </select>
            <label for="km">km</label>
            <input type="text" name="km" value="100" />
            <label for="liter">liter</label>
            <input type="text" name="liter" value="10" />
            <input type="submit" name="_eventId_display" value="Display" />
            <input type="submit" name="_eventId_add" value="Add/Update" />
            <input type="submit" name="_eventId_remove" value="Remove" />
        </fieldset>
    </form:form>
    <br />
    <table>
        <tr>
            <td>km</td>
            <td>liter</td>
        </tr>
        <c:forEach items="${fuel[0].fuelConsumption}" var="item">
            <tr>
                <td>${item.km}</td>
                <td>${item.liter}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form:form>
        <input type="hidden" name="_flowExecutionKey"
            value="${flowExecutionKey}" />
        <input type="submit" name="_eventId_ok" value="Ok" />
    </form:form>
</body>
</html>