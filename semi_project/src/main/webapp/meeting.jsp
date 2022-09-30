<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project meeting</title>
<link rel="stylesheet" href="css/board.css" />
<script>
console.log("sessionStorage:",sessionStorage.user_id);
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
  </body>
</html>