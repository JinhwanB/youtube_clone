package com.example.youtubeClone.service;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.repository.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void boardCreate(Comment comment){
        commentRepository.save(comment);
    }

    public void boardUpdate(Long boardId, Comment comment){
        commentRepository.update(boardId, comment);
    }

    public void boardDelete(Long boardId){
        commentRepository.delete(boardId);
    }

    public Comment findBoardOne(Long boardId){
        return commentRepository.findById(boardId);
    }

    public List<Comment> findBoardAll(){
        return commentRepository.findAll();
    }
}
