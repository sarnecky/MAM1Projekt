package com.example.sarne.mam1.Strategy;

import com.example.sarne.mam1.R;
import com.example.sarne.mam1.Strategy.Stategies.CameraStrategy;
import com.example.sarne.mam1.Strategy.Stategies.CheckWeatherStrategy;
import com.example.sarne.mam1.Strategy.Stategies.StepCounterStrategy;
import com.example.sarne.mam1.Strategy.Stategies.VRGalleryStrategy;
import com.example.sarne.mam1.Transactions.ActivityMaker;

import java.util.Map;
import java.util.TreeMap;

public class ActivityStrategyProvider {
    private static Map<String, IStrategy> _strategies;
    private static ActivityMaker _activityMaker;

    private ActivityStrategyProvider(){
        _activityMaker = new ActivityMaker();
        _strategies = CreateStrategies();
    }

    public static ActivityStrategyProvider Create(){
        return new ActivityStrategyProvider();
    }

    public static IStrategy Get(String id){
        return _strategies.get(id);
    }

    private static Map<String, IStrategy> CreateStrategies(){
        TreeMap<String, IStrategy> dic =  new TreeMap<String, IStrategy>();
        dic.put(String.valueOf(R.id.nav_camera), new CameraStrategy(_activityMaker));
        dic.put(String.valueOf(R.id.nav_gallery), new VRGalleryStrategy(_activityMaker));
        dic.put(String.valueOf(R.id.nav_stepCounter), new StepCounterStrategy(_activityMaker));
        dic.put(String.valueOf(R.id.nav_checkWeather), new CheckWeatherStrategy(_activityMaker));
        return dic;
    }
}
