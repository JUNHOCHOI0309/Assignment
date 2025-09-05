<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>게시판 리스트</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=10" />
    <meta http-equiv="imagetoolbar" content="no" />
    <link href="../../css/contents.css" rel="stylesheet" type="text/css" />
</head>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<body >
<div id="wrapper">
    <div id="header">
        <div class="topInfoWrap">
            <div class="topInfoArea clfix">
                <div class="loginWrap">
                    <span class="fir">
                        <%= new SimpleDateFormat("yyyy.MM.dd").format(new Date())%>
                    </span>
                    <span>
                        <%= new SimpleDateFormat("HH:mm:ss").format(new Date())%>
                    </span>
                    <span><em>${sessionScope.loginMember != null ? sessionScope.loginMember.username : '사용자'}</em>님, 좋은 하루 되세요</span>
                    <c:choose>
                        <c:when test="${sessionScope.loginMember != null}">
                            <a href="${cpath}/front/0902member/login.jsp" class="btnLogout">
                                <img src="../../img/common/btn_logout.gif" alt="로그아웃" />
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${cpath}/front/0902member/login.jsp" class="btnLogin">
                                <img src="../../img/common/btn_login.gif" alt="로그인" />
                            </a>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>

    <div id="container">
        <div id="contentsWrap" class="contentsWrap">
            <div class="contents">

                <h1 class="title">게시판 리스트</h1>

                <div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button">
                                <a href="${cpath}/front/0902board/write.jsp">글쓰기</a>
                            </span>
						</span>
                </div>

                <form method="get" action="${cpath}/front/0902board/list.jsp" class="mgb15">
                    <table class="bbsWrite mgb10">
                        <colgroup>
                            <col width="80"/>
                            <col/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>검색</th>
                            <td>
                                <c:set var="selType" value="${empty param.type ? 'title': param.type}"/>
                                <select name="type" class="inputSelect">
                                    <option value="title" ${selType == 'title' ? 'selected' : ''}>제목</option>
                                    <option value="content" ${selType == 'content' ? 'selected' : ''}>내용</option>
                                    <option value="writer" ${selType == 'writer' ? 'selected' : ''}>작성자</option>
                                </select>
                                <input type="text" name="keyword" class="inputText" size="30" value="${fn:escapeXml(param.keyword)}" />
                                <input type="hidden" name="size" value="${empty param.size() ? 10: param.size()}"/>
                                <button type="submit" class="btn">검색</button>
                                <c:if test="${not empty param.type or not empty param.keyword}">
                                    <a class="btn" href="${cpath}/front/0902board/list.jsp">검색 리셋</a>
                                </c:if>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>

                <table class="bbsList">
                    <colgroup>
                        <col width="80" />
                        <col />
                        <col width="160" />
                        <col width="100" />
                        <col width="160" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col" class="fir">NO</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="items" value="${not empty boards ? boards : pageResult.content}"/>
                    <c:choose>
                        <c:when test="${empty items}">
                            <tr>
                                <td class="tal" colspan="5" style="text-align: center;">등록된 게시글이 없습니다.</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="b" items="${items}" varStatus="st">
                                <tr>
                                    <td class="fir">
                                        ${b.id}
                                    </td>
                                    <td class="tal">
                                        <a href="${cpath}/front/0902board/detail.jsp?id=${b.id}">${fn:escapeXml(b.title)}</a>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty b.nickname}"> ${fn:escapeXml(b.nickname)}</c:when>
                                            <c:otherwise>${b.writer_id}</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${b.view_cnt}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty b.created_at}">
                                                <fmt:formatDate value="${b.created_at}" pattern="yyyy-MM-dd HH:mm" />
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:formatDate value="${b.updated_at}" pattern="yyyy-MM-dd HH:mm" />
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>

                <!-- 페이지네이션 -->
                <c:set var="page" value="${pageResult.page}" />
                <c:set var="totalPages" value="${pageResult.totalPage}" />
                <c:set var="size" value="${empty param.size ? pageResult.size : param.size}" />

                <c:set var="start" value="${page - 4}" />
                <c:if test="${start < 1}"><c:set var="start" value="1"/></c:if>
                <c:set var="end" value="${page + 4}" />
                <c:if test="${end > totalPages}"><c:set var="end" value="${totalPages}"/></c:if>

                <div class="paging" style="margin-top:14px;">
                    <!-- 처음 / 이전 -->
                    <c:url var="firstUrl" value="/front/0902board/list.jsp">
                        <c:param name="page" value="1"/>
                        <c:param name="size" value="${size}"/>
                        <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
                        <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
                    </c:url>
                    <c:url var="prevUrl" value="/front/0902board/list.jsp">
                        <c:param name="page" value="${page > 1 ? page - 1 : 1}"/>
                        <c:param name="size" value="${size}"/>
                        <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
                        <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
                    </c:url>

                    <a href="${cpath}${firstUrl}"><img src="<c:url value='/img/button/btn_first.gif'/>" alt="처음"/></a>
                    <a href="${cpath}${prevUrl}"><img src="<c:url value='/img/button/btn_prev.gif'/>" alt="이전"/></a>

                    <!-- 페이지 숫자 -->
                    <span>
                        <c:forEach var="p" begin="${start}" end="${end}">
                            <c:url var="pUrl" value="/front/0902board/list.jsp">
                                <c:param name="page" value="${p}"/>
                                <c:param name="size" value="${size}"/>
                                <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
                                <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
                            </c:url>
                            <c:choose>
                                <c:when test="${p == page}">
                                    <strong>${p}</strong>
                                </c:when>
                                <c:otherwise>
                                    <a href="${cpath}${pUrl}">${p}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </span>

                    <!-- 다음 / 마지막 -->
                    <c:url var="nextUrl" value="/front/0902board/list.jsp">
                        <c:param name="page" value="${page < totalPages ? page + 1 : totalPages}"/>
                        <c:param name="size" value="${size}"/>
                        <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
                        <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
                    </c:url>
                    <c:url var="lastUrl" value="/front/0902board/list.jsp">
                        <c:param name="page" value="${totalPages}"/>
                        <c:param name="size" value="${size}"/>
                        <c:if test="${not empty param.type}"><c:param name="type" value="${param.type}"/></c:if>
                        <c:if test="${not empty param.keyword}"><c:param name="keyword" value="${param.keyword}"/></c:if>
                    </c:url>

                    <a href="${cpath}${nextUrl}"><img src="<c:url value='/img/button/btn_next.gif'/>" alt="다음"/></a>
                    <a href="${cpath}${lastUrl}"><img src="<c:url value='/img/button/btn_last.gif'/>" alt="마지막"/></a>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>