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
			<th>round_id</th>
			<th>name</th>
			<th>round_date</th>
			<th>course</th>
			<th>total_people</th>
			<th>current_people</th>
			<th>image_url</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.round_id}</td>		
				<td>${vo.name}</td>		
				<td>${vo.round_date}</td>		
				<td>${vo.course}</td>		
				<td>${vo.total_people}</td>		
				<td>${vo.current_people}</td>		
				<td>${vo.image_url}</td>		
			</tr>
		</c:forEach>
	</tbody>
	
	</table>
</body>
</html>