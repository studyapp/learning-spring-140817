<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseUrl" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL Shorter</title>

<script>
	function deleteUrl(id) {
		if(confirm('해당 URL을 삭제하시겠습니까?')) {
			location.href='urls/delete?id=' + id;
		}
	}
</script>

<style>
	td {
		padding: 8px;
	}
</style>
</head>
<body>

<h1>${user.username}님 반갑습니다.</h1>
<p>가입일 : ${user.created }</p>
<hr>
<form method="POST">

<p>
	<label for="url">URL : </label>
	<input id="url" name="url" size="70">
	<button type="submit">URL 줄이기</button>
</p>
</form>
<hr>

<table border="1">
	<thead>
		<tr>
			<td>원 URL</td>
			<td>단축 URL</td>
			<td>접속 횟수</td>
			<td>생성일시</td>
			<td>삭제</td>
		</tr>
	</thead>
	
	
	<tbody>
		<c:forEach items="${urls}" var="url">
		<tr>
			<td><a href="${url.url}" target="_blank">${url.url}</a></td>
			<td><a href="s/${url.id}" target="_blank">${baseUrl}/s/${url.id}</a></td>
			<td>${url.count}</td>
			<td>${url.created}</td>
			<td><button class="btn-delete" onclick="deleteUrl(${url.id})">삭제</button></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>