<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>글쓰기</title>
    <link href="<c:url value='/css/contents.css'/>" rel="stylesheet" type="text/css" />
    <style>
        .wrap { max-width: 960px; margin: 24px auto; }
        .field { margin-bottom: 12px; }
        .field label { display:block; font-weight:600; margin-bottom:6px; }
        .field input[type=text], .field textarea { width:100%; box-sizing:border-box; padding:8px; }
        .btn-row { display:flex; gap:8px; margin-top:14px; }
        .btn { display:inline-block; padding:8px 12px; border:1px solid #ccc; border-radius:4px; background:#f8f8f8; text-decoration:none; }
        .btn.primary { background:#2c7be5; color:#fff; border-color:#2c7be5; }
    </style>
</head>
<body>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<c:set var="loginMember" value="${sessionScope.loginMember}" />

<div class="wrap">
    <h2 style="margin-bottom:12px;">글쓰기</h2>

    <!-- 서버측 검증 실패 메시지 -->
    <c:if test="${not empty error}">
        <div style="color:#c00; margin-bottom:10px;">${error}</div>
    </c:if>

    <form method="post" action="${cpath}/front/0902board/write.jsp" onsubmit="return validateWriteForm();">
        <!-- 제목 -->
        <div class="field">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" value="${fn:escapeXml(param.title)}" required />
        </div>

        <!-- 작성자 (표시 전용: 서버에서 세션의 member.id를 사용해 writer_id 저장) -->
        <div class="field">
            <label>작성자</label>
            <div style="padding:6px 0;">
                <c:choose>
                    <c:when test="${not empty loginMember && not empty loginMember.nickname}">
                        <strong>${fn:escapeXml(loginMember.nickname)}</strong>
                        <span style="color:#777;">(@${fn:escapeXml(loginMember.username)})</span>
                    </c:when>
                    <c:when test="${not empty loginMember}">
                        <strong>${fn:escapeXml(loginMember.username)}</strong>
                    </c:when>
                    <c:otherwise>
                        <span style="color:#c00;">로그인이 필요합니다.</span>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <!-- 내용 -->
        <div class="field">
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="12" required>${fn:escapeXml(param.content)}</textarea>
        </div>

        <div class="btn-row">
            <button type="submit" class="btn primary">등록</button>
            <a class="btn" href="${cpath}/front/0902board/list.jsp">목록으로</a>
        </div>
    </form>
</div>

<script>
    function validateWriteForm() {
        var title = document.getElementById('title').value.trim();
        var content = document.getElementById('content').value.trim();
        if (!title) { alert('제목을 입력하세요.'); return false; }
        if (!content) { alert('내용을 입력하세요.'); return false; }
        return true;
    }
</script>
</body>
</html>
