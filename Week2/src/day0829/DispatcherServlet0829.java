package com.multi.controller0829;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.assign")
public class DispatcherServlet0829 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        if(id==null || id.trim().isEmpty() || pw==null|| pw.trim().isEmpty()){
            request.getSession().setAttribute("loginFailed", "Please input Correct ID and PW");
            response.sendRedirect(request.getContextPath()+"/day0829/0829LoginFailed.jsp?");
            return;
        } else if("admin".equals(id) && "admin".equals(pw)){
            request.setAttribute("id",id);
            request.setAttribute("pw",pw);

            request.getRequestDispatcher("/day0829/0829LoginSuccess.jsp").forward(request, response);
        } else{
            request.getSession().setAttribute("loginFailed", "Login Failed");
            response.sendRedirect(request.getContextPath()+"/day0829/0829LoginFailed.jsp?");
        }
    }
}
