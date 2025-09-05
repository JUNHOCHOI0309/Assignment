package com.multi.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

//BoardDTO
public class Board {
    private int id;
    private String title;
    private String content;
    private int writer_id;
    private int view_cnt;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String nickname;
}
