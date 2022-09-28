<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project meetingboard</title>
<link rel="stylesheet" href="css/board.css" />
<script>
console.log("sessionStorage:",sessionStorage.board_id);
console.log("localStorage:",localStorage.user_name);
</script>
  </head>
  <body>
    <div id="bg">
      <div id="navup">
        <ul>
          <li><a href="h_home.do">액티비티</a></li>
          <li><a href="b_board.do">게시판</a></li>
          <li><a href="v_vote.do">투표</a></li>
          <li><a href="a_album.do">앨범</a></li>
        </ul>
      </div>

      <button id="boardInsert"><a href="b_write.do">게시글 등록</a></button>
      <br /><br /><br /><br />
      <div class="container">
        <div class="row">
          <table class="table">
            <c:forEach var="vo" items="${vos}">
            <th>
              <tr>
                <th id="board_id"><a href="b_view.do?board_id=${vo.board_id}">${vo.title}</a></th>
                <th class="hidden" id="notice">${vo.notice}</th>
              </tr>
            </th>
            <tbody>
              <tr>
                <td id="boardDay">${vo.wdate}</td>
                <td id="writer">${vo.writer}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
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
          <a href="a_album.do"
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