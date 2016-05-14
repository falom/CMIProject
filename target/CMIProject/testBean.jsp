<jsp:useBean id="ttest" class="com.webapp.iamcmi.tester.TestConnection"></jsp:useBean>
<jsp:setProperty name="ttest" property="message" value="Hello JSP..." />
<jsp:getProperty name="ttest" property="message" />

<jsp:setProperty name="ttest" property="tableName" value="VehicalRedbook" />
<jsp:setProperty name="ttest" property="columnDesc" value="VEH_MakeName" />

<jsp:getProperty name="ttest" property="tableName" />
<jsp:getProperty name="ttest" property="columnDesc" />

