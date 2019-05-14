package com.example.tic_tac_toe;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.BreakIterator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.R;
import yuku.ambilwarna.AmbilWarnaDialog;


public class TicTacToeSettings extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_settings);

        Button chooseColor = findViewById(R.id.chooseColorButton);
        final Button buttonChooseSign = findViewById(R.id.buttonChooseSign);
        buttonChooseSign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(buttonChooseSign.getText() == "X")
                {
                    buttonChooseSign.setText("O");
                    check_x_or_y = false;
                }
                else
                {
                    buttonChooseSign.setText("X");
                    check_x_or_y = true;
                }
            }
        });

        chooseColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openChooseColor();
            }
        });

        Button startGame = findViewById(R.id.startGameButton);
        startGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openTicTacToe();
            }
        });
    }

    private static int signColor;

    public void openChooseColor()
    {
        int defaultColor = ContextCompat.getColor(TicTacToeSettings.this, R.color.colorPrimary);
        AmbilWarnaDialog ChooseColor = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener()
        {

            @Override
            public void onCancel(AmbilWarnaDialog dialog)
            {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color)
            {
                signColor = color;

            }
        });
        ChooseColor.show();
    }



    public void openTicTacToe()
    {
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);
        finish();
    }


    public static Integer getColor()
    {
        return signColor;
    }

    private static boolean check_x_or_y = true;

    public static boolean getSign()
    {
        if(check_x_or_y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
