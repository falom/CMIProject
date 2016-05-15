<jsp:useBean id="ttest" class="com.webapp.iamcmi.tester.TestConnection"></jsp:useBean>
<jsp:setProperty name="ttest" property="message" value="Hello JSP..." />
<jsp:getProperty name="ttest" property="message" />