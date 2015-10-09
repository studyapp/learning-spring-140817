<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YAPP URL SHORTER</title>
</head>
<body>
	<h1>YAPP URL SHORTER</h1>
	<HR>
	
	
	<h2>Result</h2>
	<div style="border:1pt solid black">
	<p><font color=red>${shortedUrl}</font></p>
	<!-- Expression Language -->
	</div>
	<hr>
	<form action=convert method=post>
		<div>
			<input name="url" placeholder="URL을 입력해주세요.">
		</div>
		<div>
			<button type=submit>줄이기</button>
			<button type=reset>폼 비우기</button>
		</div>
	</form>
</body>
</html>
