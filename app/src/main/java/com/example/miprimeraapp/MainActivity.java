package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempVal = findViewById(R.id.textNum1);
                double num1 = Double.parseDouble(tempVal.getText().toString());

                tempVal = findViewById(R.id.textNum2);
                double num2 = Double.parseDouble(tempVal.getText().toString());

                double respuesta = num1 + num2;
                respuesta = 0;

                opt = findViewById(R.id.optSuma);
                if (opt.isChecked()) {
                    respuesta = num1 + num2;
                }
                opt = findViewById(R.id.optResta);
                if (opt.isChecked()) {
                    respuesta = num1 - num2;
                }
                opt = findViewById(R.id.optMultiplicar);
                if (opt.isChecked()) {
                    respuesta = num1 * num2;
                }
                opt = findViewById(R.id.optDividir);
                if (opt.isChecked()) {
                    respuesta = num1 / num2;
                }
                tempVal = findViewById(R.id.lblRespuesta);
                tempVal.setText("Respuesta: " + respuesta);
            }
        });
    ;}
}
