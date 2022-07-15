package com.example.manoglani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.manoglani.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.button.setVisibility(View.INVISIBLE);
                WebSettings webSettings = binding.webView.getSettings();
                webSettings.setJavaScriptEnabled(true);

//                binding.webView.setWebViewClient(new Callback());
                binding.webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSc3ol-H--KmhA17zQd5aNccH0vo9lo80L0U2suo1K6GzD2M3w/viewform");
            }


        });


    }



}