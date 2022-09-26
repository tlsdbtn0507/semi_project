<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project login</title>
<link rel="stylesheet" href="css/style.css"></head>
<body>
<body>
      <div>
        <h1><img src="png/golfzon.png" alt="" /></h1>
        <form id="login"action="loginOK.do" method="post">
          <input type="text" name="member_name" placeholder="아이디" />
          <input type="password" name="password" placeholder="비밀번호" />
          <button id="loginBtn">로그인</button>
          <br />
          <span>아이디가 없으신가요? <a href="insert.jsp">회원가입</a></span>
          </form>
      </div>
    </body>
</body>
</html>