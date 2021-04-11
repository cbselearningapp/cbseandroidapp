package com.basith.cbseapp.Activities.ChaptersActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basith.cbseapp.Activities.ContentActivity.ContentActivity;
import com.basith.cbseapp.R;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    public ArrayList<ChapterModel> chapters;
    Context context;

    public ChapterAdapter(ArrayList<ChapterModel> chapters, Context context) {
        this.chapters = chapters;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_useful_links, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ChapterModel myListData = chapters.get(position);
        holder.papername.setText(myListData.name);
        final int pos = position;
        holder.lineralayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent in = new Intent(context, ContentActivity.class);
                    in.putExtra("chapter", Integer.toString(myListData.id));
                    context.startActivity(in);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView papername;
        public LinearLayout lineralayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.papername = (TextView) itemView.findViewById(R.id.title);
            this.lineralayout = (LinearLayout) itemView.findViewById(R.id.lineralayout);
        }
    }
}

