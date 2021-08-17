package com.example.cryptoconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    private Button start, help, info, rate;

    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        start = findViewById(R.id.start);
        help = findViewById(R.id.help);
        info = findViewById(R.id.info);
        rate = findViewById(R.id.rate);

        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    start.startAnimation(scaleUp);
                    openConverter();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    start.startAnimation(scaleDown);
                }
                return true;
            }
        });

        rate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    rate.startAnimation(scaleUp);
                    openFeedback();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    rate.startAnimation(scaleDown);
                }
                return true;
            }
        });

        info.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    info.startAnimation(scaleUp);
                    Intent infor = new Intent(getApplicationContext(), Informational.class);
                    startActivity(infor);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    info.startAnimation(scaleDown);
                }
                return true;
            }
        });

        help.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    help.startAnimation(scaleUp);
                    openHelp();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    help.startAnimation(scaleDown);
                }
                return true;
            }
        });
    }
    public void openConverter(){
        Intent convert = new Intent(this, MainActivity.class);
        startActivity(convert);
    }
    public void openHelp(){
        Intent helper = new Intent(this, Help.class);
        startActivity(helper);
    }
    public void openFeedback(){
        Intent rater = new Intent(this, RateMe.class);
        startActivity(rater);
    }
}