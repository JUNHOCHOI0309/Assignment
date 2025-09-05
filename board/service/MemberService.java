package com.multi.board.service;

import com.multi.board.dao.MemberDao;
import com.multi.board.dto.Member;

public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public void signup(Member member){
        memberDao.insertMember(member);
    }

    public Member login(String username, String password){
        return memberDao.login(username, password);
    }

    public boolean isExist(String username){
        return memberDao.isExistMember(username);
    }

    public Member findById(String username){
        return memberDao.findById(username);
    }
}
