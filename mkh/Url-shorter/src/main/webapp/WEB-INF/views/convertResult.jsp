<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yapp Url Shorter</title>
</head>
<body>
<h1>Yapp Url Shorter</h1>
<hr/>
<h2>Result</h2>
<div style="border:1px solid black">
<p><font color=red>${shortedUrl}</font></p>
<!--  EL -->
</div>
<hr>
<form action="convert" method="post">
	<div>
	<input name="url" placeholder="URL을 입력해주세요."></div>
	<div>
	<button type="submit">줄이기</button>
	<button type="reset">폼 비우기</button>
	</div>
</form>
</body>
</html>