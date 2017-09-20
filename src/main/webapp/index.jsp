<%@ page language= "java" contentType ="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title> Insert title here</title >
</head>
<body>
    添加用户： <br/>
    <form action="rest/users/addition" method="POST" >
        USERNAME : <input name="userName" type="text" /><br />
        PASSWORD : <input name="passWord" type="password" /><br />
         <input name="submit" type="submit" value="submit" >
    </form >
</body>
</html>