package com.example.whoisthat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.whoisthat.databinding.ActivityPlayer1Binding;

public class Player1Activity extends AppCompatActivity {

    ActivityPlayer1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayer1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String number=intent.getStringExtra("NUMBER");
        binding.player1Text.setText(number);
    }
}