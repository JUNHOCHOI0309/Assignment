<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-29
  Time: 오전 12:04
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
    String pw = request.getParameter("pass");
    if(id.equals("user") && pw.equals("1234")){
      request.getSession().setAttribute("id", id);
      request.getSession().setMaxInactiveInterval(60);
      response.sendRedirect("0828me.jsp");
    }else {
      response.sendRedirect("0828Login.jsp");
    }
  %>

</body>
</html>
