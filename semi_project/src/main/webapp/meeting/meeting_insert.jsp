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
	
</script>
</head>
<body>
	
	<div id="bg">
	<h3>모임 개설</h3>
		<form action="main_meeting_insertOK.do" method="post"
			enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<td><p class="profImg"></p></td>
					</tr>
					<tr>
						<td><label for="image_url">모임 이미지 : </label></td>
						<td><input type="file" name="image_url"></td>
					</tr>
					<tr>
						<td><label for="name">모임명을 입력하세요.</label></td>
						<td><input type="text" id="name" placeholder="name"
							name="name"></td>
					</tr>
					<tr>
						<td><label for="explanation">모임에대한 소개글을 입력하세요 : </label></td>
						<td><input type="text" name="explanation" id="explanation" /></td>
					</tr>
					<tr>
						<td><label for="permission">공개여부 : </label></td>
						<td><input type="radio" name="permission" value="true"/> 공개형</td>
						<td><input type="radio" name="permission" value="false"/> 비공개형</td>
					</tr>
					<tr>
						<td><label for="secret">가입 신청 받기 : </label></td>
						<td><input type="radio" name="secret" value="true"/> 필요
						<input type="radio" name="secret" value="false"/> 필요없음</td>
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
						<td><label for="gender">성별 : </label></td>
						<td><select name="gender" id="gender">
								<option>모두</option>
								<option>남자</option>
								<option>여자</option>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="age">나이 : </label></td>
						<td><select name="age" id="age">
								<option>10대</option>
								<option>20대</option>
								<option>30대</option>
								<option>40대</option>
								<option>50대</option>
								<option>60대</option>
								<option>70대이상</option>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="handy">평균 타수를 입력하세요</label></td>
						<td><input type="text" id="handy" name="handy"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="개설완료" class="btn btn-primary"></td>
					</tr>
				</tbody>

			</table>
		</form>

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