package pmdm.u2.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a6AnalisisLetras extends AppCompatActivity {
    public static final String INFO_TEXTO = "texto";
    EditText etTexto;
    Button btAnalizar;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_analisis_letras);
        etTexto = findViewById(R.id.u3a6etTexto);
        btAnalizar = findViewById(R.id.u3a6btAnalizar);
        tvError = findViewById(R.id.u3a6tvError);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        //tvResultadoSuma.setText(data.getStringExtra(u3a5SiguienteNumero.INFO_RESULTADO_SUMA));
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        btAnalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(u3a6AnalisisLetras.this, u3a6Analizador.class);
                intent.putExtra(INFO_TEXTO, etTexto.getText().toString());
                lanzadora.launch(intent);
            }
        });

    }
}