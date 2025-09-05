package com.multi.board.dao;

import com.multi.board.dto.Member;
import com.multi.board.exception.AppException;
import com.multi.board.exception.NotFoundException;
import com.multi.board.util.DB;
import com.multi.board.util.PasswordEncoder;
import com.multi.board.util.Validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

    public boolean isExistMember(String username) {
        String sql = "select * from member where username = ?";
        try(Connection connection = DB.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public void insertMember(Member member) {
        if(!Validation.isValidId(member.getUsername())){
            throw new IllegalArgumentException("아이디 형식이 올바르지 않습니다.");
        }
        if(!Validation.isValidPassword(member.getPassword())){
            throw new IllegalArgumentException("비밀번호 형식이 올바르지 않습니다.");
        }

        if(isExistMember(member.getUsername())){
            throw new IllegalStateException("이미 사용 중인 아이디입니다: " + member.getUsername());
        }

        String sql = "insert into member (username, password, nickname) values(?,?,?)";
        try(Connection connection = DB.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            String encodedPw = PasswordEncoder.encode(member.getPassword());

            pstmt.setString(1, member.getUsername());
            pstmt.setString(2, encodedPw);
            pstmt.setString(3, member.getNickname());
            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new AppException("회원가입 생성 오류", e);
        }
    }

    public Member findById(String username){
        String sql = "select * from member where username = ?";
        try(Connection connection = DB.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return mapRow(rs);
            } else{
                throw new NotFoundException("회원이 존재하지 않습니다. : "+ username);
            }
        } catch (SQLException e){
            throw new AppException("DB 조회 오류", e);
        }
    }

    public Member login(String username, String rawPassword){
        Member member = findById(username);
        if(member != null && PasswordEncoder.matches(rawPassword, member.getPassword())){
            return member;
        }
        return null;
    }

    private Member mapRow(ResultSet rs) throws SQLException {
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setUsername(rs.getString("username"));
        member.setPassword(rs.getString("password"));
        member.setNickname(rs.getString("nickname"));
        member.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        return member;
    }
}
