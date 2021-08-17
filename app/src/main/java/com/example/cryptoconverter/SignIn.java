package com.example.cryptoconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, password;
    Button btnlogin, questions;

    DBHelper DB;

    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.signin1);

        questions = (Button) findViewById(R.id.questions);

        DB = new DBHelper(this);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        questions.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    questions.startAnimation(scaleUp);
                    startActivity(new Intent(getApplicationContext(), Help.class));
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    questions.startAnimation(scaleDown);
                }
                return true;
            }
        });

        btnlogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnlogin.startAnimation(scaleUp);

                    if(user.equals("")||pass.equals(""))
                        Toast.makeText(SignIn.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                        if(checkuserpass==true){
                            Toast.makeText(SignIn.this, "Signed in successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), StartPage.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SignIn.this, "Invalid Login Information", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    btnlogin.startAnimation(scaleDown);
                }
                return true;
            }
        });
    }
}