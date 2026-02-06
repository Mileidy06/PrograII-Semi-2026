package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    RadioButton opt;
    RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(v -> calcular());
    }

    private void calcular() {
        tempVal = findViewById(R.id.txtNum1);
        Double num1 = Double.parseDouble(tempVal.getText().toString());

        tempVal = findViewById(R.id.txtNum2);
        Double num2 = Double.parseDouble(tempVal.getText().toString());
        double respuesta = 0;
        RadioGroup = findViewById(R.id.optOpciones)
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.optSuma:
                respuesta = num1 + num2;
                break;
            case R.id.optResta:
                respuesta = num1 - num2;
                break;
            case R.id.optMultiplicar:
                respuesta = num1 * num2;
                break;
            case R.id.optDividir:
                respuesta = num1 / num2;
                break;
        }
        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);


    }

}


