<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>User data</title>
<body>

<b>${userInfo.username}</b><br/>
<b>${userInfo.password}</b><br/>
<b>${userInfo.name}</b><br/>

<b><%=request.getAttribute("userInfo")%></b><br/>
  <form:form>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <input type="submit" name="_eventId_end" value="Ok" />
  </form:form>
</body>
</html>