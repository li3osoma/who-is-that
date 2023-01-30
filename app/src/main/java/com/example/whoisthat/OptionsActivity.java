package com.example.whoisthat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.whoisthat.databinding.ActivityOptionsBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptionsActivity extends AppCompatActivity {

    ActivityOptionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOptionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener cancelPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        binding.cancelButton.setOnClickListener(cancelPressed);

        View.OnClickListener confirmPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                intent1.putExtra("NUMBER",binding.spinner.getSelectedItem().toString());
                setResult(RESULT_OK,intent1);
                binding.spinner.setSelection(binding.spinner.getSelectedItemPosition());
                finish();
            }
        };
        binding.confirmButton.setOnClickListener(confirmPressed);

    }
}