package com.example.miprimeraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    TextView tempVal;
    Spinner spn;
    Button btn;
    TextView txtCantidad, lblRespuesta;
    Spinner spnDe, spnA;
    Button btnConvertir;


    Double valores[][] = {

            // MONEDAS (base dólar)
            {1.0, 0.85, 7.67, 26.42, 36.80, 495.77},
            {1.0, 10.7639, 1.4311, 1.19599, 0.00159033, 0.0001431, 1e-4}
    };

    // LONGITUD (base metro)
    {
        1.0, 0.001, 100.0, 39.3701, 3.28084, 1.1963, 1.09361
    },
    String[][] etiquetas = {
            {"Metro Cuadrado", "Pie Cuadrado", "Vara Cuadrada", "Yarda Cuadrada", "Tarea", "Manzana", "Hectárea"}
    };

    // VOLUMEN (base litro)
    {
        1.0, 1000.0, 0.264172, 0.0353147, 0.001
    }

    ;

    // MASA (base kilogramo)
    {
        1.0, 1000.0, 2.20462, 35.274, 0.00100000108
    },
};
    EditText etMetros;
    Button btnCalcular;
    TextView tvResultadoAgua;

    // ALMACENAMIENTO (base byte)
    {1.0, 0.001, 1e-6, 1e-9, 1e-12},
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TIEMPO (base MINUTO)
        {60.0, 1.0, 0.01666668, 0.000694445, 9.9206428571e-5, 1.9026e-6},
        configurarTabs();
        configurarAgua();
        configurarConversor();
    }

    // TRANSFERENCIA DE DATOS (base bps)
    {1.0, 0.001, 1e-6, 1e-9}
};

String[][] etiquetas = {
private void configurarTabs() {

    // MONEDAS
    {"Dolar", "Euro", "Quetzal", "Lempira", "Cordoba", "Colon CR"},
    TabHost tabHost = findViewById(android.R.id.tabhost);
    tabHost.setup();

    // LONGITUD
    {"Metro", "Kilometro", "Centimetro", "Pulgada", "Pie", "Vara", "Yarda"},
    TabHost.TabSpec spec;

    // VOLUMEN
    {"Litro", "Mililitro", "Galon", "Pie cubico", "Metro cubico"},
    spec = tabHost.newTabSpec("Tab1");
    spec.setContent(R.id.agua);
    spec.setIndicator("AGUA");
    tabHost.addTab(spec);

    // MASA
    {"Kilogramo", "Gramo", "Libra", "Onza", "Tonelada"},
    spec = tabHost.newTabSpec("Tab2");
    spec.setContent(R.id.AREA);
    spec.setIndicator("CONVERSOR");
    tabHost.addTab(spec);
}

// ALMACENAMIENTO
            {"Byte", "Kilobyte", "Megabyte", "Gigabyte", "Terabyte"},
private void configurarAgua() {

    // TIEMPO
    {"Segundo", "Minuto", "Hora", "Dia", "Semana", "Año"},
    etMetros = findViewById(R.id.etMetros);
    btnCalcular = findViewById(R.id.btnCalcular);
    tvResultadoAgua = findViewById(R.id.tvResultado);

    // TRANSFERENCIA DE DATOS
    {"Bits por segundo", "Kilobits por segundo", "Megabits por segundo", "Gigabits por segundo"}
};
        btnCalcular.setOnClickListener(v -> {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    String texto = etMetros.getText().toString();

    if (texto.isEmpty()) {
        Toast.makeText(this, "Ingresa los metros consumidos", Toast.LENGTH_SHORT).show();
        return;
    }

    btn = findViewById(R.id.btnConvertir);
    btn.setOnClickListener(v -> convertir());
    double metros;

    cambiarEtiqueta(0);
    try {
        metros = Double.parseDouble(texto);
    } catch (Exception e) {
        Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        return;
    }

    double total;

    spn = findViewById(R.id.spnTipo);
    spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            cambiarEtiqueta(i);
            if (metros <= 18) {
                total = 6.0;
            } else if (metros <= 28) {
                total = 6 + ((metros - 18) * 0.45);
            } else {
                double tramo1 = 10 * 0.45;
                double tramo2 = (metros - 28) * 0.65;
                total = 6 + tramo1 + tramo2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
            tvResultadoAgua.setText("RESULTADO: $" + String.format("%.2f", total));
            Toast.makeText(this, "Cálculo realizado", Toast.LENGTH_SHORT).show();
        });
    }

    private void cambiarEtiqueta(int posicion) {
        ArrayAdapter<String> aaEtiquetas = new ArrayAdapter<>(
        private void configurarConversor() {

            btnConvertir = findViewById(R.id.btnConvertir);
            spnDe = findViewById(R.id.spnDe);
            spnA = findViewById(R.id.spnA);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_item,
                    etiquetas[posicion]
                    etiquetas[0]
            );
            aaEtiquetas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spn = findViewById(R.id.spnDe);
            spn.setAdapter(aaEtiquetas);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spn = findViewById(R.id.spnA);
            spn.setAdapter(aaEtiquetas);
            spnDe.setAdapter(adapter);
            spnA.setAdapter(adapter);

            btnConvertir.setOnClickListener(v -> convertir());
        }

        private void convertir() {

            tempVal = findViewById(R.id.txtCantidad);
            String texto = tempVal.getText().toString();
            txtCantidad = findViewById(R.id.etArea);
            String texto = txtCantidad.getText().toString();

            // VALIDACIÓN
            if (texto.isEmpty()) {
                Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            double cantidad;

            try {
                cantidad = Double.parseDouble(texto);
            } catch (Exception e) {
                Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            spn = findViewById(R.id.spnTipo);
            int tipo = spn.getSelectedItemPosition();

            spn = findViewById(R.id.spnDe);
            int de = spn.getSelectedItemPosition();

            spn = findViewById(R.id.spnA);
            int a = spn.getSelectedItemPosition();
            int de = spnDe.getSelectedItemPosition();
            int a = spnA.getSelectedItemPosition();

            if (valores[tipo][de] == 0) {
                Toast.makeText(this, "Error en unidades", Toast.LENGTH_SHORT).show();
                return;
            }
            double respuesta = conversor(de, a, cantidad);

            double respuesta = conversor(tipo, de, a, cantidad);

            tempVal = findViewById(R.id.lblRespuesta);
            tempVal.setText("Respuesta: " + respuesta);
            lblRespuesta = findViewById(R.id.tvResultadoArea);
            lblRespuesta.setText("RESULTADO: " + respuesta);

            Toast.makeText(this, "Conversión realizada", Toast.LENGTH_SHORT).show();
        }

        private double conversor(int tipo, int de, int a, double cantidad) {
            return valores[tipo][a] / valores[tipo][de] * cantidad;
            private double conversor(int de, int a, double cantidad) {

                return valores[0][a] / valores[0][de] * cantidad;
            }
        }
    }
};