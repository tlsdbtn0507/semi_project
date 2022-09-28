<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project meetingboard</title>
<link rel="stylesheet" href="css/default.css" />
  </head>
  <body>
  <div id="bg">
      <div id="navmodal" class="hidden">
            <li>
                <a href="meetingCreate.do">
                    <img src="png/meetingCreate.png" id="meetingCreate" /><br /><b>모임 개설하기</b>
                </a>
            </li>
            <li>
                <a href="roundCreate.do">
                    <img src="png/roundCreate.png" id="roundCreate" /><br /><b>라운드 개설하기</b> 
                </a>
            </li>
      </div>
      <div id="navmain">
        <li>
          <a href="home.do"
            ><img src="png/homeIcon.png" id="homeIcon" /><br />홈</a
          >
        </li>
        <li>
          <a href="search.do"
            ><img src="png/search.png" id="search" /><br />검색</a
          >
        </li>
        <li>
          <img src="png/mainAddBtn.png" id="Addbtn" />
        </li>
        <li>
          <a href="notice.do"><img src="png/bell.png" id="bell" /><br />알림</a>
        </li>
        <li>
          <a href="album.do"
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