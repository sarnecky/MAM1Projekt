package com.example.sarne.mam1.Strategy.Stategies;

import android.content.Context;

import com.example.sarne.mam1.CameraActivity;
import com.example.sarne.mam1.StepCounterActivity;
import com.example.sarne.mam1.Strategy.IStrategy;
import com.example.sarne.mam1.Transactions.ActivityMaker;

public class StepCounterStrategy implements IStrategy {

    private ActivityMaker _activityMaker;

    public StepCounterStrategy(ActivityMaker activityMaker){
        _activityMaker = activityMaker;
    }
    @Override
    public void showActivity(Context context) {
        _activityMaker.Commit(context, StepCounterActivity.class);
    }
}