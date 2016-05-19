<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%-- <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
java.sql.Connection con;
java.sql.Statement s;
java.sql.ResultSet rs;
java.sql.PreparedStatement pst;

 %>
<html>
<head>
<title>Connection with mysql database</title>
</head>
<body>
	<h1>Connection status</h1>
	<% 

    String connectionURL = "jdbc:mysql://localhost:8889/IAMCMIDB";
    Connection connection = null; 
    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
    connection = DriverManager.getConnection(connectionURL, "root", "root");
    if(!connection.isClosed()){
    	%><p>Connect database successfully!!</p><%
    }
    else
    {
    	%><p>Connection failed!!</p><%
    }%>
</body>
</html>