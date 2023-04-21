package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    private TextView tv1spalsh;
    private String mTextToType = "BMI CALCULATOR APP ";
    private Handler mHandler;
    private Runnable mTypeRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv1spalsh=findViewById(R.id.welcome);


        tv1spalsh.setText("");

        mHandler = new Handler();
        mTypeRunnable = new Runnable() {
            @Override
            public void run() {
                if (mTextToType.length() > 0) {
                    tv1spalsh.setText(tv1spalsh.getText().toString() + mTextToType.charAt(0));
                    mTextToType = mTextToType.substring(1);
                    mHandler.postDelayed(mTypeRunnable, 70); // Change the delay time to adjust typing speed
                }
            }
        };

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    sleep(3000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Intent intent=new Intent(splash.this,MainActivity.class);
                startActivity(intent);
                splash.this.finish();
            }
        }.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mTypeRunnable, 1000); // Change the delay time to adjust when the typing starts
    }
    }
