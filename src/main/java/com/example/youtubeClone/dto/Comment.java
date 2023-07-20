package com.example.youtubeClone.dto;

import lombok.Data;

@Data
public class Comment {
    private Long commentId;
    private String commentName;
    private String commentContent;
}
