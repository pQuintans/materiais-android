package com.example.parouimpar3infd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    RadioGroup rgOptions;
    RadioButton rdbPar, rdbImpar;
    TextView txtResult, txtBattlefield, lblPartidasResultado, lblVitoriasResultado, lblDerrotasResultado;
    EditText txtPlayersNumber;

    int partidasResultado = 0;
    int derrotasResultado = 0;
    int vitoriasResultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rgOptions = findViewById(R.id.rgOptions);
        rdbPar = findViewById(R.id.rdbPar);
        rdbImpar = findViewById(R.id.rdbImpar);
        txtBattlefield = findViewById(R.id.txtBattlefield);
        txtResult = findViewById(R.id.lblResult);
        txtPlayersNumber = findViewById(R.id.txtPlayersNumber);
        lblPartidasResultado = findViewById(R.id.lblPartidasResultado);
        lblVitoriasResultado = findViewById(R.id.lblVitoriasResultado);
        lblDerrotasResultado = findViewById(R.id.lblDerrotasResultado);
    }

    public void play(View v) {
        int iaNumber, playersMove = 0;
        Boolean didPlayerWin, shouldPlay = true;


        if (rdbImpar.isChecked()){
            playersMove = 1;
        } else if (rdbPar.isChecked()) {
            playersMove = 2;
        } else {
            Toast.makeText(this, "Você deve selecionar uma opção antes de jogar", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtPlayersNumber.getText().toString().matches("")) {
            Toast.makeText(this, "Você deve digitar um número antes de jogar", Toast.LENGTH_SHORT).show();
            return;
        }

        int playersNumber = Integer.parseInt(txtPlayersNumber.getText().toString());

        if(playersNumber > 5 || playersNumber < 0) {
            Toast.makeText(this, "Você deve digitar um número entre 0 e 5", Toast.LENGTH_SHORT).show();
            shouldPlay = false;
        }

        if(shouldPlay){
            partidasResultado++;
            lblPartidasResultado.setText(Integer.toString(partidasResultado));

            Random randomizer = new  Random();
            iaNumber = randomizer.nextInt(5) + 1;

            txtBattlefield.setText(playersNumber + " x " + iaNumber);

            if((playersNumber + iaNumber) % 2 == 0){
                if(playersMove == 1) {
                    didPlayerWin = false;
                } else {
                    didPlayerWin = true;
                }
            } else {
                if(playersMove == 1) {
                    didPlayerWin = true;
                } else {
                    didPlayerWin = false;
                }
            }

            if (didPlayerWin == true){
                txtResult.setText("Você ganhou!! (" + playersNumber + "+" + iaNumber + "=" + (playersNumber+iaNumber) +")");
                vitoriasResultado++;
                lblVitoriasResultado.setText(Integer.toString(vitoriasResultado));
            }
            else {
                txtResult.setText("Você perdeu (" + playersNumber + "+" + iaNumber + "=" + (playersNumber+iaNumber) +")");
                derrotasResultado++;
                lblDerrotasResultado.setText(Integer.toString(derrotasResultado));
            }
        } else {
            Toast.makeText(this, "Você deve digitar uma opção antes de jogar", Toast.LENGTH_SHORT);
        }
    }
}