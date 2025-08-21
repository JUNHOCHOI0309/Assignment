package com.multi.board.model.service;

import com.multi.board.model.bean.BoardDto;

import java.util.List;

public interface BoardService {
    void registerArticle(BoardDto boardDto);
    List<BoardDto> searchListAll();
    List<BoardDto> searchListBySubject(String subject);
    BoardDto viewArticle(int no);
    void modifyArricle(BoardDto boardDto);
    void deleteArticle(int no);
}
