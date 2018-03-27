package com.example.dell.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by DELL on 13-03-2018.
 */

public class QuizQuestions extends AppCompatActivity {

    ArrayList<Integer> answerOptions = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    TextView correctIncorrect;
    TextView ques;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playbutton;
    TextView pointsTextView;
    TextView timerTextView;

  public void playAgain(){

        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("0s");
        pointsTextView.setText("0/0");
        correctIncorrect.setText("");
        playbutton.setVisibility(View.INVISIBLE);

        generateQuestion();

        new CountDownTimer(50000,1000){

            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/ 1000)+"s");

            }

            @Override
            public void onFinish() {

                correctIncorrect.setText("Your score: "+ Integer.toString(score) +"/"+ Integer.toString(numberOfQuestions) );
                timerTextView.setText("0s");

                if(numberOfQuestions == 33 && score >= 30)
                    Toast.makeText(QuizQuestions.this,"Your Speed and calculation is just perfect!",Toast.LENGTH_LONG).show();
                else if(numberOfQuestions > 33 && score >= 33)
                    Toast.makeText(QuizQuestions.this,"Your Superfast!!",Toast.LENGTH_LONG).show();
                else if(numberOfQuestions < 33 && score >= (numberOfQuestions-3))
                    Toast.makeText(QuizQuestions.this,"You need to improve your speed...Try Again!!",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(QuizQuestions.this,"Improvement is required....Keep Practising!!",Toast.LENGTH_LONG).show();


                playbutton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void generateQuestion(){

        //generating expression randomly for the user to solve them
        Random rand = new Random();
        int a = rand.nextInt(51);
        int b = rand.nextInt(51);

        ques.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        answerOptions.clear();
        int incorrectAnswer;

        //setting up the answer options for all the 4 buttons
        for(int i =0 ; i<4 ; i++) {
            if (i == locationOfCorrectAnswer)
                answerOptions.add(a + b);
            else {

                incorrectAnswer = rand.nextInt(101);

                while( incorrectAnswer == (a+b))
                {
                    incorrectAnswer = rand.nextInt();
                }
                answerOptions.add(incorrectAnswer);

            }
        }
        button1.setText(Integer.toString(answerOptions.get(0)));
        button2.setText(Integer.toString(answerOptions.get(1)));
        button3.setText(Integer.toString(answerOptions.get(2)));
        button4.setText(Integer.toString(answerOptions.get(3)));
    }

    //displays whether the option selected by the user is correct or not and
    // set the textview for that accordingly by matching the tag value of buttons
    public void chooseAnswer(View view){

        correctIncorrect = (TextView)findViewById(R.id.correctOrIncorrect);

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){

            score++;
            correctIncorrect.setText("Correct");
        }
        else{

            correctIncorrect.setText("Wrong");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) +"/"+ Integer.toString(numberOfQuestions));
        generateQuestion();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_up);

        ques = (TextView)findViewById(R.id.quesTextView);
        button1 = (Button)findViewById(R.id.option1);
        button2 = (Button)findViewById(R.id.option2);
        button3 = (Button)findViewById(R.id.option3);
        button4 = (Button)findViewById(R.id.option4);
        pointsTextView = (TextView)findViewById(R.id.marksTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        playbutton = (Button)findViewById(R.id.playAgainButton);

        generateQuestion();

        new CountDownTimer(50000,1000){

            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/ 1000)+"s");

            }

            @Override
            public void onFinish() {

                correctIncorrect.setText("Your score: "+ Integer.toString(score) +"/"+ Integer.toString(numberOfQuestions) );
                timerTextView.setText("0s");

                if(numberOfQuestions == 33 && score >= 30)
                    Toast.makeText(QuizQuestions.this,"Your Speed and calculation is just perfect!",Toast.LENGTH_LONG).show();
                else if(numberOfQuestions > 33 && score >= 33)
                    Toast.makeText(QuizQuestions.this,"Your Superfast!!",Toast.LENGTH_LONG).show();
                else if(numberOfQuestions < 33 && score >= (numberOfQuestions-3))
                    Toast.makeText(QuizQuestions.this,"You need to improve your speed...Try Again!!",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(QuizQuestions.this,"Improvement is required....Keep Practising!!",Toast.LENGTH_LONG).show();

                playbutton.setVisibility(View.VISIBLE);
            }
        }.start();

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playAgain();
            }
        });
    }
}
