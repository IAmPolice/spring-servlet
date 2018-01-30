<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<title>Order</title>
<body>
    <h3>${userInfo.name}</h3>
    <form:form>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <input type="submit" name="_eventId_create" value="Create" />
    </form:form>
    <c:forEach items="${orders}" var="item">
        <form:form>
            <fieldset>
                <legend>${item.title}</legend>
                <p>${item.description}</p>
                <p>Close Time: <fmt:formatDate value="${item.closeTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
                <input type="hidden" name="orderId" value="${item.orderId}" />
                <input type="submit" name="_eventId_diplay" value="Diplay" />
                <c:if test = "${item.sponsor == userInfo.userId}">
                    <input type="submit" name="_eventId_Modify" value="Modify" />
                    <input type="submit" name="_eventId_Close" value="Close" />
                    <input type="submit" name="_eventId_Delete" value="Delete" />
                </c:if>
                
            </fieldset>
        </form:form>
    </c:forEach>
</body>
</html>