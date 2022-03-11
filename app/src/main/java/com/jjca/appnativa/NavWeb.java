package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavWeb extends AppCompatActivity {

    String[] datos = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_web);

        Intent data = this.getIntent();
        Bundle receive = data.getExtras();
        datos = receive.getStringArray("datos");

        WebView pagina;
        pagina = findViewById(R.id.searchweb);

        pagina.clearCache(true);
        pagina.clearHistory();
        pagina.getSettings().setJavaScriptEnabled(true);
        pagina.getSettings().setLoadWithOverviewMode(true);
        pagina.getSettings().setUseWideViewPort(true);
        pagina.setWebChromeClient(new WebChromeClient());
        pagina.setWebViewClient(new WebViewClient());
        pagina.getSettings().setSaveFormData(true);

        if(pagina.canGoBack())
        {
            pagina.goBack();
        }

        if(pagina.canGoForward())
        {
            pagina.goForward();
        }

        String page = "http://" + receive.getString("link");

        try {
            pagina.loadUrl(page);
        }
        catch(Exception e)
        {
            Toast toast = Toast.makeText(this, "URL inválida", Toast.LENGTH_LONG);
            toast.show();
            pagina.loadUrl("about:blank");
        }

        TextView menu;
        menu = findViewById(R.id.menutextView);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavWeb.this, ListMenu.class);
                intent.putExtra("datos", datos);
                startActivity(intent);

            }
        });

        ImageView backarrow;
        backarrow = findViewById(R.id.arrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavWeb.this, Buscador.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("datos", datos);
                startActivity(intent);
            }
        });
    }
}