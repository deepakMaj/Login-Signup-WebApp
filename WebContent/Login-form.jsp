<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, org.deepak.login.LoginDataServlet"%>
<!DOCTYPE html>
<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<meta charset="ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="Login.css">
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<form method="get" action="LoginDataServlet" autocomplete="off">
		<input type="hidden" name="command" value="login" />
		<div class="wrapper">
			<h2>LOGIN</h2>
			<input type="text" name="username" placeholder="Username" /><br /> <input
				type="password" name="password" placeholder="Password" /><br /> <input
				type="submit" value="LOGIN" /><br />
			<c:if test="${bool5}">
				<p>${message}</p>
			</c:if>
			<c:remove var="message" scope="session" />
			<a href="Sign-Up-Form.jsp">New User</a><br /> <a id="pass"
				href="Check-username.jsp">Forgot Password</a>
		</div>
	</form>
</body>
</html>