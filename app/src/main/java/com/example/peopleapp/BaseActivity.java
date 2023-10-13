package com.example.peopleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public abstract class BaseActivity extends AppCompatActivity {
    private String activityName;

    public BaseActivity() {
        activityName = this.getClass().getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(activityName, "onStart() triggered");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(activityName, "onPause() triggered");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(activityName, "onResume() triggered");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(activityName, "onStop() triggered");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(activityName, "onSaveInstance() triggered");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(activityName, "onRestoreInstanceState() triggered");
    }
}