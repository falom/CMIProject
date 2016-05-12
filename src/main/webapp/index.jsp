<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IAMCMI - Home</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
<body>
<h2>Hello World! IAMCMI</h2>

<a href="<c:url value='/allpolicy.jsp' />"> Query Policy Information</a><br/>
<a href="<c:url value='/testConnection.jsp' />"> TestConnection</a><br/>
<a href="<c:url value='/queryRedbook.jsp' />"> Query Redbook</a><br/>
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>

</body>
</html>
