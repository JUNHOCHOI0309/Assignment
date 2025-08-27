<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:07
  signup Result Page / Dynamic
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>SignupResult - Mini Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <%
        request.setAttribute("active","signupResult");
    %>
    <%@ include file="common/top.jspf" %>

        <h2> 회원가입 결과 </h2>

        <table class="table table-bordered w-50">
            <tbody>
            <tr>
                <th>이름</th>
                <td><%= request.getParameter("name") != null ? request.getParameter("name") : "입력 없음" %></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><%= request.getParameter("email") != null ? request.getParameter("email") : "입력 없음" %></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><%= request.getParameter("pwd") != null ? "********" : "입력 없음" %></td>
            </tr>
            <tr>
                <th>약관 동의</th>
                <td><%= "yes".equals(request.getParameter("agree")) ? "동의함" : "동의하지 않음" %></td>
            </tr>
            </tbody>
        </table>

        <a href="signup.jsp" class="btn btn-secondary">다시 가입하기</a>

    <%@ include file="common/bottom.jspf" %>
</body>
</html>