package com.example.manoglani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.manoglani.databinding.ActivityWebViewerBinding;

public class webViewerActivity extends AppCompatActivity {
    ActivityWebViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
                WebSettings webSettings = binding.webView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                 binding.webView.setWebViewClient(new WebViewClient());
                binding.webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSc3ol-H--KmhA17zQd5aNccH0vo9lo80L0U2suo1K6GzD2M3w/viewform");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(webViewerActivity.this,MainActivity.class);
        startActivity(intent);

    }
}