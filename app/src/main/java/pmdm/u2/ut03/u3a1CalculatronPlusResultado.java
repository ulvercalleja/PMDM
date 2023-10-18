package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a1CalculatronPlusResultado extends AppCompatActivity {

    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_calculatron_plus_resultado);

        tvResultado = findViewById(R.id.u3a1tvResultado);
    }
}