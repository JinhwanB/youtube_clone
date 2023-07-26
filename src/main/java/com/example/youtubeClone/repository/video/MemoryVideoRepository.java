package com.example.youtubeClone.repository.video;

import com.example.youtubeClone.api.YoutubeApi;
import com.example.youtubeClone.dto.Video;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryVideoRepository implements VideoRepository{

    private static List<Video> videoData = new ArrayList<>();

    @Override
    public Video getVideo(String videoId) throws GeneralSecurityException, IOException {
        List<Video> popularVideos = getPopularVideos();
        Video result = null;
        for(Video video : popularVideos){
            if(video.getVideoId().equals(videoId)){
                result = video;
            }
        }
        return result;
    }

    @Override
    public List<Video> getPopularVideosListExceptCurrentVideo(String videoId) throws IOException, GeneralSecurityException {
        YoutubeApi apiClient = new YoutubeApi();
        List<Video> popularVideos = apiClient.getPopularVideos();
        popularVideos.removeIf(video -> video.getVideoId().equals(videoId));
        return popularVideos;
    }

    @Override
    public List<Video> getPopularVideos() throws GeneralSecurityException, IOException {
        YoutubeApi apiClient = new YoutubeApi();
        if(videoData.isEmpty()){
            List<Video> popularVideos = apiClient.getPopularVideos();
            videoData.addAll(popularVideos);
            return videoData;
        }else{
            return videoData.stream().toList();
        }
    }

    public void clear(){
        videoData.clear();
    }
}
