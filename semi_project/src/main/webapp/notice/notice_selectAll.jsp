<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/style.css">
</head>
<script src="../js/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		console.log("ready...");

		//let obj_dept_job_id ={dept_ids:[10,20,30,40,50,60], job_ids:['FI_MGR','FI_ACCOUNT','AC_ACCOUNT','AC_MGR']};

		/* $.get("../mymeeting_list.do", function(responseText) {
			console.log(".get:", responseText);
			let my_meeting_list = JSON.parse(responseText);
			console.log(".get:", my_meeting_list);
			my_meeting_list.forEach(function(my_meeting_list) {
				$("#my_meeting_list").append(my_meeting_list.get(0).name);
			});
		}); */

	});
</script>
</head>
<body>
	<div id="bg">

		<div class="container">
			<div class="row">
				<a class="title"> 나의 모임 </a>
				<table class="table" id="notice_selectAll">
					<c:choose>
						<c:when test="${vos.size() == 0}">
							<tr>
								<td>알림이 없어요~</td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach var="vo" items="${vos}">
								<c:choose>
									<c:when test="${fn:contains(vo.contents, '초대')}">
										<tr>
											<td>${vo.contents}<a
												href="meeting_enter.do?meeting_id=${vo.meeting_id}"><button>승인</button></a>
												<a href="alarm_deleteOK.do?notice_id=${vo.notice_id}"><button>거절</button></a></td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td>${vo.contents}<a
												href="alarm_deleteOK.do?notice_id=${vo.notice_id}"><button>삭제</button></a></td>
										</tr>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<script>
		
	</script>
</body>
</html>