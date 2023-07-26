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
@RequestMapping("/video/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createComment(@PathVariable String id,  Comment comment){
        commentService.commentCreate(comment, id);
        return "redirect:/video";
    }

    @GetMapping("/update")
    public String updateComment(@RequestParam Long id, Model model){
        Comment comment = commentService.findCommentOne(id);
        model.addAttribute("cComment", comment);
        return "test";
    }

    @PostMapping("/updated")
    public String updatedComment(@RequestParam Long id, Comment comment){
        commentService.commentUpdate(id, comment);
        return "redirect:/video";
    }

    @GetMapping("/delete")
    public String deleteComment(@RequestParam Long id){
        commentService.commentDelete(id);
        return "redirect:/video";
    }
}
