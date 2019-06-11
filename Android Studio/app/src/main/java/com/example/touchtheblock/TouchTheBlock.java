package com.example.touchtheblock;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;

import java.time.Clock;
import java.util.Random;


public class TouchTheBlock extends AppCompatActivity {

    private Button btnPlay;
    private Button btnEnd;
    private Button btnStart;
    private Button btn_continue;
    private Button btnChooseBlock;
    private Button btnChooseBack;
    private TextView tvgamelost;
    private TextView tvTime;
    private TextView tvScore;


    private int scorenum = 0;
    private String scorestr = "Score: 0";



    private String tvTimeText;
    private float yPixPos;
    private float xPixPos;




    private float pixHeight;
    private float pixWidth;
    private float btnPlaysize;
    private final int startTime = 2000;
    private DisplayMetrics dm = new DisplayMetrics();
    private ViewGroup.LayoutParams btnPlayParams;
    private ViewGroup.LayoutParams btnEndParams;
    private ViewGroup.LayoutParams tvTimerParams;
    private ViewGroup.LayoutParams tvScoreParams;
    private Random r = new Random();
    final int CHOOSE_BLOCK_COLOR = 1;
    final int CHOOSE_BACK_COLOR = 2;
    private  String blockColor = "a";
    private String backColor = "b";
    private final CountDownTimer timer = createTimer();
    private Clock clock;
    private final float btnEndtvTimeScale = 0.8F;
    private float tvTimeScale;
    private final int navbarheight = 210;
    private boolean t = false;




    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchtheblock);

        tvTimeScale = (1.0F-btnEndtvTimeScale) * 0.8F*0.4F;
        t = true;
        btnPlay = findViewById(R.id.btnPlayBox);
        btnEnd = findViewById(R.id.btnEndGame);
        btnStart = findViewById(R.id.btn_startgame);
        btn_continue = findViewById(R.id.Button_Continue);
        btnChooseBlock = findViewById(R.id.btnBlockCol);
        btnChooseBack = findViewById(R.id.btnBackCol);
        tvgamelost = (TextView) findViewById(R.id.tv_gamelost);
        tvTime = (TextView) findViewById(R.id.tv_time);
        tvScore =  (TextView) findViewById(R.id.tv_score);
        tvScore.setText(scorestr);
        tvTime.setVisibility(View.INVISIBLE);

        btnPlay.setVisibility(View.INVISIBLE);
        btnEnd.setVisibility(View.INVISIBLE);
        tvgamelost.setVisibility(View.INVISIBLE);
        btn_continue.setVisibility(View.INVISIBLE);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        setScreenSize(dm.heightPixels, dm.widthPixels);
        btnPlayParams = btnPlay.getLayoutParams();
        btnEndParams = btnEnd.getLayoutParams();
        tvTimerParams = tvTime.getLayoutParams();
        tvScoreParams = tvScore.getLayoutParams();
        tvScore.setTextSize(TypedValue.COMPLEX_UNIT_PX,(pixHeight)* tvTimeScale);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnStart ();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnPlay();
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTime.setVisibility(View.INVISIBLE);
                onBtnEnd();
            }
        });


        btnChooseBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouchTheBlock.this,
                        com.example.touchtheblock.TouchTheBlockChooseColor.class);

                startActivityForResult(intent, CHOOSE_BLOCK_COLOR);
            }
        });

        btnChooseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TouchTheBlock.this,
                        com.example.touchtheblock.TouchTheBlockChooseColor.class);

                startActivityForResult(intent, CHOOSE_BACK_COLOR);
            }
        });

    }

    public void  anfang(){
        tvTime = (TextView) findViewById(R.id.tv_time);
    }

    private CountDownTimer createTimer(){
        CountDownTimer timer_ = new CountDownTimer(startTime, 100) {

            public void onTick(long millisUntilFinished) {
                tvTimeText = String.format("%.2f", (float) (millisUntilFinished) / 1000);
                tvTime.setText(tvTimeText);

            }

            public void onFinish() {
                tvTimeText = "out";
                if (t)
                {
                    tvTime.setText(tvTimeText);

                    endGame();
                }

            }



        };

        return timer_;
    }

    public void onBtnStart (){
        btnPlay.setVisibility(View.VISIBLE);
        btnEnd.setVisibility(View.VISIBLE);
        tvTime.setVisibility(View.VISIBLE);
        btnStart.setVisibility(View.INVISIBLE);
        tvgamelost.setVisibility(View.INVISIBLE);
        btnChooseBlock.setVisibility(View.INVISIBLE);
        btnChooseBack.setVisibility(View.INVISIBLE);
        btnEndParams.height = (int) (pixHeight*btnEndtvTimeScale);
        tvTime.setTextSize(TypedValue.COMPLEX_UNIT_PX,(pixHeight)* tvTimeScale);
        game(pixHeight, pixWidth); //setting size of PlayBox
        resetScore();
        tvScore.setText(scorestr);
    }

    public void onBtnPlay(){
        btnChooseBlock.setVisibility(View.INVISIBLE);
        btnChooseBack.setVisibility(View.INVISIBLE);
        timer.cancel();
        game(btnPlaysize, btnPlaysize);
        increaseScore();
        tvScore.setText(scorestr);
    }

    public void endGame(){
        btnPlay.setVisibility(View.INVISIBLE);
        btnEnd.setVisibility(View.INVISIBLE);
        btnStart.setVisibility(View.VISIBLE);
        tvgamelost.setVisibility(View.VISIBLE);
        btnChooseBlock.setVisibility(View.VISIBLE);
        btnChooseBack.setVisibility(View.VISIBLE);
        tvTime.setVisibility(View.INVISIBLE);

    }

    public void onBtnEnd(){

        timer.cancel();
        timer.onFinish();
    }

    private void random_() {
        int randomnumber = 0;
        while ( (int)(pixHeight*(1.0F-btnEndtvTimeScale)) > randomnumber || randomnumber > (pixHeight - btnPlaysize - navbarheight))
        {


            randomnumber = this.r.nextInt((int) (pixHeight - btnPlaysize - navbarheight));
        }
        this.yPixPos = (float) randomnumber; //this.r.nextInt((int) (pixHeight - btnPlaysize - 210- (pixHeight*0.2)) + (int)(pixHeight*0.2));
        this.xPixPos = (float) this.r.nextInt((int) (pixWidth - btnPlaysize) + 1);
    }

    private float random_(float from, float to) {
        int randomnumber = -1;
        while ( (int)(from) > randomnumber || randomnumber > (int)(to))
        {
            randomnumber = this.r.nextInt((int) (to));
        }
        return (float)randomnumber;
    }

    private float random_(float to) {
        int from = 1;
        int randomnumber = -1;
        while ( from > randomnumber || randomnumber > (int)(to))
        {
            randomnumber = this.r.nextInt((int) (to));
        }
        return (float)randomnumber;
    }



    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setScreenSize(float heigth, float width) {
        pixHeight = heigth;
        pixWidth = width;
    }

    private void setBtnPlaySize(float btnHeight, float btnWidth) {

        btnPlaysize = (float) Math.sqrt((btnHeight * btnWidth) / 2);
    }

    public void game(float btnHeight, float btnWidth) {

        setBtnPlaySize(btnHeight, btnWidth); //setting size of PlayBox
        yPixPos = random_((pixHeight*(1.0F-btnEndtvTimeScale)),(pixHeight - btnPlaysize - navbarheight)); // setting random position
        xPixPos = random_(pixWidth - btnPlaysize);
        btnPlayParams.width = (int) btnPlaysize;
        btnPlayParams.height = (int) btnPlaysize;
        btnPlay.setLayoutParams(btnPlayParams);
        btnPlay.setY(yPixPos);
        btnPlay.setX(xPixPos);
        timer.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_BLOCK_COLOR)
        {
            if (resultCode == RESULT_OK)
            {
                blockColor = data.getStringExtra("color");
                if (blockColor.equals(backColor))
                {
                    Toast.makeText(this,getString(R.string.colormustdiffer), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TouchTheBlock.this,
                            com.example.touchtheblock.TouchTheBlockChooseColor.class);

                    startActivityForResult(intent, CHOOSE_BLOCK_COLOR);

                }
                btnPlay.setBackgroundColor(Color.parseColor(blockColor));
                btnChooseBlock.setVisibility(View.INVISIBLE);
                tvgamelost.setVisibility(View.INVISIBLE);


            }
        }
        else {
            if (resultCode == RESULT_OK)
            {

                backColor = data.getStringExtra("color");
                if (blockColor.equals(backColor))
                {
                    Toast.makeText(this,getString(R.string.colormustdiffer), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TouchTheBlock.this,
                            com.example.touchtheblock.TouchTheBlockChooseColor.class);

                    startActivityForResult(intent, CHOOSE_BACK_COLOR);

                }
                btnEnd.setBackgroundColor(Color.parseColor(backColor));
                btnChooseBack.setVisibility(View.INVISIBLE);
                tvgamelost.setVisibility(View.INVISIBLE);

            }
        }
    }

    public void increaseScore()
    {
        scorenum += 1;
        scorestr = "Score: " + scorenum;
    }
    public void resetScore(){
        scorenum = 0;
        scorestr = "Score: " + scorenum;
    }


    public TextView getTvTime() {
        return tvTime;
    }

    public float getyPixPos() {
        return yPixPos;
    }

    public float getxPixPos() {
        return xPixPos;
    }

    public CountDownTimer getTimer() {
        return timer;
    }

    public float getPixHeight() {
        return pixHeight;
    }

    public float getPixWidth() {
        return pixWidth;
    }

    public void logTvTimeText(){
        Log.d("tv Time Text :  ", "somelogtext");
    }

    public String getTvTimeText() {
        return tvTimeText;
    }

    public void printTvText(){
        Log.d("kalapacs :  ",tvTimeText);
    }

    public int getScoreNum() {
        return scorenum;
    }

    public String getScorestr() {
        return scorestr;
    }


}