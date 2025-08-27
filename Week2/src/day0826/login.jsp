<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:07
  login page / static
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login - Mini Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <%
        request.setAttribute("active","login");
    %>
    <%@ include file="common/top.jspf" %>
    <h2> 로그인 </h2>

    <form class="needs-validation" novalidate action="#" method="post" style="max-width: 400px;">
        <div class="mb-3">
            <label for="email" class="form-label">이메일 주소</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
            <div class="invalid-feedback">
                올바른 이메일을 입력해주세요.
            </div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요" minlength="6" required>
            <div class="invalid-feedback">
                비밀번호는 최소 6자리여야 합니다.
            </div>
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="remember" name="remember">
            <label class="form-check-label" for="remember">로그인 상태 유지</label>
        </div>

        <button type="submit" class="btn btn-primary w-100">로그인</button>
    </form>

    <script>
        // Bootstrap 5 폼 검증 예제
        (() => {
            'use strict'
            const forms = document.querySelectorAll('.needs-validation')
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
        })()
    </script>

    <%@ include file="common/bottom.jspf" %>
</body>
</html>