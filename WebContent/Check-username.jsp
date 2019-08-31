<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, org.deepak.login.LoginDataServlet"%>
<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<title>Check-Username</title>
<link type="text/css" rel="stylesheet" href="Check-username.css">
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
		<form method="get" action="LoginDataServlet" autocomplete="off">
			<input type="hidden" name="command" value="check" /> 
		<div class="container">	
			<label>Enter Username : </label><input type="text" name="username" /><br />
			<c:if test="${bool9}">
				<p>${warning}</p>
			</c:if>
			<c:remove var="warning" scope="session" />
			<input type="submit" name="submit1" value="Submit" /><br/>
			<a href="Login-form.jsp">Back to Login Page</a>
			</div>
		</form>
</body>
</html>