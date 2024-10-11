package com.neyamul.newsall;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DW extends AppCompatActivity {

    private WebView dw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dw);

        dw=findViewById(R.id.dw);

        WebSettings webSettings=dw.getSettings();
        webSettings.setJavaScriptEnabled(true);
        dw.loadUrl("https://www.dw.com/");
        dw.setWebViewClient(new sameView());

    }

    public class sameView extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}