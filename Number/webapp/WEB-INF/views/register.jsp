<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Register here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page isELIgnored="false"%>
<link rel="icon"
	href="${pageContext.request.contextPath}/sources/images/favicon.ico">
</head>
<body onload="setFocus();">
	<c:url var="addAction" value="/app/register"></c:url>
	<div style="background: #8f7a66; margin-left: 500px; margin-right: 600px; margin-top: 20px;text-align:center; font-weight:bold; font-size: xx-large; ">Register Login</div>
	<form:form action="${addAction}" commandName="userInfo" method="post">
	<div style="background: #8f7a66; margin-left: 500px; margin-right: 600px; margin-top: 150px;">
		<table>
					<tr>
				<td><form:label path="userName">
						<spring:message text="User Name" />
					</form:label></td>
				<td><form:input path="userName" size="40" /></td>
			</tr>
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
				<td><form:password path="password" size="40"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
			<tr>
					<td colspan="2"><a
						href="${pageContext.request.contextPath}/auth/showLoginPage">Login
							here</a></td></tr>
			<tr><td colspan="2"><a href="${pageContext.request.contextPath}/auth/asAnonymous">Login as Anonymous</a></td></tr>
		</table>
		</div>
	</form:form>
</body>
<script type="text/javascript">
	function setFocus() {
		document.getElementById("userName").focus();
	}
</script>
</html>