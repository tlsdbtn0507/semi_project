<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="../css/search.css?after">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="bg">
		<div id="navlogo">
			<img src="../png/golfzonlogo.png" id ="logo" />
		</div>
		<div style="margin-top: 100px;">
			<form action="main_meeting_searchListOK.do" method="get">
				<table>
					<a href="javascript:window.history.back();"><button>←</button></a>
					<input type="text" name="searchWord" id="searchWord"
							value="🔍라운드/모임 검색"> <input id="searchBtn" type="submit" value="검색"><br>
	
					<div id="nav">
						<br>
						<ul>
							<li id="round"><a href="main_round_selectAll.do" style="color: gray; border-bottom:gray">라운드</a></li>
							<li id="meeting"><a href="main_meeting_selectAll.do" style="color: skyblue; border-bottom: 1px solid skyblue">모임</a> </li>
						</ul>
					</div>
					
					<hr>
					<div>
						<select name="location" id="location"><br>
									<option value="전국">전국</option>
									<option value="서울">서울</option>
									<option value="경기">경기</option>
									<option value="충남">충남</option>
									<option value="강원">강원</option>
									<option value="제주">제주</option>
							</select>
							<select name="gender" id="gender"><br>
									<option value="성별">성별</option>
									<option value="남">남</option>
									<option value="여">여</option>
							</select>
							<select name="age" id="age">
									<option value="전체 연령">전체 연령</option>
									<option value="10대">10대</option>
									<option value="20대">20대</option>
									<option value="30대">30대</option>
									<option value="40대">40대</option>
									<option value="50대">50대</option>
									<option value="60대">60대</option>
									<option value="70대이상">70대이상</option>
							</select>
					</div>
					
			</form>
		</div>
		<div  class="container">
			<section  id="meeting_searchList">
					<!-- el 태그로 받는다.  var 변수로 객체변수 설정. -->
					<c:forEach var="vo" items="${vos}"> 
						<ul>
							<li><a href="meeting_selectOne.do?meeting_id=${vo.meeting_id}">
								<!-- 대체로 더미 이미지 (prof1) 붙임  -->
									<img alt="imgName" src="../png/prof1.png" width="130px"
									height="130px">
							</a></li>
							<li>${vo.name}</li>
							<li>${vo.location}</li>
							<li>${vo.age}</li>
							<li>${vo.gender}</li>
							<li>${vo.total_people}</li>
							<li>${vo.handy}</li>
							<li>${vo.creation_date}</li>
						</ul>
					</c:forEach>
			</section> 
		</div>
      <div id="navmodal" class="hidden">
            <li>
                <a href="m_meetingCreate.do">
                    <img src="png/meetingCreate.png" id="meetingCreate" /><br /><b>모임 개설하기</b>
                </a>
            </li>
            <li>
                <a href="r_roundCreate.do">
                    <img src="png/roundCreate.png" id="roundCreate" /><br /><b>라운드 개설하기</b> 
                </a>
            </li>

      </div>

      <div id="navmain">
        <li>
          <a href="h_home.do"
            ><img src="png/homeIcon.png" id="homeIcon" /><br />홈</a
          >
        </li>
        <li>
          <a href="s_search.do"
            ><img src="png/search.png" id="search" /><br />검색</a
          >
        </li>
        <li>
          <img src="png/mainAddBtn.png" id="Addbtn" />
        </li>
        <li>
          <a href="n_notice.do"><img src="png/bell.png" id="bell" /><br />알림</a>
        </li>
        <li>
          <a href="mypage/mypage.jsp"
            ><img src="png/mypage.png" id="mypage" /><br />마이페이지</a
          >
        </li>
      </div>
    </div>
    <script>
        const mainBtn = document.getElementById("Addbtn");
        const mainModal = document.getElementById("navmodal")

        const showModal = function (){
            mainModal.classList.toggle('hidden')
        }

        mainBtn.addEventListener('click',showModal)
    </script>
</body>
</html>