package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.view.View.OnClickListener;

import com.example.R;

public class Instructions extends AppCompatActivity {

    public int click = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuals);

        writeText();

        Button back = (Button) findViewById(R.id.btn_Back);
        Button next = (Button) findViewById(R.id.btn_Next);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBack();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext();
            }
        });

    }

    public void openBack() {
        click--;
        writeText();
    }

    public void openNext() {
        click++;
        writeText();
    }


    public void clearAll(){
        TextView Header_label =  findViewById(R.id.lblHeader);
        TextView Instructions_label = findViewById(R.id.lblInstructions);
        Header_label.setText("");
        Instructions_label.setText("");
    }

    public void writeText() {
        TextView Header_label = findViewById(R.id.lblHeader);
        TextView Instructions_label = findViewById(R.id.lblInstructions);

        if (click == 0 || click == 5) {
            finish();
        } else {
            Header_label.setText(getHeader());
            Instructions_label.setText(getText());
        }
    }

    public String getText(){
        String text;
        if(click == 1){
            text = "As a user you can play TicTacToe in two different modes:" +
                    " two player mode and autoplayer mode." +
                    " To switch to another mode you can click in the right corner." +
                    " You can also choose what tick-sign and what color you want to have."+
                    " You get one point for every game you win and -2 if you lose.";
            return text;
        }
        if(click == 2){
            text = "When playing hangman you have 8 guesses to get the right word." +
                    " You can also ask for a tip but you get deducted two points. For every game won you get one point. " +
                    "It is also possible to play in different degrees of difficulty.";
            return text;
        }
        if(click == 3){
            text = "At the game touch the block you have to click on the block every time it comes at a random position." +
                    " You can also choose the colors you want and there are different degrees of difficulty.";
            return text;
        }
        if(click == 4){
            text = "As a user you can play For in a row in two different modes: two player mode and autoplayer mode. " +
                    "To switch to another mode you can click in the right corner. " +
                    "You can also choose what color you want to have. You get one point for every game you win and -2 if you lose.";
            return text;
        }
        return "";
    }

    public String getHeader(){
        String text = "";
        if(click == 1){
            text =  "TicTacToe";
        } else if(click == 2){
            text = "Hangman";
        } else if(click == 3){
            text = "TouchTheBlock";
        } else if(click == 4){
            text = "FourInARow";
        }
        return text;
    }

}
