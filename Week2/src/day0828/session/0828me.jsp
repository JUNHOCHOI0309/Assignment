<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String id = (String) request.getSession().getAttribute("id");
%>
<h1><%=id%> 님 환영</h1>
<br>
<a href="0828logout.jsp" class="btnLogout"><img src="../../img/common/btn_logout.gif"  alt="로그아웃" /></a>
</body>
</html>