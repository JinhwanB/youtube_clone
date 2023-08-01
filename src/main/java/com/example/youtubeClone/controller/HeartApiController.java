package com.example.youtubeClone.controller;

import com.example.youtubeClone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class HeartApiController {
    private final VideoService videoService;

    @PostMapping("/like")
    public void likeMemo(@RequestBody Map<String, String> data) throws GeneralSecurityException, IOException {
        // ID에 해당하는 메모의 좋아요 수를 증가시킨 뒤 Heart로 반환
        videoService.like(data.get("id"));
    }

    @PostMapping("/dislike")
    public void dislikeMemo(@RequestBody Map<String, String> data) throws GeneralSecurityException, IOException {
        // ID에 해당하는 메모의 좋아요 수를 감소시킨 뒤 Heart로 반환
        videoService.dislike(data.get("id"));
    }
}