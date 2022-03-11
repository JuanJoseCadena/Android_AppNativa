package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    int time = 3000;
    String[] aux = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar load;
        load = findViewById(R.id.load);

        load.getIndeterminateDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);

        for(int i=0;i<6;i++)
        {
            aux[i]="";
        }

        Thread t = new Thread(){
            public void run(){
                try {
                    sleep(time);
                    Intent intent = new Intent(MainActivity.this, Formulario.class);
                    intent.putExtra("datos", aux);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();

    }
}