package com.example.myapplication;

import com.example.fourinarow.FourInARow;

import org.junit.Assert;
import org.junit.Test;


public class FourInARowUnitTest {

    private FourInARow fourInARow = new FourInARow();

    @Test
    public void testSetToken()
    {
        int expected = 1;
        int actual;

        fourInARow.setToken(0);
        actual = fourInARow.setToken(0);


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTokenOverflow()
    {
        int expected_lower_threshold = 5;
        int expected_upper_threshold = -1;
        int actual= 0;


        for(int i= 0;i<6;i++)
        {
            actual = fourInARow.setToken(0);
        }

        Assert.assertEquals(expected_lower_threshold, actual);

        actual = fourInARow.setToken(0);

        Assert.assertEquals(expected_upper_threshold, actual);
    }

    @Test
    public void testInitScore()
    {
        String expected = fourInARow.getScore_player1();
        String actual = fourInARow.getScore_player2();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseScore()
    {
        final int PLAYER_ONE = 1;
        final int PLAYER_TWO = 2;

        String expected = "1";

        for(int i = 0; i<3;i++)
        {
            fourInARow.setToken(0);
            fourInARow.checkForInARow(PLAYER_ONE);
            fourInARow.setToken(1);
            fourInARow.checkForInARow(PLAYER_TWO);
        }

        fourInARow.setToken(0);
        fourInARow.checkForInARow(PLAYER_ONE);

        String actual = fourInARow.getScore_player1();

        Assert.assertEquals(expected, actual);
    }


}