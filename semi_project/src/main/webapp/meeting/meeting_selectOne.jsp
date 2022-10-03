<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project meeting</title>
<link rel="stylesheet" href="css/myactivity.css?after" />
<link rel="stylesheet" href="css/main.css" />
<script src="js/jquery-3.6.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function enter_meeting(x) {
	
	$.ajax({
		type : "POST",
		url : "/semi_project/meeting_enter.do?meeting_id="+x,
		data : {
			
		},
		success : function(response) {
			
		}
	})

}
</script>
</head>
<body>

	<div id="bg">
	<img class="" width="400" height="200"
						 src="upload/${vo2.image_url}">
		<section id="meeting1"
			style="overflow: scroll; width: 400px; height: 500px;">
			<table class="table_margin">
				<tbody>
					<tr>
						<td class="lists">${vo2.name}</td>
					</tr>
					<tr>
						<td class="list">${vo2.explanation}</td>
					</tr>
					<tr>
						<td><a class="list">${vo2.location}</a></td>
						<td><a class="list">${vo2.age}</a></td>
						<td><a class="list">${vo2.gender}</a></td>
						<td><a class="list">${vo2.total_people}</a></td>
						<td><a class="list">개설일 ${vo2.creation_date}</a></td>
					</tr>
				</tbody>
			</table>
			<button onclick = "enter_meeting(${vo2.meeting_id})">입장하기</button>
		</section>

		<div id="navmodal" class="hidden">
			<li><a href="m_meetingCreate.do"> <img
					src="png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
						개설하기</b>
			</a></li>
			<li><a href="r_roundCreate.do"> <img
					src="png/roundCreate.png" id="roundCreate" /><br /> <b>라운드
						개설하기</b>
			</a></li>

		</div>

		<div id="navmain">
			<li><a href="h_home.do"><img src="png/homeIcon.png"
					id="homeIcon" /><br />홈</a></li>
			<li><a href="s_search.do"><img src="png/search.png"
					id="search" /><br />검색</a></li>
			<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
			<li><a href="alarm_selectAll.do"><img src="png/bell.png"
					id="bell" /><br />알림</a></li>
			<li><a href="mypage/mypage.jsp"><img src="png/mypage.png"
					id="mypage" /><br />마이페이지</a></li>
		</div>
	</div>
	<script>
		const mainBtn = document.getElementById("Addbtn");
		const mainModal = document.getElementById("navmodal")

		const showModal = function() {
			mainModal.classList.toggle('hidden')
		}

		mainBtn.addEventListener('click', showModal)
	</script>
</body>
</html>