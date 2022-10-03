<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>semi project main</title>
<link rel="stylesheet" href="css/main.css?after" />
<script src="js/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		console.log("ready...");

		$
				.get(
						"main_mymeeting_list.do",
						function(responseText) {
							console.log(".get:", responseText);
							let my_meeting_list = JSON.parse(responseText);
							console.log(".get:", my_meeting_list);
							my_meeting_list
									.forEach(function(my_meeting) {
										console.log(my_meeting.name)
										$("#my_meeting_list")
												.append(
														'<tr><td class="img_td"><a href="meeting_selectOne.do?meeting_id='
																+ my_meeting.meeting_id
																+ '"> <img class="img_round" width="65px" alt="'+my_meeting.image_url+'" src="upload/'+my_meeting.image_url+'">'
																+ '</a></td> <td><a class="lists" href="meeting_selectOne.do?meeting_id='
																+ my_meeting.meeting_id
																+ '"</a>'
																+ my_meeting.name
																+ '</td></tr>');
									});
						});
		$
				.get(
						"myrounding_list.do",
						function(responseText) {
							console.log(".get:", responseText);
							let my_round_list = JSON.parse(responseText);
							console.log(".get:", my_round_list);
							my_round_list
									.forEach(function(my_round) {
										console.log(my_round.name);
										$("#my_round_list")
												.append(
														'<tr><td class="img_td"><a href="round_selectOne.do?round_id='
																+ my_round.round_id
																+ '"> <img class="img_round_orange" width="65px" alt="'+my_round.image_url+'" src="upload/'+my_round.image_url+'">'
																+ '</a></td> <td><a class="lists" href="round_selectOne.do?round_id='
																+ my_round.round_id
																+ '"</a>'
																+ my_round.name
																+ '</td></tr>');
									});
						});

		$(".btn_recommend_activity").each(function() {
			$(this).on("click", function() {
				console.log($(this).val());
				rec_activity($(this).val());
			});
		});

		function rec_activity(x) {
			$("#recommend_activity").empty();
			$
					.get(
							"recommend_activity_selectAll.do?category=" + x,
							function(responseText) {
								console.log(".get:", responseText);
								let recommend_activity_list = JSON
										.parse(responseText);
								console.log(".get:", recommend_activity_list);
								recommend_activity_list
										.forEach(function(recommend_activity) {
											console
													.log(recommend_activity.name);
											$("#recommend_activity")
													.append(
															'<table class="table_margin"><tr><td class="img_td" rowspan="5">'
																	+ '<a href="activity_selectOne.do?activity_id='
																	+ recommend_activity.activity_id
																	+ '">'
																	+ '<img class="img_square" width="65px" alt="'+recommend_activity.image_url+'" src="upload/'+recommend_activity.image_url+'">'
																	+ '</a></td>'
																	+ '<td><a class="lists" href="activity_selectOne.do?activity_id='
																	+ recommend_activity.activity_id
																	+ '">'
																	+ recommend_activity.name
																	+ '</a></td></tr>'
																	+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																	+ recommend_activity.activity_id
																	+ '">'
																	+ recommend_activity.activity_date
																	+ " "
																	+ recommend_activity.activity_time
																	+ '</a></td></tr>'
																	+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																	+ recommend_activity.activity_id
																	+ '">'
																	+ recommend_activity.location
																	+ '</a></td></tr>'
																	+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																	+ recommend_activity.activity_id
																	+ '">'
																	+ recommend_activity.current_people
																	+ "명 참여중"
																	+ '</a></td></tr></table>');
										});
							});
		}

		$
				.get(
						"imminent_activity_selectAll.do",
						function(responseText) {
							console.log(".get:", responseText);
							let imminent_activity_list = JSON
									.parse(responseText);
							console.log(".get:", imminent_activity_list);
							imminent_activity_list
									.forEach(function(imminent_activity) {
										console.log(imminent_activity.name);
										$("#imminent_activity")
												.append(
														'<table class="table_margin"><tr><td class="img_td" rowspan="5">'
																+ '<a href="activity_selectOne.do?activity_id='
																+ imminent_activity.activity_id
																+ '">'
																+ '<img class="img_square" width="65px" alt="'+imminent_activity.image_url+'" src="upload/'+imminent_activity.image_url+'">'
																+ '</a></td>'
																+ '<td><a class="lists" href="activity_selectOne.do?activity_id='
																+ imminent_activity.activity_id
																+ '">'
																+ imminent_activity.name
																+ '</a></td></tr>'
																+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																+ imminent_activity.activity_id
																+ '">'
																+ imminent_activity.activity_date
																+ " "
																+ imminent_activity.activity_time
																+ '</a></td></tr>'
																+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																+ imminent_activity.activity_id
																+ '">'
																+ imminent_activity.location
																+ '</a></td></tr>'
																+ '<tr><td><a class="list" href="activity_selectOne.do?activity_id='
																+ imminent_activity.activity_id
																+ '">'
																+ imminent_activity.current_people
																+ "명 참여중"
																+ '</a></td></tr></table>');
									});
						});
		$
				.get(
						"recommend_meeting_selectAll.do",
						function(responseText) {
							console.log(".get:", responseText);
							let recommend_activity_list = JSON
									.parse(responseText);
							console.log(".get:", recommend_activity_list);
							recommend_activity_list
									.forEach(function(recommend_meeting) {
										console.log(recommend_meeting.name);
										$("#recommend_meeting")
												.append(
														'<table class="table_float"><tr><td class="img_td2"><a href="meeting_selectOne.do?meeting_id='
																+ recommend_meeting.meeting_id
																+ '">'
																+ '<img class="img_round td_center" width="65px" alt="'+recommend_meeting.image_url+'" src="upload/'+recommend_meeting.image_url+'">'
																+ '</a></td></tr>'
																+ '<tr><td><a class="total"href="meeting_selectOne.do?meeting_id='
																+ recommend_meeting.meeting_id
																+ '">'
																+ recommend_meeting.name
																+ '</a></td>'
																+ '</tr></table>');
									});
						});

	});
	sessionStorage.member_id = '${member_id}';
	console.log(sessionStorage.member_id);
</script>
</head>
<body>
	<div id="bg">
		<div id="nav">
			<img src="png/golfzonlogo.png" id="logo" />
		</div>

		<div class="container">
			<img src="png/main_event.png" id="main_event" />
			<table>
				<thead>
					<tr>
						<td class="title">나의 모임</td>
					</tr>
				</thead>
				<tbody id="my_meeting_list">
				</tbody>
			</table>

			<hr class="line">

			<table>
				<thead>
					<tr>
						<td class="title">나의 라운드</td>
					</tr>
				</thead>
				<tbody>
					<tr id="my_round_list">
				</tbody>
			</table>

			<table style="width: 95%;">
				<thead>
					<tr>
						<td class="title">추천 액티비티</td>
						<td class="total" style="cursor: pointer;" align=right
							valign=bottom
							onclick="location.href='main_activity_selectAll.do'">전체보기 ></td>
					</tr>
				</thead>
			</table>
			<div class="middle-button">
				<button class="btn_recommend_activity" value="또래끼리">또래끼리</button>
				<button class="btn_recommend_activity" value="성별끼리">성별끼리</button>
				<button class="btn_recommend_activity" value="실력이 비슷한">실력이
					비슷한</button>
				<button class="btn_recommend_activity" value="내 근처의">내 근처의</button>
			</div>
			<div id="recommend_activity"></div>

			<table>
				<thead>
					<tr>
						<td class="title">마감임박 액티비티</td>
					</tr>
				</thead>
			</table>
			<table id="imminent_activity"></table>

			<table style="width: 95%;">
				<thead>
					<tr>
						<td class="title">추천 모임</td>
						<td class="total" style="cursor: pointer;" align=right
							valign=bottom onclick="location.href='main_meeting_selectAll.do'">전체보기
							></td>
					</tr>
				</thead>
			</table>

			<div id="recommend_meeting"></div>


		</div>

		<jsp:include page="default.jsp"></jsp:include>
	</div>
</body>


</html>