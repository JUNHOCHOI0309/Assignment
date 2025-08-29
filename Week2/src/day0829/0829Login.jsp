<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-29
  Time: 오후 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/login.assign">
  <label for="userId">아이디:</label>
  <input type="text" id='userId' name='id' class="form-control" required />

  <label for="userPw">비밀번호</label>
  <input type="password" id="userPw" name="pw" class="form-control" required />

  <button type="submit" class="btn btn-primary">로그인</button>
</form>
</body>
</html>
