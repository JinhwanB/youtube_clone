package com.example.youtubeClone.repository.comment;

import com.example.youtubeClone.dto.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryCommentRepository implements CommentRepository {
    private static long sequence = 0L; // 고유 id
    private static Map<Long, Comment> commentData = new HashMap<>(); // 데이터베이스

    @Override
    public void save(Comment comment, String videoId) { // 댓글 저장
        comment.setCommentId(++sequence);
        comment.setBoardId(sequence);
        comment.setVideoId(videoId);
        commentData.put(comment.getCommentId(), comment);
    }

    @Override
    public void update(Long commentId, Comment comment) { // 댓글 수정
        Comment seletedComment = findById(commentId);
        seletedComment.setCommentName(comment.getCommentName());
        seletedComment.setCommentContent(comment.getCommentContent());
    }

    @Override
    public void delete(Long commentId) { // 댓글 삭제
        commentData.remove(commentId);
    }

    @Override
    public Comment findById(Long commentId) { // 하나의 댓글 찾기
        return commentData.get(commentId);
    }

    @Override
    public List<Comment> findAll(String videoId) { // 영상에 대한 댓글 리스트
        List<Comment> commentList = new ArrayList<>();
        for(Map.Entry<Long, Comment> entry : commentData.entrySet()){
            Comment value = entry.getValue();
            if(value.getVideoId().equals(videoId)) commentList.add(value);
        }
        return commentList;
    }


    public void clear(){ // 테스트 코드용
        commentData.clear();
    }
}
