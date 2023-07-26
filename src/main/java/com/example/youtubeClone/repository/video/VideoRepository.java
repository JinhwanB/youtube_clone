package com.example.youtubeClone.repository.video;

import com.example.youtubeClone.dto.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface VideoRepository {

    Video getVideo(String videoId) throws GeneralSecurityException, IOException;
    List<Video> getPopularVideosListExceptCurrentVideo(String videoId) throws IOException, GeneralSecurityException;
    List<Video> getPopularVideos() throws GeneralSecurityException, IOException;
}
