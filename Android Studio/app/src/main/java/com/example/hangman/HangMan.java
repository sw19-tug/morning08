package com.example.hangman;


import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class HangMan {

    private String searched_word_;
    private char[] output_array_;
    private int score_;
    private int letter_guessed_;
    private int guesses_left_;
    private String[] words_;
    private Context context_;
    private ArrayList <String> connected_words_ = new ArrayList();

    public HangMan(String[] words, Context context){
        score_ = 0;
        letter_guessed_ = 0;
        this.words_ = words;
        this.context_ = context;
    }

    public HangMan(String[] words){
        score_ =0;
        letter_guessed_ = 0;
        this.words_ = words;
    }

    public HangMan(){
        score_ =0;
        letter_guessed_ = 0;
    }

    // initialize a new searchedword for hangman
    public void initialize() {

        System.out.println("Hangman.initialize()!");

        Random random = new Random();

        addVaryingWords();


        int random_number = random.nextInt(connected_words_.size());
        searched_word_ = connected_words_.get(random_number);
        guesses_left_ = 8;

        System.out.println("Searchedword: " + searched_word_);

        output_array_ = new char[searched_word_.length()];
        for(int i = 0; i < output_array_.length; i++)
            output_array_[i] = '_';

        letter_guessed_ = 0;

    }

    //import all varying word to list word[]
    public void addVaryingWords()
    {

        for(int i = 0; i < words_.length; i++){
            connected_words_.add(words_[i]);
        }

        try {
            File path = context_.getFilesDir();
            File file = new File(path, "Added_words.txt");

            FileReader reader = new FileReader(file);
            BufferedReader breader = new BufferedReader(reader);

            String line = breader.readLine();

            if(line != null) {
                do {
                    String [] new_words = split_line(line, " ");

                    for(int i=0; i<new_words.length;i++){
                        connected_words_.add(new_words[i]);
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

    public String [] split_line(String line, String seperator){

        String[] seperated_words = line.split(seperator);
        return seperated_words;

    }

    // checks if the input is part of the searched word
    public boolean checkLetter(String input) {

        char [] letter = input.toCharArray();
        char [] searched_word_array = searched_word_.toCharArray();
        boolean letter_found = false;

        for(int i = 0; i < searched_word_.length(); i++)
        {
            if(letter[0] == searched_word_array[i]) {
                if(letter[0] == output_array_[i])
                    break;

                for (int j = 0; j < searched_word_.length();j++){
                    if(j == i) {
                        output_array_[j] = letter[0];
                        letter_guessed_++;
                    }

                    else if(output_array_[j] != '_')
                        continue;
                }

                letter_found = true;
            }
        }

        if(letter_found)
            return true;

        else {
            guesses_left_--;
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
        if(letter_guessed_ == searched_word_.length()){
            score_++;
            return true;
        }
        else if(guesses_left_ == 0) {
            score_ = score_ - 2;     //deduct two points if not guessed word
            return false;
        }
        return false;
    }

    public void showrandomLetter() {

        Random random = new Random();
        int randomletter = random.nextInt(searched_word_.length());

        while(output_array_[randomletter] != '_')     //get next index if letter there
            randomletter = random.nextInt(searched_word_.length());

        output_array_[randomletter] = searched_word_.charAt(randomletter);

        letter_guessed_++;
        score_ = score_ - 3;
    }

    public String getOutput() {
        return new String(output_array_);
    }

    public int getScore() {
        return score_;
    }

    public int getGuessesLeft() {
        return guesses_left_;
    }

    public void setSearchedWord(String searchedword) {
        this.searched_word_ = searchedword;
    }

    public void setOutputArray(char[] output_array) {
        this.output_array_ = output_array;
    }

    public void setLetterGuessed(int letter_guessed) {
        this.letter_guessed_ = letter_guessed;
    }
    public void setScore(int score) {
        this.score_ = score;
    }

}
