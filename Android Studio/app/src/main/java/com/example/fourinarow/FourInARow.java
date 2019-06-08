package com.example.fourinarow;




import android.widget.ImageView;
import android.widget.TextView;


public class FourInARow {

    private int score_player1;
    private int score_player2;
    private int[][] grid;

    private final static int NOT_VALID =-1;
    private final static int GRID_WIDTH = 7;
    private final static int GRID_HEIGHT = 6;

    // Constructor
    public FourInARow() {
        score_player1 = 0;
        score_player2 = 0;
        grid =  new int[GRID_HEIGHT][GRID_WIDTH];
        System.out.println("New Game initialized!");
    }

    // Set Token in given column
    public int setToken(int column)
    {
        System.out.println("Check if token is set valid!"+column);
        int temp = 0;

        for(int i = 0; i<GRID_HEIGHT;i++)
            if(grid[i][column] == 0)
            {
                grid[i][column] = 1;
                return i;
            }


        System.out.println("GRID_HEIGHT: "+temp);

        return NOT_VALID;
    }



}
        /*
        GradientDrawable backgroundGradient = (GradientDrawable)imgview.getBackground();
        backgroundGradient.setColor(getResources().getColor(R.color.colorLime));
        */

    /*
    public void onClick(View v)
    {
        click++;
        score_label.setText("Score: " + getScore());

        /*
        switch (v.getId())
            case R.id.button_0_0:
                break;
            case R.id.button_0_1:
                button[0][1].setText(getRightValue());
                button[0][1].setEnabled(false);
                break;

            case R.id.button_0_2:
                button[0][2].setText(getRightValue());
                button[0][2].setEnabled(false);
                break;

            case R.id.button_0_3:
                button[0][3].setText(getRightValue());
                button[0][3].setEnabled(false);
                break;

            case R.id.button_0_4:
                button[0][1].setText(getRightValue());
                button[0][1].setEnabled(false);
                break;

            case R.id.button_0_5:
                button[0][2].setText(getRightValue());
                button[0][2].setEnabled(false);
                break;

            case R.id.button_0_6:
                button[0][3].setText(getRightValue());
                button[0][3].setEnabled(false);
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

            case R.id.button_1_3:
                button[1][3].setText(getRightValue());
                button[1][3].setEnabled(false);
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

            case R.id.button_2_3:
                button[2][3].setText(getRightValue());
                button[2][3].setEnabled(false);
                break;

            case R.id.button_3_0:
                button[3][0].setText(getRightValue());
                button[3][0].setEnabled(false);
                break;

            case R.id.button_3_1:
                button[3][1].setText(getRightValue());
                button[3][1].setEnabled(false);
                break;

            case R.id.button_3_2:
                button[3][2].setText(getRightValue());
                button[3][2].setEnabled(false);
                break;

            case R.id.button_3_3:
                button[3][3].setText(getRightValue());
                button[3][3].setEnabled(false);
                break;
        }*/

    /*
        if (winningPosition())
        {
            for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 4; col++)
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

        if (click < 16 && !end){
            click++;
            autoplayerclick();

            if (winningPosition()) {
                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 4; col++) {
                        button[row][col].setEnabled(false);
                    }
                }

            }
        }
    }

    public int Generator (){
        Random generator = new Random();
        int number = generator.nextInt(4);
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
        String[][] Board = new String[4][4];

        int row;
        int col;
        for (row = 0; row < 4; row++)
        {
            for (col = 0; col < 4; col++)
            {
                Board[row][col] = button[row][col].getText().toString();
            }
        }

        for (row = 0; row < 4; row++)
        {
            if (Board[row][0].equals(Board[row][1]) && Board[row][0].equals(Board[row][2])
                    && !Board[row][0].equals(""))
            {
                return getWinner();
            }
        }
        for (col = 0; col < 4; col++)
        {
            if (Board[0][col].equals(Board[1][col]) && Board[0][col].equals(Board[2][col])
                    && Board[0][col].equals(Board[3][col]) && !Board[0][col].equals(""))
            {
                return getWinner();
            }
        }

        if (Board[0][0].equals(Board[1][1]) && Board[0][0].equals(Board[2][2])
                && Board[0][0].equals(Board[3][3]) && !Board[0][0].equals(""))
        {
            return getWinner();
        }

        if (Board[0][2].equals(Board[1][1]) && Board[0][2].equals(Board[2][0])
                && Board[0][2].equals(Board[2][0]) && !Board[0][2].equals(""))
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
        if(click == 16)
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fourinarow_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.auto_player:
                Autoplayer = true;
                resetGame();
                return true;

            case R.id.two_player:
                Autoplayer = false;
                resetGame();
                return true;

            default: return super.onOptionsItemSelected(item);
        }



    }

    /* prepare Settings later in another Feature//
    public void openTicTacToeSettings()
    {
        Intent intent = new Intent(this, TicTacToeSettings.class);
        startActivity(intent);
    }

    public void resetGame()
    {
        click = 0;
        end = false;
        for (int i = 0; i < 4; i++)
        {
            for (int y = 0; y < 4; y++)
            {
                button[i][y].setEnabled(true);
                button[i][y].setText("");
            }
        }

    }


    public int getScore()
    {
        return score;
    }*/
