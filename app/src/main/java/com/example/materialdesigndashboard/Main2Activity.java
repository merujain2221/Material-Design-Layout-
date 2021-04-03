package com.example.materialdesigndashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class Main2Activity extends AppCompatActivity {
    ImageView imageslpash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageslpash= (ImageView) findViewById(R.id.imageslpash);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        imageslpash.startAnimation(myanim);

        Thread mythread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i= new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        mythread.start();


    }
}
