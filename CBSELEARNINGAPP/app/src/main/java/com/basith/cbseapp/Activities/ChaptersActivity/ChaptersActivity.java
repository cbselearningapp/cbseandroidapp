package com.basith.cbseapp.Activities.ChaptersActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.basith.cbseapp.Activities.BaseActivity;
import com.basith.cbseapp.Helpers.NewApi;
import com.basith.cbseapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChaptersActivity extends BaseActivity {

    String subjectId;
    RecyclerView paper_recyclerview;
    public ArrayList<ChapterModel> chapters;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_content;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        subjectId = getIntent().getStringExtra("subjectId");
        paper_recyclerview = findViewById(R.id.paper_recyclerview);
        chapters = new ArrayList<ChapterModel>();
        getData(subjectId);
    }

    public void setAdapter(){
        ChapterAdapter adapter = new ChapterAdapter(chapters,this);
        paper_recyclerview.setHasFixedSize(true);
        paper_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        paper_recyclerview.setAdapter(adapter);
    }

    public void getData(String subject){
        super.showLoader();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qatar2022.link/app/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewApi api = retrofit.create(NewApi.class);
        Call<JSONResponseChapter> call = api.getChaptersNew(subject);
        call.enqueue(new Callback<JSONResponseChapter>() {
            @Override
            public void onResponse(Call<JSONResponseChapter> call, Response<JSONResponseChapter> response) {
                try {
                    chapters = response.body().chapters;
                    setAdapter();
                }catch (Exception e){
                    Toast.makeText(ChaptersActivity.this, e.getMessage()+"hello", Toast.LENGTH_SHORT).show();
                }
                ChaptersActivity.super.dismissLoader();
            }

            @Override
            public void onFailure(Call<JSONResponseChapter> call, Throwable t) {
                ChaptersActivity.super.dismissLoader();
                Toast.makeText(ChaptersActivity.this, "error" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}