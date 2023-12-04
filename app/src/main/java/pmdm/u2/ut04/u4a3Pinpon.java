package pmdm.u2.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;

public class u4a3Pinpon extends AppCompatActivity {

    private static final String JUGADOR_DEFAULT = "Jugador X";
    private static final String RESULTADO_DEFAULT = "0 - 0";
    private static final int MARCADOR_INICIAL = 0;
    u4f3Pinpon partido1, partido2, partido3, partido4;
    Button btResetear, btIniciar;
    TextView tvGanador1, tvGanador2, tvGanador3, tvGanador4, tvResultado1, tvResultado2, tvResultado3, tvResultado4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a3_pinpon);

        btIniciar = findViewById(R.id.ut04f1idbtIniciar);
        btResetear = findViewById(R.id.ut04f1idbtResetear);
        tvGanador1 = findViewById(R.id.ut04f1idtvGanadorPartido1);
        tvGanador2 = findViewById(R.id.ut04f1idtvGanadorPartido2);
        tvGanador3 = findViewById(R.id.ut04f1idtvGanadorPartido3);
        tvGanador4 = findViewById(R.id.ut04f1idtvGanadorPartido4);
        tvResultado1 = findViewById(R.id.ut04f1idtvResultadoPartido1);
        tvResultado2 = findViewById(R.id.ut04f1idtvResultadoPartido2);
        tvResultado3 = findViewById(R.id.ut04f1idtvResultadoPartido3);
        tvResultado4 = findViewById(R.id.ut04f1idtvResultadoPartido4);
        partido1 = (u4f3Pinpon) getSupportFragmentManager().findFragmentById(R.id.ut4a3idfrPartido1);
        partido2 = (u4f3Pinpon) getSupportFragmentManager().findFragmentById(R.id.ut4a3idfrPartido2);
        partido3 = (u4f3Pinpon) getSupportFragmentManager().findFragmentById(R.id.ut4a3idfrPartido3);
        partido4 = (u4f3Pinpon) getSupportFragmentManager().findFragmentById(R.id.ut4a3idfrPartido4);

        btIniciar.setOnClickListener((View v) -> {
            partido1.setText("Partido 1");
            partido2.setText("Partido 2");
            partido3.setText("Partido 3");
            partido4.setText("Partido 4");
        });
        btResetear.setOnClickListener((View v) -> {
            tvGanador1.setText(JUGADOR_DEFAULT);
            tvGanador2.setText(JUGADOR_DEFAULT);
            tvGanador3.setText(JUGADOR_DEFAULT);
            tvGanador4.setText(JUGADOR_DEFAULT);
            tvResultado1.setText(RESULTADO_DEFAULT);
            tvResultado2.setText(RESULTADO_DEFAULT);
            tvResultado3.setText(RESULTADO_DEFAULT);
            tvResultado4.setText(RESULTADO_DEFAULT);
            partido1.setButtonEnabled(true);
            partido2.setButtonEnabled(true);
            partido3.setButtonEnabled(true);
            partido4.setButtonEnabled(true);
            partido1.setMarcador(MARCADOR_INICIAL, MARCADOR_INICIAL);
            partido2.setMarcador(MARCADOR_INICIAL, MARCADOR_INICIAL);
            partido3.setMarcador(MARCADOR_INICIAL, MARCADOR_INICIAL);
            partido4.setMarcador(MARCADOR_INICIAL, MARCADOR_INICIAL);
        });

        partido1.setCambiarDatosListener(
                (String JGanador, String marcador) -> {
                    tvGanador1.setText(String.valueOf(JGanador));
                    tvResultado1.setText(String.valueOf(marcador));
                });
        partido2.setCambiarDatosListener(
                (String JGanador, String marcador) -> {
                    tvGanador2.setText(String.valueOf(JGanador));
                    tvResultado2.setText(String.valueOf(marcador));
                }
        );
        partido3.setCambiarDatosListener(
                (String JGanador, String marcador) -> {
                    tvGanador3.setText(String.valueOf(JGanador));
                    tvResultado3.setText(String.valueOf(marcador));
                }
        );
        partido4.setCambiarDatosListener(
                (String JGanador, String marcador) -> {
                    tvGanador4.setText(String.valueOf(JGanador));
                    tvResultado4.setText(String.valueOf(marcador));
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}