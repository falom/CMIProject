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
	
	<s:form action="addAction" >
  <s:textfield name="name" label="Name" value="" />
  <s:textarea name="address" label="Address" value="" cols="50" rows="5" />
  <s:submit />
	</s:form>
	
	<s:if test="customerList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
		<th>Customer Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Created Date</th>
	</tr>
	<s:iterator value="vehicalRedbookList" status="userStatus">
		<tr>
			<td><s:property value="vehIDPK" /></td>
			<td><s:property value="vehMakeName" /></td>
			<td><s:property value="vehIDPK" /></td>
			<td><s:property value="vehMakeName" /></td>
		</tr>
	</s:iterator>
</table>
</s:if>

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
    				%><table width="600" border="1"></table><tr>
    				<td><%= rs.getString("VEH_MakeName") %></td>
    				<td><%= rs.getString("VEH_Model") %></td>
    				
    				</tr></table>
    				<%}
    			
    			
    			if(rs!=null) rs.close();
		if(s!=null) s.close();
		if(connection!=null) connection.close();
		}%>
	

</body>
</html>