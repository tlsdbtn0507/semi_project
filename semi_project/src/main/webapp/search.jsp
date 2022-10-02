<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/search.css?after">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="bg">
		<div id="navlogo">
			<img src="png/golfzonlogo.png" id ="logo" />
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
							<li id="meeting"><a href="main_meeting_selectAll.do" style="color: gray; border-bottom:gray">모임</a> </li>
						</ul>
					</div>
					
					<hr>
					<div>
						
					</div>
					<div  class="container">
			<section  id="round_searchList">
					<!-- el 태그로 받는다.  var 변수로 객체변수 설정. -->
					<c:forEach var="vo" items="${vos}"> 
						
					</c:forEach>
			</section> 
		</div>
					
			</form>
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