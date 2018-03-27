package com.example.dell.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startB;

   /* public void start(){

        Intent openActivity = new Intent("com.example.dell.QUIZQUESTIONS");
        startActivity(openActivity);

    }
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startB = (Button)findViewById(R.id.buttonStart);

        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openActivity = new Intent("com.example.dell.QUIZQUESTIONS");
                startActivity(openActivity);
            }
        });
    }

    @Override
    protected void onPause(){

        super.onPause();
        finish();
    }
}
