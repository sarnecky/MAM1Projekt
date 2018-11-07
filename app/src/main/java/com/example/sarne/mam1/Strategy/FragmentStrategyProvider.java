package com.example.sarne.mam1.Strategy;

import com.example.sarne.mam1.R;
import com.example.sarne.mam1.Strategy.Stategies.CameraStrategy;
import com.example.sarne.mam1.Strategy.Stategies.VRGalleryStrategy;
import com.example.sarne.mam1.Transactions.FragmentTransactionMaker;

import java.util.Map;
import java.util.TreeMap;

public class FragmentStrategyProvider {
    private static Map<String, IStrategy> _strategies;
    private static FragmentTransactionMaker _fragmentTransactionMaker;

    private FragmentStrategyProvider(){
        _fragmentTransactionMaker = new FragmentTransactionMaker();
        _strategies = CreateStrategies();
    }

    public static FragmentStrategyProvider Create(){
        return new FragmentStrategyProvider();
    }

    public static IStrategy Get(String id){
        return _strategies.get(id);
    }

    private static Map<String, IStrategy> CreateStrategies(){
        TreeMap<String, IStrategy> dic =  new TreeMap<String, IStrategy>();
        dic.put(String.valueOf(R.id.nav_camera), new CameraStrategy(_fragmentTransactionMaker));
        dic.put(String.valueOf(R.id.nav_gallery), new VRGalleryStrategy(_fragmentTransactionMaker));
        return dic;
    }
}
