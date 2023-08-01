package com.example.youtubeClone.dto;

import lombok.Getter;

@Getter
public class Heart {
    private int like;         // 좋아요 수
    private boolean isLiked;   // 좋아요 여부

    private int dislike;         //싫어요 수
    private boolean isDisliked;   // 싫어요 여부

    public Heart() {
        this.like = 0;
        isLiked = false;
        dislike = 0;
        isDisliked = false;
    }

    public boolean getIsLike(){
        return this.isLiked;
    }

    public boolean getIsDisLike() {
        return this.isDisliked;
    }

    // 좋아요 기능
    public void updateLike() {
        if(!getIsLike()) {
            this.like+=1;
            isLiked = true;
        } else {
            this.like -= 1;
            isLiked = false;
        }
    }

    // 싫어요 기능, 추후 사용
    public void updateDislike() {
        if(!getIsDisLike()) {
            this.dislike += 1;
            isDisliked = true;
        } else {
            this.dislike -= 1;
            isDisliked = false;
        }
    }
}