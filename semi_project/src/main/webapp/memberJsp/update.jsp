<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/mUpdate.css" />
<title>semi project signup</title>
<script type="text/javascript">
	//중복확인
	window.onload = function() {
		console.log("onload....");
		let btn_nickCheck = document.querySelector("#btn_nickCheck");
		//   let result = document.querySelector("#result");
		// console.log(result);

		btn_nickCheck.onclick = function(event) {
			console.log("onclick....btn_nickCheck");
			let nick = document.querySelector("#nick");
			// console.log(id);
			console.log(nick.value);

			let req = new XMLHttpRequest();

			req.addEventListener("load", function() {
				console.log(this.status);
				console.log(this.responseText);
				//{"result":"Not OK"}
				if (this.status == 200) {
					try {
						let txt_json = this.responseText;
						let obj_json = JSON.parse(txt_json);
						console.log(obj_json);
						console.log(obj_json.result);

						let txt = "";
						if (obj_json.result === "Not OK") {
							txt = "사용중.";
						} else {
							txt = "사용가능.";
						}
						btn_nickCheck.innerHTML = txt;
					} catch (e) {
						console.log("json 형식이 아님.");
					}
				} //end if
			});

			req.open("GET",
					"http://localhost:8090/semi_project/json_nickCheck.do?nick="
							+ nick.value);
			req.send();

			event.preventDefault();
			event.stopPropagation();
		};

	};
</script>
</head>
<body>
	<div id="bg">
		<p class="p">
			<button class="backBtn"><</button>
			마이페이지
		</p>
		<form action="m_updateOK.do" method="post"
			enctype="multipart/form-data">
			<p class="profImg"></p>
			<input type="file" id="upFile" name="upFile" />
        <label for="upFile">${nickname}</label><br /><br /><br /><br />
			<!-- <br /> -->
			<!-- <br /> -->
			<!-- <br /> -->
			<input type="text" name="nick" id="nick" placeholder="닉네임을 입력하세요" />

			<button id="btn_nickCheck">중복확인</button>

			<input type="text" name="age" id="age" value=""
				placeholder="나이를 입력해주세요" /> 
			<input type="text"
				name="golfAvgCheck" id="golfAvgCheck" value=""
				placeholder="평균 타수를 입력해주세요" />
			<!-- <br /> -->
			<br /> <label for="loc">지역을 선택해주세요</label><br />
			<br /> <select name="loc" id="loc">
				<option placeholder="서울">서울</option>
				<option placeholder="경기">경기</option>
				<option placeholder="인천">인천</option>
				<option placeholder="강원">강원</option>
				<option placeholder="충북">충북</option>
				<option placeholder="충남">충남</option>
				<option placeholder="전북">전북</option>
				<option placeholder="전남">전남</option>
				<option placeholder="경북">경북</option>
				<option placeholder="경남">경남</option>
				<option placeholder="제주">제주</option>
			</select> <br /> <br /> <label for="loc">성별을 선택해주세요</label><br />
			<br /> <select name="gender" id="gender">
				<option placeholder="남자">남자</option>
				<option placeholder="여자">여자</option>
			</select> <br />
			<br />
			<button id="insert" value="완료">완료</button>

			<div id="navmodal" class="hidden">
				<li><a href="meetingCreate.do"> <img
						src="png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
							개설하기</b>
				</a></li>
				<li><a href="roundCreate.do"> <img
						src="png/roundCreate.png" id="roundCreate" /><br /> <b>라운드
							개설하기</b>
				</a></li>
			</div>
			<div id="navmain">
				<li><a href="home.do"><img
						src="png/homeIcon.png" id="homeIcon" /><br />홈</a></li>
				<li><a href="search.do"><img
						src="png/search.png" id="search" /><br />검색</a></li>
				<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
				<li><a href="notice.do"><img
						src="png/bell.png" id="bell" /><br />알림</a></li>
				<li><a href="mypage/mypage.jsp"><img
						src="png/mypage.png" id="mypage" /><br />마이페이지</a></li>
			</div>
		</form>
	</div>
	<script>
		const mainBtn = document.getElementById("Addbtn");
		const mainModal = document.getElementById("navmodal");

		//하단내비 모달창
		const showModal = function() {
			mainModal.classList.toggle("hidden");
		};

		mainBtn.addEventListener("click", showModal);
		//프사 랜덤돌리기
		const images = [ "prof1.png", "prof2.png", "prof3.png" ];
		const body = document.querySelector(".profImg");

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
