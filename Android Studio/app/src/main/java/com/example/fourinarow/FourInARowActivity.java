package com.example.fourinarow;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.R;


public class FourInARowActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int NOT_VALID =-1;
    private final static int GRID_WIDTH = 7;
    private final static int GRID_HEIGHT = 6;
    private final static int PLAYER_ONE = 1;
    private final static int PLAYER_TWO = 2;

    private FourInARow fourinarow;
    private int[][] tokenid;

    private TextView lbl_scoreuser1, lbl_scoreuser2;
    private GridLayout grid;
    private Button btn_start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourinarow);

        tokenid = new int[][]{
                {R.id.ImageView_0_0, R.id.ImageView_0_1, R.id.ImageView_0_2, R.id.ImageView_0_3, R.id.ImageView_0_4, R.id.ImageView_0_5, R.id.ImageView_0_6,},
                {R.id.ImageView_1_0, R.id.ImageView_1_1, R.id.ImageView_1_2, R.id.ImageView_1_3, R.id.ImageView_1_4, R.id.ImageView_1_5, R.id.ImageView_1_6,},
                {R.id.ImageView_2_0, R.id.ImageView_2_1, R.id.ImageView_2_2, R.id.ImageView_2_3, R.id.ImageView_2_4, R.id.ImageView_2_5, R.id.ImageView_2_6,},
                {R.id.ImageView_3_0, R.id.ImageView_3_1, R.id.ImageView_3_2, R.id.ImageView_3_3, R.id.ImageView_3_4, R.id.ImageView_3_5, R.id.ImageView_3_6,},
                {R.id.ImageView_4_0, R.id.ImageView_4_1, R.id.ImageView_4_2, R.id.ImageView_4_3, R.id.ImageView_4_4, R.id.ImageView_4_5, R.id.ImageView_4_6,},
                {R.id.ImageView_5_0, R.id.ImageView_5_1, R.id.ImageView_5_2, R.id.ImageView_5_3, R.id.ImageView_5_4, R.id.ImageView_5_5, R.id.ImageView_5_6,}
        };

        grid = findViewById(R.id.Grid);
        btn_start = findViewById(R.id.btn_Start);
        lbl_scoreuser1 = findViewById(R.id.lbl_ScoreUser_1);
        lbl_scoreuser2 = findViewById(R.id.lbl_ScoreUser_2);


        btn_start.setOnClickListener(this);
        findViewById(tokenid[5][0]).setOnClickListener(this);
        findViewById(tokenid[5][1]).setOnClickListener(this);
        findViewById(tokenid[5][2]).setOnClickListener(this);
        findViewById(tokenid[5][3]).setOnClickListener(this);
        findViewById(tokenid[5][4]).setOnClickListener(this);
        findViewById(tokenid[5][5]).setOnClickListener(this);
        findViewById(tokenid[5][6]).setOnClickListener(this);

        grid.setVisibility(View.INVISIBLE);
        lbl_scoreuser1.setVisibility(View.INVISIBLE);
        lbl_scoreuser2.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_Start:
                btn_start.setText("Reset");
                grid.setVisibility(View.VISIBLE);
                lbl_scoreuser1.setVisibility(View.VISIBLE);
                lbl_scoreuser2.setVisibility(View.VISIBLE);
                fourinarow = new FourInARow();
                if(btn_start.getText() == "Reset")
                    resetUI();
                break;
            default:
                for(int column = 0; column < GRID_WIDTH; column++) {

                    if(v.getId() == tokenid[5][column]) {
                        System.out.println("Row "+column+"!");

                        int row = fourinarow.setToken(column);
                        if(row == NOT_VALID)
                        {
                            Toast.makeText(this, "Token can not be placed!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            GradientDrawable backgroundGradient = (GradientDrawable) findViewById(tokenid[row][column]).getBackground();
                            if(fourinarow.selectPlayer() == PLAYER_ONE)
                            {
                                backgroundGradient.setColor(getResources().getColor(R.color.colorLime));
                                if(fourinarow.checkForInARow(PLAYER_ONE))
                                    Toast.makeText(this, "PLAYER ONE WIN!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                backgroundGradient.setColor(getResources().getColor(R.color.colorBlue));
                                if(fourinarow.checkForInARow(PLAYER_TWO))
                                    Toast.makeText(this, "PLAYER TWO WIN!", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        }
                    }
                }

                System.out.println("NO CASE MATCHED!");
        }
    }

    private void resetUI()
    {
        // clear grid from set Token
        for(int y = 0; y < GRID_HEIGHT; y++)
        {
            for(int x = 0; x < GRID_WIDTH; x++)
            {
                int color_code = Color.parseColor("#6B6B6D");
                GradientDrawable backgroundGradient = (GradientDrawable) findViewById(tokenid[y][x]).getBackground();
                backgroundGradient.setColor(color_code);
            }

        }
    }




}