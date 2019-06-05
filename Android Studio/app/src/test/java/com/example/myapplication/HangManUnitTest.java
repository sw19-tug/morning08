package com.example.myapplication;

import com.example.hangman.HangMan;

import org.junit.Assert;
import org.junit.Test;


public class HangManUnitTest {

    private String[] words = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};

    private HangMan hangman = new HangMan(words);

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

    @Test
    public void testSubtractLive()
    {
        String word = "apple";
        String input = "x";

        hangman.initialize();

        int expected = hangman.getGuessesLeft();

        char[] testOutputarray = new char[word.length()];
        for(int i = 0; i < testOutputarray.length; i++)
            testOutputarray[i] = '_';
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);
        hangman.checkLetter(input);

        int actual = hangman.getGuessesLeft();

        Assert.assertEquals(expected, actual+1);
    }

    @Test
    public void testDoNotSubtractLive()
    {
        String word = "apple";
        String input = "p";

        hangman.initialize();

        int expected = hangman.getGuessesLeft();

        char[] testOutputarray = new char[word.length()];
        for(int i = 0; i < testOutputarray.length; i++)
            testOutputarray[i] = '_';
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);
        hangman.checkLetter(input);


        int actual = hangman.getGuessesLeft();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDoesNotGuessTheWord()
    {
        String word = "apple";
        String input = "x";

        hangman.initialize();

        int expected = hangman.getScore();

        char[] testOutputarray = new char[word.length()];
        for(int i = 0; i < testOutputarray.length; i++)
            testOutputarray[i] = '_';
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);
        for(int i = 9; i > 0; i--) {
            hangman.checkLetter(input);
            hangman.wordGuessed();
        }


        int actual = hangman.getScore();


        Assert.assertEquals(expected, actual+2);
    }
    @Test
    public void testTip()
    {
        hangman.initialize();

        int initoutputcounter = 0;
        int initialscore = hangman.getScore();
        String initialoutput = hangman.getOutput();

        hangman.showrandomLetter();

        int finaloutputcounter = 0;
        String finaloutput = hangman.getOutput();

        for(int i = 0; i< initialoutput.length(); i++){
            if(initialoutput.charAt(i) == '_')
                initoutputcounter++;
        }
        for(int i = 0; i< finaloutput.length(); i++){
            if(finaloutput.charAt(i) == '_')
                finaloutputcounter++;
        }

        int actual = hangman.getScore();

        Assert.assertEquals(initoutputcounter, finaloutputcounter+1);
        Assert.assertEquals(initialscore, actual+3);
    }

}