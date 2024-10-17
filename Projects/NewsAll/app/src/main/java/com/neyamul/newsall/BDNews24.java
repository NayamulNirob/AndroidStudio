package com.neyamul.newsall;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BDNews24 extends AppCompatActivity {

    private WebView bdnews24;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bdnews24);

        bdnews24=findViewById(R.id.bdnews24);

        WebSettings webSettings=bdnews24.getSettings();
        webSettings.setJavaScriptEnabled(true);
        bdnews24.setWebViewClient(new sameView());
        bdnews24.loadUrl("https://www.bdnews24.com/");

    }

    public class sameView extends WebViewClient{
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}