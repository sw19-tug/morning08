package com.example.touchtheblock;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.R;

public class TouchTheBlockChooseColor extends AppCompatActivity implements View.OnClickListener {


    Button btn00, btn01, btn02, btn03,
            btn10, btn11, btn12, btn13,
            btn20, btn21, btn22, btn23,
            btn30, btn31, btn32, btn33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color_touchtheblock);

        btn00 = findViewById(R.id.button00);
        btn01 = findViewById(R.id.button01);
        btn02 = findViewById(R.id.button02);
        btn03 = findViewById(R.id.button03);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13 = findViewById(R.id.button13);
        btn20 = findViewById(R.id.button20);
        btn21 = findViewById(R.id.button21);
        btn22 = findViewById(R.id.button22);
        btn23 = findViewById(R.id.button23);
        btn30 = findViewById(R.id.button30);
        btn31 = findViewById(R.id.button31);
        btn32 = findViewById(R.id.button32);
        btn33 = findViewById(R.id.button33);

        btn00.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.button00:
                intent.putExtra("color", "#00FFFF");
                break;

            case R.id.button01:
                intent.putExtra("color", "#000000");
                break;

            case R.id.button02:
                intent.putExtra("color", "#0000FF");
                break;

            case R.id.button03:
                intent.putExtra("color","#FF00FF");
                break;


            case R.id.button10:
                intent.putExtra("color","#808080");
                break;

            case R.id.button11:
                intent.putExtra("color","#008000");
                break;

            case R.id.button12:
                intent.putExtra("color","#00FF00");
                break;

            case R.id.button13:
                intent.putExtra("color","#800000");
                break;


            case R.id.button20:
                intent.putExtra("color","#000080");
                break;

            case R.id.button21:
                intent.putExtra("color","#808000");
                break;

            case R.id.button22:
                intent.putExtra("color","#800080");
                break;

            case R.id.button23:
                intent.putExtra("color","#FF0000");
                break;


            case R.id.button30:
                intent.putExtra("color","#C0C0C0");
                break;

            case R.id.button31:
                intent.putExtra("color","#008080");
                break;

            case R.id.button32:
                intent.putExtra("color","#FFFFFF");
                break;

            case R.id.button33:
                intent.putExtra("color","#FFFF00");
                break;




        }

        setResult(RESULT_OK, intent);
        TouchTheBlockChooseColor.this.finish();
    }


}
