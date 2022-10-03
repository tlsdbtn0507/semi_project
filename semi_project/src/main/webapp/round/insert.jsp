<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/round_insert.css?after" />
</head>
<body>
	<div id="bg">
		<form method="post" action="main_round_insertOK.do"
			enctype="multipart/form-data">
			<table>
				<tr class="img">
					<td><img src="png/img_0001.png" id="img" /></td>
					<td><label class="input-file-button" for="input-file">
							사진</label> <input type="file" id="input-file"
								name="upFile" /></td>
				</tr>
				<tr>
					<td><input type="text" name="name" id="name"
						placeholder="라운드 이름을 입력하세요(최대15자)" />
						<hr /></td>
				</tr>
				<tr>
					<td style="font-size: 20px; opacity: 0.7">일정을 선택하세요<br /> <input
						type="date" id="round_date" name="round_date" /> <br />
						<hr />
					</td>
				</tr>
				<tr>
					<td style="font-size: 20px; opacity: 0.7; text-align: left">코스
						선택 <select name="course" id="course">
							<!-- <th class="courseTd"><p id="courseTd"> option</p></th> -->

							<option>코스 검색</option>
							<option>골프존카운티 감포</option>
							<option>골프존카운티 경남</option>
							<option>골프존카운티 구미</option>
							<option>골프존카운티 무주</option>
							<option>골프존카운티 사천</option>
							<option>골프존카운티 선운</option>
							<option>골프존카운티 순천</option>
							<option>골프존카운티 안성H</option>
							<option>골프존카운티 안성W</option>
							<option>골프존카운티 오라</option>
							<option>골프존카운티 진천</option>
							<option>골프존카운티 천안</option>
							<option>골프존카운티 청통</option>
							<option>골프존카운티 청통</option>
							<option>골프존카운티 청통</option>
							<option>골프존카운티 화랑</option>
							<option>청담CC</option>
					</select>
					<hr>
					</td>

				</tr>

				<tr>
					<!-- 					<td style="font-size:20px;opacity:0.7;text-align:left">모집인원<input type="number" name="total_people"
						id="total_people"></td>
 -->
					<td style="font-size: 20px; opacity: 0.7; text-align: left">모집인원
						<input type="number" name="total_people" id="total_people"
						placeholder="모집인원" />
					</td>
				</tr>
			</table>
			<input type="submit" id="btn" value="개설하기" />
		</form>
	</div>
	<script>
		const nameForm = document.querySelector("#name");
		const dateForm = document.querySelector("#round_date");
		const courseForm = document.querySelector("#course");
		const peopleForm = document.querySelector("#total_people");
		const loginBtn = document.querySelector("#btn");

		const btnDefault = function() {
			loginBtn.disabled = true;
		};
		btnDefault();

		function activeEvent() {
			switch (!(nameForm.value && dateForm.value && courseForm.value && peopleForm.value)) {
			case true:
				loginBtn.disabled = true;
				loginBtn.style.backgroundColor = "gray";
				loginBtn.style.color = "white";
				break;
			case false:
				loginBtn.disabled = false;
				loginBtn.style.backgroundColor = "blue";
				loginBtn.style.color = "white";
				loginBtn.style.border = "skyblue";
				break;
			}
		}

		nameForm.addEventListener("keyup", activeEvent);
		dateForm.addEventListener("keyup", activeEvent);
		courseForm.addEventListener("keyup", activeEvent);
		peopleForm.addEventListener("keyup", activeEvent);
	</script>
</body>
</html>
