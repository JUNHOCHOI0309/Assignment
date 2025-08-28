<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-29
  Time: 오전 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String id = request.getParameter("id");
    String checker = request.getParameter("checker");
    Cookie cookie = new Cookie("id",id);
    cookie.setMaxAge(checker != null && checker.equals("on")? 604800 : 0);
    response.addCookie(cookie);
    response.sendRedirect("0828CookieLogin.jsp");
  %>
</body>
</html>
