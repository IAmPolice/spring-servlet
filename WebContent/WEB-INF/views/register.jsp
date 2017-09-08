<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Register</title>
  </head>
  <body>
    <div id="content">
      <h1>Register</h1>
  
      <form method="POST" action="./register">
        <label>Username</label>: <input type="text" name="username" value="stone2"/><br/>
        <label>Password</label>: <input type="text" name="password" value="123456"/><br/>
        <label>Name</label>: <input type="text" name="name" value="stone2"/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Submit" />
      </form>
    </div>
  </body>
</html>
