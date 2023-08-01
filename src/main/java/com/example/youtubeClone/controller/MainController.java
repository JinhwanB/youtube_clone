package com.example.youtubeClone.controller;

import com.example.youtubeClone.dto.Video;
import com.example.youtubeClone.service.CommentService;
import com.example.youtubeClone.service.ReplyService;
import com.example.youtubeClone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

// 개발할 때 편의를 위해서 사용하는 컨트롤러입니다.
// 개발이 완료되면 제거해주세요
@Controller
@RequiredArgsConstructor
public class MainController {

    private final CommentService commentService;
    private final ReplyService replyService;
    private final VideoService videoService;

    @GetMapping("/")
    public String mainForm(Model model) throws GeneralSecurityException, IOException {
        List<Video> videoList = videoService.findVideoList();
        model.addAttribute("videoList", videoList);
        return "Page/searchPage";
    }

    @GetMapping("/search")
    public String searchForm() {

        return "/Page/search{age";
    }

    @GetMapping("/player")
    public String playerForm(Model model) {
        model.addAttribute("comments", commentService.findCommentAll("test"));
        return "/Page/playerPage";
    }
}
