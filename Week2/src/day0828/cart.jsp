<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.multi.dto.Product" %><%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-29
  Time: 오전 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Product> cart = (List<Product>) session.getAttribute("carts");
  if(cart ==null){
    cart = new ArrayList<>();
  }
%>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
  <title>Session Cart</title>
</head>
<body>
<div class="container mt-5">
  <h2>장바구니 목록</h2>

  <%
    if (cart.isEmpty()) {
  %>
  <p>장바구니가 비어 있습니다.</p>
  <%
  } else {
  %>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>상품명</th>
    </tr>
    </thead>
    <tbody>
    <%
      for(Product p : cart) {
    %>
    <tr>
      <td><%= p.getName() %></td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <%
    }
  %>

  <form action="<%=request.getContextPath()%>/CartServlet" method="get">
    <input type="hidden" name="action" value="clear" />
    <button type="submit" class="btn btn-danger">비우기</button>
  </form>

  <a href="productList.jsp" class="btn btn-primary mt-3">상품 목록으로 돌아가기</a>
</div>

</body>
</html>
