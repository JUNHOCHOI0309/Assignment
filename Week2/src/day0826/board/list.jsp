<%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-27
  Time: 오전 12:09
  list page / static
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Board List - Mini Portal</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
  <%
    request.setAttribute("active", "board");
    request.setAttribute("pageTitle", "board list - Mini Portal");
  %>
  <%@ include file="../common/top.jspf"%>

  <h2>게시판 목록</h2>
  <table class="table table-striped table-bordered table-hover">
    <thead class="table-primary">
    <tr>
      <th scope="col">#번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">수정일</th>
    </tr>
    </thead>
    <tbody>
    <!-- 정적 데이터 8행 작성 -->
    <tr>
      <td>1</td>
      <td><a href="detail.jsp">첫 번째 게시글 제목</a></td>
      <td>홍길동</td>
      <td>2025-08-01</td>
      <td>2025-08-05</td>
    </tr>
    <tr>
      <td>2</td>
      <td><a href="detail.jsp">두 번째 게시글 제목</a></td>
      <td>김철수</td>
      <td>2025-07-28</td>
      <td>2025-08-02</td>
    </tr>
    <tr>
      <td>3</td>
      <td><a href="detail.jsp">새로운 소식 안내</a></td>
      <td>이영희</td>
      <td>2025-07-25</td>
      <td>2025-07-26</td>
    </tr>
    <tr>
      <td>4</td>
      <td><a href="detail.jsp">여름 행사 계획</a></td>
      <td>박민수</td>
      <td>2025-07-20</td>
      <td>2025-07-21</td>
    </tr>
    <tr>
      <td>5</td>
      <td><a href="etail.jsp">서비스 점검 안내</a></td>
      <td>최지우</td>
      <td>2025-07-15</td>
      <td>2025-07-17</td>
    </tr>
    <tr>
      <td>6</td>
      <td><a href="detail.jsp">추석 휴무 안내</a></td>
      <td>김서현</td>
      <td>2025-07-10</td>
      <td>2025-07-12</td>
    </tr>
    <tr>
      <td>7</td>
      <td><a href="detail.jsp">신규 업데이트 안내</a></td>
      <td>이준호</td>
      <td>2025-07-05</td>
      <td>2025-07-07</td>
    </tr>
    <tr>
      <td>8</td>
      <td><a href="detail.jsp">개발팀 회의록</a></td>
      <td>오지현</td>
      <td>2025-07-01</td>
      <td>2025-07-02</td>
    </tr>
    </tbody>
  </table>

  <%@ include file="../common/bottom.jspf"%>
</body>
</html>