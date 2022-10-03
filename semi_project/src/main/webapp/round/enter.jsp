<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/search.css">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="bg">
		
		<div  class="container">
			<section  id="round_searchList">
					<!-- el 태그로 받는다.  var 변수로 객체변수 설정. -->
					<form method="post" action="round_enter.do?round_id=${vo2.round_id}">
						<ul>
							<%-- <img width="50" alt="${vo2.image_url}" src="upload/${vo2.image_url}"> --%>
							<li>${member_id}</li>
							<li>${vo2.name}</li>
							<li>${vo2.course}</li>
							<li>${vo2.total_people}</li>
							<li>${vo2.current_people}</li>
							<li>${vo2.round_date}</li>
						</ul>
						<button type="submit">입장하기</button>
					</form>
			</section> 
		</div>
      
</body>
</html>