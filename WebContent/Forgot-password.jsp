<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, org.deepak.login.LoginDataServlet"%>
<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<title>Forgot Password</title>
<link type="text/css" rel="stylesheet" href="Forgot-password.css">
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<form action="LoginDataServlet" method="get" autocomplete="off">
		<input type="hidden" name="command" value="forgot" /> 
		<div class="wrapper">
			<label id="enter">Enter Password : </label><input type="text" name="password1" id="pass1"/><br /> 
			<label>Re-enter Password : </label><input type="text" name="password2" id="pass2"/><br />
			<c:if test="${bool8}">
				<p>${message2}</p>
			</c:if>
			<c:remove var="message2" scope="session" />
			<c:if test="${bool7}">
				<p>${warning2}</p>
			</c:if>
			<c:if test="${bool6}">
				<p>${warning1}</p>
			</c:if>
			<c:remove var="warning1" scope="session" />
			<c:remove var="warning2" scope="session" />
			<input type="submit" name="submit2" value="Submit" /><br />
			<a	href="Login-form.jsp">Back to Login page</a>
		</div>
	</form>
</body>
</html>