package com.example.sarne.mam1.Strategy.Stategies;

import android.content.Context;

import com.example.sarne.mam1.Strategy.IStrategy;
import com.example.sarne.mam1.Transactions.ActivityMaker;
import com.example.sarne.mam1.VRGalleryActivity;

public class VRGalleryStrategy implements IStrategy {

    private ActivityMaker _activityMaker;

    public VRGalleryStrategy(ActivityMaker activityMaker){
        _activityMaker = activityMaker;
    }

    @Override
    public void showActivity(Context context) {
        _activityMaker.Commit( context, VRGalleryActivity.class);
    }
}
