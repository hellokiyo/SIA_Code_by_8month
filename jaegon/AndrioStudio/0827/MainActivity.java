package com.lx.webview;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹 뷰 찾아서 설정하기
        WebView webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);


        // 페이지 띄우기
        webview.loadUrl("http://172.168.10.15:5173/");
        //webview.loadUrl("http://m.naver.com");
    }
}