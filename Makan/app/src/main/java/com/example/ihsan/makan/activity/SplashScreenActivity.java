package com.example.ihsan.makan.activity;

import android.os.Bundle;
import android.os.Handler;

import com.example.ihsan.makan.R;
import com.example.ihsan.makan.helper.SessionManager;

public class SplashScreenActivity extends SessionManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//       myIntent(LoginActivity.class);
//                finish();
                sessionManager.checkLogin();
            }
        },4000);

    }
}
