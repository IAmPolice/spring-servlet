<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>Fuel Result</title>
<body>
    <h1>Not Found</h1>

    <a href="fuel">fuel</a>
    <form:form>
        <input type="hidden" name="_flowExecutionKey"
            value="${flowExecutionKey}" />
        <input type="submit" name="_eventId_ok" value="ok" />
    </form:form>
</body>
</html>