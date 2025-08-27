<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:06
  gallery page / static
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Gallery - Mini Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <%
        request.setAttribute("active", "gallery");
    %>
    <%@ include file="common/top.jspf" %>
    <%! String imagesrc = "https://cdn.discordapp.com/attachments/1253230373039771648/1396435458094923837/image.png?ex=68af839d&is=68ae321d&hm=e4b3a9895b53152baf84469ba78f0fb44faf0d8cd2b982683edbd04fe237ec68";%>

    <h2>갤러리</h2>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <!-- 카드 1 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 1">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 1</h5>
                    <p class="card-text">부트스트랩을 활용한 반응형 카드 레이아웃 예시입니다.</p>
                </div>
            </div>
        </div>

        <!-- 카드 2 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 2">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 2</h5>
                    <p class="card-text">다양한 화면 크기에 자동으로 맞춰지는 그리드.</p>
                </div>
            </div>
        </div>

        <!-- 카드 3 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 3">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 3</h5>
                    <p class="card-text">Bootstrap 5 컴포넌트를 활용한 디자인.</p>
                </div>
            </div>
        </div>

        <!-- 카드 4 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 4">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 4</h5>
                    <p class="card-text">반응형 레이아웃은 모바일 환경에도 적합합니다.</p>
                </div>
            </div>
        </div>

        <!-- 카드 5 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 5">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 5</h5>
                    <p class="card-text">다양한 이미지와 텍스트 조합 가능.</p>
                </div>
            </div>
        </div>

        <!-- 카드 6 -->
        <div class="col">
            <div class="card h-100 shadow-sm">
                <img src=<%=imagesrc%> class="card-img-top" alt="갤러리 이미지 6">
                <div class="card-body">
                    <h5 class="card-title">갤러리 이미지 6</h5>
                    <p class="card-text">손쉬운 확장 및 유지보수가 가능한 구조.</p>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="common/bottom.jspf" %>
</body>
</html>