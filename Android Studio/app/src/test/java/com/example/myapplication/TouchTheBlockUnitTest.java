package com.example.myapplication;


import com.example.R;
import com.example.touchtheblock.TouchTheBlock;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class TouchTheBlockUnitTest {



    TouchTheBlock touchtheblock = new TouchTheBlock();


    @Test
    public void testInitialStateTimer() {
        assertNotNull(touchtheblock);
        assertNotNull(touchtheblock.getTimer());
    }

    @Test
    public void testFunktionalityTimer() {

        assertNull(touchtheblock.getTvTimeText());
        touchtheblock.getTimer().start();
        touchtheblock.getTimer().onFinish();
        assertNotNull(touchtheblock.getTvTimeText());
        assertNotNull(touchtheblock.getTimer());
    }


    @Test
    public void testScoreatWinning()  {
        int expectedscore = touchtheblock.getScoreNum() + 3;

        touchtheblock.increaseScore();
        touchtheblock.increaseScore();
        touchtheblock.increaseScore();

        int actualscore = touchtheblock.getScoreNum();

        Assert.assertEquals(expectedscore,actualscore);

    }

    @Test
    public void testtvScore(){
        String expectedScore = "Score: 3" ;

        touchtheblock.increaseScore();
        touchtheblock.increaseScore();
        touchtheblock.increaseScore();

        String actualScore = touchtheblock.getScorestr();

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testScoreatWinning()  {
        int expectedscore = 0;

        touchtheblock.resetScore();

        int actualscore = touchtheblock.getScoreNum();

        Assert.assertEquals(expectedscore,actualscore);

    }

    @Test
    public void testResetScore(){
        String expectedScore = "Score: 0" ;

        touchtheblock.resetScore();

        String actualScore = touchtheblock.getScorestr();

        Assert.assertEquals(expectedScore, actualScore);
    }
}