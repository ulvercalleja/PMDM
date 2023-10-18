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
    TextView validationStatus;
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
        validationStatus = findViewById(R.id.u3a1tvValidar);
        btCalcular = findViewById(R.id.u3a1btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num1 = ptNum1.getText().toString();
                String num2 = ptNum2.getText().toString();

                if (num1.isEmpty() && num2.isEmpty() ) {
                    validationStatus.setText("Por favor, introduzca ambos numeros");
                } else if (num1.isEmpty() ){
                    validationStatus.setText("Por favor, introduzca el primer numero");
                } else if (num2.isEmpty() ){
                    validationStatus.setText("Por favor, introduzca el segundo numero");
                } else if (!num1.matches("\\d+") && !num2.matches("\\d+")) {
                    validationStatus.setText("Por favor, introduzca números válidoss");
                }else {
                    validationStatus.setText("");
                    Intent intent = new Intent(u3a1CalculatronPlus.this, u3a1CalculatronPlusResultado.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}