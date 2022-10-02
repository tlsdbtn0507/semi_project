<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/main.css">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="bg">
		<a href="javascript:window.history.back();"><button>뒤로가기</button></a>
		<img src="png/golfzonlogo.png" id="logo" />
		<form action="main_meeting_searchListOK.do" method="get">
			<table>
				<tr>
				<td><select name="location" id="location">
							<option value="전체">전체</option>
							<option value="서울">서울</option>
							<option value="경기">경기</option>
							<option value="충남">충남</option>
							<option value="강원">강원</option>
							<option value="제주">제주</option>
					</select></td>
					<td><select name="gender" id="gender">
							<option value="모두">모두</option>
							<option value="남">남</option>
							<option value="여">여</option>
					</select></td>
					<td><select name="age" id="age">
							<option value="상관없음">상관없음</option>
							<option value="10대">10대</option>
							<option value="20대">20대</option>
							<option value="30대">30대</option>
							<option value="40대">40대</option>
							<option value="50대">50대</option>
							<option value="60대">60대</option>
							<option value="70대이상">70대이상</option>
					</select></td>
					<td><input type="text" name="searchWord" id="searchWord"
						value="라운드/모임 검색"> <input type="submit" value="검색"></td>
				</tr>
			</table>
		</form>
		<div style="overflow: scroll; width: 350px; height: 600px;">
			<table class="table" id="round_searchList">
				<tbody>
					<!-- el 태그로 받는다.  var 변수로 객체변수 설정. -->
					<c:forEach var="vo" items="${vos}">
						<tr>
							<td><a href="round_selectOne.do?meeting_id=${vo.meeting_id}">
									<img alt="imgName" src="upload/${vo.image_url}" width="50px"
									height="50px">
							</a></td>
							<td>${vo.name}</td>
							<td>${vo.location}</td>
							<td>${vo.age}</td>
							<td>${vo.gender}</td>
							<td>${vo.total_people}</td>
							<td>${vo.handy}</td>
							<td>${vo.creation_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="navmain">
				<li><a href="h_home.do"><img src="png/homeIcon.png"
						id="homeIcon" /><br />홈</a></li>
				<li><a href="s_search.do"><img src="png/search.png"
						id="search" /><br />검색</a></li>
				<li><img src="png/mainAddBtn.png" id="Addbtn" /></li>
				<li><a href="n_notice.do"><img src="png/bell.png" id="bell" /><br />알림</a>
				</li>
				<li><a href="a_album.do"><img src="png/mypage.png"
						id="mypage" /><br />마이페이지</a></li>
			</div>

	</div>
</body>
</html>