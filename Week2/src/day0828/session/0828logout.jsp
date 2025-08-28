<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-28
  Time: 오후 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.invalidate();//세션이 무효화...
        response.sendRedirect("0828Login.jsp");
    %>
</body>
</html>
