package com.example.jogovelha3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnReset;
    String jogador;
    int[] jogadas = {-1, -2, -3, -4, -5, -6, -7, -8, -9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnReset = findViewById(R.id.btnReset);

        jogador = "x";
    }

    public void play(View v){
        Button clickedButton = findViewById(v.getId());

        clickedButton.setText(jogador);
        clickedButton.setEnabled(false);
        clickedButton.setTextSize(50);

        int  numeroJogador = (jogador == "x" ? 1 : 0);

        if(v.getId() == R.id.btn0) jogadas[0] = numeroJogador;
        if(v.getId() == R.id.btn1) jogadas[1] = numeroJogador;
        if(v.getId() == R.id.btn2) jogadas[2] = numeroJogador;
        if(v.getId() == R.id.btn3) jogadas[3] = numeroJogador;
        if(v.getId() == R.id.btn4) jogadas[4] = numeroJogador;
        if(v.getId() == R.id.btn5) jogadas[5] = numeroJogador;
        if(v.getId() == R.id.btn6) jogadas[6] = numeroJogador;
        if(v.getId() == R.id.btn7) jogadas[7] = numeroJogador;
        if(v.getId() == R.id.btn8) jogadas[8] = numeroJogador;


        //verificar vencedor
        if((jogadas[0] == jogadas[1]) && (jogadas[1] == jogadas[2])){
            //012
            ganhou();
        } else if ((jogadas[3] == jogadas[4]) && (jogadas[4] == jogadas[8])) {
            //345
            ganhou();
        } else if ((jogadas[6] == jogadas[7]) && (jogadas[7] == jogadas[8])){
            //678
            ganhou();
        } else if ((jogadas[0] == jogadas[3]) && (jogadas[3] == jogadas[6])){
            //036
            ganhou();
        } else if ((jogadas[1] == jogadas[4]) && (jogadas[4] == jogadas[7])){
            //147
            ganhou();
        } else if ((jogadas[2] == jogadas[5]) && (jogadas[5] == jogadas[8])){
            //258
            ganhou();
        } else if ((jogadas[0] == jogadas[4]) && (jogadas[4] == jogadas[8])){
            //048
            ganhou();
        } else if ((jogadas[2] == jogadas[4]) && (jogadas[4] == jogadas[6])){
            //246
            ganhou();
        } else if(velha()){
            Toast.makeText(this, "Deu velha", Toast.LENGTH_SHORT).show();
        }

        // troca o jogador
        if(jogador.equals("x")){
            jogador = "o";
        } else {
            jogador = "x";
        }
    }

    public void ganhou() {
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);

        // LENGTH_SHORT = dura 3 seg;
        // LENGTH_LONG = dura 10 seg;

        Toast.makeText(this, "O jogador " + jogador + " ganhou!", Toast.LENGTH_SHORT).show();
    }

    public void reset(View v){
        btn0.setTextSize(14);
        btn1.setTextSize(14);
        btn2.setTextSize(14);
        btn3.setTextSize(14);
        btn4.setTextSize(14);
        btn5.setTextSize(14);
        btn6.setTextSize(14);
        btn7.setTextSize(14);
        btn8.setTextSize(14);

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);

        btn0.setText("JOGAR!");
        btn1.setText("JOGAR!");
        btn2.setText("JOGAR!");
        btn3.setText("JOGAR!");
        btn4.setText("JOGAR!");
        btn5.setText("JOGAR!");
        btn6.setText("JOGAR!");
        btn7.setText("JOGAR!");
        btn8.setText("JOGAR!");

        jogadas = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9};

        jogador = "x";
    }

    public boolean velha(){
        for(int i = 0; i < jogadas.length; i++) {
            if(jogadas[i] < 0) return (false);
        }
        return true;
    }
}