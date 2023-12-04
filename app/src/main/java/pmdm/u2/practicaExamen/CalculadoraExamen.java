package pmdm.u2.practicaExamen;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import pmdm.u2.R;
import pmdm.u2.ut03.u3a4MostrarNombreP2;
import pmdm.u2.ut03.u3a7ElegirArma;
import pmdm.u2.ut03.u3a7Metalslug;

public class CalculadoraExamen extends AppCompatActivity {
    public static final String INFO_NOMBRE_NUMERO1 = "num1";
    public static final String INFO_NOMBRE_NUMERO2 = "num2";
    public static final String INFO_NOMBRE_OPERACION = "operacion";
    EditText etN1, etN2;
    RadioGroup rgGrupo;
    Button btCalcular;
    TextView tvError;
    ActivityResultLauncher<Intent> lanzadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_calculadora_examen);

        etN1 = findViewById(R.id.exetN1);
        etN2 = findViewById(R.id.exetN2);
        btCalcular = findViewById(R.id.exbtCalcular);
        rgGrupo = findViewById(R.id.exrbDRadioGroup);
        tvError = findViewById(R.id.extvError);

        lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        etN1.setText("");
                        etN2.setText("");
                        rgGrupo.clearCheck();
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        btCalcular.setOnClickListener(View -> {
            // Obtener los valores de los EditText y RadioButton
            String num1 = etN1.getText().toString();
            String num2 = etN2.getText().toString();
            int radioButtonId = rgGrupo.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(radioButtonId);
            String operacion = selectedRadioButton.getText().toString();

            //Control de errores campos vacios en edit text
            if (num1.isEmpty() || num2.isEmpty() || (num2.equals("0") && operacion.equals("Dividir"))) {
                if (num1.isEmpty()) {
                    etN1.setError("Por favor, introduzca un número.");
                } else {
                    etN1.setError(null); // Borra cualquier mensaje de error existente
                }

                if (num2.isEmpty()) {
                    etN2.setError("Por favor, introduzca un número.");
                } else {
                    etN2.setError(null); // Borra cualquier mensaje de error existente
                }
                if (num2.equals("0") && operacion.equals("Dividir")) {
                    // Mostrar un mensaje de error para evitar la división por 0
                    etN2.setError("No se puede dividir por cero");
                }
            } else {
                Intent intent = new Intent(CalculadoraExamen.this, CalculadoraBExamen.class);
                intent.putExtra(INFO_NOMBRE_NUMERO1, num1);
                intent.putExtra(INFO_NOMBRE_NUMERO2, num2);
                intent.putExtra(INFO_NOMBRE_OPERACION, operacion);
                lanzadora.launch(intent);
            }
        });
    }
}