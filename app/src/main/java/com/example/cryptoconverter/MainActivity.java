package com.example.cryptoconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1, sp2;
    EditText ed1;
    Button b1, questions, rate;
    TextView rateMeTextView;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);

        questions = (Button) findViewById(R.id.questions);
        rate = (Button) findViewById(R.id.rate);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        String[] from = {"Doge Coin", "ETH", "Bitcoin", "USD", "CAKE", "Litecoin", "Uniswap"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] to = {"Doge Coin", "ETH", "Bitcoin", "USD", "CAKE", "Litecoin", "Uniswap"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);

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

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rate = new Intent(getApplicationContext(), RateMe.class);
                startActivity(rate);
            }
        });

        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Double total;
                Double amount = Double.parseDouble(ed1.getText().toString());

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    b1.startAnimation(scaleUp);

                    //--------------------------From USD to other Currencies----------------------------------
                    if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 2.61;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 0.000334;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.000017;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 0.027503;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From Doge Coin to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "Doge Coin" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 0.555378;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Doge Coin" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 0.000141;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Doge Coin" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.00000946;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Doge Coin" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 0.014209;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Doge Coin" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From ETH to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "ETH" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 3941.94;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "ETH" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.06715286;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "ETH" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 7034.31;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "ETH" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 100.17;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "ETH" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From Bitcoin to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "Bitcoin" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 57406.08;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Bitcoin" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 19.18;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Bitcoin" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 149727.46;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Bitcoin" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 1585.06;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Bitcoin" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From CAKE to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "CAKE" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 36.31;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "CAKE" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 0.010260;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "CAKE" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 52.27;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "CAKE" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.00063053;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "CAKE" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From Litecoin to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 329.54;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 0.080716;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 601.74;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.00659306;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 10.38;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Litecoin" && sp2.getSelectedItem().toString() == "Litecoin"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    //----------------------------------------------------------------------------------------
                    //--------------------------From Uniswap to other Currencies----------------------------
                    if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "USD"){
                        total = amount * 40.83;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "ETH"){
                        total = amount * 0.009939;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "Doge Coin"){
                        total = amount * 73.96;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "Bitcoin"){
                        total = amount * 0.00081034;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "CAKE"){
                        total = amount * 1.28;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "Litecoin"){
                        total = amount * 0.123056;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else if(sp1.getSelectedItem().toString() == "Uniswap" && sp2.getSelectedItem().toString() == "Uniswap"){
                        total = amount * 1;
                        Toast.makeText(getApplicationContext(),total.toString(), Toast.LENGTH_SHORT).show();
                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    b1.startAnimation(scaleDown);
                }
                return true;
            }
        });
    }
}