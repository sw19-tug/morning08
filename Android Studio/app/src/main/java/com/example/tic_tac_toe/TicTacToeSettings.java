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

        Button choose_color = findViewById(R.id.button_Choose_Color);
        final Button button_choose_sign = findViewById(R.id.button_Choose_Sign);
        button_choose_sign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(button_choose_sign.getText() == "X")
                {
                    button_choose_sign.setText("O");
                    check_x_or_y = false;
                }
                else
                {
                    button_choose_sign.setText("X");
                    check_x_or_y = true;
                }
            }
        });

        choose_color.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openChooseColor();
            }
        });

        Button start_game = findViewById(R.id.button_Start_Game);
        start_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openTicTacToe();
            }
        });
    }

    private static int sign_color_;

    public void openChooseColor()
    {
        int default_color = ContextCompat.getColor(TicTacToeSettings.this, R.color.colorPrimary);
        AmbilWarnaDialog ChooseColor = new AmbilWarnaDialog(this, default_color, new AmbilWarnaDialog.OnAmbilWarnaListener()
        {

            @Override
            public void onCancel(AmbilWarnaDialog dialog)
            {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color)
            {
                sign_color_ = color;

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
        return sign_color_;
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
