<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인목록</h1>
	<table border=1>
	<thead>
		<tr>
			<th>모임아이디</th>
			<th>모임이름</th>
			<th>모임설명</th>
			<th>모임대표이미지</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.meeting_id}</td>		
				<td>${vo.name}</td>		
				<td>${vo.explanation}</td>		
				<td>${vo.image_url}</td>		
			</tr>
		</c:forEach>
	</tbody>
	
	</table>
</body>
</html>