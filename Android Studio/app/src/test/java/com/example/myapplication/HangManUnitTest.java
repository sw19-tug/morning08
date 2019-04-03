package com.example.hangman;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class HangManUnitTest {

    private HangMan hangman = new HangMan();

    @Test
    public void testCheckLetter()
    {
        boolean expected = true;
        boolean actual;
        String word = "apple";
        String input = "a";

        char[] testOutputarray = new char[word.length()];
        for(int i = 0; i < testOutputarray.length; i++)
            testOutputarray[i] = '_';
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);


        actual = hangman.checkLetter(input);


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckInput()
    {
        boolean expected = true;
        boolean actual;
        String input = "m";

        actual = hangman.checkInput(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetOutput()
    {
        String expected = "apple";
        String actual;
        char[] testOutputarray = {'a', 'p', 'p', 'l', 'e'};
        hangman.setOutputarray(testOutputarray);

        actual = hangman.getOutput();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testWordGuessed()
    {
        boolean expected = false;
        boolean actual;
        String testWord = "apple";
        hangman.setSearchedword(testWord);
        hangman.setLetterguessed(0);

        actual = hangman.wordGuessed();

        Assert.assertEquals(expected, actual);
    }
}