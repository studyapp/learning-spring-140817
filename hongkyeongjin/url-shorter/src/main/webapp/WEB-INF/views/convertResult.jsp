<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>YAPP</title>
</head>
<body>
<h1>YAPP URL Short</h1>
<hr>

<h2>Result</h2>
<div style="border:1pt solid black">
<p><font color="red">${shortedUrl}</font></p>
</div>

<form action="convert" method="post">
[	][줄이기][폼비우기]
<div>
<input name="url"
placeholder="URL을 입력해 주세요">
</div>
<div>
<button type="submit">줄이기</button>
<button type="reset">폼비우기</button>
</div>
</form>


</body>
</html>
