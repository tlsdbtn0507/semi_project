<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="test.com.board.BoardVO"%>
<%@page import="test.com.board.BoardDAOimpl"%>
<%@page import="test.com.board.BoardUpdateController"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>semi project viewpage</title>
    <link rel="stylesheet" href="css/view.css" />
  </head>
  <body>
  <% String userId = null;
  if(session.getAttribute("member_id")!= null){
	  userId = (String)session.getAttribute("member_id");
  }
  %>
    <div id="bg">
      <div class="container">
        <div class="row">
          <table>
            <th>
              <tr>
                <td colspan="2" id="title">게시판</td>
                <input type="button" class="backBtn" value="<">
              </tr>
            </th>
          </table>
          <hr />
          <p id="writer" colspan="2">
            ${vo2.writer}

<%-- 			<%
			if(userId !=null && userId==${vo2.member_id}){
				
			}
			%> --%>
            <button>
              <a href="boardUpdate.do?board_id=${param.board_id}">📝</a>
            </button>
            <button>
              <a href="boardDelete.do?board_id=${param.board_id}">🗑️</a>
            </button>
          </p>

          <p id="wdate" colspan="2">${vo2.wdate}</p>
          <hr />
          <p id="title" colspan="2">${vo2.title}</p>
          <p id="contents" colspan="3" style="min-height: 200px">
            ${vo2.contents}
          </p>
        </div>
      </div>
    </div>
    <script>
      console.log("sessionStorage:", sessionStorage.user_id);
      console.log("localStorage:", localStorage.user_name);

      const images = ["prof1.png", "prof2.png", "prof3.png"];
      const body = document.querySelector("#writer");

      const IMG_NUMBER = images.length;

      const chosenImg = images[Math.floor(Math.random() * images.length)];

      function chaPho(IMG_NUMBER) {
        const image = new Image();
        image.src = 'png/'+chosenImg;
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