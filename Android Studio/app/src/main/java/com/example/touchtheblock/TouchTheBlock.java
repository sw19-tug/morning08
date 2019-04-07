package com.example.touchtheblock;

import android.graphics.Point;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import com.example.R;

import java.util.Random;


public class TouchTheBlock extends AppCompatActivity {

    Button btnPlay;
    Button btnEnd;
    Button btnStart;
    TextView tvgamelost;

    float yPixPos = 0;
    float xPixPos = 0;
    float dpHeight;
    float dpWidth;
    float pixHeight;
    float pixWidth;
    float density;
    Point size = new Point();
    int pWidth;
    int pHeight;
    DisplayMetrics dm = new DisplayMetrics();
    Display display;
    float btnPlaysize;
    ViewGroup.LayoutParams params;
    Random r = new Random();



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchtheblock);



        getWindowManager().getDefaultDisplay().getMetrics(dm);
        display = getWindowManager().getDefaultDisplay();

        setScreenSize();

        setBtnPlaySize(pixHeight,pixWidth); //setting size of PlayBox
        random_(); // setting random position
        btnPlay = findViewById(R.id.btnPlayBox);
        btnEnd = findViewById(R.id.btnEndGame);
        btnStart = findViewById(R.id.btn_startgame);
        tvgamelost = (TextView)findViewById(R.id.tv_gamelost);

        btnPlay.setVisibility(View.INVISIBLE);
        btnEnd.setVisibility(View.INVISIBLE);
        tvgamelost.setVisibility(View.INVISIBLE);

        params = btnPlay.getLayoutParams();

        params.width = (int)btnPlaysize;
        params.height = (int)btnPlaysize;
        btnPlay.setLayoutParams(params);
        btnPlay.setY(yPixPos);
        btnPlay.setX(xPixPos);



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                random_();
                setBtnPlaySize(btnPlaysize,btnPlaysize);


                params.width = (int)btnPlaysize;
                params.height = (int)btnPlaysize;
                btnPlay.setLayoutParams(params);
                btnPlay.setY(yPixPos);
                btnPlay.setX(xPixPos);


            }
        });


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button CLicked: ", "End Game");
                btnPlay.setVisibility(View.INVISIBLE);
                btnEnd.setVisibility(View.INVISIBLE);
                btnStart.setVisibility(View.VISIBLE);
                tvgamelost.setVisibility(View.VISIBLE);
            }
        });


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button CLicked: ", "Start Game");

                btnPlay.setVisibility(View.VISIBLE);
                btnEnd.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
                tvgamelost.setVisibility(View.INVISIBLE);

                setBtnPlaySize(pixHeight,pixWidth); //setting size of PlayBox
                random_(); // setting random position
                params.width = (int)btnPlaysize;
                params.height = (int)btnPlaysize;
                btnPlay.setLayoutParams(params);
                btnPlay.setY(yPixPos);
                btnPlay.setX(xPixPos);




            }
        });



    }


    private void random_(){
        this.yPixPos = (float)this.r.nextInt((int)(pixHeight-btnPlaysize-210)+1);
        this.xPixPos = (float)this.r.nextInt((int)(pixWidth-btnPlaysize)+1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setScreenSize(){
        density = getResources().getDisplayMetrics().density;
        pixHeight = dm.heightPixels;
        pixWidth = dm.widthPixels;
        dpHeight = pixHeight / density;
        dpWidth = pixWidth / density;

        display.getRealSize(size);

        pWidth = size.x;
        pHeight = size.y;







    }

    private void setBtnPlaySize(float btnHeight, float btnWidth){

        btnPlaysize = (float)Math.sqrt((btnHeight * btnWidth) / 2 );



    }

}