package com.example.fourinarow;

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

    private FourInARow fourinarow;
    private ImageView token_0_0, token_0_1, token_0_2, token_0_3, token_0_4, token_0_5, token_0_6;
    private ImageView token_1_0, token_1_1, token_1_2, token_1_3, token_1_4, token_1_5, token_1_6;
    private ImageView token_2_0, token_2_1, token_2_2, token_2_3, token_2_4, token_2_5, token_2_6;
    private ImageView token_3_0, token_3_1, token_3_2, token_3_3, token_3_4, token_3_5, token_3_6;
    private ImageView token_4_0, token_4_1, token_4_2, token_4_3, token_4_4, token_4_5, token_4_6;
    private ImageView token_5_0, token_5_1, token_5_2, token_5_3, token_5_4, token_5_5, token_5_6;

    private final static int NOT_VALID =-1;
    private final static int GRID_WIDTH = 7;
    private final static int GRID_HEIGHT = 6;

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

        /*
        token_0_0 = findViewById(R.id.ImageView_0_0);
        token_0_1 = findViewById(R.id.ImageView_0_1);
        token_0_2 = findViewById(R.id.ImageView_0_2);
        token_0_3 = findViewById(R.id.ImageView_0_3);
        token_0_4 = findViewById(R.id.ImageView_0_4);
        token_0_5 = findViewById(R.id.ImageView_0_5);
        token_0_6 = findViewById(R.id.ImageView_0_6);
        token_1_0 = findViewById(R.id.ImageView_0_0);
        token_1_1 = findViewById(R.id.ImageView_1_1);
        token_1_2 = findViewById(R.id.ImageView_1_2);
        token_1_3 = findViewById(R.id.ImageView_1_3);
        token_1_4 = findViewById(R.id.ImageView_1_4);
        token_1_5 = findViewById(R.id.ImageView_1_5);
        token_1_6 = findViewById(R.id.ImageView_1_6);
        token_2_0 = findViewById(R.id.ImageView_2_0);
        token_2_1 = findViewById(R.id.ImageView_2_1);
        token_2_2 = findViewById(R.id.ImageView_2_2);
        token_2_3 = findViewById(R.id.ImageView_2_3);
        token_2_4 = findViewById(R.id.ImageView_2_4);
        token_2_5 = findViewById(R.id.ImageView_2_5);
        token_2_6 = findViewById(R.id.ImageView_2_6);
        token_3_0 = findViewById(R.id.ImageView_3_0);
        token_3_1 = findViewById(R.id.ImageView_3_1);
        token_3_2 = findViewById(R.id.ImageView_3_2);
        token_3_3 = findViewById(R.id.ImageView_3_3);
        token_3_4 = findViewById(R.id.ImageView_3_4);
        token_3_5 = findViewById(R.id.ImageView_3_5);
        token_3_6 = findViewById(R.id.ImageView_3_6);
        token_4_0 = findViewById(R.id.ImageView_4_0);
        token_4_1 = findViewById(R.id.ImageView_4_1);
        token_4_2 = findViewById(R.id.ImageView_4_2);
        token_4_3 = findViewById(R.id.ImageView_4_3);
        token_4_4 = findViewById(R.id.ImageView_4_4);
        token_4_5 = findViewById(R.id.ImageView_4_5);
        token_4_6 = findViewById(R.id.ImageView_4_6);
        token_5_0 = findViewById(R.id.ImageView_5_0);
        token_5_1 = findViewById(R.id.ImageView_5_1);
        token_5_2 = findViewById(R.id.ImageView_5_2);
        token_5_3 = findViewById(R.id.ImageView_5_3);
        token_5_4 = findViewById(R.id.ImageView_5_4);
        token_5_5 = findViewById(R.id.ImageView_5_5);
        token_5_6 = findViewById(R.id.ImageView_5_6);*/


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

        fourinarow = new FourInARow();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Start:
                //GradientDrawable backgroundGradient = (GradientDrawable)token_0_0.getBackground();
                //backgroundGradient.setColor(getResources().getColor(R.color.colorLime));
                grid.setVisibility(View.VISIBLE);
                lbl_scoreuser1.setVisibility(View.VISIBLE);
                lbl_scoreuser2.setVisibility(View.VISIBLE);
                System.out.println("Start!");
                break;
            default:
                for(int column = 0; column < GRID_WIDTH; column++) {

                    if (v.getId() == tokenid[5][column]) {
                        System.out.println("Row "+column+"!");

                        int row = fourinarow.setToken(column);
                        if (row == NOT_VALID)
                        {
                            Toast.makeText(this, "Token can not be placed!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            GradientDrawable backgroundGradient = (GradientDrawable) findViewById(tokenid[row][column]).getBackground();
                            backgroundGradient.setColor(getResources().getColor(R.color.colorLime));
                            break;
                        }
                    }
                }

                System.out.println("NO CASE MATCHED!");

                /*
                else if (v.getId() == tokenid[5][1]) {
                    System.out.println("Row 1!");
                }
                else if (v.getId() == tokenid[5][2]) {
                    System.out.println("Row 2!");
                }
                else if (v.getId() == tokenid[5][3]) {
                    System.out.println("Row 3!");
                }
                else if (v.getId() == tokenid[5][4]) {
                    System.out.println("Row 4!");
                }
                else if (v.getId() == tokenid[5][5]) {
                    System.out.println("Row 5!");
                }
                else if (v.getId() == tokenid[5][6]) {
                    System.out.println("Row 6!");
                }
                */




        }

    }






    /*
    private void initialize() {

        int[][] tokenidasf = {
                {R.id.ImageView_0_0, R.id.ImageView_0_1, R.id.ImageView_0_2, R.id.ImageView_0_3, R.id.ImageView_0_4, R.id.ImageView_0_5, R.id.ImageView_0_6,},
                {R.id.ImageView_1_0, R.id.ImageView_1_1, R.id.ImageView_1_2, R.id.ImageView_1_3, R.id.ImageView_1_4, R.id.ImageView_1_5, R.id.ImageView_1_6,},
                {R.id.ImageView_2_0, R.id.ImageView_2_1, R.id.ImageView_2_2, R.id.ImageView_2_3, R.id.ImageView_2_4, R.id.ImageView_2_5, R.id.ImageView_2_6,},
                {R.id.ImageView_3_0, R.id.ImageView_3_1, R.id.ImageView_3_2, R.id.ImageView_3_3, R.id.ImageView_3_4, R.id.ImageView_3_5, R.id.ImageView_3_6,},
                {R.id.ImageView_4_0, R.id.ImageView_4_1, R.id.ImageView_4_2, R.id.ImageView_4_3, R.id.ImageView_4_4, R.id.ImageView_4_5, R.id.ImageView_4_6,},
                {R.id.ImageView_5_0, R.id.ImageView_5_1, R.id.ImageView_5_2, R.id.ImageView_5_3, R.id.ImageView_5_4, R.id.ImageView_5_5, R.id.ImageView_5_6,}
        };
    }*/
}