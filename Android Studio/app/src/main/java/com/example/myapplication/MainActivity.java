package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Wire up button to do stuff
        // ..get the button
        Button btn = (Button) findViewById(R.id.bt_tictac);
        // ..set what happens when the user clicks.

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.i("MyApp","This is magic log messeage");
            }
        });
    }


}
