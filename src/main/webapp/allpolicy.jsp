<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IAMCMI - Query Policy Information</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Policy</h2>  
    <table>
        <tr>
            <td>NAME</td>
            <td>Joining Date</td>
            <td>Salary</td>
            <td>SSN</td>
        </tr>
        <c:forEach items="${policy}" var="policy">
            <tr>
            <td>${policy.id}</td>
            <td>?</td>
            <td>?</td>
            <td>?</td>
            </tr>
        </c:forEach>
        
    </table>
    <br/>
    <a href="<c:url value='/index.jsp' />">Home</a>
</body>
</html>