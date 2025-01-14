<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>semi project myactivity</title>
<link rel="stylesheet" href="css/myactivity.css?after" />
</head>
<body>
	<div id="bg">
		<h3>마이페이지</h3>
		<p id="profImg"></p>
		${nickname} <a href="m_update.do"><button id="memberUpdate">
				<b>프로필 수정</b>
			</button></a> <a href="logout.do"><button id="logout">
				<b>로그 아웃</b>
			</button></a>
		<div id="navup">
			<ul>
				<li><a href="mymeeting_list.do">모임</a></li>
				<li><a href="myactivity_list.do">액티비티</a></li>
				<li><a href="myrounding_list.do"
					style="color: skyblue; border-bottom: 1px solid skyblue">라운드</a></li>
			</ul>
		</div>
		<br /> <br /> <br /> <select name="activitystate"
			id="activitystate">
			<option placeholder="활동중">활동중</option>
			<option placeholder="활동전">활동전</option>
			<option placeholder="활동후">활동후</option>
		</select> <br /> <br />

		<form method="post" id="round${vo.round_id}">
		<c:forEach var="vo" items="${vo}">
				<img width="50" alt="${vo.image_url}" src="upload/${vo.image_url}">
				<li class="name">1${vo.name}</li>
				<li class="date">2${vo.round_date}</li>
				<li class="course">3${vo.course}</li>
				<li class="currentP">4${vo.current_people}</li>
				<li class="image">5${vo.image_url}</li>
		</c:forEach>
		</form>

		<div id="navmodal" class="hidden">
			<li><a href="meetingCreate.do"> <img
					src="../png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
						개설하기</b>
			</a></li>
			<li><a href="main_round_insert.do"> <img
					src="../png/roundCreate.png" id="roundCreate" /><br /> <b>라운드
						개설하기</b>
			</a></li>
		</div>

		<div id="navmain">
			<li><a href="home.do"><img src="png/homeIcon.png"
					id="homeIcon" /><br />홈</a></li>
			<li><a href="search.do"><img src="png/search.png"
					id="search" /><br />검색</a></li>
			<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
			<li><a href="notice.do"><img src="png/bell.png" id="bell" /><br />알림</a>
			</li>
			<li><a href="mypage/mypage.jsp"><img src="png/mypage.png"
					id="mypage" /><br />마이페이지</a></li>
		</div>
	</div>
	<script>
		const mainBtn = document.getElementById("Addbtn");
		const mainModal = document.getElementById("navmodal");
		const logOut = document.getElementById("logout");

		//로그아웃
		function outing() {
			const result = confirm("로그아웃 하시겠습니까?");

			if (result) {
				function locationHref() {
					location.href = "logoutOK.do";
				}
			}
		}
		logOut.addEventListener("click", outing);

		//하단내비 모달창
		const showModal = function() {
			mainModal.classList.toggle("hidden");
		};

		mainBtn.addEventListener("click", showModal);

		//프사 랜덤돌리기
		const images = [ "prof1.png", "prof2.png", "prof3.png" ];
		const body = document.querySelector("#profImg");

		const IMG_NUMBER = images.length;

		const chosenImg = images[Math.floor(Math.random() * images.length)];

		function chaPho(IMG_NUMBER) {
			const image = new Image();
			image.src = "png/" + chosenImg;
			image.classList.add("profImg");
			body.appendChild(image);
		}

		function inti() {
			chaPho(Math.floor(Math.random() * images.length));
		}
		inti();
	</script>
</body>
</html>
