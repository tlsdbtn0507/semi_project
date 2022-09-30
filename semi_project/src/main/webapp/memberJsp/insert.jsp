<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/signupstyle.css?after" />
<title>semi project signup</title>
</head>
<body>
<body>
      <div>
        <h2>회원가입(SignUp)</h2>
        <form action="insertOK.do" method="post" enctype="multipart/form-data">
        <section>
        <input class="check" type="text" name="nick" id="nick" placeholder="닉네임을 입력하세요" /><button id="btn_nickCheck">중복확인</button><br>
        <input class="check" type="text" name="id" id="id" placeholder="아이디를 입력하세요" /><button id="btn_idCheck">중복확인</button>
        <br><br><br><br><br>
        <p><b> 아이디:영문과 숫자,일부 특수문자(._-)사용가능,2~10자 길이</b></p>
        
    </section>
    <input id="pw" type="password" name="pw" value=""  placeholder="비밀번호를 입력하세요">
    <br><br><br>
    <p ><b> 비밀번호:영문과 숫자 필수 포함, 특수문자 사용가능, 8자 길이</b></p>
    <input id="pwc" type="password" name="pwc" value=""  placeholder="비밀번호를 확인해주세요">        
    <input  type="text" name="age" id="age" value=""  placeholder="나이를 입력해주세요">
    <input  type="text" name="golfAvgCheck" id="golfAvgCheck" value=""  placeholder="평균 타수를 입력해주세요">
        
        <br><br><br><br><br><br><br><br><br>
        <br><br><br><label for="loc">지역을 선택해주세요:</label>
        <select name="loc" id="loc">
            <option placeholder="서울">서울</option>
            <option placeholder="경기">경기</option>
            <option placeholder="인천">인천</option>
            <option placeholder="강원">강원</option>
            <option placeholder="충북">충북</option>
            <option placeholder="충남">충남</option>
            <option placeholder="전북">전북</option>
            <option placeholder="전남">전남</option>
            <option placeholder="경북">경북</option>
            <option placeholder="경남">경남</option>
            <option placeholder="제주">제주</option>
        </select>
        <br><br><br><label for="loc">성별을 선택해주세요:</label>
        <select name="gender" id="gender">
          <option placeholder="남자">남자</option>
          <option placeholder="여자">여자</option>
        </select>
        <button type="submit" id="insert">가입완료</button>
       
        
      </form>
      </body>
      <script src="insert.js"></script>
</body>
</html>