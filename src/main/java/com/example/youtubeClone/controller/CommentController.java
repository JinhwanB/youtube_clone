package com.example.youtubeClone.controller;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/video/comment") // "localhost:8080/video/comment"로 들어오는 요청 처리
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create/{id}") // 댓글 작성
    public String createComment(@PathVariable String id,  Comment comment){
        commentService.commentCreate(comment, id);
        return "redirect:/video?id=" + id;
    }

    @PostMapping("/updated/{id}") // 댓글 수정
    public String updatedComment(@PathVariable Long id, Comment comment){
        commentService.commentUpdate(id, comment);
        String videoId = commentService.findCommentOne(id).getVideoId();
        return "redirect:/video?id=" + videoId;
    }

    @GetMapping("/delete") // 댓글 삭제
    public String deleteComment(@RequestParam Long id){
        String videoId = commentService.findCommentOne(id).getVideoId();
        commentService.commentDelete(id);
        return "redirect:/video?id=" + videoId;
    }
}
