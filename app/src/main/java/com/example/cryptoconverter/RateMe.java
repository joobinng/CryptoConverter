package com.example.cryptoconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RateMe extends AppCompatActivity{
    Button submit, cancel;
    EditText feedback;

    Animation scaleUp, scaleDown;

    DBHelperFeedback DBfeed;
    Boolean insertfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback = findViewById(R.id.feedback);

        submit = (Button) findViewById(R.id.submit);
        cancel = (Button) findViewById(R.id.cancel);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        DBfeed = new DBHelperFeedback(this);

        submit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String feed = feedback.getText().toString();

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    submit.startAnimation(scaleUp);

                    if(feed.equals("")) {
                        Toast.makeText(RateMe.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    }
                    else{
                            Boolean checkfeed = DBfeed.checkfeedback(feed);
                            if(checkfeed == false) {
                                insertfeed = DBfeed.insertData(feed);
                                if(insertfeed == true) {
                                    Toast.makeText(RateMe.this, "Thank you for your Feedback", Toast.LENGTH_SHORT).show();
                                    Intent feedfinished = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(feedfinished);
                                }
                                else{
                                    Toast.makeText(RateMe.this, "Thank you for your Feedback", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(RateMe.this, "You have already left feedback. Thank you", Toast.LENGTH_SHORT).show();
                            }
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    submit.startAnimation(scaleDown);
                }
                return true;
            }
        });

        cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    cancel.startAnimation(scaleUp);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    cancel.startAnimation(scaleDown);
                }
                return true;
            }
        });
    }
}
