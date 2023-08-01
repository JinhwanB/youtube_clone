package com.example.youtubeClone.controller;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.dto.Heart;
import com.example.youtubeClone.dto.Video;
import com.example.youtubeClone.service.CommentService;
import com.example.youtubeClone.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    private final CommentService commentService;

    @GetMapping("/video") // 영상 재생되는 페이지
    public String videoHome(@RequestParam String id, Model model) throws GeneralSecurityException, IOException {
        List<Video> videoListExceptCurrentVideo = videoService.findVideoListExceptCurrentVideo(id);
        List<Comment> commentAll = commentService.findCommentAll(id);
        Video video = videoService.findVideo(id);
        Heart heart = videoService.findVideo(id).getHeart();
        model.addAttribute("cVideo", video);
        model.addAttribute("videoId", id);
        model.addAttribute("heart", heart);
        model.addAttribute("videoList", videoListExceptCurrentVideo);
        model.addAttribute("commentList", commentAll);
        return "page/playerPage";
    }
}
