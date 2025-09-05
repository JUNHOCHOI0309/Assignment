package com.multi.board.dao;

import com.multi.board.dto.Board;
import com.multi.board.dto.Member;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;

import java.util.List;

public interface BoardInterface {
    PageResult<Board> getAllBoard(PageRequest pageRequest);
    Board getDetailBoard(int id);
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int id, int writer_id);
    PageResult<Board> searchBoard(PageRequest pageRequest, String type, String keyword);
}
