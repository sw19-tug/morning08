package com.example.hangman;

import java.util.Random;

public class HangMan {

    private String searchedword;
    private char[] outputarray;
    private int score;
    private int letterguessed;
    private int guessesleft;

    public HangMan(){
        score =0;
        letterguessed = 0;
    }

    // initialize a new searchedword for hangman
    public void initialize() {

        System.out.println("Hangman.initialize()!");

        Random random = new Random();
        String[] words = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};
        int randomnumber = random.nextInt(words.length);
        searchedword = words[randomnumber];
        guessesleft = 8;

        System.out.println("Searchedword: " + searchedword);

        outputarray = new char[searchedword.length()];
        for(int i = 0; i < outputarray.length; i++)
            outputarray[i] = '_';

        letterguessed = 0;

    }

    // checks if the input is part of the searched word
    public boolean checkLetter(String input) {

        char [] letter = input.toCharArray();
        char [] searchedwordarray = searchedword.toCharArray();
        boolean letterfound = false;

        for(int i = 0; i<searchedword.length(); i++)
        {
            if(letter[0] == searchedwordarray[i]) {
                if(letter[0] == outputarray[i])
                    break;

                for (int j = 0; j < searchedword.length();j++){
                    if(j == i) {
                        outputarray[j] = letter[0];
                        letterguessed++;
                    }

                    else if(outputarray[j] != '_')
                        continue;
                }

                letterfound = true;
            }
        }

        if(letterfound)
            return true;

        else {
            guessesleft--;
            return false;
        }

    }

    // check if the input given by the user is valid
    public boolean checkInput(String input) {

        System.out.println("Hangman.checkletter()!: " + input + " Length: " + input.length());

        if(input.length() != 1)
            return false;
        else
            return true;

    }

    // verify if the word is completly guessed & manage the score
    public boolean wordGuessed() {
        if(letterguessed == searchedword.length()){
            score++;
            return true;
        }
        else if(guessesleft == 0) {
            score = score - 2;     //deduct two points if not guessed word
            return false;
        }
        return false;
    }

    public void showrandomLetter() {

        Random random = new Random();
        int randomletter = random.nextInt(searchedword.length());

        while(outputarray[randomletter] != '_')     //get next index if letter there
            randomletter = random.nextInt(searchedword.length());

        outputarray[randomletter] = searchedword.charAt(randomletter);

        letterguessed++;
        score = score - 3;
    }

    public String getOutput() {
        return new String(outputarray);
    }

    public int getScore() {
        return score;
    }

    public int getGuessesLeft() {
        return guessesleft;
    }

    public void setSearchedword(String searchedword) {
        this.searchedword = searchedword;
    }

    public void setOutputarray(char[] outputarray) {
        this.outputarray = outputarray;
    }

    public void setLetterguessed(int letterguessed) {
        this.letterguessed = letterguessed;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
