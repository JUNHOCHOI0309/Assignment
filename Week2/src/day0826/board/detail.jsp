<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:09
  list detail page / static
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Board Detail - Mini Portal</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
  <%
    request.setAttribute("active", "board");
  %>
  <%@ include file="../common/top.jspf" %>

  <h2>게시글 상세보기</h2>

  <div class="card mb-4 shadow-sm">
    <div class="card-header bg-primary text-white">
      <h5>첫 번째 게시글 제목</h5>
      <small>작성자: 홍길동 | 작성일: 2025-08-01 | 수정일: 2025-08-05</small>
    </div>
    <div class="card-body">
      <p class="card-text" style="white-space: pre-line;">
        이 게시글은 미니 포털 테스트용으로 작성된 정적 본문입니다.
        <br><br>
        Bootstrap 5의 카드 컴포넌트를 활용해 레이아웃을 구성하였습니다.
        <br><br>
        게시글 내용에는 여러줄 텍스트, 문단, 리스트, 강조 텍스트 등을 포함할 수 있습니다.
      </p>

      <h6>추가 정보</h6>
      <ul>
        <li>카테고리: 공지사항</li>
        <li>조회수: 123</li>
        <li>태그: 미니포털, 예제, 게시글</li>
      </ul>
    </div>
    <div class="card-footer text-end">
      <a href="list.jsp" class="btn btn-secondary">목록으로</a>
      <a href="#" class="btn btn-primary">수정</a>
      <a href="#" class="btn btn-danger">삭제</a>
    </div>
  </div>

  <%@ include file="../common/bottom.jspf" %>
</body>
</html>