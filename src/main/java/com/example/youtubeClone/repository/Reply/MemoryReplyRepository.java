package com.example.youtubeClone.repository.Reply;

import com.example.youtubeClone.dto.Comment;
import com.example.youtubeClone.dto.Reply;
import com.example.youtubeClone.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryReplyRepository implements ReplyRepository{
    private static long sequence = 0L;

    private final CommentRepository commentRepository;
    private static Map<Long, Reply> replyMap = new HashMap<>();
    @Override
    public void save(Long parentId, Reply reply) {
        reply.setId(++sequence);
        reply.setParentId(parentId);
        Comment parentCommnet = commentRepository.findById(parentId);
        List<Reply> replyList = parentCommnet.getReply();
        replyList.add(reply);
        parentCommnet.setReply(replyList);
        replyMap.put(sequence, reply);
    }

    @Override
    public void update(Long id, Reply reply) {
        Reply updateReply = replyMap.get(id);
        updateReply.setContent(reply.getContent());
        updateReply.setDateTime(reply.getDateTime());
    }

    @Override
    public void delete(Long id) {
        replyMap.remove(id);
    }

    @Override
    public List<Reply> findByParentId(Long parentId) {
        List<Reply> data = new ArrayList<>();
        for(Map.Entry<Long, Reply> entry : replyMap.entrySet()) {
            if(entry.getValue().getParentId() == parentId) {
                data.add(entry.getValue());
            }
        }
        return data;
    }

    @Override
    public Reply findById(Long id) {
        return replyMap.get(id);
    }

    @Override
    public void clear() {
        replyMap.clear();
    }
}
