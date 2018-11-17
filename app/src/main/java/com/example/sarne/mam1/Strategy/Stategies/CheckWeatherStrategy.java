package com.example.sarne.mam1.Strategy.Stategies;

import android.content.Context;

import com.example.sarne.mam1.CheckWeatherActivity;
import com.example.sarne.mam1.Strategy.IStrategy;
import com.example.sarne.mam1.Transactions.ActivityMaker;

public class CheckWeatherStrategy implements IStrategy {

    private ActivityMaker _activityMaker;

    public CheckWeatherStrategy(ActivityMaker activityMaker) {
        _activityMaker = activityMaker;
    }

    @Override
    public void showActivity(Context context) {
        _activityMaker.Commit(context, CheckWeatherActivity.class);
    }
}
