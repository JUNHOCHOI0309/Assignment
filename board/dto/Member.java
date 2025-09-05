package com.multi.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

//MemberDTO
public class Member {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime created_at;
}
