package com.basith.cbseapp.Activities.ContentActivity;

import java.util.ArrayList;

public class JSONResponseContent {

    public ArrayList<ContentModel> content;


    public JSONResponseContent(ArrayList<ContentModel> content) {
        this.content = content;
    }

    public ArrayList<ContentModel> getContent() {
        return content;
    }
}
