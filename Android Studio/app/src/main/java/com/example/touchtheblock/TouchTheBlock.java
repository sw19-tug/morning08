package com.example.touchtheblock;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

import java.util.Random;


public class TouchTheBlock extends AppCompatActivity {

    private Button btn_play;
    private Button btn_end;
    private Button btn_start;
    private Button btn_continue;
    private Button btn_choose_block;
    private Button btn_choose_back;
    private TextView tv_game_lost;
    private TextView tv_time;
    private TextView tv_score;
    private ViewGroup.LayoutParams params_btn_play;
    private ViewGroup.LayoutParams params_btn_end;
    private ViewGroup.LayoutParams params_tv_timer;
    private ViewGroup.LayoutParams params_tv_score;
    private DisplayMetrics displaymetrics_dm = new DisplayMetrics();
    private final CountDownTimer countdowntimer_timer = createTimer();
    private Random random_r = new Random();
    private int scorenum_ = 0;
    final int CHOOSE_BLOCK_COLOR = 1;
    final int CHOOSE_BACK_COLOR = 2;
    private final int START_TIME = 2000;
    private final int NAV_BAR_HEIGHT = 210;
    private float time_scale;
    private float y_pix_pos;
    private float x_pix_pos;
    private float pix_height;
    private float pix_width;
    private float size_button_play;
    private final float SCLAE_BUTTON_END_TV_TIME = 0.8F;
    private String score_str_ = "Score: 0";
    private String time_text_;
    private  String block_color = "a";
    private String back_color_ = "b";
    private boolean bool_timer_ = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchtheblock);
        bool_timer_ = true;
        time_scale = (1.0F- SCLAE_BUTTON_END_TV_TIME) * 0.8F*0.4F;

        btn_play = findViewById(R.id.Button_PlayBox);
        btn_end = findViewById(R.id.Button_EndGame);
        btn_start = findViewById(R.id.Button_StartGame);
        btn_continue = findViewById(R.id.Button_Continue);
        btn_choose_block = findViewById(R.id.Button_ChoosePlayBoxColor);
        btn_choose_back = findViewById(R.id.Button_ChooseBackgroundColor);
        tv_game_lost = (TextView) findViewById(R.id.TextView_GameLost);
        tv_time = (TextView) findViewById(R.id.TextView_Time);
        tv_score =  (TextView) findViewById(R.id.TextView_Score);
        tv_score.setText(score_str_);
        tv_time.setVisibility(View.INVISIBLE);

        btn_play.setVisibility(View.INVISIBLE);
        btn_end.setVisibility(View.INVISIBLE);
        tv_game_lost.setVisibility(View.INVISIBLE);
        btn_continue.setVisibility(View.INVISIBLE);

        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics_dm);
        setScreenSize(displaymetrics_dm.heightPixels, displaymetrics_dm.widthPixels);
        params_btn_play = btn_play.getLayoutParams();
        params_btn_end = btn_end.getLayoutParams();
        params_tv_timer = tv_time.getLayoutParams();
        params_tv_score = tv_score.getLayoutParams();
        tv_score.setTextSize(TypedValue.COMPLEX_UNIT_PX,(pix_height)* time_scale);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnStart ();
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnPlay();
            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_time.setVisibility(View.INVISIBLE);
                onBtnEnd();
            }
        });


        btn_choose_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouchTheBlock.this,
                        com.example.touchtheblock.TouchTheBlockChooseColor.class);

                startActivityForResult(intent, CHOOSE_BLOCK_COLOR);
            }
        });

        btn_choose_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouchTheBlock.this,
                        com.example.touchtheblock.TouchTheBlockChooseColor.class);

                startActivityForResult(intent, CHOOSE_BACK_COLOR);
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnContinue();
            }
        });
    }

    private CountDownTimer createTimer(){
        CountDownTimer timer_ = new CountDownTimer(START_TIME, 100) {

            public void onTick(long millisUntilFinished) {
                time_text_ = String.format("%.2f", (float) (millisUntilFinished) / 1000);
                tv_time.setText(time_text_);

            }

            public void onFinish() {
                time_text_ = "out";
                if (bool_timer_)
                {
                    tv_time.setText(time_text_);

                    endGame();
                }

            }

        };

        return timer_;
    }

    public void onBtnStart (){
        btn_play.setVisibility(View.VISIBLE);
        btn_end.setVisibility(View.VISIBLE);
        tv_time.setVisibility(View.VISIBLE);
        btn_start.setVisibility(View.INVISIBLE);
        tv_game_lost.setVisibility(View.INVISIBLE);
        btn_choose_block.setVisibility(View.INVISIBLE);
        btn_choose_back.setVisibility(View.INVISIBLE);
        btn_continue.setVisibility(View.INVISIBLE);
        params_btn_end.height = (int) (pix_height * SCLAE_BUTTON_END_TV_TIME);
        tv_time.setTextSize(TypedValue.COMPLEX_UNIT_PX,(pix_height)* time_scale);
        game(pix_height, pix_width); //setting size of PlayBox
        resetScore();
        tv_score.setText(score_str_);
    }

    public void onBtnContinue (){
        btn_play.setVisibility(View.VISIBLE);
        btn_end.setVisibility(View.VISIBLE);
        tv_time.setVisibility(View.VISIBLE);
        btn_start.setVisibility(View.INVISIBLE);
        tv_game_lost.setVisibility(View.INVISIBLE);
        btn_choose_block.setVisibility(View.INVISIBLE);
        btn_choose_back.setVisibility(View.INVISIBLE);
        btn_continue.setVisibility(View.INVISIBLE);

        tv_time.setTextSize(TypedValue.COMPLEX_UNIT_PX,(pix_height)* time_scale);
        game(size_button_play, size_button_play);

        decreaseScoreContiune();
        tv_score.setText(score_str_);
    }

    public void onBtnPlay(){
        btn_choose_block.setVisibility(View.INVISIBLE);
        btn_choose_back.setVisibility(View.INVISIBLE);
        countdowntimer_timer.cancel();
        game(size_button_play, size_button_play);
        increaseScore();
        tv_score.setText(score_str_);
    }

    public void endGame(){
        btn_play.setVisibility(View.INVISIBLE);
        btn_end.setVisibility(View.INVISIBLE);
        btn_start.setVisibility(View.VISIBLE);
        tv_game_lost.setVisibility(View.VISIBLE);
        btn_choose_block.setVisibility(View.VISIBLE);
        btn_choose_back.setVisibility(View.VISIBLE);
        tv_time.setVisibility(View.INVISIBLE);
        if (scorenum_ > 9){
            btn_continue.setVisibility(View.VISIBLE);
        }

    }

    public void onBtnEnd(){

        countdowntimer_timer.cancel();
        countdowntimer_timer.onFinish();
    }

    public float random_(float from, float to) {
        int random_number = -1;
        while ( (int)(from) > random_number || random_number > (int)(to))
        {
            random_number = this.random_r.nextInt((int) (to));
        }
        return (float)random_number;
    }

    public float random_(float to) {
        int from = 1;
        int randomnumber = -1;
        while ( from > randomnumber || randomnumber > (int)(to))
        {
            randomnumber = this.random_r.nextInt((int) (to));
        }
        return (float)randomnumber;
    }

    public void setScreenSize(float heigth, float width) {
        pix_height = heigth;
        pix_width = width;
    }

    public void setBtnPlaySize(float btnHeight, float btnWidth) {

        size_button_play = (float) Math.sqrt((btnHeight * btnWidth) / 2);
    }

    public void game(float btnHeight, float btnWidth) {

        setBtnPlaySize(btnHeight, btnWidth); //setting size of PlayBox
        y_pix_pos = random_((pix_height *(1.0F- SCLAE_BUTTON_END_TV_TIME)),(pix_height - size_button_play - NAV_BAR_HEIGHT)); // setting random position
        x_pix_pos = random_(pix_width - size_button_play);
        params_btn_play.width = (int) size_button_play;
        params_btn_play.height = (int) size_button_play;
        btn_play.setLayoutParams(params_btn_play);
        btn_play.setY(y_pix_pos);
        btn_play.setX(x_pix_pos);
        countdowntimer_timer.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_BLOCK_COLOR)
        {
            if (resultCode == RESULT_OK)
            {
                block_color = data.getStringExtra("color");
                if (block_color.equals(back_color_))
                {
                    Toast.makeText(this,getString(R.string.colormustdiffer), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TouchTheBlock.this,
                            com.example.touchtheblock.TouchTheBlockChooseColor.class);

                    startActivityForResult(intent, CHOOSE_BLOCK_COLOR);

                }
                btn_play.setBackgroundColor(Color.parseColor(block_color));
                btn_choose_block.setVisibility(View.INVISIBLE);
                tv_game_lost.setVisibility(View.INVISIBLE);


            }
        }
        else {
            if (resultCode == RESULT_OK)
            {

                back_color_ = data.getStringExtra("color");
                if (block_color.equals(back_color_))
                {
                    Toast.makeText(this,getString(R.string.colormustdiffer), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TouchTheBlock.this,
                            com.example.touchtheblock.TouchTheBlockChooseColor.class);

                    startActivityForResult(intent, CHOOSE_BACK_COLOR);

                }
                btn_end.setBackgroundColor(Color.parseColor(back_color_));
                btn_choose_back.setVisibility(View.INVISIBLE);
                tv_game_lost.setVisibility(View.INVISIBLE);

            }
        }
    }

    public void increaseScore()
    {
        scorenum_ += 1;
        score_str_ = "Score: " + scorenum_;
    }
    public void resetScore(){
        scorenum_ = 0;
        score_str_ = "Score: " + scorenum_;
    }

    public void decreaseScoreContiune(){
        scorenum_ -= 10;
        score_str_ = "Score: " + scorenum_;
    }

    public CountDownTimer getCountdowntimer_timer() {
        return countdowntimer_timer;
    }

    public float getPix_height() {
        return pix_height;
    }

    public float getPix_width() {
        return pix_width;
    }

    public String getTime_text_() {
        return time_text_;
    }

    public int getScoreNum() {
        return scorenum_;
    }

    public String getScore_str_() {
        return score_str_;
    }

    public float getSize_button_play() {
        return size_button_play;
    }


}