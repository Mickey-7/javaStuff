<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:url value="${pageContext.request.contextPath}/resources/style/hello.css" var="jstlCss"/>
<link rel="stylesheet" href="${jstlCss}"></link>


</head>
<body>
     <h2 class="colorRed">Hello </h2>
     <h3 class="colorBlue"> ${message} </h3>

     <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Action</th>
                <th>Timer</th>
            </tr>
        </thead>
        <tbody id="start">
        </tbody>
     </table>

     <h1 class="colorRed">here</h1>



    <script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>

    <c:url value="${pageContext.request.contextPath}/resources/js/hello.js" var="jstlJS"/>
    <script type="text/javascript" src="${jstlJS}"></script>



</body>
</html>