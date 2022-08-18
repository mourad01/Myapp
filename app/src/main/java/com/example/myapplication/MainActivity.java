package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        mywebView = (WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://2lk7o7nptasa5bzrvpparw.on.drv.tw/www.my-gaming-website-master.blog/");
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}