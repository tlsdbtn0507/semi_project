<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/signupstyle.css?after" />
<title>semi project signup</title>
<script>
	window.onload = function() {
		console.log("onload....");
		let btn_idCheck = document.querySelector("#btn_idCheck");
		let btn_nickCheck = document.querySelector("#btn_nickCheck");
		//   let result = document.querySelector("#result");
		// console.log(result);

		btn_nickCheck.onclick = function(event) {
			console.log("onclick....");
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

		btn_idCheck.onclick = function(event) {
			console.log("onclick....");
			let id = document.querySelector("#id");
			// console.log(id);
			console.log(id.value);

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
						btn_idCheck.innerHTML = txt;
					} catch (e) {
						console.log("json 형식이 아님.");
					}
				} //end if
			});

			req.open("GET",
					"http://localhost:8090/semi_project/json_idCheck.do?id="
							+ id.value);
			req.send();

			event.preventDefault();
			event.stopPropagation();
		};
	};
</script>
</head>
<body>
	<div>
		<h2>회원가입(SignUp)</h2>
		<form action="m_insertOK.do" method="post"
			enctype="multipart/form-data">
			<section>
				<input class="check" type="text" name="nick" id="nick"
					placeholder="닉네임을 입력하세요" />
				<button id="btn_nickCheck">중복확인</button>
				<br> <input class="check" type="text" name="id" id="id"
					placeholder="아이디를 입력하세요" />
				<button id="btn_idCheck">중복확인</button>
				<br>
				<br>
				<br>
				<br>
				<br>
				<p>
					<b> 아이디:영문과 숫자,일부 특수문자(._-)사용가능,2~10자 길이</b>
				</p>

			</section>
			<input id="pw" type="password" name="pw" value=""
				placeholder="비밀번호를 입력하세요"> <br>
			<br>
			<br>
			<p>
				<b> 비밀번호:영문과 숫자 필수 포함, 특수문자 사용가능, 8자 길이</b>
			</p>
			<input id="pwc" type="password" name="pwc" value=""
				placeholder="비밀번호를 확인해주세요">
			<!-- <input  type="text" name="age" id="age" value=""  placeholder="나이를 입력해주세요"> -->
			<label for="age">나이를 선택해주세요:</label> <select name="age" id="age">
				<option>10대</option>
				<option>20대</option>
				<option>30대</option>
				<option>40대</option>
				<option>50대</option>
				<option>60대</option>
				<option>70대 이상</option>
			</select>

			<!-- <input  type="text" name="golfAvgCheck" id="golfAvgCheck" value=""  placeholder="평균 타수를 입력해주세요"> -->

			<br>
			<br>
			<br>
			<br>
			<br>
			<br> <label for="handy">평균 타수를 선택해주세요:</label> <select
				name="handy" id="handy">
				<option>60타</option>
				<option>70타</option>
				<option>80타</option>
				<option>90타</option>
				<option>100타</option>
				<option>110타 이상</option>
			</select> <br>
			<br>
			<br>
			<br> <br>
			<br>
			<br>
			<label for="loc">지역을 선택해주세요:</label> <select name="loc" id="loc">
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
			</select> <br>
			<br>
			<br>
			<label for="loc">성별을 선택해주세요:</label> <select name="gender"
				id="gender">
				<option placeholder="남자">남자</option>
				<option placeholder="여자">여자</option>
			</select>
			<button type="submit" id="insert">가입완료</button>


		</form>
	</div>
</body>
</html>