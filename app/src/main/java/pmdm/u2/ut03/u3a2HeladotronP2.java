package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a2HeladotronP2 extends AppCompatActivity {
    TextView tvFresaResultado;
    TextView tvVainillaResultado;
    TextView tvChocolateResultado;
    TextView tvPrueba;
    String numOVainilla = "";
    String numOFresa = "";
    String numOChocolate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_heladotron_p2);

        tvFresaResultado = findViewById(R.id.u3a2tvFresaResultado);
        tvVainillaResultado = findViewById(R.id.u3a2tvVainillaResultado);
        tvChocolateResultado = findViewById(R.id.u3a2tvChocolateResultado);
        tvPrueba = findViewById(R.id.u3a2tvPrueba);


        String numFresaStr = getIntent().getStringExtra(u3a2Heladotron.INFO_NOMBRE_FRESA);
        String numVainillaStr = getIntent().getStringExtra(u3a2Heladotron.INFO_NOMBRE_VAINILLA);
        String numChocolateStr = getIntent().getStringExtra(u3a2Heladotron.INFO_NOMBRE_CHOCOLATE);
        String recipiente = getIntent().getStringExtra(u3a2Heladotron.INFO_NOMBRE_SPINNER);

        int numFresa = numFresaStr.isEmpty() ? 0 : Integer.parseInt(numFresaStr);
        int numVainilla = numVainillaStr.isEmpty() ? 0 : Integer.parseInt(numVainillaStr); //Si no hago operador ternario, la aplicacion se cierra al tener campo vacio
        int numChocolate = numChocolateStr.isEmpty() ? 0 : Integer.parseInt(numChocolateStr);

        for (int i = 0; i < numVainilla; i++) {
            numOVainilla += "o";
        }
        for (int i = 0; i < numFresa; i++) {
            numOFresa += "o";
        }
        for (int i = 0; i < numChocolate; i++) {
            numOChocolate += "o";
        }
        tvFresaResultado.setText(numOVainilla);
        tvVainillaResultado.setText(numOFresa);
        tvChocolateResultado.setText(numOChocolate);
        tvPrueba.setText(recipiente);

    }
}