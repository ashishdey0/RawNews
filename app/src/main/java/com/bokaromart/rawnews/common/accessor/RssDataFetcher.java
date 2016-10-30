package com.bokaromart.rawnews.common.accessor;

import android.os.AsyncTask;
import android.util.Log;

import com.bokaromart.rawnews.pojo.News;

import java.util.List;

/**
 * Created by ashdey on 8/21/16.
 */
public class RssDataFetcher extends AsyncTask<Void, Void, List<News>> {
    private static final String TAG = "RssDataFetcher";
    private String feedUrl;

    public RssDataFetcher(final String feedUrl) {
        this.feedUrl = feedUrl;
    }

    @Override
    protected List<News> doInBackground(Void... voids) {
        RssDataFetcherUtil accessor = new RssDataFetcherUtil();
        List<News> newsList = accessor.getNews(feedUrl);
        Log.d(TAG, "Length og news list = " + newsList.size());
        return newsList;
    }
}
