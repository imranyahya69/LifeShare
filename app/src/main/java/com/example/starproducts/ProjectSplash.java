package com.example.starproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectSplash extends AppCompatActivity {

    Button sBtn;
    Animation tAnim, bAnim;
    Button bB;
    ImageView tI;
    TextView bT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_project_splash);
        tAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bAnim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);
        tI = findViewById(R.id.sImage);
        bT = findViewById(R.id.splashText);

        tI.setAnimation(tAnim);
        bT.setAnimation(bAnim);


        sBtn = (Button) findViewById(R.id.splashButton);
        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ProjectSplash.this, MainActivity.class);
                startActivity(in);

            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.getStackTrace();
                } finally {
                    Intent intent = new Intent(ProjectSplash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}