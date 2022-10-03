<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>semi project myactivity</title>
<link rel="stylesheet" href="css/myactivity.css?after" />
<link rel="stylesheet" href="css/main.css" />
<script src="js/jquery-3.6.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<script>
function activity_ongoing(x) {
    $('#myactivity_list').empty();
    $.ajax({
        type: 'GET',
        url: '/semi_project/myactivity_listOK.do?activityState='+x,
        data: {},
        success: function (data) {
				console.log(data)
				let rows = JSON.parse(data);
				console.log(rows);
            for (let i = 0; i < rows.length; i++) {
                let location = rows[i]['location']
                let total_people = rows[i]['total_people']
                /* let activities = rows[i] */
                let activity_id = rows[i]['activity_id']
                let name = rows[i]['name']
                let activity_date = rows[i]['activity_date']
                let activity_time = rows[i]['activity_time']
                let current_people = rows[i]['current_people']
                let image_url = rows[i]['image_url']
                
				console.log(activity_id,name,location)
                
                let temp_html = '<table class="table_margin"><tr><td class="img_td" rowspan="5">'
					+ '<a href="activity_selectOne.do?activity_id='
					+ activity_id
					+ '">'
					+ '<img class="img_square" width="65px" alt="'+image_url+'" src="png/'+image_url+'">'
					+ '</a></td>'
					+ '<td><a class="lists" href="activity_selectOne.do?activity_id='
					+ activity_id
					+ '">'
					+ name
					+ '</a></td></tr>'
					+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
					+ activity_id
					+ '">'
					+ activity_date
					+ " "
					+ activity_time
					+ '</a></td></tr>'
					+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
					+ activity_id
					+ '">'
					+ location
					+ '</a></td></tr>'
					+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
					+ activity_id
					+ '">'
					+ current_people
					+ "명 참여중"
					+ '</a></td></tr></table>'

                 $('#myactivity_list').append(temp_html)
            }
        }
    })
}
</script>
<body>
	<div id="bg">
		<h3>마이페이지</h3>
		<p id="profImg"></p>
		${member_name} <a href="m_update.do"><button id="memberUpdate">
				<b>프로필 수정</b>
			</button></a> <a href="logout.do"><button id="logout">
				<b>로그 아웃</b>
			</button></a>
		<div id="navup">
			<ul>
				<li><a href="mymeeting_list.do">모임</a></li>
				<li><a style="color: skyblue; border-bottom: 1px solid skyblue">액티비티</a></li>
<!-- 				<li><a href="myrounding_list.do">라운드</a></li> -->
			</ul>
		</div>
		<br /> <br /> <br /> <select name="activitystate"
			id="activitystate" onchange="activity_ongoing(value)">
			<option>선택</option>
			<option value="활동중">활동중</option>
			<option value="활동전">활동전</option>
			<option value="활동후">활동후</option>
		</select> <br /> <br />

		<section id="myactivity_list">
			
		</section>

		<div id="navmodal" class="hidden">
			<li><a href="meetingCreate.do"> <img
					src="../png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
						개설하기</b>
			</a></li>
			<li><a href="roundCreate.do"> <img
					src="../png/roundCreate.png" id="roundCreate" /><br /> <b>라운드
						개설하기</b>
			</a></li>
		</div>

		<!-- <div id="navmain">
			<li><a href="home.do"><img src="png/homeIcon.png"
					id="homeIcon" /><br />홈</a></li>
			<li><a href="s_search.do"><img src="png/search.png"
					id="search" /><br />검색</a></li>
			<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
			<li><a href="notice.do"><img src="png/bell.png" id="bell" /><br />알림</a>
			</li>
			<li><a href="mypage/mypage.jsp"><img src="png/mypage.png"
					id="mypage" /><br />마이페이지</a></li>
		</div> -->
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
