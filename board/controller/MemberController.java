package com.multi.board.controller;

import com.multi.board.dto.Member;
import com.multi.board.service.MemberService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberController implements Controller{
    private MemberService memberService = new MemberService();

    @Override
    public String handle(String action, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            String method = request.getMethod();
            String ctx = request.getContextPath();

            switch (action){
                case "/0902member/login.jsp":
                    if("GET".equalsIgnoreCase(method)){
                        return "/WEB-INF/day0902/login.jsp";
                    } else if("POST".equalsIgnoreCase(method)){
                        return doLogin(request,response, ctx);
                    }
                    break;
                case "/0902member/signup.jsp":
                    if("GET".equalsIgnoreCase(method)){
                        return "/WEB-INF/day0902/signup.jsp";
                    } else if("POST".equalsIgnoreCase(method)){
                        return doSignup(request,response,ctx);
                    }
                    break;
                case "/0902member/logout.jsp":
                    HttpSession session = request.getSession(false);
                    if(session != null) session.invalidate();
                    response.sendRedirect(ctx+"/0902member/login");
                    return null;
            }
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } catch (Exception e){
            e.printStackTrace();
        }
        return "error/404";
    }

    private String doLogin(HttpServletRequest request, HttpServletResponse response, String ctx) throws Exception{
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.isEmpty() || password.isEmpty()){
            request.setAttribute("error", "아이디/비밀번호를 입력하세요.");
            return "/WEB-INF/day0902/login.jsp";
        }

        Member loginMember = memberService.login(username,password);
        if(loginMember == null){
            request.setAttribute("error","아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/WEB-INF/day0902/login.jsp";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);
        response.sendRedirect(ctx+"/front/0902board/list.jsp");
        return null;
    }

    private String doSignup(HttpServletRequest request, HttpServletResponse response, String ctx) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String nickname = request.getParameter("nickname");

        if(username.isEmpty()) {request.setAttribute("error", "아이디를 입력하세요"); return "/WEB-INF/day0902/signup.jsp";}
        if(password.isEmpty()){request.setAttribute("error", "비밀번호를 입력하세요."); return "/WEB-INF/day0902/signup.jsp";}
        if(!password.equals(passwordConfirm)){request.setAttribute("error","비밀번호가 일치하지 않습니다."); return "/WEB-INF/day0902/signup.jsp";}
        if(nickname.isEmpty()){request.setAttribute("error","닉네임을 입력해주세요."); return "/WEB-INF/day0902/signup.jsp";}

        if(memberService.isExist(username)){
            request.setAttribute("error","이미 사용 중인 아이디입니다.");
            return "/WEB-INF/day0902/signup.jsp";
        }

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setNickname(nickname);
        memberService.signup(member);

        response.sendRedirect(ctx+"/front/0902member/login.jsp");
        return null;
    }
    private static String nvl(String s) { return (s == null) ? "" : s.trim(); }
}
