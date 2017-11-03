<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>User data</title>
<body>

    <h1>order2</h1>
    <b>${userInfo1.username}</b>
    <br />
    <b>${userInfo1.password}</b>
    <br />
    <b>${userInfo1.name}</b>
    <br />
    <b><%=request.getAttribute("userInfo1")%></b>
    <br />
    <form:form>
        <input type="hidden" name="_flowExecutionKey"
            value="${flowExecutionKey}" />
        <input type="submit" name="_eventId_end" value="Ok" />
    </form:form>
</body>
</html>