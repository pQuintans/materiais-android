package com.example.jankenpo3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogarActivity extends AppCompatActivity {

    RadioButton rbPedra, rbPapel, rbTesoura;
    ImageView ivCampo;
    TextView tvPartidas, tvVitorias, tvEmpates, tvDerrotas;
    RadioGroup rgEscolha;

    int contaPartidas, contaVitorias, contaEmpates, contaDerrotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        rbPedra = findViewById(R.id.rbPedra);
        rbPapel = findViewById(R.id.rbPapel);
        rbTesoura = findViewById(R.id.rbTesoura);
        tvPartidas = findViewById(R.id.tvPartidas);
        tvVitorias = findViewById(R.id.tvVitorias);
        tvEmpates = findViewById(R.id.tvEmpates);
        tvDerrotas = findViewById(R.id.tvDerrotas);
        rgEscolha = findViewById(R.id.rgEscolha);
        ivCampo = findViewById(R.id.ivCampo);

        contaPartidas = 0;
        contaVitorias = 0;
        contaEmpates = 0;
        contaDerrotas = 0;
    }

    public void Escolher(View v) {
        int escolhaCPU, escolhaJogador;
        escolhaCPU = 0;
        escolhaJogador = 0;

        if(rbPedra.isChecked()){
            escolhaJogador = 1;
        } else if(rbPapel.isChecked()){
            escolhaJogador = 2;
        } else if(rbTesoura.isChecked()){
            escolhaJogador = 3;
        } else {
            Toast.makeText(this, "Escolha pedra, papel ou tesoura", Toast.LENGTH_SHORT).show();
            escolhaJogador = 0;
        }

        if(escolhaJogador > 0){
            contaPartidas++;
            Random rand = new Random();
            escolhaCPU = rand.nextInt(3) + 1;

            if(escolhaJogador == 1 && escolhaCPU==1){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.pedra_pedra);
            } else if(escolhaJogador == 1 && escolhaCPU == 2){
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.pedra_papel);
            } else if(escolhaJogador == 1 && escolhaCPU == 3){
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.pedra_tesoura);
            } else if(escolhaJogador == 2 && escolhaCPU== 1){
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.papel_pedra);
            } else if(escolhaJogador == 2 && escolhaCPU== 2){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.papel_papel);
            } else if(escolhaJogador == 2 && escolhaCPU== 3){
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.papel_tesoura);
            } else if(escolhaJogador == 3 && escolhaCPU== 1){
                contaDerrotas++;
                ivCampo.setImageResource(R.drawable.tesoura_pedra);
            } else if(escolhaJogador == 3 && escolhaCPU== 2){
                contaVitorias++;
                ivCampo.setImageResource(R.drawable.tesoura_papel);
            } else if(escolhaJogador == 3 && escolhaCPU== 3){
                contaEmpates++;
                ivCampo.setImageResource(R.drawable.tesoura_tesoura);
            }

            atualizarTextos();
        }
    }

    public void chamaIntrucoes(View v){
        Intent tela = new Intent(this, InstrucoesActivity.class);
        startActivity(tela);
    }

    public void novaPartida(View v) {
        contaPartidas = 0;
        contaEmpates = 0;
        contaDerrotas = 0;
        contaVitorias = 0;
        ivCampo.setImageResource(R.drawable.campo_batalha);

        atualizarTextos();
    }

    private void atualizarTextos() {
        tvPartidas.setText("Total Jogadas: " + contaPartidas);
        tvVitorias.setText("Total Derrotas: " + contaVitorias);
        tvEmpates.setText("Total Empates: " + contaEmpates);
        tvDerrotas.setText("Total Derrotas: " + contaDerrotas);
    }
}