package com.example.fourinarow;




import android.widget.ImageView;
import android.widget.TextView;


public class FourInARow {

    private int score_player1;
    private int score_player2;
    private int played_rounds;
    private int[][] grid;

    private final static int NOT_VALID = -1;
    private final static int GRID_WIDTH = 7;
    private final static int GRID_HEIGHT = 6;
    private final static int PLAYER_ONE = 1;
    private final static int PLAYER_TWO = 2;
    private final static int EMPTY_FIELD = 0;

    // Constructor
    public FourInARow() {
        score_player1 = 0;
        score_player2 = 0;
        played_rounds = 1;

        grid =  new int[GRID_HEIGHT][GRID_WIDTH];
        System.out.println("New Game initialized!");
    }

    // Set Token in given column
    public int setToken(int column)
    {
        System.out.println("Check if token is set valid!"+column);

        for(int i = 0; i<GRID_HEIGHT;i++)
            if(grid[i][column] == 0)
            {
                if(selectPlayer() == PLAYER_ONE)
                    grid[i][column] = PLAYER_ONE; // player one
                else
                    grid[i][column] = PLAYER_TWO; // player two
                return i;
            }

        return NOT_VALID;
    }

    public int selectPlayer()
    {
        if(played_rounds % 2 == 0)
        {
            System.out.println("selectPlayer: PLAYER_TWO");
            return PLAYER_TWO;
        }
        else
        {
            System.out.println("selectPlayer: PLAYER_ONE");
            return  PLAYER_ONE;
        }
    }

    public boolean checkForInARow(int current_player)
    {
        System.out.println("checkForInARow: current_player: "+current_player);

        for(int y = 0; y < GRID_HEIGHT; y++)
        {
            for(int x = 0; x < GRID_WIDTH; x++)
            {
                // only fields from the current user are interesting
                if(grid[y][x] != current_player)
                    continue;

                // check for 4inarow in x-axis
                for(int iterator = 0; iterator <= 3; iterator++)
                {
                    if(x+iterator > GRID_HEIGHT-1)
                        continue;
                    System.out.println("x_iterator:"+iterator );
                    if(grid[y][x+iterator] != current_player)
                        break;

                    else if(iterator == 3)
                    {
                        System.out.println("Player"+current_player+"won!");
                        played_rounds++;
                        return true;
                    }
                }
                // check for 4inarow in y-axis
                for(int iterator = 0; iterator <= 3; iterator++)
                {
                    if(y+iterator > GRID_HEIGHT-1)
                        continue;
                    System.out.println("y_iterator:"+iterator );
                    if(grid[y+iterator][x] != current_player)
                        break;
                    else if(iterator == 3)
                    {
                        System.out.println("Player"+current_player+"won!");
                        played_rounds++;
                        return true;
                    }
                }
                // check for 4inarow in positiv diagonal
                for(int iterator = 1; iterator <= 3; iterator++)
                {
                    if(x+iterator > GRID_WIDTH-1 || y+iterator > GRID_HEIGHT-1)
                        continue;

                    else if(grid[y+iterator][x+iterator] != current_player) {
                        System.out.println("y_iterator:"+iterator );
                        break;
                    }
                    else if(iterator == 3)
                    {
                        System.out.println("Player"+current_player+"won!");
                        played_rounds++;
                        return true;
                    }
                }
                // check for 4inarow in negativ diagonal
                for(int iterator = 1; iterator <= 3; iterator++)
                {
                    if(y-iterator < 0 || x+iterator > GRID_WIDTH-1)
                        continue;

                    else if(grid[y-iterator][x+iterator] != current_player) {
                        System.out.println("y_iterator:" + iterator );
                        break;
                    }
                    else if(iterator == 3)
                    {
                        System.out.println("Player" + current_player + "won!");
                        played_rounds++;
                        return true;
                    }
                }


            }
        }
        played_rounds++;
        return false;
    }

}