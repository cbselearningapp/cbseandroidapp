package com.basith.cbseapp.Activities.ContentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.basith.cbseapp.Activities.BaseActivity;
import com.basith.cbseapp.Helpers.NewApi;
import com.basith.cbseapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContentActivity extends BaseActivity {


    String chapter;
    ArrayList<ContentModel> listdata;
    ArrayList<Object> listdata1;
    RecyclerView paper_recyclerview;

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_content;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chapter = getIntent().getStringExtra("chapter");
        listdata = new ArrayList<ContentModel>();
        listdata1 = new ArrayList<Object>();
        paper_recyclerview = findViewById(R.id.paper_recyclerview);
        getData(chapter);

    }

    public void setAdapter(){
        FilesAdapter adapter = new FilesAdapter(listdata1,this);
        paper_recyclerview.setHasFixedSize(true);
        paper_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        paper_recyclerview.setAdapter(adapter);
    }


    public void getData(String chapter){
        super.showLoader();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qatar2022.link/app/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewApi api = retrofit.create(NewApi.class);
        Call<JSONResponseContent> call = api.getContentsNew(chapter);
        call.enqueue(new Callback<JSONResponseContent>() {
            @Override
            public void onResponse(Call<JSONResponseContent> call, Response<JSONResponseContent> response) {
                try {
                    listdata = response.body().content;
                    for (ContentModel a : listdata) {
                        listdata1.add(a);
                    }
                    if (listdata1.size()>5){
                        for (int i = 5; i <= listdata1.size(); i += 10){
                            listdata1.add(i, new Object());
                        }
                    }
                    setAdapter();
                }catch (Exception e){

                }
                ContentActivity.super.dismissLoader();
            }

            @Override
            public void onFailure(Call<JSONResponseContent> call, Throwable t) {
                ContentActivity.super.dismissLoader();

            }
        });

    }
}