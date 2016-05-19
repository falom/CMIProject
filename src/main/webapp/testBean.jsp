<%-- <jsp:useBean id="a" class="com.webapp.iamcmi.tester.TestBean" scope="session"></jsp:useBean>
 --%>
<%-- <jsp:useBean id="date" class="java.util.Date" /> 
<p>The date/time is <%= date %>

<jsp:useBean id="ttest" 
                    class="TestBean2"> 
   <jsp:setProperty name="ttest" property="message"
                    value="Test value"/>
</jsp:useBean> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Getting the Value of Bean</title>
</head>
<body bgcolor="#99CCFF">
    <jsp:useBean id="employee" class="com.webapp.iamcmi.tester.TestBean" />
    <div>
        <h2> Employee details is mentioned below</h2>
    </div>
    <jsp:getProperty name="employee" property="name" /><br>
    <jsp:getProperty name="employee" property="department" />
</body>
</html>
- See more at: http://www.javawebtutor.com/articles/jsp/jspusebean.html#sthash.lnMqPA06.dpuf