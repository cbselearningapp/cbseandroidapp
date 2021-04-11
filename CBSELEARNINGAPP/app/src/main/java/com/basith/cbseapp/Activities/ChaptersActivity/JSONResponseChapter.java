package com.basith.cbseapp.Activities.ChaptersActivity;

import java.util.ArrayList;
import java.util.List;

public class JSONResponseChapter {

    public ArrayList<ChapterModel> chapters;


    public JSONResponseChapter(ArrayList<ChapterModel> chapters) {
        this.chapters = chapters;
    }

    public List<ChapterModel> getChapters() {
        return chapters;
    }
}
