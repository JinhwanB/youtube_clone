package com.example.youtubeClone.controller;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "redirect:/video";
    }

    @GetMapping("/update") // 댓글 수정 시 수정 전 댓글 내용 보여주기
    public String updateComment(@RequestParam Long id, Model model){
        Comment comment = commentService.findCommentOne(id);
        model.addAttribute("cComment", comment);
        return "test";
    }

    @PostMapping("/updated") // 댓글 수정 완료
    public String updatedComment(@RequestParam Long id, Comment comment){
        commentService.commentUpdate(id, comment);
        return "redirect:/video";
    }

    @GetMapping("/delete") // 댓글 삭제
    public String deleteComment(@RequestParam Long id){
        commentService.commentDelete(id);
        return "redirect:/video";
    }
}
