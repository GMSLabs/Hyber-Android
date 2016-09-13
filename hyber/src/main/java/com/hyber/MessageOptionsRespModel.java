package com.hyber;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MessageOptionsRespModel {

    @SerializedName("img")
    private String mImageUrl;

    @SerializedName("action")
    private String mAction;

    @SerializedName("caption")
    private String mCaption;


    @Nullable
    public String getImageUrl() {
        return mImageUrl;
    }

    @Nullable
    public String getAction() {
        return mAction;
    }

    @Nullable
    public String getCaption() {
        return mCaption;
    }

}
