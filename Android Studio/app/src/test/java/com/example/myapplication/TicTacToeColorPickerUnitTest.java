package com.example.tic_tac_toe;

import android.support.v4.content.ContextCompat;

import com.example.R;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeColorPickerUnitTest
{
    private TicTacToeSettings ticTacToe = new TicTacToeSettings();

    @Test
    public void testGetColor()
    {
        int expected = 0;
        int actual = ticTacToe.getColor();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSign()
    {
        boolean expected = true;
        boolean actual = ticTacToe.getSign();

        Assert.assertEquals(expected, actual);
    }
}
