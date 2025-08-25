<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>회원가입</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap 5 CDN -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <div class="card shadow-sm">
                <div class="card-body p-4">
                    <h3 class="mb-4">회원가입</h3>

                    <form method="post" action="signupResult.jsp" novalidate>
                        <!-- 이름 -->
                        <div class="mb-3">
                            <label for="name" class="form-label">이름</label>
                            <input type="text" class="form-control" id="name" name="name" required placeholder="홍길동">
                            <div class="form-text">실명을 입력해주세요.</div>
                        </div>

                        <!-- 이메일 -->
                        <div class="mb-3">
                            <label for="email" class="form-label">이메일</label>
                            <input type="email" class="form-control" id="email" name="email" required placeholder="you@example.com">
                        </div>

                        <!-- 비밀번호 -->
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" class="form-control" id="password" name="password" required minlength="6" placeholder="6자 이상">
                        </div>

                        <!-- 성별 (radio) -->
                        <div class="mb-3">
                            <label class="form-label d-block">성별</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="genderM" value="M" checked>
                                <label class="form-check-label" for="genderM">남성</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="genderF" value="F">
                                <label class="form-check-label" for="genderF">여성</label>
                            </div>
                        </div>

                        <!-- 취미 (checkbox, 다중값 → getParameterValues) -->
                        <div class="mb-3">
                            <label class="form-label d-block">취미</label>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="hobby" id="h1" value="music">
                                <label class="form-check-label" for="h1">음악</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="hobby" id="h2" value="movie">
                                <label class="form-check-label" for="h2">영화</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="hobby" id="h3" value="game">
                                <label class="form-check-label" for="h3">게임</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="hobby" id="h4" value="sports">
                                <label class="form-check-label" for="h4">스포츠</label>
                            </div>
                        </div>

                        <!-- 기술 스택 (multiple select, 다중값) -->
                        <div class="mb-3">
                            <label for="skills" class="form-label">기술 스택(복수 선택 가능)</label>
                            <select id="skills" name="skills" class="form-select" multiple size="5">
                                <option value="java">Java</option>
                                <option value="spring">Spring</option>
                                <option value="mysql">MySQL</option>
                                <option value="react">React</option>
                                <option value="docker">Docker</option>
                            </select>
                            <div class="form-text">Ctrl/Command로 여러 개 선택 가능</div>
                        </div>

                        <!-- 약관 동의 -->
                        <div class="mb-4 form-check">
                            <input class="form-check-input" type="checkbox" id="agree" name="agree" value="yes" required>
                            <label class="form-check-label" for="agree">
                                이용약관 및 개인정보 처리방침에 동의합니다.
                            </label>
                        </div>

                        <div class="d-flex gap-2">
                            <button type="submit" class="btn btn-primary">가입하기</button>
                            <button type="reset" class="btn btn-outline-secondary">초기화</button>
                        </div>
                    </form>

                </div>
            </div>

            <p class="text-muted small text-center mt-3">
                * 이 폼은 교육용 예시이며 실제 저장은 하지 않습니다.
            </p>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
