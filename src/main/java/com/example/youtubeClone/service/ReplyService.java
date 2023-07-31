package com.example.youtubeClone.service;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.dto.Reply;
import com.example.youtubeClone.repository.Reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository repository;
    private final CommentService commentService;

    public void addReply(Long parentId, Reply reply) {
        repository.save(parentId, reply);
    }

    public void updateReply(Long id, Reply reply) {
        repository.update(id, reply);
    }

    public void deleteReply(Long parentId, Long id) {
        System.out.println("commentId : "+parentId);
        Comment comment = commentService.findCommentOne(parentId);
        List<Reply> replyList = comment.getReply();
        for(int i = 0; i < replyList.size(); i++) {
            if(replyList.get(i).getId() == id) {
                replyList.remove(i);
            }
        }
        comment.setReply(replyList);
        repository.delete(id);
    }

    public List<Reply> findByParentId(Long parentId) {
        return repository.findByParentId(parentId);
    }

    public Reply findOne(Long id) {
        return repository.findById(id);
    }
}
