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
    public Video getVideo(String videoId) throws GeneralSecurityException, IOException { // 영상 하나의 데이터 가져오기
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
    public List<Video> getPopularVideosListExceptCurrentVideo(String videoId) throws IOException, GeneralSecurityException { // 현재 재생되는 영상 제외한 나머지 영상 리스트
        YoutubeApi apiClient = new YoutubeApi();
        List<Video> popularVideos = apiClient.getPopularVideos();
        popularVideos.removeIf(video -> video.getVideoId().equals(videoId));
        return popularVideos;
    }

    @Override
    public List<Video> getPopularVideos() throws GeneralSecurityException, IOException { // 유튜브 인기 동영상 10개 리스트
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
