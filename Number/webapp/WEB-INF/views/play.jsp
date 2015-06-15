<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>2048</title>
<link href="${pageContext.request.contextPath}/sources/style/main.css"
	rel="stylesheet" type="text/css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/sources/images/favicon.ico">
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/sources/meta/apple-touch-icon.png">
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath}/sources/meta/apple-touch-startup-image-640x1096.png"
	media="(device-width: 320px) and (device-height: 568px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPhone 5+ -->
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath}/sources/meta/apple-touch-startup-image-640x920.png"
	media="(device-width: 320px) and (device-height: 480px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPhone, retina -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport"
	content="width=device-width, target-densitydpi=160dpi, initial-scale=1.0, maximum-scale=1, user-scalable=no, minimal-ui">
</head>
<script>
	var userId = ${userInfo.userId};
	function deleteCookies() {	
		alert(getCookie("JSESSIONID"));
		if(getCookie("JSESSIONID")) {
			createCookie("JSESSIONID", "", -1, "localhost", "localhost");
		}

				
		    //var re = new RegExp('JSESSIONID' + "=([^;]+)");
		   		  
	}
</script>
<body onload="deleteCookies()">
	<div style="width: 400px; float: left;">
		<table>
			<tr>
				<td>Game history</td>
			</tr>
			<tr>
				<td>Gamer Name</td>
				<td>Last Score</td>
				<td>Best Score</td>
			</tr>
			<tr>
				<td><font color="blue">${userInfo.userName}</font></td>
				<td>${userInfo.lastScore}</td>
				<td>${userInfo.bestScore}</td>
			</tr>
						<tr>
				<td>-----</td>
				<td>-----</td>
				<td>-----</td>
			</tr>
			<tr>
				<td>Top 10 Scorers</td>
			</tr>
			<tr><td>Gamer Name</td>
			<td>Best Score</td>
			<c:forEach items="${topScorers}" var="top">
				<tr>
					<td>${top.userName}</td>
					<td>${top.bestScore}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<div style="float: right; margin-right: 50px;"><a href="${pageContext.request.contextPath}/auth/logout">Logout</a></div>
	<div class="container">
		<div class="heading">
			<h1 class="title">2048</h1>
			<div class="scores-container">
				<div class="score-container">0</div>
				<div class="best-container">0</div>
			</div>
		</div>

		<div class="above-game">
			<p class="game-intro">
				Join the numbers and get to the <strong>2048 tile!</strong>
			</p>
			<a class="restart-button">New Game</a>
		</div>

		<div class="game-container">
			<div class="game-message">
				<p></p>
				<div class="lower">
					<a class="keep-playing-button">Keep going</a> <a
						class="retry-button">Try again</a>
				</div>
			</div>

			<div class="grid-container">
				<div class="grid-row">
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
				</div>
				<div class="grid-row">
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
				</div>
				<div class="grid-row">
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
				</div>
				<div class="grid-row">
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
					<div class="grid-cell"></div>
				</div>
			</div>

			<div class="tile-container"></div>
		</div>

		<p class="game-explanation">
			<strong class="important">How to play:</strong> Use your <strong>arrow
				keys</strong> to move the tiles. When two tiles with the same number touch,
			they <strong>merge into one!</strong>
		</p>
		<hr>
		<p>
			<strong class="important">Note:</strong> This site is the official
			version of 2048. You can play it on your phone via <a
				href="http://git.io/2048">http://git.io/2048.</a> All other apps or
			sites are derivatives or fakes, and should be used with caution.
		</p>
		<hr>
		<p>
			Created by <a href="http://gabrielecirulli.com" target="_blank">Gabriele
				Cirulli.</a> Based on <a
				href="https://itunes.apple.com/us/app/1024!/id823499224"
				target="_blank">1024 by Veewo Studio</a> and conceptually similar to
			<a href="http://asherv.com/threes/" target="_blank">Threes by
				Asher Vollmer.</a>
		</p>
	</div>

	<script
		src="${pageContext.request.contextPath}/sources/js/bind_polyfill.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/classlist_polyfill.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/animframe_polyfill.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/keyboard_input_manager.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/html_actuator.js"></script>
	<script src="${pageContext.request.contextPath}/sources/js/grid.js"></script>
	<script src="${pageContext.request.contextPath}/sources/js/tile.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/local_storage_manager.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/game_manager.js"></script>
	<script
		src="${pageContext.request.contextPath}/sources/js/application.js"></script>
</body>
</html>