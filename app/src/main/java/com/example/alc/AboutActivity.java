package com.example.alc;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar mTopToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        webView = (WebView) findViewById(R.id.webview);
        mTopToolbar = (Toolbar) findViewById(R.id.tbar);

        final ProgressBar pbar = (ProgressBar) findViewById(R.id.pB1);


        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle("About ALC");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://andela.com/alc/");
        webView.clearView();
        webView.measure(100, 100);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setAppCacheEnabled(true);
//
//        webView.loadUrl("https://andela.com/alc/");

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {


            public void onProgressChanged(WebView view, int progress) {
                if(progress < 100 && pbar.getVisibility() == ProgressBar.GONE){
                    pbar.setVisibility(ProgressBar.VISIBLE);
                }

                pbar.setProgress(progress);
                if(progress == 100) {
                    pbar.setVisibility(ProgressBar.GONE);
                }
            }
        });

        mTopToolbar.setNavigationOnClickListener(view -> onBackPressed());

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
//        startActivity(new Intent(this, MainActivity.class));
    }
}
