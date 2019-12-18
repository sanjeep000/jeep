<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>
<h2>User Registration</h2>
 <form action="registeruser" method ="post">
 <pre>
First Name:<input type="text" name="firstName"/><br/>
 Last Name:<input type="text" name="lastName"/><br/>
    Email:<input type="text" name="email"/><br/>
 Password:<input type="password"  name="password"/><br/>
 Confirm
 Password:<input type="text" name="confirmpassword"/><br/>
   <input type="Submit" value="register"/>
   </pre>
 </form>
</body>
</html>