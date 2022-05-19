package com.example.parouimpar3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleOpenPlayScreen(View v) {
        Intent playScreen = new Intent(this, PlayActivity.class);
        startActivity(playScreen);
    }
}