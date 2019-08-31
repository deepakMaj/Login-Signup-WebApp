<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, org.deepak.login.LoginDataServlet"%>
<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link type="text/css" rel="stylesheet" href="SignUp.css">
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<h2>Welcome to Deep Technology</h2>
	<form method="get" action="LoginDataServlet" autocomplete="off">
		<div class="wrapper">
			<input type="hidden" name="command" value="update" /> <input
				type="text" name="user" placeholder="Username" /><br />
			<c:if test="${bool1}">
				<p>${username}</p>
			</c:if>
			<c:remove var="username" scope="session" />
			<input type="text" name="pass" placeholder="Password" /><br />
			<c:if test="${bool2}">
				<p>${password}</p>
			</c:if>
			<c:remove var="password" scope="session" />
			<input type="text" name="email" placeholder="Email" /><br />
			<c:if test="${bool3}">
				<p>${email}</p>
			</c:if>
			<c:remove var="email" scope="session" />
			<input type="submit" value="Sign-Up" /><br />
			<c:if test="${bool4}">
				<p>${success}</p>
			</c:if>
			<c:remove var="success" scope="session" />
			<a href="Login-form.jsp">Back to Login Page</a>
		</div>
	</form>
</body>
</html>