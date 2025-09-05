package com.multi.board.controller;

import com.multi.board.dto.Board;
import com.multi.board.dto.Member;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;
import com.multi.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardController implements Controller{
    private BoardService boardService = new BoardService();

    @Override
    public String handle(String action, HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setCharacterEncoding("UTF-8");
            String method = request.getMethod();
            String ctx = request.getContextPath();

            switch (action){
                case "/0902board/list.jsp": {
                    int page = parseIntOrDefault(request.getParameter("page"), 1);
                    int size = parseIntOrDefault(request.getParameter("size"), 10);

                    String type = request.getParameter("type");
                    String keyword = request.getParameter("keyword");

                    PageResult<Board> pageResult;
                    if(keyword != null && !keyword.trim().isEmpty()) {
                        pageResult = boardService.searchBoard(new PageRequest(page, size), type, keyword);
                    } else {
                        pageResult = boardService.getBoardList(new PageRequest(page,size));
                    }
                    request.setAttribute("pageResult", pageResult);
                    request.setAttribute("boards", pageResult.getContent());
                    return "/WEB-INF/day0902/list.jsp";
                }
                case "/0902board/detail.jsp": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Board board = boardService.getBoardDetail(id);
                    request.setAttribute("board", board);

                    Member login = getLoginMember(request);
                    boolean canEdit = (login != null) && (board.getWriter_id() == login.getId());
                    request.setAttribute("canEdit", canEdit);
                    return "/WEB-INF/day0902/detail.jsp";
                }
                case "/0902board/write.jsp": {
                    Member login = getLoginMember(request);
                    if(login == null) {response.sendRedirect(ctx+"/front/0902member/login.jsp"); return null;}

                    if("GET".equalsIgnoreCase(method)){
                        return "/WEB-INF/day0902/write.jsp";
                    } else if("POST".equalsIgnoreCase(method)){
                        String title = request.getParameter("title");
                        String content = request.getParameter("content");
                        if(title == null || title.isEmpty() || content == null || content.isEmpty()){
                            request.setAttribute("error","제목과 내용을 입력하세요.");
                            return "/WEB-INF/day0902/write.jsp";
                        }

                        Board b = new Board();
                        b.setTitle(title);
                        b.setContent(content);
                        b.setWriter_id(login.getId());

                        boardService.writeBoard(b);
                        response.sendRedirect(ctx+"/front/0902board/list.jsp");
                        return null;
                    }
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    return null;
                }
                case "/0902board/edit.jsp": {
                    if("POST".equalsIgnoreCase(method)){
                        Member login = getLoginMember(request);
                        if(login == null) {response.sendRedirect(ctx+"/front/day0902/login.jsp"); return null;}

                        Board b = new Board();
                        b.setId(Integer.parseInt(request.getParameter("id")));
                        b.setTitle(request.getParameter("title"));
                        b.setContent(request.getParameter("content"));
                        b.setWriter_id(login.getId());
                        boardService.updateBoard(b);
                        response.sendRedirect(ctx+"/front/0902board/detail.jsp?id="+b.getId());
                        return null;
                    }
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    return null;
                }
                case "/0902board/delete":{
                    if(!"POST".equalsIgnoreCase(method)){
                        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                        return null;
                    }
                    Member login = getLoginMember(request);
                    if(login == null) {response.sendRedirect(ctx+"/front/day0902/login.jsp"); return null;}

                    int id = Integer.parseInt(request.getParameter("id"));
                    boardService.deleteBoard(id, login.getId());
                    response.sendRedirect(ctx+"/front/0902board/list.jsp");
                    return null;
                }
            }

            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private int parseIntOrDefault(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private Member getLoginMember(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (Member) session.getAttribute("loginMember");
    }
}
