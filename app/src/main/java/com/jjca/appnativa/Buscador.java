package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buscador extends AppCompatActivity {

    String[] datos = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        Intent data = this.getIntent();
        Bundle receive = data.getExtras();
        datos = receive.getStringArray("datos");

        TextView menu;
        menu = findViewById(R.id.menutextView);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buscador.this, ListMenu.class);
                intent.putExtra("datos", datos);
                startActivity(intent);

            }
        });

        EditText link;
        link = findViewById(R.id.search);

        Button searchbtn;
        searchbtn = findViewById(R.id.searchbtn);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String page = link.getText().toString();
                Intent web = new Intent(Buscador.this, NavWeb.class);
                web.putExtra("link", page);
                web.putExtra("datos", datos);
                startActivity(web);
            }
        });
    }
}