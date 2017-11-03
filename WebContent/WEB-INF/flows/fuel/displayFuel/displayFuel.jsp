<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Fuel Result</title>
<style>
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

    <h1>${fuel.username}  Fuel</h1>
    <h3>car: ${fuel.car}</h3>
    <table>
        <tr>
            <td>km</td>
            <td>liter</td>
        </tr>
        <c:forEach items="${fuel.fuelConsumption}" var="item">
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