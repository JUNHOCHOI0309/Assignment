package com.multi.board.model.service;

import com.multi.board.model.bean.BoardDto;
import com.multi.board.model.dao.BoardDaoImpl;

import java.util.List;

public class BoardServiceImpl implements BoardService{
    private static BoardService boardService = new BoardServiceImpl();
    public static BoardService getBoardService(){
        return boardService;
    }

    @Override
    public void registerArticle(BoardDto boardDto) {
        BoardDaoImpl.getBoardDao().registerArticle(boardDto);
    }

    @Override
    public List<BoardDto> searchListAll() {
        return BoardDaoImpl.getBoardDao().searchListAll();
    }

    @Override
    public List<BoardDto> searchListBySubject(String subject) {
        return BoardDaoImpl.getBoardDao().searchListBySubject(subject);
    }

    @Override
    public BoardDto viewArticle(int no) {
        return BoardDaoImpl.getBoardDao().viewArticle(no);
    }

    @Override
    public void modifyArricle(BoardDto boardDto) {
        BoardDaoImpl.getBoardDao().modifyArricle(boardDto);
    }
    @Override
    public void deleteArticle(int no) {
        BoardDaoImpl.getBoardDao().deleteArticle(no);
    }
}
