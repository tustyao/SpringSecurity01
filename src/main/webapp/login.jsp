<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
<h2>Login in jsp</h2>
<form action = "/doLogin"  method = "post" >
<P>
    <label for = "username" >用户名 </label>
    <input type = "text"  id = "username"  name = "username" />
</p>
<P>
    <label for = "password" >密码</label>
    <input type = "password"  id = "password"  name = "password" />
</p>
<button type = "submit"  class = "btn" >登录</button>
</form>
</body>
</html>
