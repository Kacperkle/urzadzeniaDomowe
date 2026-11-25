package com.example.urzadzeniadomowe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumerPrania;
    private Button btnZatwierdz, btnOdkurzacz;
    private TextView tvNumerPrania, tvStanOdkurzacza;
    private boolean czyOdkurzaczWlaczony = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumerPrania = findViewById(R.id.etNumerPrania);
        btnZatwierdz = findViewById(R.id.btnZatwierdz);
        tvNumerPrania = findViewById(R.id.tvNumerPrania);
        btnOdkurzacz = findViewById(R.id.btnOdkurzacz);
        tvStanOdkurzacza = findViewById(R.id.tvStanOdkurzacza);

        btnZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ustawNumerPrania();
            }
        });

        btnOdkurzacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przelaczOdkurzacz();
            }
        });
    }

    private void ustawNumerPrania() {
        String tekst = etNumerPrania.getText().toString().trim();
        if (!tekst.isEmpty()) {
            int numer = Integer.parseInt(tekst);
            if (numer >= 1 && numer <= 12) {
                tvNumerPrania.setText("Numer prania: " + numer);
            }
        }
    }

    private void przelaczOdkurzacz() {
        czyOdkurzaczWlaczony = !czyOdkurzaczWlaczony;
        if (czyOdkurzaczWlaczony) {
            btnOdkurzacz.setText("Wyłącz");
            tvStanOdkurzacza.setText("Odkurzacz włączony");
        } else {
            btnOdkurzacz.setText("Włącz");
            tvStanOdkurzacza.setText("Odkurzacz wyłączony");
        }
    }
}
