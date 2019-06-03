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
                AddText();
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
                fixed_text.append(processwords(splitline(line)));

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

    public String [] splitline(String line){

        String[] seperated_words = line.split(" ");
        return seperated_words;

    }

    //Add Text

    public void AddText(){
        //TODO - Add
    }

    //Delet Text

    public void DeleteText(){
        //TODO - Delete
    }

}