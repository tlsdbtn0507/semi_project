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
			let nick = document.querySelector("#nickname");
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
					"http://localhost:8090/semi_project/json_nickCheck.do?nickname="
							+ nickname.value);
			req.send();

			event.preventDefault();
			event.stopPropagation();
		};

	};
	function profile_update() {

		let nickname = $("#nickname").val()
		let location = $("#location").val()
		let handy = $("#handy").val()
		let image_url = $("#image_url").val()

		$.ajax({
			type : "POST",
			url : "/m_updateOK.do",
			data : {
				nickname : nickname,
				location : location,
				handy : handy,
				image_url : image_url
			},
			success : function(response) {
				if (response['result'] == 'success') {
					alert('회원가입이 완료되었습니다.')
				} else {
					alert(response['msg'])
				}
			}
		})

	}
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
			<table>
				<tbody>
					<tr>
						<td><p class="profImg"></p></td>
					</tr>
					<tr>
						<td><label for="image_url">image : </label></td>
						<td><input type="file" name="image_url"></td>
					</tr>
					<tr>
						<td><label for="nickname">nickame :</label></td>
						<td><input type="text" id="nickname" placeholder="nickname"
							name="nickname" value="${vo.nickname}">${vo.nickname}
							<button id="btn_nickCheck">중복확인</button></td>
					</tr>

					<tr>
						<td><label for="handy">평균 타수를 입력하세요</label></td>
						<td><select name="handy" id="handy">
								<option>60타</option>
								<option>70타</option>
								<option>80타</option>
								<option>90타</option>
								<option>100타</option>
								<option>110타 이상</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="location">지역 : </label></td>
						<td><select name="location" id="location">
								<option>서울</option>
								<option>경기</option>
								<option>인천</option>
								<option>강원</option>
								<option>충북</option>
								<option>충남</option>
								<option>전북</option>
								<option>전남</option>
								<option>경북</option>
								<option>경남</option>
								<option>제주</option>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="수정완료" class="btn btn-primary"></td>
					</tr>
				</tbody>

			</table>
		</form>

		<div id="navmodal" class="hidden">
			<li><a href="meetingCreate.do"> <img
					src="png/meetingCreate.png" id="meetingCreate" /><br /> <b>모임
						개설하기</b>
			</a></li>
			<li><a href="roundCreate.do"> <img src="png/roundCreate.png"
					id="roundCreate" /><br /> <b>라운드 개설하기</b>
			</a></li>
		</div>
		<div id="navmain">
			<li><a href="home.do"><img src="png/homeIcon.png"
					id="homeIcon" /><br />홈</a></li>
			<li><a href="search.do"><img src="png/search.png"
					id="search" /><br />검색</a></li>
			<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
			<li><a href="notice.do"><img src="png/bell.png" id="bell" /><br />알림</a></li>
			<li><a href="mypage/mypage.jsp"><img src="png/mypage.png"
					id="mypage" /><br />마이페이지</a></li>
		</div>
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
