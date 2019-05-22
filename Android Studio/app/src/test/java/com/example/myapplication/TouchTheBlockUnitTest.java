package com.example.myapplication;


import com.example.touchtheblock.TouchTheBlock;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class TouchTheBlockUnitTest {



    TouchTheBlock touchtheblock = new TouchTheBlock();


    @Test
    public void testInitialStateTimer() {
        assertNotNull(touchtheblock);
        assertNotNull(touchtheblock.getTimer());
    }
}