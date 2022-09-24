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
console.log("sessionStorage:",sessionStorage.user_id);
console.log("localStorage:",localStorage.user_name);
</script>
  </head>
  <body>
    <div id="bg">
    
      <div class="container">
        <div class="row">
        
        <form method="post" action="writeOK.do">
          <table class="table">
            <th>
              <tr>
            <input type="submit" class="btn" value="글쓰기완료">
                <th colspan ="2" id="title">게시판 양식</th>
              </tr>
            </th>
            <tbody>
             
              <tr>
                <td id="writetitle"><input type="text" placeholder="글제목"name="title"maxlength="50"></td>
              </tr>
              <tr>
                <td id="contents"><textarea  placeholder="글내용"name="contents"maxlength="500"></textarea></td>
              </tr>
              <tr>
                <td id="writer"><input type="text" placeholder="작성자"name="writer"maxlength="12"></td>
              </tr>
              <select name="notice" id="notice">
          <option placeholder="false">비공지</option>
          <option placeholder="false">공지</option>
          
            </tbody>
          </table>
        </div>
        </form>
        
      </div>

      
    </div>
    </div>
  </body>
</html>
