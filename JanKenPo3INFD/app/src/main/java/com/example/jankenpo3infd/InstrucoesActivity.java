package com.example.jankenpo3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InstrucoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);
    }

    public void chamaJogo(View v) {
        Intent tela = new Intent(this, JogarActivity.class);
        startActivity(tela);
    }
}