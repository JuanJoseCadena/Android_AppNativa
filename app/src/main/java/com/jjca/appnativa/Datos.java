package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Datos extends AppCompatActivity {

    String[] datosrec = new String[6];
    TextView dato1, dato2, dato3, dato4, dato5, dato6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        recieveData();

        TextView menu;
        menu = findViewById(R.id.menutextView);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Datos.this, ListMenu.class);
                intent.putExtra("datos", datosrec);
                startActivity(intent);

            }
        });
    }

    public void recieveData()
    {
        dato1 = findViewById(R.id.resulttextView1);
        dato2 = findViewById(R.id.resulttextView2);
        dato3 = findViewById(R.id.resulttextView3);
        dato4 = findViewById(R.id.resulttextView4);
        dato5 = findViewById(R.id.resulttextView5);
        dato6 = findViewById(R.id.resulttextView6);

        Intent data = this.getIntent();
        Bundle receive = data.getExtras();
        datosrec = receive.getStringArray("datos");

        dato1.setText(datosrec[0]);
        dato2.setText(datosrec[1]);
        dato3.setText(datosrec[2]);
        dato4.setText(datosrec[3]);
        dato5.setText(datosrec[4]);
        dato6.setText(datosrec[5]);

    }
}