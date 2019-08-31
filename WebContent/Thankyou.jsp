<html>
<head>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<title>Thank-You</title>
<link type="text/css" rel="stylesheet" href="Thankyou.css">
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<div class="wrapper">
		<marquee direction="right" behavior="alternate">!!!Webapp
			created by Deepak Mahajan!!!</marquee>
		<h2>THANKYOU</h2>
	</div>
	<div class="container">
		<form method="get" action="LoginDataServlet">
			<input type="hidden" name="command" value="thanks" /> <input
				type="submit" value="Logout" />
		</form>
	</div>
</body>
</html>