<%@ page import="com.webapp.iamcmi.tester.*, java.util.*, java.io.*" %>
<%-- <jsp:useBean id="a" class="com.webapp.iamcmi.tester.TestBean" scope="session"></jsp:useBean>
 --%>
 <%
 com.webapp.iamcmi.tester.TestBean test = new com.webapp.iamcmi.tester.TestBean();
out.println(test);
%>