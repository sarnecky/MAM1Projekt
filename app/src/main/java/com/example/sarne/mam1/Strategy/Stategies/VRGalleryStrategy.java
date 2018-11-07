package com.example.sarne.mam1.Strategy.Stategies;

import com.example.sarne.mam1.Strategy.IStrategy;
import com.example.sarne.mam1.Transactions.FragmentTransactionMaker;
import com.example.sarne.mam1.VRGalleryFragment;

public class VRGalleryStrategy implements IStrategy {

    private FragmentTransactionMaker _fragmentTransactionMaker;

    public VRGalleryStrategy(FragmentTransactionMaker fragmentTransactionMaker){
        _fragmentTransactionMaker = fragmentTransactionMaker;
    }

    @Override
    public void ShowFragment() {
        _fragmentTransactionMaker.Commit(new VRGalleryFragment());
    }
}
