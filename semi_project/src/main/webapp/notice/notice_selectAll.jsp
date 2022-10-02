<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>

<link rel="stylesheet" href="css/alarm.css">
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
		<a href="javascript:window.history.back();"><button class ="backBtn"><</button></a>
		<h2>알림</h2>
		<hr>
		<table class="table" id="notice_selectAll">
			<c:choose>
				<c:when test="${vos.size() == 0}">
					<tr>
					<img src="png/noAlarm.png" id="noAlarm"/><br><br><br><br><br><br><br><br><br>
						<td> <b>새로운 알림이 없습니다</b></td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach var="vo" items="${vos}">
						<c:choose>
							<c:when test="${fn:contains(vo.contents, '초대')}">
								<tr>
									<td>${vo.contents}<a class="content"
										href="meeting_enter.do?meeting_id=${vo.meeting_id}"><button>승인</button></a>
										<a href="alarm_deleteOK.do?notice_id=${vo.notice_id}"><button>거절</button></a>
										<br><br><hr></td>
								
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${vo.contents}<a class="content"
										href="alarm_deleteOK.do?notice_id=${vo.notice_id}"><button>🗑</button></a>
										<br><br><hr></td>
								
								</tr>

							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>

	</div>
<script>
const images = [ "prof1.png", "prof2.png", "prof3.png" ];
const body = document.querySelectorAll(".content");
const IMG_NUMBER = images.length;

const chosenImg = images[Math.floor(Math.random()
								* images.length)];

function chaPho(IMG_NUMBER) {
		for(i=0;i<body.length;i++){
		let image = new Image();
		image.src = 'png/' + chosenImg;
		image.classList.add("profImg");
		body[i].appendChild(image);
		}
	}

function inti() {
		chaPho(Math.floor(Math.random() * images.length));
		}
inti();
</script>
</body>
</html>