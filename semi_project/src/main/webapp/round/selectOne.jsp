<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/selectOne.css?after">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="bg">
		<section id="round_searchList">
			<!-- el 태그로 받는다.  var 변수로 객체변수 설정. -->
			<form method="post" action="round_enter.do?round_id=${vo2.round_id}">
				<%-- <img width="50" alt="${vo2.image_url}" src="upload/${vo2.image_url}"> --%>
				<div id="insert">
					<!-- <img src="png/roundBg.png" id="roundProf"> -->
					<p id="roundN">${vo2.name}</p>
				</div>
				<p id="nick">
					<img src="png/img_0001.png" id="prof"><b>닉네임</b>
				</p>
				<hr>
				<ul>
					<label>라운드</label>
					<li>${vo2.name}</li>
					<label>기간</label>
					<li>${vo2.round_date}</li>
					<label>코스</label>
					<li>${vo2.course}</li>
					<label>참여 인원</label>
					<li>${vo2.current_people}</li>
				</ul>
				<button type="submit">입장하기</button>
			</form>
		</section>
</body>
</html>