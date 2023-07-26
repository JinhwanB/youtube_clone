package com.example.youtubeClone.dto;

import lombok.Data;

import java.util.List;

@Data
public class Video {
    private String videoId; // 영상 재생과 영상 썸네일 불러올 시 필요한 id (예 : http://https://www.youtube.com/embed/{videoId})
    private String videoTitle; // 영상 제목
    private String channelTitle; // 채널 이름
}
