package com.example.whoisthat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.whoisthat.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    ActivityAboutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener toMainMenuPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        binding.toMainMenuButton.setOnClickListener(toMainMenuPressed);
    }
}