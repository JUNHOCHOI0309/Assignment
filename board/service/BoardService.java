package com.multi.board.service;

import com.multi.board.dao.BoardDao;
import com.multi.board.dto.Board;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;

public class BoardService {
    private BoardDao boardDao = new BoardDao();

    public PageResult<Board> getBoardList(PageRequest pageRequest){
        return boardDao.getAllBoard(pageRequest);
    }

    public Board getBoardDetail(int id){
        return boardDao.getDetailBoard(id);
    }

    public void writeBoard(Board board){
        boardDao.insertBoard(board);
    }

    public void updateBoard(Board board){
        boardDao.updateBoard(board);
    }

    public void deleteBoard(int id, int writer_id){
        boardDao.deleteBoard(id, writer_id);
    }

    public PageResult<Board> searchBoard(PageRequest pageRequest, String type, String keyword){
        return boardDao.searchBoard(pageRequest,type,keyword);
    }
}
