package com.example.sarne.mam1.Transactions;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.sarne.mam1.CameraFragment;
import com.example.sarne.mam1.R;

public class FragmentTransactionMaker extends AppCompatActivity {

    public void Commit(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
