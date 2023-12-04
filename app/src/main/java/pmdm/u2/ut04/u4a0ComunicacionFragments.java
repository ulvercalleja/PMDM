package pmdm.u2.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pmdm.u2.R;

public class u4a0ComunicacionFragments extends AppCompatActivity {
    ImageButton tick;
    u4f0ComunicacionFragments fragment;
    TextView color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a0_comunicacion_fragments);
        tick = findViewById(R.id.u4a1idimbttick);
        color = findViewById(R.id.u4a1idtvcolor);
        fragment = (u4f0ComunicacionFragments) getSupportFragmentManager().findFragmentById(R.id.ut0401idfragment1);

        tick.setOnClickListener((View v) -> {
            fragment.setColor(0x77, 0xFF, 00, 0xFF);
            fragment.setText("Truco de magia con esta cadena mágica");
        });

        fragment.setColorChangeListener(
                (int c)-> color.setText("Funciona asqueroso " + String.valueOf(c))
        );
    }
}