package com.example.youtubeClone.repository.Reply;


import com.example.youtubeClone.dto.Reply;

import java.util.List;

public interface ReplyRepository {
    void save(Long parentId, Reply reply);
    void update(Long id, Reply reply);
    void delete(Long id);
    List<Reply> findByParentId(Long parentId);

    Reply findById(Long id);

    void clear();
}
