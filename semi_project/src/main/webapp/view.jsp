<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project viewpage</title>
<link rel="stylesheet" href="css/board.css" />
</head>
<body>
	<div id="bg">

		<div class="container">
			<div class="row">
				<table>
					<%--  <c:forEach var="vo" items="${vos}">  --%>

						<thead>
							<tr>
								<th colspan="3">게시판 글 보기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="board_id"><label>글 번호</label></td>
								<td colspan="2">${vo2.board_id}</td>
							</tr>
							<tr>
								<td id="title"><label>제목</label></td>
								<td colspan="2">${vo2.title}</td>
							</tr>
							<tr>
								<td id="writer"><label>작성자</label></td>
								<td colspan="2">${vo2.writer}</td>
							</tr>
							<tr>
								<td id="wdate"><label>작성일자</label></td>
								<td colspan="2">${vo2.wdate}</td>
							</tr>
							<tr>
								<td id="contents"><label> 내용 </label></td>
								<td colspan="3" style="min-height: 200px">${vo2.contents}</td>
							</tr>
						</tbody>
					 <%-- </c:forEach>  --%>
				</table>
			</div>


		</div>
	</div>
</body>
</html>
