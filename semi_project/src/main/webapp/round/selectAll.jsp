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
					<c:forEach var="vo" items="${vos}"> 
						<ul>
							<li><a href="round_selectOne.do?round_id=${vo.round_id}">
							<img width="50" alt="${vo.image_url}" src="upload/${vo.image_url}"></a></li>
							<li>라운드 이름:${vo.name}</li>
							<li>라운드 번호:${vo.round_id}</li>
							<li>라운드 코스:${vo.course}</li>
							<li>라운드 정원:${vo.total_people}</li>
							<li>현재 라운드 인원:${vo.current_people}</li>
							<li>라운드 날짜:${vo.round_date}</li>
							<hr>
						</ul>
					</c:forEach>
			</section> 
		</div>
      
</body>
</html>