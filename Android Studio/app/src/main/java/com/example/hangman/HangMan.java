package com.example.hangman;


import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.widget.TextView;

import com.example.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.Object.*;
public class HangMan {

    private String searchedword;
    private char[] outputarray;
    private int score;
    private int letterguessed;
    private int guessesleft;
    private String[] words;
    private Context context;
    private ArrayList <String> connected_words = new ArrayList();

    public HangMan(String[] words, Context context){
        score =0;
        letterguessed = 0;
        this.words = words;
        this.context = context;
    }

    public HangMan(String[] words){
        score =0;
        letterguessed = 0;
        this.words = words;
    }



    // initialize a new searchedword for hangman
    public void initialize() {

        System.out.println("Hangman.initialize()!");

        Random random = new Random();

        add_varying_words();


        int randomnumber = random.nextInt(connected_words.size());
        searchedword = connected_words.get(randomnumber);
        guessesleft = 8;

        System.out.println("Searchedword: " + searchedword);

        outputarray = new char[searchedword.length()];
        for(int i = 0; i < outputarray.length; i++)
            outputarray[i] = '_';

        letterguessed = 0;

    }

    //import all varying word to list word[]
    public void add_varying_words(){

        for(int i=0; i<words.length;i++){
            connected_words.add(words[i]);
        }

        try {
            File path = context.getFilesDir();
            File file = new File(path, "Added_words.txt");

            FileReader reader = new FileReader(file);
            BufferedReader breader = new BufferedReader(reader);

            String line = breader.readLine();

            if(line != null) {
                do {
                    String [] new_words = splitline(line);

                    for(int i=0; i<new_words.length;i++){
                        connected_words.add(new_words[i]);
                    }

                    line = breader.readLine();
                } while (line != null);
            }

            reader.close();
            breader.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public String [] splitline(String line){

        String[] seperated_words = line.split(" ");
        return seperated_words;

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
