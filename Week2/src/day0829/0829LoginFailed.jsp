<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-30
  Time: 오전 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String error = (String) session.getAttribute("loginFailed");
    if(error != null){
        %>
<p style="color:red;"><%= error%></p>
<%
        session.removeAttribute("loginFailed");
    }
%>
<a href="0829Login.jsp">로그인페이지로 돌아가기</a>
</body>
</html>
