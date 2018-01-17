<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Spring Boot Example</title>
<body>
	<h2>Spring Boot Example</h2>
	Id : ${teacher.id}
	<br /> Name : ${teacher.name}
	<br /> Expertise : ${teacher.expertise}
	<br />  <a 	href="<%=request.getContextPath()%>/logout"> <b>Logout</b></a>
			<a 	href="<%=request.getContextPath()%>/teachers"> <b>Back</b></a>
					
</body>
</html>