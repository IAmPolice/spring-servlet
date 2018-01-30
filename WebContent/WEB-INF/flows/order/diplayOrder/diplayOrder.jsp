<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<title>Order ${orderDetail.title}</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    position: relative;
    top: 13px;
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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <img src="order/menu/${orderDetail.orderId}">
    <p>${orderDetail.description}</p>
    <p>Close Time: <fmt:formatDate value="${orderDetail.closeTime}" pattern="yyyy-MM-dd HH:mm" /></p>
    <form:form>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <input type="hidden" name="orderId" value="${orderDetail.orderId}" />
        <input type="text" name="item" value="麵類" />
        <input type="number" name="price" value="50" />
        <input type="submit" name="_eventId_add" value="Add" />
        <input type="submit" name="_eventId_modify" value="Modify" />
        <input type="submit" name="_eventId_ok" value="Prev" />
    </form:form>
    <table>
        <tr>
            <td>Name</td>
            <td>Item</td>
            <td>Price</td>
            <td>Time</td>
            <td width="80px"></td>
        </tr>
        <c:forEach items="${orderDetail.purchaser}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.item}</td>
                <td>${item.price}</td>
                <td><fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td style="text-align: center;">
                    <c:if test = "${item.userId == userInfo.userId}">
                        <form:form>
                            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
                            <input type="hidden" name="orderId" value="${orderDetail.orderId}" />
                            <input type="hidden" name="item" value="${item.item}" />
                            <input type="submit" name="_eventId_remove" value="Remove" />
                        </form:form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>