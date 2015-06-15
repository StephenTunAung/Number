<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<%@ page isELIgnored="false"%>
<link rel="icon"
	href="${pageContext.request.contextPath}/sources/images/favicon.ico">
</head>
<body onload="setFocus();">
	<c:url var="addAction" value="/auth/login"></c:url>
	<div
		style="background: #8f7a66; margin-left: 500px; margin-right: 600px; margin-top: 20px; text-align: center; font-weight: bold; font-size: xx-large;">Please
		Login</div>
	<form:form action="${addAction}" commandName="loginUser" method="post">
		<div
			style="background: #8f7a66; margin-left: 450px; margin-right: 550px; margin-top: 150px;">
			<table>
				<c:if test="${message!=null}">
					<tr>
						<td><font color="red">${message}</font></td>
					</tr>
				</c:if>
				<tr>
					<td><form:label path="email">
							<spring:message text="Email" />
						</form:label></td>
					<td><form:input path="email" size="40" /></td>
				</tr>
				<tr>
					<td><form:label path="password">
							<spring:message text="Password" />
						</form:label></td>
					<td><form:password path="password" size="40" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
				<tr>
					<td colspan="2"><a
						href="${pageContext.request.contextPath}/auth/asAnonymous">Login
							as Anonymous</a></td>
				</tr>
				<tr>
					<td colspan="2"><a
						href="${pageContext.request.contextPath}/app/showRegister">Register</a></td>
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