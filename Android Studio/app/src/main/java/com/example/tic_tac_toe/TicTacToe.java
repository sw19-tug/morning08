package com.example.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.R;


public class TicTacToe extends AppCompatActivity implements OnClickListener
{

   private Button[][] button = new Button[3][3];
   static int click = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        button[0][0] = (Button) findViewById(R.id.button_1);
        button[0][1] = (Button) findViewById(R.id.button_2);
        button[0][2] = (Button) findViewById(R.id.button_3);
        button[1][0] = (Button) findViewById(R.id.button_4);
        button[1][1] = (Button) findViewById(R.id.button_5);
        button[1][2] = (Button) findViewById(R.id.button_6);
        button[2][0] = (Button) findViewById(R.id.button_7);
        button[2][1] = (Button) findViewById(R.id.button_8);
        button[2][2] = (Button) findViewById(R.id.button_9);

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
        switch (v.getId())
        {
            case R.id.button_1:
                button[0][0].setText(getRightValue());
                button[0][0].setEnabled(false);
                break;
            case R.id.button_2:
                button[0][1].setText(getRightValue());
                button[0][1].setEnabled(false);
                break;

            case R.id.button_3:
                button[0][2].setText(getRightValue());
                button[0][2].setEnabled(false);
                break;

            case R.id.button_4:
                button[1][0].setText(getRightValue());
                button[1][0].setEnabled(false);
                break;

            case R.id.button_5:
                button[1][1].setText(getRightValue());
                button[1][1].setEnabled(false);
                break;

            case R.id.button_6:
                button[1][2].setText(getRightValue());
                button[1][2].setEnabled(false);
                break;

            case R.id.button_7:
                button[2][0].setText(getRightValue());
                button[2][0].setEnabled(false);
                break;

            case R.id.button_8:
                button[2][1].setText(getRightValue());
                button[2][1].setEnabled(false);
                break;

            case R.id.button_9:
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




        gameIsOver();

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
        {
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
                   return true;
               }
           }
           for (col = 0; col < 3; col++)
           {
               if (Board[0][col].equals(Board[1][col]) && Board[0][col].equals(Board[2][col])
                   && !Board[0][col].equals(""))
               {
                   return true;                                                               
               }
           }

           if (Board[0][0].equals(Board[1][1]) && Board[0][0].equals(Board[2][2])
               && !Board[0][0].equals(""))
           {
               return true;                                                              
           }

           if (Board[0][2].equals(Board[1][1]) && Board[0][2].equals(Board[2][0])
               && !Board[0][2].equals(""))
           {
               return true;
           }

        }
        return false;
    }

    private boolean drawingPosition()
    {
      if(click == 9 && winningPosition() == false)
      {
          return true;
      }
      return false;
    }

    private boolean gameIsOver()
    {
       if(winningPosition())
       {
           //in case something like new Game should be a feature
           new AlertDialog.Builder(this).setTitle("You won! :)").
                   setMessage("").setPositiveButton(""
                   , new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which)
               {

               }
           }).show();
       }

       if(drawingPosition())
       {
           //in case something like new Game should be a feature
           new AlertDialog.Builder(this).setTitle("It's a Draw! :)").
                   setMessage("").setPositiveButton(""
                   , new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which)    
               {

               }
           }).show();
       }

       return false;
    }


}
