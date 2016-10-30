package com.bokaromart.rawnews.pojo;

import android.graphics.Bitmap;

import com.bokaromart.rawnews.pojo.enums.NewsCategory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NewsChannelData {
    private UUID newsChannelId;
    private String channelImageLink;
    private Bitmap channelImage;
    private Map<NewsCategory, List<News>> newsCategoryListMap;
}
