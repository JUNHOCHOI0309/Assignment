package com.multi.board.model.dao;

import java.util.List;
import com.multi.board.model.bean.BoardDto;

public interface BoardDao {
    void registerArticle(BoardDto boardDto);
    List<BoardDto> searchListAll();
    List<BoardDto> searchListBySubject(String subject);
    BoardDto viewArticle(int no);
    void modifyArricle(BoardDto boardDto);
    void deleteArticle(int no);
}
