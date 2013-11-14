<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<head>
<meta charset="utf-8">
<title>Administration</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<h3>Add a User</h3>
<form action="/addUser" method="post">
First name: <input type="text" name="firstName"><br>
Last name: <input type="text" name="lastName"><br>
Password: <input type="password" name="hashedPassword"><br>
User name: <input type="text" name="userName"><br>
ID: <input type="text" name="id"><br>
<input type="submit" value="Submit">
</form> 
</body>
</html>