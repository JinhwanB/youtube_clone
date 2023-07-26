package com.example.youtubeClone.service;

import com.example.youtubeClone.dto.Video;
import com.example.youtubeClone.repository.video.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public Video findVideo(String videoId) throws GeneralSecurityException, IOException {
        return videoRepository.getVideo(videoId);
    }

    public List<Video> findVideoListExceptCurrentVideo(String videoId) throws GeneralSecurityException, IOException {
        return videoRepository.getPopularVideosListExceptCurrentVideo(videoId);
    }

    public List<Video> findVideoList() throws GeneralSecurityException, IOException {
        return videoRepository.getPopularVideos();
    }
}
