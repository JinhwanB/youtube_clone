package com.example.youtubeClone.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * 사용자로부터 입력받을 답글
 * 실제로 저장되는 객체가 아닌 입력을 위한 객체임
 */
@Getter
@Setter
public class ReplyForm {
    private Long parentId;
    private Long boardId;
    private String content;
    private String username;
}
