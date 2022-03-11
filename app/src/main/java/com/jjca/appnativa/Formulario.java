package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    String[] datos = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        TextView menu;
        menu = findViewById(R.id.menutextView);

        Intent aux = this.getIntent();
        Bundle receive = aux.getExtras();
        datos = receive.getStringArray("datos");

        receiveData();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fillData();

                Intent data = new Intent(Formulario.this, ListMenu.class);
                data.putExtra("datos", datos);
                startActivity(data);

            }
        });

        Button btn;
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fillData();

                if(datos[0].equals("") || datos[1].equals("") || datos[2].equals("") ||
                        datos[3].equals("") || datos[4].equals("") || datos[5].equals(""))
                {
                    String mensaje = "Se han encontrado valores vacíos o no válidos";
                    Toast toast = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                else
                    {
                        String mensaje = "Se han registrado las datos";
                        Toast toast = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
                        toast.show();

                        Thread t = new Thread(){
                            public void run(){
                                try {
                                    sleep(2000);
                                    finish();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        t.start();
                    }

                Intent data = new Intent(Formulario.this, Datos.class);
                data.putExtra("datos", datos);
                startActivity(data);

            }
        });
    }

    public void fillData()
        {
            EditText dato1, dato2, dato3, dato4, dato5, dato6;
            dato1 = findViewById(R.id.EditText1);
            dato2 = findViewById(R.id.EditText2);
            dato3 = findViewById(R.id.EditText3);
            dato4 = findViewById(R.id.EditText4);
            dato5 = findViewById(R.id.EditText5);
            dato6 = findViewById(R.id.EditText6);

            datos[0]=dato1.getText().toString();
            datos[1]=dato2.getText().toString();
            datos[2]=dato3.getText().toString();
            datos[3]=dato4.getText().toString();
            datos[4]=dato5.getText().toString();
            datos[5]=dato6.getText().toString();

        }

        public void receiveData()
        {
            EditText dato1, dato2, dato3, dato4, dato5, dato6;
            dato1 = findViewById(R.id.EditText1);
            dato2 = findViewById(R.id.EditText2);
            dato3 = findViewById(R.id.EditText3);
            dato4 = findViewById(R.id.EditText4);
            dato5 = findViewById(R.id.EditText5);
            dato6 = findViewById(R.id.EditText6);

            dato1.setText(datos[0]);
            dato2.setText(datos[1]);
            dato3.setText(datos[2]);
            dato4.setText(datos[3]);
            dato5.setText(datos[4]);
            dato6.setText(datos[5]);
        }

}