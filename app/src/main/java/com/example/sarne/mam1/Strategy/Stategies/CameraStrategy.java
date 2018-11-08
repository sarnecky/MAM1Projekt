package com.example.sarne.mam1.Strategy.Stategies;

import android.content.Context;

import com.example.sarne.mam1.CameraFragment;
import com.example.sarne.mam1.Strategy.IStrategy;
import com.example.sarne.mam1.Transactions.FragmentTransactionMaker;

public class CameraStrategy implements IStrategy {

    private FragmentTransactionMaker _fragmentTransactionMaker;

    public CameraStrategy(FragmentTransactionMaker fragmentTransactionMaker){
        _fragmentTransactionMaker = fragmentTransactionMaker;
    }
    @Override
    public void ShowFragment(Context context) {
        _fragmentTransactionMaker.Commit(new CameraFragment(), context);
    }
}
