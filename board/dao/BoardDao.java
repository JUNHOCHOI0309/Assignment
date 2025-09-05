package com.multi.board.dao;

import com.multi.board.dto.Board;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;
import com.multi.board.exception.AppException;
import com.multi.board.util.DB;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDao implements BoardInterface{
    @Override
    public PageResult<Board> getAllBoard(PageRequest pageRequest) {
        String sql = "select * from board b left join member m on b.writer_id = m.id order by b.created_at desc limit ? offset ?";
        String countSql = "select count(*) from board";
        List<Board> boards = new ArrayList<>();
        int total = 0;

        try(Connection connection = DB.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            PreparedStatement countPstmt = connection.prepareStatement(countSql)){
            pstmt.setInt(1,pageRequest.getSize()) ;
            pstmt.setInt(2,pageRequest.getOffset());
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    Board board = new Board();
                    board.setId(rs.getInt("id"));
                    board.setTitle(rs.getString("title"));
                    board.setNickname(rs.getString("nickname"));
                    board.setView_cnt(rs.getInt("view_cnt"));
                    board.setCreated_at(rs.getTimestamp("created_at"));
                    board.setUpdated_at(ldt(rs,"updated_at"));
                    boards.add(board);
                }
            }
            try(ResultSet rs = countPstmt.executeQuery()){
                if(rs.next()){
                    total = rs.getInt(1);
                }
            }
        } catch (SQLException e){
            throw new AppException("게시판 불러오기 실패", e);
        }
        return new PageResult<>(boards,pageRequest,total);
    }
    private static Timestamp ldt(ResultSet rs, String col) throws SQLException {
        Timestamp ts = rs.getTimestamp(col);
        return (ts != null) ? ts : null;
    }

    @Override
    public Board getDetailBoard(int id) {
        String updateSql = "update board set view_cnt = view_cnt + 1 where id = ?";
        String selectSql = "select * from board b left join member m on b.writer_id = m.id where b.id = ?";
        Board board = null;
        try(Connection connection = DB.getConnection()){
            connection.setAutoCommit(false);

            try(PreparedStatement updatePstmt = connection.prepareStatement(updateSql)){
                updatePstmt.setInt(1, id);
                updatePstmt.executeUpdate();
            }

            try(PreparedStatement selectPstmt = connection.prepareStatement(selectSql)){
                selectPstmt.setInt(1, id);
                try(ResultSet rs = selectPstmt.executeQuery()){
                    if(rs.next()){
                        board = new Board();
                        board.setId(rs.getInt("id"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setNickname(rs.getString("nickname"));
                        board.setWriter_id(rs.getInt("writer_id"));
                        board.setView_cnt(rs.getInt("view_cnt"));
                        board.setUpdated_at(ldt(rs,"updated_at"));
                    }
                }
            }
            connection.commit();
            return board;
        } catch (SQLException e){
            throw new AppException("게시글 상세 조회 실패", e);
        }
    }

    @Override
    public void insertBoard(Board board) {
        String sql = "insert into board (title, content, writer_id) values (?, ?, ?)";
        try(Connection connection = DB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getWriter_id());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new AppException("새 글 생성 실패", e);
        }
    }

    @Override
    public void updateBoard(Board board) {
        String sql = "update board set title = ?, content = ? where id = ? AND writer_id = ?";
        try(Connection connection = DB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getId());
            stmt.setInt(4, board.getWriter_id());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new AppException("게시글 업데이트 실패", e);
        }
    }

    @Override
    public void deleteBoard(int id, int writer_id) {
        String sql = "delete from board where id = ? AND writer_id = ?";
        try(Connection connection = DB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.setInt(2, writer_id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new AppException("게시글 삭제 실패", e);
        }
    }

    @Override
    public PageResult<Board> searchBoard(PageRequest pageRequest, String type, String keyword) {
        String base = "FROM board b LEFT JOIN member m ON b.writer_id = m.id";
        String column;

        switch (type) {
            case "title": column= "b.title"; break;
            case "writer": column= "m.nickname"; break;
            case "content": column= "b.content"; break;
            default: column= "b.title"; break;
        }

        final String countSql = "SELECT count(*) " + base + " where " + column +" like ?";
        final String listSql = "SELECT b.id, b.title, b.content, b.writer_id, b.view_cnt, b.created_at, b.updated_at, m.nickname AS nickname " +
                base + " where " + column +" like ? ORDER BY b.created_at DESC LIMIT ? OFFSET ?";

        List<Board> boards = new ArrayList<>();
        int total = 0;

        try (Connection connection = DB.getConnection()) {
            try(PreparedStatement countPstmt = connection.prepareStatement(countSql)){
                countPstmt.setString(1, "%" + keyword + "%");
                try(ResultSet rs = countPstmt.executeQuery()){
                    if(rs.next()) total = rs.getInt(1);
                }
            }
            try(PreparedStatement pstmt = connection.prepareStatement(listSql)){
                int idx = 1;
                pstmt.setString(idx++, "%" + keyword + "%");
                pstmt.setInt(idx++, pageRequest.getSize());
                pstmt.setInt(idx++, pageRequest.getOffset());
                try(ResultSet rs = pstmt.executeQuery()){
                    while(rs.next()){
                        Board board = new Board();
                        board.setId(rs.getInt("id"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter_id(rs.getInt("writer_id"));
                        board.setNickname(rs.getString("nickname"));
                        board.setView_cnt(rs.getInt("view_cnt"));
                        board.setUpdated_at(rs.getTimestamp("updated_at"));
                        boards.add(board);
                    }
                }
            }
            System.out.println(listSql);
        } catch (SQLException e) {
            throw new AppException("게시글 검색 실패", e);
        }
        return new PageResult<>(boards, pageRequest, total);
    }
}
