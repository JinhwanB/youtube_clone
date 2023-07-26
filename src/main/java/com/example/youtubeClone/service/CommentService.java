package com.example.youtubeClone.service;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void commentCreate(Comment comment, String videoId){
        commentRepository.save(comment, videoId);
    }

    public void commentUpdate(Long commentId, Comment comment){
        commentRepository.update(commentId, comment);
    }

    public void commentDelete(Long commentId){
        commentRepository.delete(commentId);
    }

    public Comment findCommentOne(Long commentId){
        return commentRepository.findById(commentId);
    }

    public List<Comment> findCommentAll(String videoId){
        return commentRepository.findAll(videoId);
    }
}
