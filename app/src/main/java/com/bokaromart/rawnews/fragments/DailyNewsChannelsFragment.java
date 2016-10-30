package com.bokaromart.rawnews.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bokaromart.rawnews.R;
import com.bokaromart.rawnews.activity.DrawerItemActivity;
import com.bokaromart.rawnews.pojo.NewsChannelData;
import com.bokaromart.rawnews.pojo.NewsDataLab;

import java.util.Map;

/**
 * Created by ashdey on 8/22/16.
 */
public class DailyNewsChannelsFragment extends Fragment {
    private NewsDataLab newsDataLab;
    public DailyNewsChannelsFragment() {
        super();
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsDataLab = NewsDataLab.getInstance(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.daily_news_channel_fragment, container, false);
        GridView gridView = (GridView)v.findViewById(R.id.gridview);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
