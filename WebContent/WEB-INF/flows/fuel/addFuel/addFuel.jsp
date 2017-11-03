<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>Add Fuel</title>
<body>

    <form:form>
        <input type="hidden" name="_flowExecutionKey"
            value="${flowExecutionKey}" />
        <input type="text" name="username" value="stone4" />
        <input type="text" name="car" value="mazda 3" />
        <input type="text" name="km" value="100" />
        <input type="text" name="liter" value="10" />
        <input type="submit" name="_eventId_add" value="Submit" />
    </form:form>
</body>
</html>