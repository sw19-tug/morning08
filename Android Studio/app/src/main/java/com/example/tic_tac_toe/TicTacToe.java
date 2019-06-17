package com.example.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
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


public class TicTacToe extends AppCompatActivity implements OnClickListener {

    public TicTacToe() {

    }

    private Button[][] button_ = new Button[3][3];
    static int click_ = 0;
    private int score_ = 0;
    boolean end_ = false;
    static boolean autoplayer_;
    private TextView score_label_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        button_[0][0] = (Button) findViewById(R.id.button_0_0);
        button_[0][1] = (Button) findViewById(R.id.button_0_1);
        button_[0][2] = (Button) findViewById(R.id.button_0_2);
        button_[1][0] = (Button) findViewById(R.id.button_1_0);
        button_[1][1] = (Button) findViewById(R.id.button_1_1);
        button_[1][2] = (Button) findViewById(R.id.button_1_2);
        button_[2][0] = (Button) findViewById(R.id.button_2_0);
        button_[2][1] = (Button) findViewById(R.id.button_2_1);
        button_[2][2] = (Button) findViewById(R.id.button_2_2);
        score_label_ = (TextView) findViewById(R.id.label_sc);
        score_label_.setText("Score: ");

        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                button_[i][y].setOnClickListener(this);
            }
        }

    }

    TicTacToeSettings call_color = new TicTacToeSettings();
    String hex_color_sign_1 = String.format("#%06X", (0xFFFFFF & call_color.getColor()));
    String hex_color_sign_2 = String.format("#%06X", (0xFFFFFF & call_color.getColor() - 20000));

    public void onClick(View v) {


        click_++;
        score_label_.setText("Score: " + getScore());

        switch (v.getId()) {

            case R.id.button_0_0:
                button_[0][0].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[0][0].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[0][0].setText(getRightValue());
                button_[0][0].setEnabled(false);
                break;
            case R.id.button_0_1:
                button_[0][1].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[0][1].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[0][1].setText(getRightValue());
                button_[0][1].setEnabled(false);
                break;
            case R.id.button_0_2:
                button_[0][2].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[0][2].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[0][2].setText(getRightValue());
                button_[0][2].setEnabled(false);
                break;
            case R.id.button_1_0:
                button_[1][0].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[1][0].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[1][0].setText(getRightValue());
                button_[1][0].setEnabled(false);
                break;
            case R.id.button_1_1:
                button_[1][1].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[1][1].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[1][1].setText(getRightValue());
                button_[1][1].setEnabled(false);
                break;
            case R.id.button_1_2:
                button_[1][2].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[1][2].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[1][2].setText(getRightValue());
                button_[1][2].setEnabled(false);
                break;
            case R.id.button_2_0:
                button_[2][0].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[2][0].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[2][0].setText(getRightValue());
                button_[2][0].setEnabled(false);
                break;
            case R.id.button_2_1:
                button_[2][1].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[2][1].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[2][1].setText(getRightValue());
                button_[2][1].setEnabled(false);
                break;
            case R.id.button_2_2:
                button_[2][2].setTextColor(Color.parseColor(hex_color_sign_1));
                if (click_ % 2 == 0)
                    button_[2][2].setTextColor(Color.parseColor(hex_color_sign_2));
                button_[2][2].setText(getRightValue());
                button_[2][2].setEnabled(false);
                break;
        }

        if (winningPosition()) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    button_[row][col].setEnabled(false);
                }
            }
        }
        if (autoplayer_) {
            startAutoplayer();
        }

    }

    public void startAutoplayer() {

        if (click_ < 9 && !end_) {
            click_++;
            autoplayerClick();

            if (winningPosition()) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        button_[row][col].setEnabled(false);
                    }
                }

            }
        }
    }

    public int Generator() {
        Random generator = new Random();
        int number = generator.nextInt(3);
        return number;
    }

    public void autoplayerClick() {
        int x = Generator();
        int y = Generator();
        while (!button_[x][y].isEnabled()) {
            x = Generator();
            y = Generator();
        }
        button_[x][y].setTextColor(Color.parseColor(hex_color_sign_2));
        if (click_ % 2 == 0)
            button_[0][0].setTextColor(Color.parseColor(hex_color_sign_1));
        button_[x][y].setText(getRightValue());
        button_[x][y].setEnabled(false);
    }

    public String getRightValue() {
        TicTacToeSettings call_sign = new TicTacToeSettings();
        boolean x_or_y = call_sign.getSign();
        if (click_ % 2 == 0) {
            if (x_or_y) {
                return "O";
            } else {
                return "X";
            }
        } else {
            if (x_or_y) {
                return "X";
            } else {
                return "O";
            }
        }
    }

    public boolean winningPosition() {
        String[][] board = new String[3][3];

        int row;
        int col;
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                board[row][col] = button_[row][col].getText().toString();
            }
        }

        for (row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2])
                    && !board[row][0].equals("")) {
                return getWinner();
            }
        }
        for (col = 0; col < 3; col++) {
            if (board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col])
                    && !board[0][col].equals("")) {
                return getWinner();
            }
        }

        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])
                && !board[0][0].equals("")) {
            return getWinner();
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])
                && !board[0][2].equals("")) {
            return getWinner();
        }

        return drawingPosition();

    }

    private boolean getWinner() {


        if (click_ % 2 == 0) {
            return gameIsOver(1);
        } else {
            return gameIsOver(2);
        }

    }

    private boolean drawingPosition() {
        if (click_ == 9) {
            gameIsOver(0);
        }
        return false;
    }



    private boolean gameIsOver(int winner) {
        end_ = true;
        String message = getMessage(winner);

        if (message != "ERROR") {

            new AlertDialog.Builder(this).setTitle(message).
                    setMessage("").setPositiveButton("BACK"
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

    private String getMessage (int winner){
        if (winner == 1){
            if(autoplayer_){
                score_ = score_ - 2;
                score_label_.setText("Score: "+getScore());
                return "Computer won!";
            } else {
                score_ = score_ - 2;
                score_label_.setText("Score: "+getScore());
                return "Player 2 won! :)";
            }
        } else if (winner == 2){
            if(autoplayer_){
                score_++;
                score_label_.setText("Score: "+getScore());
                return "You won! :)";
            } else {
                score_++;
                score_label_.setText("Score: "+getScore());
                return "Player 1 won! :)";
            }
        } else if (winner == 0){
            return "It's a Draw! :)";
        }
        return "ERROR";
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
                autoplayer_ = true;
                resetGame();
                return true;

            case R.id.two_player:
                autoplayer_ = false;
                resetGame();
                return true;

            case R.id.settings:
                openTicTacToeSettings();

            default: return super.onOptionsItemSelected(item);
        }



    }

    public void openTicTacToeSettings()
    {
        Intent intent = new Intent(this, TicTacToeSettings.class);
        startActivity(intent);
        click_ = 0;
        finish();
    }

    public void resetGame()
    {
        click_ = 0;
        end_ = false;
        for (int i = 0; i < 3; i++)
        {
            for (int y = 0; y < 3; y++)
            {
                button_[i][y].setEnabled(true);
                button_[i][y].setText("");
            }
        }
    }


    public int getScore()
    {
        return score_;
    }
}