<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>ORM Form</title>
		</head>
	<body>
			<!-- RUN ON SERVER 9 -->
			<h2>Register User</h2>
		<form action="handle" method="post">
		
			<label>Username</label> 
			<input type="text" name="name"><br/><br/>
			
			<label>Password</label> 
			<input type="password" name="psw"><br/><br/>
			
			<input type="submit" name="Submit">
		
		</form>
	</body>
</html>