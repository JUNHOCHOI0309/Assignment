<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:06
  HOME / static
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Home - Mini Portal</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
  <%
    request.setAttribute("active", "home");
  %>
  <%@ include file="common/top.jspf"%>

  <div id="heroCarousel" class="carousel slide mb-5" data-bs-ride="carousel" aria-label="홈페이지 히어로 이미지">
    <div class="carousel-inner rounded-3 shadow-sm">
      <div class="carousel-item active">
        <img src="https://media.discordapp.net/attachments/1253230373039771648/1406507709641003079/1755407931449.jpg?ex=68afe6e1&is=68ae9561&hm=669d087ee33936d8d61a0a528f46d54a39cc2de7daca74c98788a106281ff8df&=&format=webp&width=601&height=801" class="d-block w-100" alt="첫번째 이미지">
        <div class="carousel-caption d-none d-md-block text-dark">
          <h5>미니 포털에 오신 것을 환영합니다</h5>
          <p>Bootstrap 5와 JSP 기반 반응형 포털 프로젝트</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="https://cdn.discordapp.com/attachments/1253230373039771648/1403333579827712142/i1683489141.png?ex=68af8f7e&is=68ae3dfe&hm=9529513f684b5e5069db8b0439379f15b8a1ebba9402415b5b3ba159bb949c41&" class="d-block w-100" alt="두번째 이미지">
        <div class="carousel-caption d-none d-md-block">
          <h5>강력한 반응형 디자인</h5>
          <p>어디서나 편리하게 접근 가능</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="https://cdn.discordapp.com/attachments/1253230373039771648/1403333563440566333/i1126553317.png?ex=68af8f7a&is=68ae3dfa&hm=fe66ed0008a0ef931ca5100e198b78893551039e607e7718b5a05ac7f3dd8648&" class="d-block w-100" alt="세번째 이미지">
        <div class="carousel-caption d-none d-md-block text-light">
          <h5>간편한 구성과 확장</h5>
          <p>JSP 와 Bootstrap으로 쉽게 구현</p>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#heroCarousel" data-bs-slide="prev" aria-label="이전">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#heroCarousel" data-bs-slide="next" aria-label="다음">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
    </button>
  </div>
  <!-- 카드 3개 섹션 -->
  <div class="row g-4">
    <div class="col-md-4">
      <div class="card h-100 shadow-sm">
        <img src="https://media.discordapp.net/attachments/1253230373039771648/1406507709641003079/1755407931449.jpg?ex=68afe6e1&is=68ae9561&hm=669d087ee33936d8d61a0a528f46d54a39cc2de7daca74c98788a106281ff8df&=&format=webp&width=601&height=801" width="400" height="250" class="card-img-top" alt="게시판 리스트">
        <div class="card-body">
          <h5 class="card-title">게시판</h5>
          <p class="card-text">8개 이상의 정적 글 목록 및 상세보기 페이지</p>
          <a href="board/list.jsp" class="btn btn-primary">게시판 보기</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card h-100 shadow-sm">
        <img src="https://cdn.discordapp.com/attachments/1253230373039771648/1403333579827712142/i1683489141.png?ex=68af8f7e&is=68ae3dfe&hm=9529513f684b5e5069db8b0439379f15b8a1ebba9402415b5b3ba159bb949c41&" width="400" height="250" class="card-img-top" alt="갤러리">
        <div class="card-body">
          <h5 class="card-title">갤러리</h5>
          <p class="card-text">반응형 카드 그리드로 아름다운 이미지 모음</p>
          <a href="gallery.jsp" class="btn btn-primary">갤러리 방문</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card h-100 shadow-sm">
        <img src="https://cdn.discordapp.com/attachments/1253230373039771648/1403333563440566333/i1126553317.png?ex=68af8f7a&is=68ae3dfa&hm=fe66ed0008a0ef931ca5100e198b78893551039e607e7718b5a05ac7f3dd8648&" width="400" height="250" class="card-img-top" alt="회원가입">
        <div class="card-body">
          <h5 class="card-title">회원가입</h5>
          <p class="card-text">간편한 회원가입 폼과 결과 확인 페이지</p>
          <a href="signup.jsp" class="btn btn-primary">회원가입 하러 가기</a>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="common/bottom.jspf"%>
</body>
</html>
