package com.example.youtubeClone.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    private Long commentId;
    private String commentName;
    private String commentContent;

    // 게시판 ID 추가
    private Long boardId;//댓글이 쓰여진 게시판의 번호
    private List<Reply> reply = new ArrayList<>();//대댓글이 저장됨

    private String videoId;
}
