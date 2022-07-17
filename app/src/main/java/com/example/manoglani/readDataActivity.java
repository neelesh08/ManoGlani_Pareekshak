package com.example.manoglani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.manoglani.databinding.ActivityReadDataActivityBinding;

public class readDataActivity extends AppCompatActivity {
    ActivityReadDataActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityReadDataActivityBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }
}