<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>게시글 상세</title>
    <link href="<c:url value='/css/contents.css'/>" rel="stylesheet" type="text/css" />
    <style>
        .meta { color:#666; font-size:13px; margin-bottom:12px; }
        .content-box { white-space:pre-wrap; line-height:1.6; border:1px solid #e5e5e5; padding:14px; border-radius:6px; }
        .btn-row { display:flex; gap:8px; margin-top:14px; }
        .btn { display:inline-block; padding:8px 12px; border:1px solid #ccc; border-radius:4px; background:#f8f8f8; text-decoration:none; }
        .btn.primary { background:#2c7be5; color:#fff; border-color:#2c7be5; }
        .btn.danger  { background:#e55353; color:#fff; border-color:#e55353; }
        .edit-panel { margin-top:16px; border:1px solid #e5e5e5; border-radius:6px; padding:12px; display:none; }
        .field { margin-bottom:10px; }
        .field label { display:block; font-weight:600; margin-bottom:6px; }
        .field input[type=text], .field textarea { width:100%; box-sizing:border-box; padding:8px; }
    </style>
</head>
<body>
<c:set var="cpath" value="${pageContext.request.contextPath}" />

<div class="container" style="max-width:960px; margin:24px auto;">

    <h2 style="margin-bottom:8px;"><c:out value="${board.title}"/></h2>


    <div class="meta">
        작성자:
        <c:choose>
            <c:when test="${not empty board.nickname}"><c:out value="${board.nickname}"/></c:when>
            <c:otherwise>${board.writer_id}</c:otherwise>
        </c:choose>
        &nbsp;|&nbsp;
        조회수: ${board.view_cnt}
        &nbsp;|&nbsp;
        수정일:
        <c:choose>
            <c:when test="${not empty board.updated_at}">
                <fmt:formatDate value="${board.updated_at}" pattern="yyyy-MM-dd HH:mm" />
            </c:when>
            <c:when test="${not empty board.created_at}">
                <fmt:formatDate value="${board.created_at}" pattern="yyyy-MM-dd HH:mm" />
            </c:when>
        </c:choose>
    </div>


    <div class="content-box"><c:out value="${board.content}"/></div>


    <div class="btn-row">

        <c:url var="backUrl" value="/front/0902board/list.jsp">
            <c:if test="${not empty param.page}"><c:param name="page" value="${param.page}"/></c:if>
            <c:if test="${not empty param.size}"><c:param name="size" value="${param.size}"/></c:if>
            <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
            <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
        </c:url>
        <a class="btn" href="${cpath}${backUrl}">목록으로</a>


        <c:if test="${canEdit}">
            <button class="btn primary" type="button" id="btnToggleEdit">수정</button>

            <form method="post" action="${cpath}/front/0902board/delete"
                  onsubmit="return confirm('정말 삭제하시겠습니까?');" style="display:inline;">
                <input type="hidden" name="id" value="${board.id}" />
                <button type="submit" class="btn danger">삭제</button>
            </form>
        </c:if>
    </div>


    <c:if test="${canEdit}">
        <div id="editPanel" class="edit-panel">
            <form method="post" action="${cpath}/front/0902board/edit.jsp" class="vstack gap-2">
                <input type="hidden" name="id" value="${board.id}" />
                <div class="field">
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title" value="${fn:escapeXml(board.title)}" required />
                </div>
                <div class="field">
                    <label for="content">내용</label>
                    <textarea id="content" name="content" rows="10" required>${fn:escapeXml(board.content)}</textarea>
                </div>
                <div class="btn-row">
                    <button type="submit" class="btn primary">수정 저장</button>
                    <button type="button" class="btn" id="btnCancelEdit">취소</button>
                </div>
            </form>
        </div>
    </c:if>
</div>

<script>
    (function(){
        var btn = document.getElementById('btnToggleEdit');
        var panel = document.getElementById('editPanel');
        var cancel = document.getElementById('btnCancelEdit');
        if (btn && panel) {
            btn.addEventListener('click', function(){ panel.style.display = (panel.style.display === 'block' ? 'none' : 'block'); });
        }
        if (cancel && panel) {
            cancel.addEventListener('click', function(){ panel.style.display = 'none'; });
        }
    })();
</script>
</body>
</html>
