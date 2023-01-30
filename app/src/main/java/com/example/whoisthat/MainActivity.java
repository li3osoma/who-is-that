package com.example.whoisthat;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.whoisthat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String number="24";

    ActivityMainBinding binding;

    ActivityResultLauncher<Intent> startForResult=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result!=null && result.getResultCode()==RESULT_OK){
                        if(result.getData()!=null && result.getData().getStringExtra("NUMBER")!=null){
                            number=result.getData().getStringExtra("NUMBER");
                        }
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener aboutPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), AboutActivity.class);
                startActivity(intent);
            }
        };

        binding.aboutButton.setOnClickListener(aboutPressed);

        View.OnClickListener exitPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        binding.exitBottom.setOnClickListener(exitPressed);

        View.OnClickListener optionsPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), OptionsActivity.class);
                intent.putExtra("NUMBER",number);
                startForResult.launch(intent);
            }
        };
        binding.optionsButton.setOnClickListener(optionsPressed);

        View.OnClickListener playPressed=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Player1Activity.class);
                intent.putExtra("NUMBER",number);
                startActivity(intent);
            }
        };
        binding.playButton.setOnClickListener(playPressed);

    }
}