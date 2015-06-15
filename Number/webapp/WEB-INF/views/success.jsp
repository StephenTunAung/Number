<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
<%@ page isELIgnored="false"%>
<link rel="icon"
	href="${pageContext.request.contextPath}/sources/images/favicon.ico">
</head>
<body onload="setFocus();">
	<c:url var="addAction" value="/auth/login"></c:url>
	<div
		style="background: #8f7a66; margin-left: 500px; margin-right: 600px; margin-top: 20px; text-align: center; font-weight: bold; font-size: xx-large;">Registration completed</div>
	<form:form action="${addAction}" commandName="loginUser" method="post">
		<div
			style="background: #8f7a66; margin-left: 500px; margin-right: 600px; margin-top: 150px;">
			<table>
				<tr>
					<td>Your account has been successfully registered.</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>"${userInfo.userName}"</td>
				</tr>
								<tr>
					<td>Email</td>
					<td>"${userInfo.email}"</td>
				</tr>
				<tr>
					<td colspan="2"><a
						href="${pageContext.request.contextPath}/auth/showLoginPage">Login
							here</a></td>
				</tr>
				<tr>
					<td colspan="2"><a
						href="${pageContext.request.contextPath}/auth/asAnonymous">Login
							as Anonymous</a></td>
				</tr>
				<tr>
					<td colspan="2"><a href="${pageContext.request.contextPath}/app/showRegister">Register here</a></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
<script type="text/javascript">
	function setFocus() {
		document.getElementById("email").focus();
	}
</script>
</html>