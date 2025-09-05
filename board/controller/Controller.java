package com.multi.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    String handle(String action, HttpServletRequest request, HttpServletResponse response);
}
