<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
<h2>Hello World!</h2>

<form action = "/custom/logout"  method = "post" >
    <P>
        <label>LOG OUT</label>
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type = "submit"  class = "btn" >登出</button>
</form>
</body>
</html>
