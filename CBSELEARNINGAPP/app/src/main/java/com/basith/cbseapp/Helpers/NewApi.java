package com.basith.cbseapp.Helpers;

import com.basith.cbseapp.Activities.ChaptersActivity.JSONResponseChapter;
import com.basith.cbseapp.Activities.ContentActivity.JSONResponseContent;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NewApi {

    @POST("chapters")
    Call<JSONResponseChapter> getChaptersNew(@Query("subject") String subject);

    @POST("content")
    Call<JSONResponseContent> getContentsNew(@Query("chapter") String chapter);

}
