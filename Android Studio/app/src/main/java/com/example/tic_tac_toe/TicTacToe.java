package com.example.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.R;
import com.example.myapplication.MainActivity;

import java.util.Random;


public class TicTacToe extends AppCompatActivity implements OnClickListener
{

   private Button[][] button = new Button[3][3];
   static int click = 0;
   private int  score = 0;
   //Variable end is to stop Autoplayer after the last possible step (which will always be done by Player 1) -> Avoiding an endless loop
   boolean end = false;
   static boolean Autoplayer;
   private TextView score_label;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        button[0][0] = (Button) findViewById(R.id.button_0_0);
        button[0][1] = (Button) findViewById(R.id.button_0_1);
        button[0][2] = (Button) findViewById(R.id.button_0_2);
        button[1][0] = (Button) findViewById(R.id.button_1_0);
        button[1][1] = (Button) findViewById(R.id.button_1_1);
        button[1][2] = (Button) findViewById(R.id.button_1_2);
        button[2][0] = (Button) findViewById(R.id.button_2_0);
        button[2][1] = (Button) findViewById(R.id.button_2_1);
        button[2][2] = (Button) findViewById(R.id.button_2_2);
        score_label = (TextView) findViewById(R.id.label_sc);
        score_label.setText("Score: ");

        for (int i = 0; i < 3; i++)
        {
            for (int y = 0; y < 3; y++)
            {
                button[i][y].setOnClickListener(this);
            }
        }

    }


    public void onClick(View v)
    {
        click++;
        score_label.setText("Score: "+getScore());

        switch (v.getId())
        {
            case R.id.button_0_0:
                button[0][0].setText(getRightValue());
                button[0][0].setEnabled(false);
                break;
            case R.id.button_0_1:
                button[0][1].setText(getRightValue());
                button[0][1].setEnabled(false);
                break;

            case R.id.button_0_2:
                button[0][2].setText(getRightValue());
                button[0][2].setEnabled(false);
                break;

            case R.id.button_1_0:
                button[1][0].setText(getRightValue());
                button[1][0].setEnabled(false);
                break;

            case R.id.button_1_1:
                button[1][1].setText(getRightValue());
                button[1][1].setEnabled(false);
                break;

            case R.id.button_1_2:
                button[1][2].setText(getRightValue());
                button[1][2].setEnabled(false);
                break;

            case R.id.button_2_0:
                button[2][0].setText(getRightValue());
                button[2][0].setEnabled(false);
                break;

            case R.id.button_2_1:
                button[2][1].setText(getRightValue());
                button[2][1].setEnabled(false);
                break;

            case R.id.button_2_2:
                button[2][2].setText(getRightValue());
                button[2][2].setEnabled(false);
                break;
        }

        if (winningPosition())
        {
            for (int row = 0; row < 3; row++)
            {
                for (int col = 0; col < 3; col++)
                {
                    button[row][col].setEnabled(false);
                }
            }
        }

        if (Autoplayer){
            startAutoplayer();
        }

    }

    public void startAutoplayer(){
        if (click < 9 && !end){
            click++;
            autoplayerclick();

            if (winningPosition()) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        button[row][col].setEnabled(false);
                    }
                }

            }
        }
    }

    public int Generator (){
        Random generator = new Random();
        int number = generator.nextInt(3);
        return number;
    }

    public void autoplayerclick()
    {
        int x = Generator();
        int y = Generator();
        while(!button[x][y].isEnabled()){
            x = Generator();
            y = Generator();
        }

        button[x][y].setText(getRightValue());
        button[x][y].setEnabled(false);
    }

    public String getRightValue ()
    {
       if (click % 2 == 0)
       {
           return "O";
       }
       else
       {
           return "X";
       }

    }

    public boolean winningPosition()
    {
        String[][] Board = new String[3][3];

        int row;
        int col;
        for (row = 0; row < 3; row++)
        {
            for (col = 0; col < 3; col++)
            {
                Board[row][col] = button[row][col].getText().toString();
            }
        }

        for (row = 0; row < 3; row++)
        {
            if (Board[row][0].equals(Board[row][1]) && Board[row][0].equals(Board[row][2])
                    && !Board[row][0].equals(""))
            {
                return getWinner();
            }
        }
        for (col = 0; col < 3; col++)
        {
            if (Board[0][col].equals(Board[1][col]) && Board[0][col].equals(Board[2][col])
                    && !Board[0][col].equals(""))
            {
                return getWinner();
            }
        }

        if (Board[0][0].equals(Board[1][1]) && Board[0][0].equals(Board[2][2])
                && !Board[0][0].equals(""))
        {
            return getWinner();
        }

        if (Board[0][2].equals(Board[1][1]) && Board[0][2].equals(Board[2][0])
                && !Board[0][2].equals(""))
        {
            return getWinner();
        }

        return drawingPosition();

    }

    private boolean getWinner(){


        if (click % 2 == 0){
            return gameIsOver(1);
        } else {
            return gameIsOver(2);
        }

    }

    private boolean drawingPosition()
    {
        if(click == 9)
        {
            gameIsOver(0);
        }
        return false;
    }

    private String getMessage (int winner){
        if (winner == 1){
            if(Autoplayer){
                score = score - 2;
                score_label.setText("Score: "+getScore());
                return "Computer won!";
            } else {
                score = score - 2;
                score_label.setText("Score: "+getScore());
                return "Player 2 won! :)";
            }
        } else if (winner == 2){
            if(Autoplayer){
                score++;
                score_label.setText("Score: "+getScore());
                return "You won! :)";
            } else {
                score++;
                score_label.setText("Score: "+getScore());
                return "Player 1 won! :)";
            }
        } else if (winner == 0){
            return "It's a Draw! :)";
        }
        return "ERROR";
    }

    private boolean gameIsOver(int winner) {
        end = true;
        String message = getMessage(winner);

        if (message != "ERROR") {

            new AlertDialog.Builder(this).setTitle(message).
                    setMessage("").setPositiveButton(""
                    , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tictactoe_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.auto_player:
                openTicTacToeAutoPlayer();
                return true;

            case R.id.two_player:
                openTicTacToeTwoPlayer();
                return true;

            default: return super.onOptionsItemSelected(item);
        }



    }

    /* prepare Settings later in another Feature//
    public void openTicTacToeSettings()
    {
        Intent intent = new Intent(this, TicTacToeSettings.class);
        startActivity(intent);
    }*/


    public void openTicTacToeTwoPlayer()
    {
        Autoplayer = false;
        click = 0;
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);
    }

    public void openTicTacToeAutoPlayer()
    {
        Autoplayer = true;
        click = 0;
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);

    }

    public int getScore()
    {
        return score;
    }
}
