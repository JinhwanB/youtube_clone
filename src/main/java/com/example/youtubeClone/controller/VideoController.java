package com.example.youtubeClone.controller;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.dto.Video;
import com.example.youtubeClone.service.CommentService;
import com.example.youtubeClone.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/video") // "localhost:8080/video"로 들어오는 요청 처리
public class VideoController {

    private final VideoService videoService;
    private final CommentService commentService;

    @GetMapping("/") // 영상 재생되는 페이지
    public String videoHome(@RequestParam String id, Model model) throws GeneralSecurityException, IOException {
        List<Video> videoListExceptCurrentVideo = videoService.findVideoListExceptCurrentVideo(id);
        Video video = videoService.findVideo(id);
        List<Comment> commentAll = commentService.findCommentAll(id);
        model.addAttribute("video", video);
        model.addAttribute("videoList", videoListExceptCurrentVideo);
        model.addAttribute("commentList", commentAll);
        return "test";
    }
}
