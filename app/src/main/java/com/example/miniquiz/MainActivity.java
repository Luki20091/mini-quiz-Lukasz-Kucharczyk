package com.example.miniquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // UI Elements
    private TextView tekstTytul;
    private Button przyciskStart;
    private LinearLayout kontenerQuizu;
    private TextView tekstPytania;
    private Button przyciskOdpA;
    private Button przyciskOdpB;
    private Button przyciskOdpC;
    private TextView tekstWynik;
    private Button przyciskReset;

    private List<Pytanie> bazaPytan;
    private List<Pytanie> wylosowanePytania;
    private int aktualnyIndeksPytania = 0;
    private int liczbaPunktow = 0;
    private final int LICZBA_PYTAN_W_RUNDZIE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicjalizujWidoki();
        przygotujBazePytan();
        ustawStanPoczatkowy();

        przyciskStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rozpocznijQuiz();
            }
        });

        View.OnClickListener sluchaczOdpowiedzi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button kliknietyPrzycisk = (Button) v;
                sprawdzOdpowiedz(kliknietyPrzycisk.getText().toString());
            }
        };

        przyciskOdpA.setOnClickListener(sluchaczOdpowiedzi);
        przyciskOdpB.setOnClickListener(sluchaczOdpowiedzi);
        przyciskOdpC.setOnClickListener(sluchaczOdpowiedzi);

        przyciskReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ustawStanPoczatkowy();
            }
        });
    }

    private void inicjalizujWidoki() {
        tekstTytul = findViewById(R.id.tekstTytul);
        przyciskStart = findViewById(R.id.przyciskStart);
        kontenerQuizu = findViewById(R.id.kontenerQuizu);
        tekstPytania = findViewById(R.id.tekstPytania);
        przyciskOdpA = findViewById(R.id.przyciskOdpA);
        przyciskOdpB = findViewById(R.id.przyciskOdpB);
        przyciskOdpC = findViewById(R.id.przyciskOdpC);
        tekstWynik = findViewById(R.id.tekstWynik);
        przyciskReset = findViewById(R.id.przyciskReset);
    }

    private void przygotujBazePytan() {
        bazaPytan = new ArrayList<>();
        bazaPytan.add(new Pytanie("Stolica Włoch to:", "Rzym", "Paryż", "Madryt", "Rzym"));
        bazaPytan.add(new Pytanie("2 + 2 * 2 to:", "8", "6", "4", "6"));
        bazaPytan.add(new Pytanie("Największy ocean to:", "Atlantycki", "Indyjski", "Spokojny", "Spokojny"));
        bazaPytan.add(new Pytanie("Symbol chemiczny wody to:", "H2O", "O2", "CO2", "H2O"));
        bazaPytan.add(new Pytanie("Stolica Polski to:", "Kraków", "Warszawa", "Gdańsk", "Warszawa"));
        bazaPytan.add(new Pytanie("Ile dni ma rok przestępny?", "365", "366", "364", "366"));
        bazaPytan.add(new Pytanie("Kolor trawy to zazwyczaj:", "Czerwony", "Niebieski", "Zielony", "Zielony"));
    }

    private void ustawStanPoczatkowy() {
        liczbaPunktow = 0;
        aktualnyIndeksPytania = 0;
        tekstWynik.setText("Wynik: 0");

        przyciskStart.setVisibility(View.VISIBLE);
        kontenerQuizu.setVisibility(View.GONE);
        przyciskReset.setVisibility(View.VISIBLE);

        przyciskOdpA.setEnabled(true);
        przyciskOdpB.setEnabled(true);
        przyciskOdpC.setEnabled(true);
    }

    private void rozpocznijQuiz() {
        wylosowanePytania = new ArrayList<>(bazaPytan);
        Collections.shuffle(wylosowanePytania);

        if (wylosowanePytania.size() > LICZBA_PYTAN_W_RUNDZIE) {
            wylosowanePytania = wylosowanePytania.subList(0, LICZBA_PYTAN_W_RUNDZIE);
        }

        przyciskStart.setVisibility(View.GONE);
        kontenerQuizu.setVisibility(View.VISIBLE);

        pokazPytanie();
    }

    private void pokazPytanie() {
        if (aktualnyIndeksPytania < wylosowanePytania.size()) {
            Pytanie obecnePytanie = wylosowanePytania.get(aktualnyIndeksPytania);
            tekstPytania.setText(obecnePytanie.pobierzTresc());
            przyciskOdpA.setText(obecnePytanie.pobierzOdpA());
            przyciskOdpB.setText(obecnePytanie.pobierzOdpB());
            przyciskOdpC.setText(obecnePytanie.pobierzOdpC());
        } else {
            zakonczQuiz();
        }
    }

    private void sprawdzOdpowiedz(String wybranaOdpowiedz) {
        Pytanie obecnePytanie = wylosowanePytania.get(aktualnyIndeksPytania);

        if (wybranaOdpowiedz.equals(obecnePytanie.pobierzPoprawna())) {
            liczbaPunktow++;
            Toast.makeText(this, "Dobra odpowiedź!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Błędna odpowiedź!", Toast.LENGTH_SHORT).show();
        }

        tekstWynik.setText("Wynik: " + liczbaPunktow);
        aktualnyIndeksPytania++;
        pokazPytanie();
    }

    private void zakonczQuiz() {
        tekstPytania.setText("Koniec quizu! Twój wynik: " + liczbaPunktow + " / " + wylosowanePytania.size());

        przyciskOdpA.setEnabled(false);
        przyciskOdpB.setEnabled(false);
        przyciskOdpC.setEnabled(false);

    }
}