<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>Create Order</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <form:form enctype="multipart/form-data">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <label for="title">Title</label><input type="text" name="title" value="中餐"/><br />
        <label for="menu">Menu</label><input type="file" name="menu"/><br />
        <label for="menu">Description</label><input type="text" name="description" value="12點結單"/><br />
        <label for="closeTime">Close Time</label><input type="date" name="closeDate"/><input type="time" name="closeTime"/><br />
        <input type="submit" name="_eventId_submit" value="Submit" />
    </form:form>
</body>
</html>