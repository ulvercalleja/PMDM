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


    EditText ptNum1;
    RadioButton rbSumar;
    RadioButton rbRestar;
    RadioButton rbMultiplicar;
    RadioButton rbDividir;
    RadioGroup rgGrupo;
    EditText ptNum2;
    Button btCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1_calculatron_plus);

        ptNum1 = findViewById(R.id.u3a1ptNum1);
        rbSumar = findViewById(R.id.u3a1rbSumar);
        rbRestar = findViewById(R.id.u3a1rbRestar);
        rbMultiplicar = findViewById(R.id.u3a1rbMultiplicar);
        rbDividir = findViewById(R.id.u3a1rbDividir);
        rgGrupo = findViewById(R.id.u3a1rgGrupoRadio);
        ptNum2 = findViewById(R.id.u3a1ptNum2);
        btCalcular = findViewById(R.id.u3a1btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String num1 = ptNum1.getText().toString().trim();
                String num2 = ptNum2.getText().toString();
                int radioButtonId = rgGrupo.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(radioButtonId);
                String operacion = selectedRadioButton.getText().toString();

                //Control de errores campos vacios en edit text

                if (num1.isEmpty() || num2.isEmpty()) {
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
                } else {
                    ptNum1.setError(null);
                    ptNum2.setError(null);

                    Intent intent = new Intent(u3a1CalculatronPlus.this, u3a1CalculatronPlusResultado.class);
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    intent.putExtra("operacion", operacion);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}