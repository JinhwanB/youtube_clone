package com.example.youtubeClone.service;

import com.example.youtubeClone.dto.Reply;
import com.example.youtubeClone.repository.Reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository repository;

    public void addReply(Long parentId, Reply reply) {
        repository.save(parentId, reply);
    }

    public void updateReply(Long id, Reply reply) {
        repository.update(id, reply);
    }

    public void deleteReply(Long id) {
        repository.delete(id);
    }

    public List<Reply> findByParentId(Long parentId) {
        return repository.findByParentId(parentId);
    }
}
