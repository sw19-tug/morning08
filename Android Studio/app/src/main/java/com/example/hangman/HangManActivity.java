package com.example.hangman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HangManActivity extends AppCompatActivity implements View.OnClickListener
{
    private HangMan hangman;
    private Button btn_start;
    private Button btn_check;
    private Button btn_retry;
    private Button btn_tip;
    private ImageView iv_rope;
    private ImageView iv_head;
    private ImageView iv_face;
    private ImageView iv_body;
    private ImageView iv_left_hand;
    private ImageView iv_right_hand;
    private ImageView iv_left_leg;
    private ImageView iv_right_leg;
    private EditText input;
    private TextView tv_output;
    private TextView tv_score;
    private TextView tv_guesses;
    private String[] words_ = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};

    private TextView tv_timer;
    private long time_left_ = 60000;
    private long time_to_guess_ = 60000;
    private CountDownTimer cdt_timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        btn_start = findViewById(R.id.btn_start);
        btn_check = findViewById(R.id.btn_check);
        btn_retry = findViewById(R.id.btn_retry);
        btn_tip = findViewById(R.id.btn_tip);
        input = (EditText) findViewById(R.id.txtInput);
        tv_output = (TextView) findViewById(R.id.lblOutput);

        iv_rope = (ImageView) findViewById(R.id.imageViewRope);
        iv_face = (ImageView) findViewById(R.id.imageViewFace);
        iv_head = (ImageView) findViewById(R.id.imageViewHead);
        iv_body = (ImageView) findViewById(R.id.imageViewBody);
        iv_left_hand = (ImageView) findViewById(R.id.imageViewLeftHand);
        iv_left_leg = (ImageView) findViewById(R.id.imageViewLeftLeg);
        iv_right_hand = (ImageView) findViewById(R.id.imageViewRightHand);
        iv_right_leg = (ImageView) findViewById(R.id.imageViewRightLeg);
        tv_score = (TextView) findViewById(R.id.lblScore);
        tv_guesses = (TextView) findViewById(R.id.lblGuesses);
        tv_timer = (TextView) findViewById(R.id.lblTimer);

        btn_start.setOnClickListener(this);
        btn_check.setOnClickListener(this);
        btn_retry.setOnClickListener(this);
        btn_tip.setOnClickListener(this);

        iv_rope.setVisibility(View.INVISIBLE);
        iv_head.setVisibility(View.INVISIBLE);
        iv_face.setVisibility(View.INVISIBLE);
        iv_body.setVisibility(View.INVISIBLE);
        iv_left_hand.setVisibility(View.INVISIBLE);
        iv_left_leg.setVisibility(View.INVISIBLE);
        iv_right_hand.setVisibility(View.INVISIBLE);
        iv_right_leg.setVisibility(View.INVISIBLE);

        btn_check.setVisibility(View.INVISIBLE);
        btn_retry.setVisibility(View.INVISIBLE);
        btn_tip.setVisibility(View.INVISIBLE);

        tv_score.setVisibility(View.INVISIBLE);
        tv_guesses.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        tv_output.setVisibility(View.INVISIBLE);
        Context context = this;


        try {
            create_files();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < words_.length; i++) {
            words_to_file(words_[i]);
        }



        hangman = new HangMan(words_, context);

    }

    // load the score, output & guesses
    private void refreshScreen() {
        tv_score.setText("Score: " + hangman.getScore());
        tv_guesses.setText("Guesses: " + hangman.getGuessesLeft());
        tv_output.setText(hangman.getOutput());
        input.setText("");

        switch (hangman.getGuessesLeft()) {
            case 8:
                iv_head.setVisibility(View.INVISIBLE);
                iv_rope.setVisibility(View.INVISIBLE);
                iv_face.setVisibility(View.INVISIBLE);
                iv_body.setVisibility(View.INVISIBLE);
                iv_left_hand.setVisibility(View.INVISIBLE);
                iv_left_leg.setVisibility(View.INVISIBLE);
                iv_right_hand.setVisibility(View.INVISIBLE);
                iv_right_leg.setVisibility(View.INVISIBLE);
                break;
                case 7:
                iv_rope.setVisibility(View.VISIBLE);
                break;
                case 6:
                iv_head.setVisibility(View.VISIBLE);
                break;
                case 5:
                iv_body.setVisibility(View.VISIBLE);
                break;
                case 4:
                iv_left_hand.setVisibility(View.VISIBLE);
                break;
                case 3:
                iv_left_leg.setVisibility(View.VISIBLE);
                break;
                case 2:
                iv_right_hand.setVisibility(View.VISIBLE);
                break;
                case 1:
                iv_right_leg.setVisibility(View.VISIBLE);
                break;
                case 0:
                iv_face.setVisibility(View.VISIBLE);
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                if(btn_start.getText() == "Next Word"){
                    hangman.initialize();
                    refreshScreen();
                    startTimer();
                    btn_check.setVisibility(View.VISIBLE);
                    btn_retry.setVisibility(View.VISIBLE);
                    btn_tip.setVisibility(View.VISIBLE);
                    btn_start.setVisibility(View.INVISIBLE);
                    break;
                }
                Toast.makeText(this,"Start!", Toast.LENGTH_SHORT).show();
                btn_start.setVisibility(View.INVISIBLE);
                btn_check.setVisibility(View.VISIBLE);
                btn_retry.setVisibility(View.VISIBLE);
                btn_tip.setVisibility(View.VISIBLE);
                tv_score.setVisibility(View.VISIBLE);
                tv_guesses.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
                tv_output.setVisibility(View.VISIBLE);
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
                            cdt_timer.cancel();
                            cdt_timer = null;
                            hangman.initialize();

                        }
                    }
                    else
                    {
                        if(hangman.getGuessesLeft() == 0)
                        {
                            Toast.makeText(this,"No more guesses left!",Toast.LENGTH_SHORT).show();
                            btn_start.setText("Next Word");
                            btn_check.setVisibility(View.INVISIBLE);
                            btn_retry.setVisibility(View.INVISIBLE);
                            btn_tip.setVisibility(View.INVISIBLE);
                            btn_start.setVisibility(View.VISIBLE);
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
                time_left_ = time_to_guess_;
                endTimer();
                startTimer();

                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hangman_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.settings:
                openHangmanSettings();

            default: return super.onOptionsItemSelected(item);
        }
    }

    public void openHangmanSettings()
    {
        Intent intent = new Intent(this, HangmanSettings.class);
        startActivity(intent);
    }



    public boolean words_to_file(String word){
        System.out.println(words_);
        Context context = this;
        try {
            File path = context.getFilesDir();
            File file = new File(path, "Fixed_words.txt");
            FileWriter writer = new FileWriter(file, true);
            if(check_file(word, file)) {
                word += " ";
                writer.write(word);
            }
            writer.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }


    }

    public boolean check_file(String input, File file) throws IOException {

        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        String line = breader.readLine();

        do{
            if(line != null){
                String[] seperated_words = line.split(" ");
                for (int i = 0; i < seperated_words.length; i++) {
                    if (seperated_words[i].equals(input)) {
                        reader.close();
                        breader.close();
                        return false;
                    }

                }
                line = breader.readLine();
            }

        }while (line != null);

        reader.close();
        breader.close();
        return true;
    }


    public boolean create_files() throws IOException {
        Context context = this;
        File path = context.getFilesDir();
        File file1 = new File(path, "Added_words.txt");
        File file2 = new File(path, "Fixed_words.txt");
        if (!file1.exists())
        {
            file1.createNewFile();
        }
        if(!file2.exists()){
            file2.createNewFile();
        }

        return true;

    }


    void startTimer() {


        cdt_timer = new CountDownTimer(time_left_, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                time_left_ = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish()
            {
                Toast.makeText(HangManActivity.this, "Maybe next Time ! :)", Toast.LENGTH_SHORT).show();
                btn_start.setText("Next Word");
                btn_check.setVisibility(View.INVISIBLE);
                btn_retry.setVisibility(View.INVISIBLE);
                btn_tip.setVisibility(View.INVISIBLE);
                btn_start.setVisibility(View.VISIBLE);
                hangman.wordGuessed();
                hangman.setScore(hangman.getScore()-2);
                time_left_ = time_to_guess_;
                refreshScreen();
            }
        }.start();
    }


    void updateTimer() {
        int min = (int) time_left_ / 600000;
        int sec = (int) time_left_ % 600000 / 1000;

        String outputTime;

        outputTime = "" + min + ":";
        if (sec < 10)
            outputTime += "0";

        outputTime += sec;

        tv_timer.setText(outputTime);
    }

    void endTimer() {
        cdt_timer.cancel();
        cdt_timer = null;
    }

}
