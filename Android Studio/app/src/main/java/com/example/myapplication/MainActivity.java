package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.R;
import com.example.fourinarow.FourInARowActivity;
import com.example.hangman.HangManActivity;
import com.example.touchtheblock.TouchTheBlock;
import com.example.tic_tac_toe.TicTacToe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;
        File path = context.getFilesDir();
        File file = new File(path, "myfile.txt");

        if(file.length() == 0)
        {
            Toast.makeText(this,"Welcome to your first game!", Toast.LENGTH_SHORT).show();
            try {
                FileOutputStream stream = new FileOutputStream(file);
                stream.write("entered".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(this,"Welcome back!", Toast.LENGTH_SHORT).show();
        }


        Button tictac = (Button) findViewById(R.id.bt_tictac);
        Button hangman = (Button) findViewById(R.id.bt_hangman);
        Button touchbox = (Button) findViewById(R.id.bt_touchbox);
        Button fourinarow = (Button) findViewById(R.id.bt_fourinarow);
        Button manuals = (Button) findViewById(R.id.bt_instructions);

        manuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManuals();
            }
        });
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

    public void openManuals() {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, FourInARowActivity.class);
        startActivity(intent);
    }


}
