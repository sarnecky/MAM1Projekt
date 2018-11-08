package com.example.sarne.mam1.Transactions;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.sarne.mam1.R;

public class FragmentTransactionMaker extends AppCompatActivity {

    public void Commit(Fragment fragment, Context context){
        try{
            AppCompatActivity activity = (AppCompatActivity)context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)

                    .commit();
        }catch(Exception e){
            int a = 1;
        }

    }
}
