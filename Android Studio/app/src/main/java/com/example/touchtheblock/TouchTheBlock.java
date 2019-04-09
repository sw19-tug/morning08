package com.example.touchtheblock;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.R;
import java.util.Random;


public class TouchTheBlock extends AppCompatActivity {

    private Button btnPlay;
    private Button btnEnd;
    private Button btnStart;
    private Button btnChooseBlock;
    private Button btnChooseBack;
    private TextView tvgamelost;
    private float yPixPos = 0;
    private float xPixPos = 0;
    private float pixHeight;
    private float pixWidth;
    private float btnPlaysize;
    private DisplayMetrics dm = new DisplayMetrics();
    private ViewGroup.LayoutParams params;
    private Random r = new Random();
    final int CHOOSE_BLOCK_COLOR = 1;
    final int CHOOSE_BACK_COLOR = 2;
    private  String blockColor = "a";
    private String backColor = "b";



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchtheblock);


        btnPlay = findViewById(R.id.btnPlayBox);
        btnEnd = findViewById(R.id.btnEndGame);
        btnStart = findViewById(R.id.btn_startgame);

        btnChooseBlock = findViewById(R.id.btnBlockCol);
        btnChooseBack = findViewById(R.id.btnBackCol);

        tvgamelost = (TextView) findViewById(R.id.tv_gamelost);

        btnPlay.setVisibility(View.INVISIBLE);
        btnEnd.setVisibility(View.INVISIBLE);
        tvgamelost.setVisibility(View.INVISIBLE);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        setScreenSize();
        params = btnPlay.getLayoutParams();


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnPlay.setVisibility(View.VISIBLE);
                btnEnd.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
                tvgamelost.setVisibility(View.INVISIBLE);
                btnChooseBlock.setVisibility(View.INVISIBLE);
                btnChooseBack.setVisibility(View.INVISIBLE);
                game(pixHeight, pixWidth); //setting size of PlayBox


            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnChooseBlock.setVisibility(View.INVISIBLE);
                btnChooseBack.setVisibility(View.INVISIBLE);
                game(btnPlaysize, btnPlaysize);
            }
        });


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setVisibility(View.INVISIBLE);
                btnEnd.setVisibility(View.INVISIBLE);
                btnStart.setVisibility(View.VISIBLE);
                tvgamelost.setVisibility(View.VISIBLE);
                btnChooseBlock.setVisibility(View.VISIBLE);
                btnChooseBack.setVisibility(View.VISIBLE);

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


    private void random_() {
        this.yPixPos = (float) this.r.nextInt((int) (pixHeight - btnPlaysize - 210) + 1);
        this.xPixPos = (float) this.r.nextInt((int) (pixWidth - btnPlaysize) + 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setScreenSize() {

        pixHeight = dm.heightPixels;
        pixWidth = dm.widthPixels;


    }

    private void setBtnPlaySize(float btnHeight, float btnWidth) {

        btnPlaysize = (float) Math.sqrt((btnHeight * btnWidth) / 2);


    }

    private void game(float btnHeight, float btnWidth) {


        setBtnPlaySize(btnHeight, btnWidth); //setting size of PlayBox
        random_(); // setting random position
        params.width = (int) btnPlaysize;
        params.height = (int) btnPlaysize;
        btnPlay.setLayoutParams(params);
        btnPlay.setY(yPixPos);
        btnPlay.setX(xPixPos);


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
}