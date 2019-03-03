package com.example.shahriar_vaio.mydaytodolisthabittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class Splash extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = findViewById(R.id.tvID);
        iv = findViewById(R.id.ivID);

        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.setAnimation(myAnim);
        iv.setAnimation(myAnim);

        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {
                    startActivity(intent);
                    //CustomIntent.customType(Splash.this,"rotateout-to-rotatein");
                    finish();
                }
            }
        };

        timer.start();

    }
}
