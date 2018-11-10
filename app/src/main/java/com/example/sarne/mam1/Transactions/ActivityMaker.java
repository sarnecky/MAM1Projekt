package com.example.sarne.mam1.Transactions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class ActivityMaker extends AppCompatActivity {

    public void Commit(Context context, Class<?> cls){
        Intent newAct = new Intent(context, cls);
        context.startActivity(newAct);
    }
}
