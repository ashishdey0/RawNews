package com.bokaromart.rawnews.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bokaromart.rawnews.common.constant.MiscellaneousConstants;
import com.bokaromart.rawnews.fragments.DailyNewsChannelsFragment;
import com.bokaromart.rawnews.fragments.SingleFragmentActivity;
import com.bokaromart.rawnews.pojo.NewsChannelData;
import com.bokaromart.rawnews.pojo.NewsDataLab;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ashdey on 8/22/16.
 */
public class DrawerItemActivity extends SingleFragmentActivity {
    public static final String DRAWER_ITEM_ID = "com.bokaromart.rawnews.drawer.item.id";
    @Override
    protected Fragment createFragment() {
        int drawerItemId = (int) getIntent().getSerializableExtra(DRAWER_ITEM_ID);
        switch (drawerItemId) {
            case MiscellaneousConstants.DAILY_NEWS: {
                new DailyNewsChannelsFragment();
            }
            case MiscellaneousConstants.JOB_NEWS: {

            }
        }
        return null;
    }

    public static Intent newIntent(final Context packageContext, final int drawerItemId) {
        Intent intent = new Intent(packageContext, DrawerItemActivity.class);
        intent.putExtra(DRAWER_ITEM_ID, drawerItemId);
        return intent;
    }
}
