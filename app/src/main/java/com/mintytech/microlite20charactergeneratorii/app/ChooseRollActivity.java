package com.mintytech.microlite20charactergeneratorii.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

import java.util.Random;


public class ChooseRollActivity extends ActionBarActivity {
    Random rand = new Random();
    int[] stats = new int[3];
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = new Intent(getBaseContext(),RollActivity.class);
        setContentView(R.layout.activity_choose_roll);
        getActionBar().setTitle("Choose Rolling Method");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.choose_roll, menu);
        return true;
    }

    public void choose4d6(View v){
        for(int i=0;i<stats.length;i++){
            stats[i]=0;
            int[] rolls = new int[4];
            for(int j=0;j<rolls.length;j++){
                rolls[j] = 1+rand.nextInt(6);
            }
            int lowest=0;
            for(int j=1;j<rolls.length;j++) if(rolls[j] < rolls[lowest]) lowest=j;
            rolls[lowest] = 0;
            for(int j=0;j<rolls.length;j++) stats[i]+=rolls[j];
        }

        intent.putExtra("stats",stats);
        startActivity(intent);
    }

    public void choose3d6(View v){
        for(int i=0;i<stats.length;i++){
            stats[i] = 0;
            for(int j=0;j<3;j++) stats[i]+=1+rand.nextInt(6);
        }
        intent.putExtra("stats",stats);
        startActivity(intent);
    }

    public void choosePointBuy(View v){
        for(int i=0;i<stats.length;i++) stats[i] = 11;
        intent.putExtra("stats",stats);
        startActivity(intent);
    }

}
