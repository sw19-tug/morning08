package com.example.hangman;

import org.junit.Test;

import static org.junit.Assert.*;

public class HangmanSettingsUnitTest {
    HangmanSettings hangman = new HangmanSettings();

    @Test
    public void import_all_words() {
        assertFalse(hangman.import_all_words());
    }


}