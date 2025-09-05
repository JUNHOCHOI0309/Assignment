<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>서버 에러</title>
</head>
<body>
<h1>500 - Internal Server Error</h1>
<p>서버 처리 중 문제가 발생했습니다. 잠시 후 다시 시도해주세요.</p>
<a href="<%=request.getContextPath()%>/">메인으로 돌아가기</a>
</body>
</html>
