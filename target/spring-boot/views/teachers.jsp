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
	<c:choose>
		<c:when test="${teachers != null}">
			<h3>List of Teachers</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Expertise</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${teachers}">
						<tr>
							<td>${t.id}</td>
							<td>${t.name}</td>
							<td>${t.expertise}</td>
							<td><a
								href="<%=request.getContextPath()%>/teacher/${t.id}">View</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/update/teacher/${t.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/teacher/${t.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
					
					
					
				</tbody>
				
				
				
			</table>
			<table>
			<tr> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a 	href="<%=request.getContextPath()%>/addTeacher"> <b>Add</b></a>
								&nbsp; 
					</tr>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>