package com.jjca.appnativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class InsPage extends AppCompatActivity {

    String[] datos = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_page);

        Intent data = this.getIntent();
        Bundle receive = data.getExtras();
        datos = receive.getStringArray("datos");

        WebView pagina;
        pagina = findViewById(R.id.insweb);

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

        pagina.loadUrl("https://umb.edu.co");

        TextView menu;
        menu = findViewById(R.id.menutextView);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsPage.this, ListMenu.class);
                intent.putExtra("datos", datos);
                startActivity(intent);

            }
        });
    }
}