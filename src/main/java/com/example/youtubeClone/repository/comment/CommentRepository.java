package com.example.youtubeClone.repository.comment;

import com.example.youtubeClone.dto.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);
    void update(Long commentId, Comment comment);
    void delete(Long commentId);
    Comment findById(Long commentId);
    List<Comment> findAll();
}
