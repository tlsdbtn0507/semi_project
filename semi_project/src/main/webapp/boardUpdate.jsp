<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project meetingboard</title>
<link rel="stylesheet" href="css/board.css" />
<script>
	console.log("sessionStorage:", sessionStorage.user_id);
	console.log("localStorage:", localStorage.user_name);
</script>
</head>
<body>
	<div id="bg">

		<div class="container">
			<div class="row">

				<form method="post" action="boardUpdateOK.do">
					<table class="table">
						<th>
						<tr>
							<input type="submit" class="btn" value="글 수정완료">
							<th colspan="2" id="title">게시판 수정</th>
						</tr>
						</th>
						<tbody>
							<tr>
								<td><label for="board_id">글번호:</label></td>
								<td>${param.board_id}<input type="hidden" id="board_id"
									name="board_id" value="${param.board_id}"></td>
							</tr>
							<tr>
								<td id="writetitle"><input type="text" placeholder="글제목"
									name="title" maxlength="50" value="${vo2.title}"></td>
							</tr>
							<tr>
								<td id="contents"><textarea placeholder="글내용"
										name="contents" maxlength="500">
                ${vo2.contents}</textarea></td>
							</tr>
							<tr>
								<td id="writer"><input type="text" placeholder="작성자"
									name="writer" maxlength="12"> ${vo2.writer}</td>
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
