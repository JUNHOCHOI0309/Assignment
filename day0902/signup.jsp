<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<div class="container py-4" style="max-width: 640px">

    <h2 class="mb-4"> 회원가입 </h2>

    <form method="post" action="${cpath}/front/0902member/signup.jsp" class="needs-validation" novalidate>

        <div class="mb-3">
            <label for="name" class="form-label">username</label>
            <input type="text" class="form-control" id="name" name="username" placeholder="홍길동" required>
            <div class="invalid-feedback">
                Username을 입력해주세요.
            </div>
        </div>

        <div class="mb-3">
            <label for="pwd" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <div>
                최소 8자 이상, 숫자, 특수문자 한 개씩 이상, 특수문자, 숫자, 영문자 제외 사용 불가
            </div>
            <div class="invalid-feedback">
                Password를 입력해주세요.
            </div>
        </div>

        <div class="mb-3">
            <label for="pwd" class="form-label">비밀번호 확인</label>
            <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" required>
            <div class="invalid-feedback">
                Password 확인 차 다시  입력해주세요.
            </div>
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">nickname</label>
            <input type="text" class="form-control" id="nickname" name="nickname" required>
            <div class="invalid-feedback">
                Nickname을 입력해주세요.
            </div>
        </div>

        <button type="submit" class="btn btn-primary w-100">가입하기</button>
        <div class="text-end mt-3">
            <a href="${cpath}/front/0902member/login.jsp" class="link-secondary">로그인으로</a>
        </div>
    </form>
</div>


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

</body>
</html>