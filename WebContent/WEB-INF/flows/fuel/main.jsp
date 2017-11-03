<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>Fuel</title>
<body>

    <form:form>
        <input type="hidden" name="_flowExecutionKey"
            value="${flowExecutionKey}" />
        <select name="car">
            <option value="mazda 3">mazda 3</option>
        </select>
        <input type="submit" name="_eventId_getData" value="display" />
        <input type="submit" name="_eventId_addInfo" value="add" />
        <input type="submit" name="_eventId_modifyInfo" value="modify" />
        <input type="submit" name="_eventId_removeInfoo" value="remove" />
    </form:form>
</body>
</html>