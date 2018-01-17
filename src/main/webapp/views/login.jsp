<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot Example</title>
<body>
	<h2>Spring Boot Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Login User</h3>
	<form 
		action="<%=request.getContextPath()%>/loginuser">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		Password: <input name="password" value="${password}" type="password" />
		<br /> <br />
		<input value="Login" type="submit" />
	</form>
</body>
</html>