package pmdm.u2.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.*;

import org.w3c.dom.Text;

import pmdm.u2.R;

public class u8a0AleatorioPrimo extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;
    TextView tvResultado;
    Button btSumar;
    ProgressBar pbCargando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a0_numero_aleatorio);

        etNum1 = findViewById(R.id.u8a0etNum1);
        etNum2 = findViewById(R.id.u8a0etNum2);
        tvResultado = findViewById(R.id.u8a0tvResultado);
        btSumar = findViewById(R.id.u8a0btSumar);
        pbCargando = findViewById(R.id.u8a0pbCargando);

        u8a0AleatorioPrimoViewModel vm = new ViewModelProvider(this).get(u8a0AleatorioPrimoViewModel.class);
        vm.getNumero().observe(this, integer -> {
            tvResultado.setText("" + integer);
            pbCargando.setVisibility(View.INVISIBLE);
            tvResultado.setVisibility(View.VISIBLE);
            btSumar.setEnabled(true);
        });
        btSumar.setEnabled(false);
        btSumar.setOnClickListener((v) -> {
            pbCargando.setVisibility(View.VISIBLE);
            tvResultado.setVisibility(View.INVISIBLE);
            btSumar.setEnabled(false);
            // Obtener los números de los EditText
            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 = Integer.parseInt(etNum2.getText().toString());

            // Llamar al método cargaNumero con los números obtenidos
            vm.cargaNumero(num1, num2);
        });
    }
}