package com.example.youtubeClone.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    private Long commentId; // 댓글 id
    private String commentName; // 댓글 쓴 사람 이름
    private String commentContent; // 댓글 내용

    // 게시판 ID 추가
    private Long boardId;//댓글이 쓰여진 게시판의 번호
    private List<Reply> reply = new ArrayList<>();//대댓글이 저장됨

    private String videoId; // 영상 id
}
