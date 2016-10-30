package com.bokaromart.rawnews.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ashdey on 9/6/16.
 */
public class RssPollService extends IntentService {
    private static final String TAG = "RssPollService";

    public RssPollService() {
        super(TAG);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, RssPollService.class);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Polling started ...");

    }
}
