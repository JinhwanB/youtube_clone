package com.example.youtubeClone.repository.video;

import com.example.youtubeClone.dto.Video;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryVideoRepositoryTest {

    MemoryVideoRepository memoryVideoRepository = new MemoryVideoRepository();

    @AfterEach
    void afterEach(){
        memoryVideoRepository.clear();
    }

    @Test
    void getPopularVideos() throws GeneralSecurityException, IOException {
        memoryVideoRepository.getPopularVideos();
        System.out.println(memoryVideoRepository.getPopularVideos());
        assertThat(memoryVideoRepository.getPopularVideos()).hasSize(10);
    }

    @Test
    void getPopularVideosListExceptCurrentVideo() throws GeneralSecurityException, IOException {
        List<Video> popularVideos = memoryVideoRepository.getPopularVideos();
        Video video = popularVideos.get(0);
        List<Video> popularVideosListExceptCurrentVideo = memoryVideoRepository.getPopularVideosListExceptCurrentVideo(video.getVideoId());
        assertThat(popularVideosListExceptCurrentVideo).doesNotContain(video);
    }

    @Test
    void getVideo() throws GeneralSecurityException, IOException {
        List<Video> popularVideos = memoryVideoRepository.getPopularVideos();
        Video video = popularVideos.get(0);
        Video video1 = memoryVideoRepository.getVideo(video.getVideoId());
        assertThat(video).isEqualTo(video1);
    }
}