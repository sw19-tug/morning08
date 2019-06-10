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



}