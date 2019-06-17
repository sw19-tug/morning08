package com.example.hangman;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HangmanSettings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_settings);

        Button button_add = findViewById(R.id.btn_add);
        Button button_delete = findViewById(R.id.btn_delete);
        Button button_return = findViewById(R.id.btn_return);


        import_all_words();

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AddText();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteText();
            }
        });

        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    //import words
    public boolean  import_all_words()  {

        try {
            Context context = this;
            File path = context.getFilesDir();
            File file1 = new File(path, "Fixed_words.txt");
            TextView view1 = findViewById(R.id.lbl_fix_words);
            view1.setText("");
            add_import_to_view(file1,view1);

            File file2 = new File(path, "Added_words.txt");
            TextView view2 = findViewById(R.id.lbl_varying_words);
            view2.setText("");
            add_import_to_view(file2,view2);
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }


    }



    public void add_import_to_view(File file, TextView current_view) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        StringBuilder fixed_text = new StringBuilder(current_view.getText().toString());
        String line = breader.readLine();

        if(line != null) {
            do {
                fixed_text.append(processwords(splitline(line, " ")));

                line = breader.readLine();
            }
            while (line != null);
        }

        current_view.append(fixed_text.toString());
        reader.close();
        breader.close();
    }

    public String processwords(String [] seperated_words){
        StringBuilder adding_words = new StringBuilder(" ");
        for (int i = 0; i < seperated_words.length; i++){
            if(seperated_words[i] == null) continue;
            if(seperated_words[i].equals(" ")) continue;

            adding_words.append(seperated_words[i]).append(", ");
        }
        return adding_words.toString();
    }

    public String [] splitline(String line, String seperator){

        String[] seperated_words = line.split(seperator);
        return seperated_words;

    }

    //Add Text
    public void AddText() throws IOException {
        String input_txt = ((EditText) findViewById(R.id.txtInput)).getText().toString();
        if(input_txt.isEmpty()){
            String message = "Nothing Added";
            getMessage(message);
            return;
        }


        TextView varying_words = findViewById(R.id.lbl_varying_words);
        Context context = this;
        File path = context.getFilesDir();
        File file = new File(path, "Added_words.txt");
        FileWriter writer = new FileWriter(file, true);
        try {

            if(checkwords_for_adding(input_txt)) { //writing is possible
                writer.write(input_txt + " ");
                varying_words.append(input_txt + ", ");
                String message = "Successfully Added";
                getMessage(message);

            } else {
                String message = "word allready exists!";
                getMessage(message);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }

    }

    public boolean checkwords_for_adding(String input) throws IOException {

        Context context = this;
        File path = context.getFilesDir();
        File file1 = new File(path, "Added_words.txt");
        File file2 = new File(path, "Fixed_words.txt");
        if (search_word(file1, input)){
            return false;       //word found - writing not possible
        }
        if (search_word(file2, input)){
            return false;       //word found - writing not possible
        }
        return true;        //word not found - writing possible
    }

    public boolean search_word(File current_file, String input) throws IOException {
        FileReader reader = new FileReader(current_file);
        BufferedReader breader = new BufferedReader(reader);

        String line = breader.readLine();

        if(line != null) {
            do {
                String[] words = splitline(line, " ");
                if (compare_words(words, input)) {
                    breader.close();
                    return true;
                }
                line = breader.readLine();

            } while (line != null);
        }
        reader.close();
        breader.close();
        return false;
    }

    public boolean compare_words(String [] words, String input){
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(input)){
                return true;    //word found   - deleting possible
            }
        }
        return false;         //word not found - writing possible
    }

    //Delet Text
    public void DeleteText(){
        String input_txt = ((EditText) findViewById(R.id.txtInput)).getText().toString();
        if(input_txt.isEmpty()){
            String message = "Nothing Deleted";
            getMessage(message);
            return;
        }


        Context context = this;
        File path = context.getFilesDir();
        File file = new File(path, "Added_words.txt");

        try {
            if(checkwords_for_deleting(input_txt)) { //writing is possible
                String message = "word does not exists or deleting is not possible!";
                getMessage(message);
            } else {
                find_word_to_delete(input_txt, file);
                import_all_words();
                String message = "Successfully Deleted";
                getMessage(message);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean checkwords_for_deleting(String input) throws IOException {

        Context context = this;
        File path = context.getFilesDir();
        File file1 = new File(path, "Added_words.txt");
        File file2 = new File(path, "Fixed_words.txt");
        if (search_word(file1, input)){
            return false;       //word found - deleting  possible
        }
        if (search_word(file2, input)){
            return true;       //word found - deleting not possible
        }
        return true;        //word not found - deleting not  possible
    }

    public void find_word_to_delete(String input, File file) throws IOException {

        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);

        String line = breader.readLine();

        if(line != null) {
            do {
                String[] words = splitline(line, " ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(input)) {
                        words[i] = "";
                    }

                }
                line = breader.readLine();
            } while (line != null);
        }
        reader.close();
        breader.close();
    }

    //just a TextAlert
    public void getMessage(String message){
        new AlertDialog.Builder(this).setTitle(message).
                setMessage("").setPositiveButton("OK"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

}