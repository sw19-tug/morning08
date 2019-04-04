package com.example.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class HangManActivity extends AppCompatActivity implements View.OnClickListener {

    private HangMan hangman;
    private Button startButton;
    private Button checkButton;
    private Button retryButton;
    private ImageView headImage;
    private ImageView bodyImage;
    private ImageView leftHandImage;
    private ImageView rightHandImage;
    private ImageView leftLegImage;
    private ImageView rightLegImage;
    private EditText input;
    private TextView output;
    private TextView score;
    private TextView guesses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        startButton = findViewById(R.id.btn_start);
        checkButton = findViewById(R.id.btn_check);
        retryButton = findViewById(R.id.btn_retry);
        input = (EditText) findViewById(R.id.txtInput);
        output = (TextView) findViewById(R.id.lblOutput);
        headImage = (ImageView) findViewById(R.id.imageViewHead);
        bodyImage = (ImageView) findViewById(R.id.imageViewBody);
        leftHandImage = (ImageView) findViewById(R.id.imageViewLeftHand);
        leftLegImage = (ImageView) findViewById(R.id.imageViewLeftLeg);
        rightHandImage = (ImageView) findViewById(R.id.imageViewRightHand);
        rightLegImage = (ImageView) findViewById(R.id.imageViewRightLeg);
        score = (TextView) findViewById(R.id.lblScore);
        guesses = (TextView) findViewById(R.id.lblGuesses);


        startButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
        retryButton.setOnClickListener(this);

        headImage.setVisibility(View.INVISIBLE);
        bodyImage.setVisibility(View.INVISIBLE);
        leftHandImage.setVisibility(View.INVISIBLE);
        leftLegImage.setVisibility(View.INVISIBLE);
        rightHandImage.setVisibility(View.INVISIBLE);
        rightLegImage.setVisibility(View.INVISIBLE);

        checkButton.setVisibility(View.INVISIBLE);
        retryButton.setVisibility(View.INVISIBLE);

        score.setVisibility(View.INVISIBLE);
        guesses.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        output.setVisibility(View.INVISIBLE);

        hangman = new HangMan();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                Toast.makeText(this,"Start!", Toast.LENGTH_SHORT).show();
                hangman.initialize();
                startButton.setVisibility(View.INVISIBLE);
                checkButton.setVisibility(View.VISIBLE);
                retryButton.setVisibility(View.VISIBLE);
                score.setVisibility(View.VISIBLE);
                guesses.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
                output.setVisibility(View.VISIBLE);
                score.setText("Score: "+hangman.getScore());
                guesses.setText("Guesses: "+hangman.getGuessesLeft());
                output.setText(hangman.getOutput());
                break;

            case R.id.btn_check:
                if(hangman.checkInput(input.getText().toString())) {
                    if(hangman.checkLetter(input.getText().toString())){
                        input.setText("");
                        output.setText(hangman.getOutput());
                        Toast.makeText(this,"This letter is a part of the searched word!",Toast.LENGTH_SHORT).show();
                        guesses.setText("Guesses: "+hangman.getGuessesLeft());
                        if(hangman.wordGuessed()){
                            score.setText("Score: "+hangman.getScore());
                            guesses.setText("Guesses: "+hangman.getGuessesLeft());
                            Toast.makeText(this,"Word Guessed!",Toast.LENGTH_LONG).show();
                            hangman.initialize();
                            output.setText(hangman.getOutput());
                        }
                    }
                    else
                    {
                        if(hangman.getGuessesLeft() == 0)
                        {
                            hangman.wordGuessed();
                            Toast.makeText(this,"No more guesses left!",Toast.LENGTH_SHORT).show();
                            hangman.initialize();
                            output.setText(hangman.getOutput());
                            score.setText("Score: "+hangman.getScore());

                        }
                        input.setText("");
                        Toast.makeText(this,"This letter is not a part of the searched word!",Toast.LENGTH_SHORT).show();
                        guesses.setText("Guesses: "+hangman.getGuessesLeft());

                    }

                }
                else
                {
                    Toast.makeText(this,"Not Correct Input!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_retry:
                hangman.initialize();
                score.setText("Score: " + hangman.getScore());
                guesses.setText("Guesses: "+hangman.getGuessesLeft());
                output.setText(hangman.getOutput());
                input.setText("");
                break;


        }
    }

}
