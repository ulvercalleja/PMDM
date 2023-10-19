package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.ut02.u2a6PiedraPapelTijera;
import pmdm.u2.ut02.u2a6PiedraPapelTijeraPartida;

public class u3a1CalculatronPlus extends AppCompatActivity {

    public static final String INFO_NOMBRE_NUMERO1 = "num1";
    public static final String INFO_NOMBRE_NUMERO2 = "num2";
    public static final String INFO_NOMBRE_OPERACION = "operacion";
    EditText ptNum1;
    RadioGroup rgGrupo;
    EditText ptNum2;
    Button btCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_calculatron_plus);

        // Inicialización de las variables
        ptNum1 = findViewById(R.id.u3a1ptNum1);
        rgGrupo = findViewById(R.id.u3a1rgGrupoRadio);
        ptNum2 = findViewById(R.id.u3a1ptNum2);
        btCalcular = findViewById(R.id.u3a1btCalcular);

        btCalcular.setOnClickListener(v -> {

            // Obtener los valores de los EditText y RadioButton
            String num1 = ptNum1.getText().toString();
            String num2 = ptNum2.getText().toString();
            int radioButtonId = rgGrupo.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(radioButtonId);
            String operacion = selectedRadioButton.getText().toString();

            //Control de errores campos vacios en edit text
            if (num1.isEmpty() || num2.isEmpty() || (num2.equals("0") && operacion.equals("Dividir"))) {
                if (num1.isEmpty()) {
                    ptNum1.setError("Por favor, introduzca un número.");
                } else {
                    ptNum1.setError(null); // Borra cualquier mensaje de error existente
                }

                if (num2.isEmpty()) {
                    ptNum2.setError("Por favor, introduzca un número.");
                } else {
                    ptNum2.setError(null); // Borra cualquier mensaje de error existente
                }
                if (num2.equals("0") && operacion.equals("Dividir")) {
                    // Mostrar un mensaje de error para evitar la división por 0
                    ptNum2.setError("No se puede dividir por cero");
                }
            } else {
                ptNum1.setError(null);
                ptNum2.setError(null);

                // Crear un intent para pasar los datos a la siguiente actividad
                Intent intent = new Intent(u3a1CalculatronPlus.this, u3a1CalculatronPlusResultado.class);
                intent.putExtra(INFO_NOMBRE_NUMERO1, num1);
                intent.putExtra(INFO_NOMBRE_NUMERO2, num2);
                intent.putExtra(INFO_NOMBRE_OPERACION, operacion);
                startActivity(intent);
            }
        });
    }
}