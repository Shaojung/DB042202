package com.example.teacher.db042202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class InfoActivity extends AppCompatActivity {
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        uid = getIntent().getStringExtra("uid");
        Log.d("FCM", "uid:" + uid);
    }
}
