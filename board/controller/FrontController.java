package com.multi.board.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = "/front/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> controllerMap = new HashMap<>();

    @Override
    public void init(){
        Controller boardController = new BoardController();
        Controller memberController = new MemberController();

        controllerMap.put("/0902board/list.jsp",boardController);
        controllerMap.put("/0902board/write.jsp",boardController);
        controllerMap.put("/0902board/edit.jsp",boardController);
        controllerMap.put("/0902board/detail.jsp",boardController);
        controllerMap.put("/0902board/delete",boardController);

        controllerMap.put("/0902member/login.jsp",memberController);
        controllerMap.put("/0902member/signup.jsp",memberController);
        controllerMap.put("/0902member/logout.jsp",memberController);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getPathInfo();

        try{
            if(action == null){
                req.getRequestDispatcher("/WEB-INF/day0902/404.jsp").forward(req, resp);
                return;
            }
            Controller controller = controllerMap.get(action);
            if(controller == null){
                req.getRequestDispatcher("/WEB-INF/day0902/404.jsp").forward(req, resp);
                return;
            }
            String view = controller.handle(action,req,resp);

            if(view != null){
                req.getRequestDispatcher(view).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/day0902/500.jsp").forward(req, resp);
        }
    }
}
