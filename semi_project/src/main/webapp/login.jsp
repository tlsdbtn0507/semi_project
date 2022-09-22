<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project login</title>
<link rel="stylesheet" href="style.css"></head>
<body>
<body>
      <div>
        <h1><img src="golfzon.png" alt="" /></h1>
        <form id="login"action="loginOk.do" method="post">
          <input type="text" name="userID" placeholder="아이디" />
          <input type="password" name="userPW" placeholder="비밀번호" />
          <button id="loginBtn">로그인</button>
          <br />
          <span>아이디가 없으신가요? <a href="insert.jsp">회원가입</a></span>
          </form>
      </div>
    </body>
</body>
</html>