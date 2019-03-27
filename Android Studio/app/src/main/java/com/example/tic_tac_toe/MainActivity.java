package com.example.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity implements OnClickListener{

   private Button[][] button = new Button[3][3];
   static int click = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button[0][0] = (Button) findViewById(R.id.button_1);
        button[0][1] = (Button) findViewById(R.id.button_2);
        button[0][2] = (Button) findViewById(R.id.button_3);
        button[1][0] = (Button) findViewById(R.id.button_4);
        button[1][1] = (Button) findViewById(R.id.button_5);
        button[1][2] = (Button) findViewById(R.id.button_6);
        button[2][0] = (Button) findViewById(R.id.button_7);
        button[2][1] = (Button) findViewById(R.id.button_8);
        button[2][2] = (Button) findViewById(R.id.button_9);

        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                button[i][y].setOnClickListener(this);
            }
        }

    }


    public void onClick(View v){
        click++;
        switch (v.getId()) {
            case R.id.button_1:
                button[0][0].setText(getrightvalue());
                button[0][0].setEnabled(false);
                break;
            case R.id.button_2:
                button[0][1].setText(getrightvalue());
                button[0][1].setEnabled(false);
                break;
            case R.id.button_3:
                button[0][2].setText(getrightvalue());
                button[0][2].setEnabled(false);
                break;
            case R.id.button_4:
                button[1][0].setText(getrightvalue());
                button[1][0].setEnabled(false);
                break;
            case R.id.button_5:
                button[1][1].setText(getrightvalue());
                button[1][1].setEnabled(false);
                break;
            case R.id.button_6:
                button[1][2].setText(getrightvalue());
                button[1][2].setEnabled(false);
                break;
            case R.id.button_7:
                button[2][0].setText(getrightvalue());
                button[2][0].setEnabled(false);
                break;
            case R.id.button_8:
                button[2][1].setText(getrightvalue());
                button[2][1].setEnabled(false);
                break;
            case R.id.button_9:
                button[2][2].setText(getrightvalue());
                button[2][2].setEnabled(false);
                break;
        }


    }

    public String getrightvalue (){
       if (click % 2 == 0) {
           return "X";
       } else {
           return "O";
       }

    }

}
