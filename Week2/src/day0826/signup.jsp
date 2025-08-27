<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:07
  signup page / Dynamic
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Signup - Mini Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <%
        request.setAttribute("active","signup");
    %>
    <%@ include file="common/top.jspf" %>

        <h2> 회원가입 </h2>

        <form method="post" action="signupResult.jsp" class="needs-validation" novalidate style="max-width: 600px;">

            <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="홍길동" required>
                <div class="invalid-feedback">
                    이름을 입력해주세요.
                </div>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                <div class="invalid-feedback">
                    올바른 이메일 주소를 입력해주세요.
                </div>
            </div>

            <div class="mb-3">
                <label for="pwd" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="6자 이상" minlength="6" required>
                <div class="invalid-feedback">
                    6자 이상 비밀번호를 입력해주세요.
                </div>
            </div>

            <div class="form-check mb-3">
                <input type="checkbox" class="form-check-input" id="agree" name="agree" value="yes" required>
                <label class="form-check-label" for="agree">이용약관 및 개인정보 처리방침에 동의합니다.</label>
                <div class="invalid-feedback">
                    약관 동의가 필요합니다.
                </div>
            </div>

            <button type="submit" class="btn btn-primary w-100">가입하기</button>

        </form>

        <script>
            (() => {
                'use strict';

                const forms = document.querySelectorAll('.needs-validation');
                Array.from(forms).forEach(form => {
                    form.addEventListener('submit', event => {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            })();
        </script>

    <%@ include file="common/bottom.jspf" %>
</body>
</html>