package com.example.myapplication;


import com.example.touchtheblock.TouchTheBlock;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class TouchTheBlockUnitTest {



    TouchTheBlock touchtheblock = new TouchTheBlock();

    @Test
    public void testRandom_() {
        float from;
        float to;
        float randnum;
        boolean under;
        boolean over;
        boolean between;

        from = (float) 1.0;
        to = (float) 5.0;

        randnum = touchtheblock.random_(from, to);
        under = (randnum<to);
        over = (randnum > from);
        between = (under && over);

        assertTrue(between);


        from = (float) 0.99;
        to = (float) 5.0;
        randnum = touchtheblock.random_(to);
        under = (randnum<to);
        over = (randnum > from);
        between = (under && over);
        assertTrue(between);
    }



    @Test
    public void testSetScreenSize() {

        float heigth = (float) 350.0;
        float width = (float) 200.0;
        float pixHeight;
        float pixWidth;

        touchtheblock.setScreenSize(heigth, width);

        pixHeight = touchtheblock.getPix_height();
        pixWidth = touchtheblock.getPix_width();
        Assert.assertEquals(heigth,pixHeight,1e-8);
        Assert.assertEquals(width,pixWidth, 1e-8);
    }

    @Test
    public void testSetBtnPlaySize() {
        float btnHeight = (float) 50.0;
        float btnWidth = (float) 50.0;
        float btnPlaySize;
        touchtheblock.setBtnPlaySize(btnHeight,btnWidth);

        float expected = (float) 35.35533905932738;
        float actual = touchtheblock.getSize_button_play();
        Assert.assertEquals(expected,actual, 1e-8);
    }

    @Test
    public void testInitialStateTimer() {
        assertNotNull(touchtheblock);
        assertNotNull(touchtheblock.getCountdowntimer_timer());
    }

    @Test
    public void testFunktionalityTimer() {

        assertNull(touchtheblock.getTime_text_());
        touchtheblock.getCountdowntimer_timer().start();
        touchtheblock.getCountdowntimer_timer().onFinish();
        assertNotNull(touchtheblock.getTime_text_());
        assertNotNull(touchtheblock.getCountdowntimer_timer());
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

        String actualScore = touchtheblock.getScore_str_();

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testResetScoreInt()  {
        int expectedscore = 0;

        touchtheblock.resetScore();

        int actualscore = touchtheblock.getScoreNum();

        Assert.assertEquals(expectedscore,actualscore);

    }

    @Test
    public void testResetScoreStr(){
        String expectedScore = "Score: 0" ;

        touchtheblock.resetScore();

        String actualScore = touchtheblock.getScore_str_();

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testRScoreContinue(){
        String expectedScore = "Score: 1" ;

        for (int round = 0; round < 11; round++){
            touchtheblock.increaseScore();
        }

        touchtheblock.decreaseScoreContiune();
        String actualScore = touchtheblock.getScore_str_();
        Assert.assertEquals(expectedScore, actualScore);
    }
}