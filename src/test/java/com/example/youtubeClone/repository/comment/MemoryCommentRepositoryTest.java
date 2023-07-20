package com.example.youtubeClone.repository.comment;

import com.example.youtubeClone.dto.Comment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryCommentRepositoryTest {

    MemoryCommentRepository memoryCommentRepository = new MemoryCommentRepository();

    @AfterEach
    public void afterEach(){
        memoryCommentRepository.clear();
    }

    @Test
    void save() {
        Comment comment = new Comment();
        comment.setCommentName("배진환");
        comment.setCommentContent("안녕하세요");

        memoryCommentRepository.save(comment);

        Comment result = memoryCommentRepository.findById(comment.getCommentId());
        assertThat(comment).isEqualTo(result);
    }

    @Test
    void update() {
        Comment comment = new Comment();
        comment.setCommentContent("안녕하세요");
        memoryCommentRepository.save(comment);

        Comment comment1 = new Comment();
        comment1.setCommentContent("안녕");
        memoryCommentRepository.update(comment.getCommentId(), comment1);

        assertThat(comment1.getCommentContent()).isEqualTo(comment.getCommentContent());
    }

    @Test
    void delete() {
        Comment comment = new Comment();
        comment.setCommentName("배진환");
        comment.setCommentContent("안녕하세요");
        memoryCommentRepository.save(comment);

        memoryCommentRepository.delete(comment.getCommentId());

        assertThat(memoryCommentRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    void findById() {
        Comment comment = new Comment();
        comment.setCommentName("배진환");
        memoryCommentRepository.save(comment);

        Comment result = memoryCommentRepository.findById(comment.getCommentId());

        assertThat(comment).isEqualTo(result);
    }

    @Test
    void findAll() {
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        comment.setCommentName("배진환");
        comment1.setCommentName("김경규");
        memoryCommentRepository.save(comment);
        memoryCommentRepository.save(comment1);

        List<Comment> result = memoryCommentRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}