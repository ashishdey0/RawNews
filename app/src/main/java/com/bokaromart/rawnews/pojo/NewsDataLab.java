package com.bokaromart.rawnews.pojo;

import android.content.Context;

import com.bokaromart.rawnews.pojo.enums.NewsCategory;

import java.util.List;
import java.util.UUID;

/**
 * Created by ashdey on 8/23/16.
 */
public class NewsDataLab {
    private static NewsDataLab instance;
    private Context context;
    private List<NewsChannelData> newsChannelDataList;

    private NewsDataLab(Context context) {
        this.context = context;
    }

    public static NewsDataLab getInstance(final Context context) {
        if (instance == null) {
            synchronized (NewsDataLab.class) {
                if (instance == null) {
                    instance = new NewsDataLab(context);
                }
            }
        }
        return instance;
    }

    public NewsChannelData getNewsChannelData(final UUID newsChannelId) {
        return null;
    }

    public void addNewsChannelData(final NewsChannelData newsChannelData) {
        newsChannelDataList.add(newsChannelData);
    }

    public List<NewsChannelData> getNewsChannelDataList() {
        return newsChannelDataList;
    }

    public void setNewsChannelDataList(List<NewsChannelData> newsChannelDataList) {
        this.newsChannelDataList = newsChannelDataList;
    }
}
