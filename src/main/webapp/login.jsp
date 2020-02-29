<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Security</title>
</head>
<body>
	<div>
	<h1>Custom Login Page</h1>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
		<form action="home" method="post">
			<input type="text" name="username" value="" /> <br><br>
			<input type="password" name="password"> <br><br>
			<input type="submit" name="Submit">
		</form>
	</div>
</body>
</html>