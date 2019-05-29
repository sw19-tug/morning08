package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.R;
import com.example.fourinarow.FourInARow;
import com.example.hangman.HangMan;
import com.example.hangman.HangManActivity;

import com.example.touchtheblock.TouchTheBlock;
import com.example.tic_tac_toe.TicTacToe;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tictac = (Button) findViewById(R.id.bt_tictac);
        Button hangman = (Button) findViewById(R.id.bt_hangman);
        Button touchbox = (Button) findViewById(R.id.bt_touchbox);
        Button fourinarow = (Button) findViewById(R.id.bt_fourinarow);


        tictac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTicTac();
            }
        });

        hangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHangman();
            }
        });

        touchbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTouchbox();
            }
        });

        fourinarow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourinarow();
            }
        });

    }



    public void openTicTac() {
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);
    }

    public void openHangman() {
        Intent intent = new Intent(this, HangManActivity.class);
        startActivity(intent);
    }

    public void openTouchbox() {
        Intent intent = new Intent(this, TouchTheBlock.class);
        startActivity(intent);
    }

    public void openFourinarow() {
        Intent intent = new Intent(this, FourInARow.class);
        startActivity(intent);
    }


}
