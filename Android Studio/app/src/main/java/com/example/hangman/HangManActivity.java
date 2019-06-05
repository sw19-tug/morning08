package com.example.hangman;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

import java.util.Timer;


public class HangManActivity extends AppCompatActivity implements View.OnClickListener {

    private HangMan hangman;
    private Button startButton;
    private Button checkButton;
    private Button retryButton;
    private Button tipButton;
    private ImageView ropeImage;
    private ImageView headImage;
    private ImageView faceImage;
    private ImageView bodyImage;
    private ImageView leftHandImage;
    private ImageView rightHandImage;
    private ImageView leftLegImage;
    private ImageView rightLegImage;
    private EditText input;
    private TextView output;
    private TextView score;
    private TextView guesses;
    private TextView timer;
    private long timeLeft = 600000;
    private long timeToGuess = 600000;
    private CountDownTimer cdTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        startButton = findViewById(R.id.btn_start);
        checkButton = findViewById(R.id.btn_check);
        retryButton = findViewById(R.id.btn_retry);
        tipButton = findViewById(R.id.btn_tip);
        input = (EditText) findViewById(R.id.txtInput);
        output = (TextView) findViewById(R.id.lblOutput);

        ropeImage = (ImageView) findViewById(R.id.imageViewRope);
        faceImage = (ImageView) findViewById(R.id.imageViewFace);
        headImage = (ImageView) findViewById(R.id.imageViewHead);
        bodyImage = (ImageView) findViewById(R.id.imageViewBody);
        leftHandImage = (ImageView) findViewById(R.id.imageViewLeftHand);
        leftLegImage = (ImageView) findViewById(R.id.imageViewLeftLeg);
        rightHandImage = (ImageView) findViewById(R.id.imageViewRightHand);
        rightLegImage = (ImageView) findViewById(R.id.imageViewRightLeg);
        score = (TextView) findViewById(R.id.lblScore);
        guesses = (TextView) findViewById(R.id.lblGuesses);
        timer = (TextView) findViewById(R.id.lblTimer);

        startButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
        retryButton.setOnClickListener(this);
        tipButton.setOnClickListener(this);

        ropeImage.setVisibility(View.INVISIBLE);
        headImage.setVisibility(View.INVISIBLE);
        faceImage.setVisibility(View.INVISIBLE);
        bodyImage.setVisibility(View.INVISIBLE);
        leftHandImage.setVisibility(View.INVISIBLE);
        leftLegImage.setVisibility(View.INVISIBLE);
        rightHandImage.setVisibility(View.INVISIBLE);
        rightLegImage.setVisibility(View.INVISIBLE);

        checkButton.setVisibility(View.INVISIBLE);
        retryButton.setVisibility(View.INVISIBLE);
        tipButton.setVisibility(View.INVISIBLE);

        score.setVisibility(View.INVISIBLE);
        guesses.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        output.setVisibility(View.INVISIBLE);


        hangman = new HangMan();

    }

    // load the score, output & guesses
    private void refreshScreen() {
        score.setText("Score: "+hangman.getScore());
        guesses.setText("Guesses: "+hangman.getGuessesLeft());
        output.setText(hangman.getOutput());
        input.setText("");

        switch (hangman.getGuessesLeft()) {
            case 8:
                headImage.setVisibility(View.INVISIBLE);
                ropeImage.setVisibility(View.INVISIBLE);
                faceImage.setVisibility(View.INVISIBLE);
                bodyImage.setVisibility(View.INVISIBLE);
                leftHandImage.setVisibility(View.INVISIBLE);
                leftLegImage.setVisibility(View.INVISIBLE);
                rightHandImage.setVisibility(View.INVISIBLE);
                rightLegImage.setVisibility(View.INVISIBLE);
                break;
            case 7:
                ropeImage.setVisibility(View.VISIBLE);
                break;
            case 6:
                headImage.setVisibility(View.VISIBLE);
                break;
            case 5:
                bodyImage.setVisibility(View.VISIBLE);
                break;
            case 4:
                leftHandImage.setVisibility(View.VISIBLE);
                break;
            case 3:
                leftLegImage.setVisibility(View.VISIBLE);
                break;
            case 2:
                rightHandImage.setVisibility(View.VISIBLE);
                break;
            case 1:
                rightLegImage.setVisibility(View.VISIBLE);
                break;
            case 0:
                faceImage.setVisibility(View.VISIBLE);
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                if(startButton.getText() == "Next Word"){
                    hangman.initialize();
                    refreshScreen();
                    startTimer();
                    checkButton.setVisibility(View.VISIBLE);
                    retryButton.setVisibility(View.VISIBLE);
                    tipButton.setVisibility(View.VISIBLE);
                    startButton.setVisibility(View.INVISIBLE);
                    break;
                }
                Toast.makeText(this,"Start!", Toast.LENGTH_SHORT).show();
                startButton.setVisibility(View.INVISIBLE);
                checkButton.setVisibility(View.VISIBLE);
                retryButton.setVisibility(View.VISIBLE);
                tipButton.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                guesses.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
                output.setVisibility(View.VISIBLE);
                hangman.initialize();

                refreshScreen();
                startTimer();

                break;

            case R.id.btn_check: // check the given input
                if(hangman.checkInput(input.getText().toString())) {
                    if(hangman.checkLetter(input.getText().toString())){
                        Toast.makeText(this,"This letter is a part of the searched word!",Toast.LENGTH_SHORT).show();
                        if(hangman.wordGuessed()){
                            Toast.makeText(this,"Word Guessed!",Toast.LENGTH_SHORT).show();
                            cdTimer.cancel();
                            cdTimer = null;
                            hangman.initialize();

                        }
                    }
                    else
                    {
                        if(hangman.getGuessesLeft() == 0)
                        {
                            Toast.makeText(this,"No more guesses left!",Toast.LENGTH_SHORT).show();
                            startButton.setText("Next Word");
                            checkButton.setVisibility(View.INVISIBLE);
                            retryButton.setVisibility(View.INVISIBLE);
                            tipButton.setVisibility(View.INVISIBLE);
                            startButton.setVisibility(View.VISIBLE);
                            hangman.wordGuessed();
                            refreshScreen();
                            break;

                        }
                        else
                            Toast.makeText(this,"This letter is not a part of the searched word!",Toast.LENGTH_SHORT).show();

                    }
                    refreshScreen();

                }
                // invalid input
                else
                {
                    Toast.makeText(this,"Not Correct Input!",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_tip:
                hangman.showrandomLetter();
                hangman.wordGuessed();
                refreshScreen();
                break;

            case R.id.btn_retry: // get a new word
                hangman.setScore(hangman.getScore()-2);
                hangman.initialize();
                refreshScreen();
                timeLeft = timeToGuess;
                startTimer();

                break;

        }
    }


    void startTimer() {


        cdTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                timeLeft = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish()
            {
                Toast.makeText(HangManActivity.this, "Maybe next Time ! :)", Toast.LENGTH_SHORT).show();
                startButton.setText("Next Word");
                checkButton.setVisibility(View.INVISIBLE);
                retryButton.setVisibility(View.INVISIBLE);
                tipButton.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
                hangman.wordGuessed();
                hangman.setScore(hangman.getScore()-2);
                timeLeft = timeToGuess;
                refreshScreen();
            }
        }.start();
    }


    void updateTimer() {
        int min = (int) timeLeft / 600000;
        int sec = (int) timeLeft % 600000 / 1000;

        String outputTime;

        outputTime = "" + min + ":";
        if (sec < 10)
            outputTime += "0";

        outputTime += sec;

        timer.setText(outputTime);
    }

}
