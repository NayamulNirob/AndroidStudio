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

public class DhakaTribune extends AppCompatActivity {

    private WebView dhakatribune;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_tribune);

        dhakatribune=findViewById(R.id.dhakatribune);

        WebSettings webSettings=dhakatribune.getSettings();
        webSettings.setJavaScriptEnabled(true);
        dhakatribune.setWebViewClient(new sameView());
        dhakatribune.loadUrl("https://www.dhakatribune.com/");

    }

    public class sameView extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
