package com.example.myapplication;

import com.example.hangman.HangMan;

import org.junit.Assert;
import org.junit.Test;


public class HangManUnitTest {

    private String[] words_ = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};

    private HangMan hangman = new HangMan(words_);

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
        hangman.setOutputArray(testOutputarray);
        hangman.setSearchedWord(word);


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
        char[] test_output_array = {'a', 'p', 'p', 'l', 'e'};
        hangman.setOutputArray(test_output_array);

        actual = hangman.getOutput();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testWordGuessed()
    {
        boolean expected = false;
        boolean actual;
        String test_word = "apple";
        hangman.setSearchedWord(test_word);
        hangman.setLetterGuessed(0);

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

        char[] test_output_array = new char[word.length()];
        for(int i = 0; i < test_output_array.length; i++)
            test_output_array[i] = '_';
        hangman.setOutputArray(test_output_array);
        hangman.setSearchedWord(word);
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

        char[] test_output_array = new char[word.length()];
        for(int i = 0; i < test_output_array.length; i++)
            test_output_array[i] = '_';
        hangman.setOutputArray(test_output_array);
        hangman.setSearchedWord(word);
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

        char[] test_output_array = new char[word.length()];
        for(int i = 0; i < test_output_array.length; i++)
            test_output_array[i] = '_';
        hangman.setOutputArray(test_output_array);
        hangman.setSearchedWord(word);
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

        int init_output_counter = 0;
        int initial_score = hangman.getScore();
        String initial_output = hangman.getOutput();

        hangman.showrandomLetter();

        int final_output_counter = 0;
        String final_output = hangman.getOutput();

        for(int i = 0; i< initial_output.length(); i++){
            if(initial_output.charAt(i) == '_')
                init_output_counter++;
        }
        for(int i = 0; i< final_output.length(); i++){
            if(final_output.charAt(i) == '_')
                final_output_counter++;
        }

        int actual = hangman.getScore();

        Assert.assertEquals(init_output_counter, final_output_counter+1);
        Assert.assertEquals(initial_score, actual+3);
    }

}