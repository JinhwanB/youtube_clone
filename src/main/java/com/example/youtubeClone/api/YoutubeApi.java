package com.example.youtubeClone.api;

import com.example.youtubeClone.dto.Video;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class YoutubeApi {

    private static final String API_KEY = "";

    private YouTube youtube;

    public YoutubeApi() throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        this.youtube = new YouTube.Builder(httpTransport, jsonFactory, null)
                .setApplicationName("youtube-api-example")
                .build();
    }

    public List<Video> getPopularVideos() throws IOException { // 유튜브 인기 동영상 10개 가져오기
        YouTube.Search.List search = youtube.search().list("id,snippet");
        search.setKey(API_KEY);
        search.setType("video");
        search.setOrder("viewCount");
        search.setMaxResults(10L);

        SearchListResponse response = search.execute();
        List<SearchResult> items = response.getItems();
        List<Video> videos = new ArrayList<>();

        for (SearchResult item : items) {
            ResourceId resourceId = item.getId();
            Video video = new Video();
            video.setVideoId(resourceId.getVideoId());
            video.setVideoTitle(item.getSnippet().getTitle());
            video.setChannelTitle(item.getSnippet().getChannelTitle());
            videos.add(video);
        }

        return videos;
    }
}
