package com.example.youtubeClone.repository.comment;

import com.example.youtubeClone.dto.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryCommentRepository implements CommentRepository {
    private static long sequence = 0L;
    private static Map<Long, Comment> commentData = new HashMap<>();

    @Override
    public void save(Comment comment, String videoId) {
        comment.setCommentId(++sequence);
        comment.setBoardId(sequence);
        comment.setVideoId(videoId);
        commentData.put(comment.getCommentId(), comment);
    }

    @Override
    public void update(Long commentId, Comment comment) {
        Comment seletedComment = findById(commentId);
        seletedComment.setCommentName(comment.getCommentName());
        seletedComment.setCommentContent(comment.getCommentContent());
    }

    @Override
    public void delete(Long commentId) {
        commentData.remove(commentId);
    }

    @Override
    public Comment findById(Long commentId) {
        return commentData.get(commentId);
    }

    @Override
    public List<Comment> findAll(String videoId) {
        List<Comment> commentList = new ArrayList<>();
        for(Map.Entry<Long, Comment> entry : commentData.entrySet()){
            Comment value = entry.getValue();
            if(value.getVideoId().equals(videoId)) commentList.add(value);
        }
        return commentList;
    }


    public void clear(){
        commentData.clear();
    }
}
