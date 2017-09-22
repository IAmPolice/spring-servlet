<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>HTML Tutorial</title>
<body>

<h1>order1222</h1>
  <form:form>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <input type="text" name="username" value="stone1" /><br/>
    <input type="submit" name="_eventId_getUserInfo" value="Seach" />
  </form:form>
</body>
</html>