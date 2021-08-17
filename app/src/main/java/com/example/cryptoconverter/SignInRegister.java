package com.example.cryptoconverter;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInRegister extends FragmentActivity {

    EditText username, password, repassword;
    Button signin, signup, questions;
    DBHelper DB;

    Animation scaleUp, scaleDown;

    Boolean insert = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinregister);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        signup = (Button) findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);

        questions = (Button) findViewById(R.id.questions);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        DB = new DBHelper(this);

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

        signup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    signup.startAnimation(scaleUp);

                    if(user.equals("")||pass.equals("")||repass.equals("")) {
                        Toast.makeText(SignInRegister.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(pass.equals(repass)) {
                            Boolean checkuser = DB.checkusername(user);
                            if(checkuser == false) {
                                insert = DB.insertData(user, pass);
                                if(insert == true) {
                                    Toast.makeText(SignInRegister.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                    Intent success = new Intent(getApplicationContext(), StartPage.class);
                                    startActivity(success);
                                }
                                else{
                                    Toast.makeText(SignInRegister.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(SignInRegister.this, "User already exists. Please Sign in", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignInRegister.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    signup.startAnimation(scaleDown);
            }
            return true;
        }
        });

        signin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    signin.startAnimation(scaleUp);
                    Intent intent = new Intent(getApplicationContext(), SignIn.class);
                    startActivity(intent);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    signin.startAnimation(scaleDown);
                }
                return true;
            }
        });


    }
}