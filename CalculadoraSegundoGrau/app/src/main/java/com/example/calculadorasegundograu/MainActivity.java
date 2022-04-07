//Fabio Henrique
//Pedro Losso Quintans - 200146

package com.example.calculadorasegundograu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c;
    TextView delta, x1, x2, equacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.editTextNumber);
        b = findViewById(R.id.editTextNumber2);
        c = findViewById(R.id.editTextNumber3);
        delta = findViewById(R.id.textView8);;
        x1 = findViewById(R.id.textView9);;
        x2 = findViewById(R.id.textView10);
        equacao = findViewById(R.id.textView4);
    }

    public void Calcular(View v) {
        if(a.getText().toString().matches("") || b.getText().toString().matches("") || c.getText().toString().matches("")) {
            Toast.makeText(this, "Insira um nuúero em todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double aValue = Double.parseDouble(a.getText().toString());
        double bValue = Double.parseDouble(b.getText().toString());
        double cValue = Double.parseDouble(c.getText().toString());


        equacao.setText(aValue + (bValue > 0 ? "x²+" : "x²") + bValue + (cValue > 0 ? "x+" : "x") + cValue + " = 0");

        double deltaValue = Math.pow(bValue, 2) - (4 * aValue * cValue);

        delta.setText(Double.toString(arredondar(deltaValue)));

        if (deltaValue < 0) {
            x1.setText("Sem solução");
            x2.setText("Sem solução");
            return;
        }

        double x1Value = (-bValue + Math.sqrt(deltaValue)) / (2 * aValue);
        double x2Value = (-bValue - Math.sqrt(deltaValue)) / (2 * aValue);

        x1.setText(Double.toString(arredondar(x1Value)));
        x2.setText(Double.toString(arredondar(x2Value)));


    }

    public double arredondar(Double value) {
        return Math.round(value*100) / 100.0;
    }
}