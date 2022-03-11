package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMenu extends AppCompatActivity {

    String[] datostrans = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        Intent data = this.getIntent();
        Bundle receive = data.getExtras();
        datostrans = receive.getStringArray("datos");

        ListView lista;
        lista = findViewById(R.id.list);

        ArrayList<String> items = new ArrayList<String>();

        items.add("Página Institucional");
        items.add("Buscador");
        items.add("Datos registrados");
        items.add("Formulario");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                {
                    Intent intent = new Intent(ListMenu.this, InsPage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("datos", datostrans);
                    startActivity(intent);
                }
                else if (position == 1)
                {
                    Intent intent = new Intent(ListMenu.this, Buscador.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("datos", datostrans);
                    startActivity(intent);
                }
                else if (position == 2)
                {
                    Intent intent = new Intent(ListMenu.this, Datos.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("datos", datostrans);
                    startActivity(intent);
                }
                else if (position == 3)
                {
                    Intent intent = new Intent(ListMenu.this, Formulario.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("datos", datostrans);
                    startActivity(intent);
                }
            }
        });


    }


}