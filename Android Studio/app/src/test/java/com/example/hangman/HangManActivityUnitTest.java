package com.example.hangman;

import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class HangManActivityUnitTest {
    HangManActivity hangman = new HangManActivity();


    @Test
    public void words_to_file() throws IOException {
        String word = "Farbe";
        hangman.create_files();
        assertTrue(hangman.words_to_file(word));
    }

    @Test
    public void create_files() throws IOException {
        assertTrue(hangman.create_files());
    }
}