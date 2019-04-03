package com.example.hangman;

import java.util.Random;

public class HangMan {

    private String searchedword;
    private char[] outputarray;
    private int score;
    private int letterguessed;

    public HangMan(){
        score =0;
        letterguessed = 0;
    }

    public void initialize() {

        //ToDo Logic
        System.out.println("Hangman.initialize()!");

        Random random = new Random();
        String[] words = {"apple", "banana", "cherry", "fig", "lemon", "mango", "orange", "pear"};
        int randomnumber = random.nextInt(words.length);
        searchedword = words[randomnumber];

        System.out.println("Searchedword: " + searchedword);

        outputarray = new char[searchedword.length()];
        for(int i = 0; i < outputarray.length; i++)
            outputarray[i] = '_';

        letterguessed = 0;


    }


    public boolean checkLetter(String input) {

        char [] letter = input.toCharArray();
        char [] searchedwordarray = searchedword.toCharArray();
        boolean letterfound = false;

        for(int i = 0; i<searchedword.length(); i++)
        {
            //TODO logic
            if(letter[0] == searchedwordarray[i]) {
                if(letter[0] == outputarray[i])
                    break;

                for (int j = 0; j < searchedword.length();j++){
                    if(j == i)
                    {
                        outputarray[j] = letter[0];
                        letterguessed++;
                    }

                    else if(outputarray[j] != '_')
                        continue;
                }

                letterfound = true;
            }

        }

        if(letterfound){
            System.out.println("outputarray: " + outputarray);
            return true;
        }
        else
            return false;

    }

    public boolean checkInput(String input) {

        System.out.println("Hangman.checkletter()!: " + input + " Length: " + input.length());

        if(input.length() != 1)
            return false;
        else
            return true;

    }

    public String getOutput() {
        return new String(outputarray);
    }

    public int getScore() {
        return score;
    }

    public boolean wordGuessed() {
        if(letterguessed == searchedword.length()){
            score++;
            return true;
        }
        else
            return false;
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
}
