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
			<th>activity_id</th>
			<th>name</th>
			<th>activity_date</th>
			<th>activity_time</th>
			<th>location</th>
			<th>current_people</th>
			<th>total_people</th>
			<th>image_url</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.activity_id}</td>		
				<td>${vo.name}</td>		
				<td>${vo.activity_date}</td>		
				<td>${vo.activity_time}</td>		
				<td>${vo.location}</td>		
				<td>${vo.current_people}</td>		
				<td>${vo.total_people}</td>		
				<td>${vo.image_url}</td>		
			</tr>
		</c:forEach>
	</tbody>
	
	</table>
</body>
</html>