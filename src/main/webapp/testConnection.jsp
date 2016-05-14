<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
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
        		String sql = "select * from VehicalRedbook";
    			
    			s = connection.createStatement();
    			rs = s.executeQuery(sql);
    			while( rs.next() ){
    				%><table width="600" border="1"></table>
    				<tr>
    				<td><%= rs.getString("VEH_MakeName") %></td>
    				<td><%= rs.getString("VEH_Model") %></td>
    				
    				</tr>
    				</table>
    				<%}
    			
    			
    			if(rs!=null) rs.close();
		if(s!=null) s.close();
		if(connection!=null) connection.close();
		}%>
</body>
</html>