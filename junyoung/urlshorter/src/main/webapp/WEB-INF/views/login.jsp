<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL Shorter 로그인</title>

<style>
	.error-message {
		color: red;
	}
</style>

</head>
<body>

<h1>로그인이 필요합니다.</h1>
<hr>
<form method="POST">

<p>
	<label for="username">Username : </label>
	<input id="username" name="username">
</p>

<p>
	<label for="password">Password : </label>
	<input id="password" name="password" type="password">
</p>

<p class="error-message">${errorMessage}</p>

<p>
	<a href="sign-up">회원가입</a>
	<button type="submit">로그인</button>
</p>


</form>
</body>
</html>