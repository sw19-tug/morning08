package com.example.hangman;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HangmanSettingsUnitTest {
    HangmanSettings hangman = new HangmanSettings();

    @Test
    public void import_all_words() {
        assertFalse(hangman.import_all_words());
    }
    @Test
    public void processwords() {
        String[] words = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};
        String expected = " apple, banana, cherry, fig, lemon, mango, orange, pear, ";
        assertEquals(expected, hangman.processwords(words));
    }

    @Test
    public void splitline() {
        String words = "apple banana cherry fig lemon mango orange pear";
        String[] expected = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};
        assertEquals(expected, hangman.splitline(words));
    }



    @Test
    public void checkwords_for_adding() throws IOException {
        String word = "kiwi";
        assertTrue(hangman.checkwords_for_adding(word));
    }


    @Test
    public void compare_words() {
        String[] words = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};
        String word = "apple";
        assertTrue(hangman.compare_words(words,word));
    }

}