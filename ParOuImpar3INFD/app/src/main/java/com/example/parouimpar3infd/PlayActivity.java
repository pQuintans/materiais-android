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
    ImageView ivPlayersMove, ivIAMove;
    TextView txtResult;
    EditText txtPlayersNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rgOptions = findViewById(R.id.rgOptions);
        rdbPar = findViewById(R.id.rdbPar);
        rdbImpar = findViewById(R.id.rdbImpar);
        ivPlayersMove = findViewById(R.id.ivPlayersMove);
        ivIAMove = findViewById(R.id.ivIAMove);
        txtResult = findViewById(R.id.lblResult);
        txtPlayersNumber = findViewById(R.id.txtPlayersNumber);
    }

    public void play(View v) {
        int iaMove = 0, playersMove = 0;
        Boolean didPlayerWin;

        if (rdbImpar.isChecked()){
            playersMove = 1;
            ivPlayersMove.setImageResource(R.drawable.impar);
        } else if (rdbPar.isChecked()) {
            playersMove = 2;
            ivPlayersMove.setImageResource(R.drawable.par);
        } else {
            Toast.makeText(this, "Você deve selecionar uma opção antes de jogar", Toast.LENGTH_SHORT);
            return;
        }

        int playersNumber = Integer.parseInt(txtPlayersNumber.getText().toString());

        if(playersNumber >= 0){
            Random randomizer = new  Random();
            iaMove = randomizer.nextInt(5) + 1;

            if (iaMove % 2 == 0){
                ivIAMove.setImageResource(R.drawable.par);
            } else {
                ivIAMove.setImageResource(R.drawable.impar);
            }

            if((playersNumber + iaMove) % 2 == 0){
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

            txtResult.setText("Você");
        } else {
            Toast.makeText(this, "Você deve digitar uma opção antes de jogar", Toast.LENGTH_SHORT);
        }
    }
}