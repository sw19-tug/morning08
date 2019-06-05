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
    public void testScoreatWinning() throws InterruptedException {
        int expectedscore = TouchTheBlock.getScoreNum() + 3;

        increaseScore();
        increaseScore();
        increaseScore();

        int actualscore = TouchTheBlock.getScoreNum();

        Assert.assertEquals(expectedscore,actualscore);


    }

}