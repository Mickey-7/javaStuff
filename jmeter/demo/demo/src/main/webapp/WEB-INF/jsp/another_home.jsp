<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>ANOTHER HOME</h2>
	<a href="<%=request.getContextPath()%>/home">Add</a>
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
                </table>
        </c:when>
            <c:otherwise>
            No User found in the DB!
            </c:otherwise>
    </c:choose>
</body>
</html>