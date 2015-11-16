<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<style>
	.error-message {
		color: red;
	}
</style>
</head>
<body>

<h1>회원가입</h1>
<hr>

<form method="POST">
	<p>
		<label for="username">Username:</label>
		<input name="username" id="username">
	</p>
	
	<p>
		<label for="password">Password:</label>
		<input name="password" id="password" type="password">
	</p>
	
	<p style="error-message">${errorMessage }</p>
	
	<p><button type="submit">회원가입</button></p>
</form>

</body>
</html>








