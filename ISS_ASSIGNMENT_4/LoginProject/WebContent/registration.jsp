<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		
		if(session.getAttribute("username")!=null){
			response.sendRedirect("welcome.jsp");
		}
	%>
	<form action="Register" method="post">
		Enter username : <input type="text" name="uname"><br/>
		Enter password : <input type="password" name="pass"><br/>
		<input type="submit" value="Register"><br/>
		<a href="login.jsp">Already have an account?Login here</a><br/>
	</form>
	<%
		String message = "";
		if(request.getAttribute("message")!=null)
			message = request.getAttribute("message").toString();
	%>
	${message}
</body>
</html>