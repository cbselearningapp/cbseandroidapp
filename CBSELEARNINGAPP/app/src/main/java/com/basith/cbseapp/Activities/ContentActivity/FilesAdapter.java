package com.basith.cbseapp.Activities.ContentActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basith.cbseapp.R;

import java.util.ArrayList;

public class FilesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> listdata;

    Context context;

    public FilesAdapter(ArrayList<Object> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || listdata.get(position) instanceof ContentModel) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_item_links, parent, false);
            ViewHolder1 viewHolder = new ViewHolder1(listItem);
            return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final ContentModel myListData = (ContentModel) listdata.get(position);
            ViewHolder1 holder1 = (ViewHolder1) holder;
            String str = myListData.title;
            String cap = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
            holder1.title.setText(cap);
            holder1.number.setText("");

            if(myListData.type.equals("PDF")){
                holder1.hin_image.setBackgroundResource(R.drawable.pdf);
                holder1.lineralayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent in = new Intent(context, Pdfctivity.class);
//                        in.putExtra("url",myListData.url);
//                        in.putExtra("title",myListData.title);
//                        context.startActivity(in);
                    }
                });

            }else if(myListData.type.equals("YOUTUBE")){
                holder1.hin_image.setBackgroundResource(R.drawable.youtube);
                holder1.lineralayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent web =  new Intent(context, WebActivity.class);
//                        web.putExtra("url",myListData.url);
//                        web.putExtra("type","YOUTUBE");
//                        context.startActivity(web);
                    }
                });



            }else if(myListData.type.equals("WEBSITE")){
                holder1.hin_image.setBackgroundResource(R.drawable.resource);
                holder1.lineralayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent web =  new Intent(context, WebActivity.class);
//                        web.putExtra("url",myListData.url);
//                        web.putExtra("type","WEBSITE");
//                        context.startActivity(web);
                    }
                });
            }
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        public TextView title,number;
        ImageView hin_image;
        public LinearLayout lineralayout;
        public ViewHolder1(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.number = (TextView) itemView.findViewById(R.id.number);
            this.hin_image = (ImageView) itemView.findViewById(R.id.image);
            lineralayout = (LinearLayout) itemView.findViewById(R.id.lineralayout);
        }
    }


}



