<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>YAPP URL SHORTER</title>
</head>
<body>
<h1>YAPP URL Short</h1>
<hr>


<h2>Result</h2>
<div style="border:1pt solid black">
<p><font color="red">${shortedUrl}</font></p>
<!-- EL -->
</div>
<hr>




<form action="convert" method="post">
	<div>
		<input name="url" 
			placeholder="URL을 입력해 주세요">
	</div>
	<div>
		<button type="submit">줄이기</button>
		<button type="reset">폼 비우기</button>
	</div>
</form>



</body>
</html>