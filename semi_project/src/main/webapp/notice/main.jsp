<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>
<link rel="stylesheet" href="../css/main.css" />
<script src="../js/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		console.log("ready...");

		//let obj_dept_job_id ={dept_ids:[10,20,30,40,50,60], job_ids:['FI_MGR','FI_ACCOUNT','AC_ACCOUNT','AC_MGR']};

		$.get("../mymeeting_list.do", function(responseText) {
			console.log(".get:", responseText);
			let my_meeting_list = JSON.parse(responseText);
			console.log(".get:", my_meeting_list);
			my_meeting_list.forEach(function(my_meeting_list) {
				$("#my_meeting_list").append(
						my_meeting_list.get(0).name);
			});
		});

	});
</script>
</head>
<body>
	<div id="bg">
		<div id="nav">
			<img src="../png/golfzonlogo.png" id="logo" /> <img
				src="../png/main_event.png" id="main_event" />
		</div>

		<div class="container">
			<div class="row">
				<a class="title"> 나의 모임 </a>
				<table class="table" id="my_meeting_list">
					<c:forEach var="vo" items="${vos}">
						<th>
						<tr>
							<th id="board_id"><a
								href="b_view.do?board_id=${vo.board_id}">${vo.title}</a></th>
							<th class="hidden" id="notice">${vo.notice}</th>
						</tr>
						</th>
						<tbody>
							<tr>
								<td id="boardDay">${vo.wdate}</td>
								<td id="writer">${vo.writer}</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


		<div id="navmodal" class="hidden">
			<li><a href="m_meetingCreate.do"> <img
					src="../png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
						개설하기</b>
			</a></li>
			<li><a href="r_roundCreate.do"> <img
					src="../png/roundCreate.png" id="roundCreate" /><br /> <b>라운드
						개설하기</b>
			</a></li>


		</div>

		<div id="navmain">
			<li><a href="h_home.do"><img src="../png/homeIcon.png"
					id="homeIcon" /><br />홈</a></li>
			<li><a href="s_search.do"><img src="../png/search.png"
					id="search" /><br />검색</a></li>
			<li><img src="../png/mainAddBtn.png" id="Addbtn" /></li>
			<li><a href="n_notice.do"><img src="../png/bell.png"
					id="bell" /><br />알림</a></li>
			<li><a href="a_album.do"><img src="../png/mypage.png"
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