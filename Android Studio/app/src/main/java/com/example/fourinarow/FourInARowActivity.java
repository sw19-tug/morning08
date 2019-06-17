package com.example.fourinarow;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewDebug;
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
    private int player1_color;
    private int player2_color;
    private  boolean round_over;

    private TextView lbl_scoreuser1, lbl_scoreuser2;
    private GridLayout grd_grid;
    private Button btn_start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourinarow);

        round_over = false;
        fourinarow = new FourInARow();
        tokenid = new int[][]{
                {R.id.ImageView_0_0, R.id.ImageView_0_1, R.id.ImageView_0_2, R.id.ImageView_0_3, R.id.ImageView_0_4, R.id.ImageView_0_5, R.id.ImageView_0_6,},
                {R.id.ImageView_1_0, R.id.ImageView_1_1, R.id.ImageView_1_2, R.id.ImageView_1_3, R.id.ImageView_1_4, R.id.ImageView_1_5, R.id.ImageView_1_6,},
                {R.id.ImageView_2_0, R.id.ImageView_2_1, R.id.ImageView_2_2, R.id.ImageView_2_3, R.id.ImageView_2_4, R.id.ImageView_2_5, R.id.ImageView_2_6,},
                {R.id.ImageView_3_0, R.id.ImageView_3_1, R.id.ImageView_3_2, R.id.ImageView_3_3, R.id.ImageView_3_4, R.id.ImageView_3_5, R.id.ImageView_3_6,},
                {R.id.ImageView_4_0, R.id.ImageView_4_1, R.id.ImageView_4_2, R.id.ImageView_4_3, R.id.ImageView_4_4, R.id.ImageView_4_5, R.id.ImageView_4_6,},
                {R.id.ImageView_5_0, R.id.ImageView_5_1, R.id.ImageView_5_2, R.id.ImageView_5_3, R.id.ImageView_5_4, R.id.ImageView_5_5, R.id.ImageView_5_6,}
        };

        grd_grid = findViewById(R.id.GridLayout_Grid);
        btn_start = findViewById(R.id.Button_Start);
        lbl_scoreuser1 = findViewById(R.id.Label_ScoreUser_1);
        lbl_scoreuser2 = findViewById(R.id.Label_ScoreUser_2);

        btn_start.setOnClickListener(this);
        findViewById(tokenid[5][0]).setOnClickListener(this);
        findViewById(tokenid[5][1]).setOnClickListener(this);
        findViewById(tokenid[5][2]).setOnClickListener(this);
        findViewById(tokenid[5][3]).setOnClickListener(this);
        findViewById(tokenid[5][4]).setOnClickListener(this);
        findViewById(tokenid[5][5]).setOnClickListener(this);
        findViewById(tokenid[5][6]).setOnClickListener(this);

        grd_grid.setVisibility(View.INVISIBLE);
        player1_color = getResources().getColor(R.color.colorRed);
        player2_color = getResources().getColor(R.color.colorBlue);

        lbl_scoreuser1.setText(fourinarow.getScore_player1());
        lbl_scoreuser2.setText(fourinarow.getScore_player2());
        lbl_scoreuser1.setVisibility(View.INVISIBLE);
        lbl_scoreuser2.setVisibility(View.INVISIBLE);
        lbl_scoreuser1.setTextColor(player1_color);
        lbl_scoreuser2.setTextColor(player2_color);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Button_Start:
                btn_start.setText("Reset");
                grd_grid.setVisibility(View.VISIBLE);
                lbl_scoreuser1.setVisibility(View.VISIBLE);
                lbl_scoreuser2.setVisibility(View.VISIBLE);

                if(btn_start.getText() == "Reset")
                {
                    round_over = false;
                    resetUI();
                }
                break;
            default:
                for(int column = 0; column < GRID_WIDTH; column++) {

                    if(v.getId() == tokenid[5][column] && !round_over) {
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
                                //Player One
                                backgroundGradient.setColor(player1_color);
                                if(fourinarow.checkForInARow(PLAYER_ONE))
                                {
                                    lbl_scoreuser1.setText(fourinarow.getScore_player1());
                                    round_over = true;
                                    Toast.makeText(this, "PLAYER ONE WIN!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                //Player Two
                                backgroundGradient.setColor(player2_color);
                                if(fourinarow.checkForInARow(PLAYER_TWO))
                                {
                                    lbl_scoreuser2.setText(fourinarow.getScore_player2());
                                    round_over = true;
                                    Toast.makeText(this, "PLAYER TWO WIN!", Toast.LENGTH_SHORT).show();
                                }
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