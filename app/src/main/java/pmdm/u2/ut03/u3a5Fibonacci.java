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
import android.widget.TextView;

import pmdm.u2.R;

public class u3a5Fibonacci extends AppCompatActivity {
    public static final String INFO_NUM1 = "n1";
    public static final String INFO_NUM2 = "n2";
    TextView tvNUM1;
    TextView tvNUM2;
    TextView tvResultadoSuma;
    TextView tvError;
    Button btSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5_fibonacci);
        tvNUM1 = findViewById(R.id.u3a5tvN1);
        tvNUM2 = findViewById(R.id.u3a5tvN2);
        tvResultadoSuma = findViewById(R.id.u3a5tvResultadoSuma);
        btSiguiente = findViewById(R.id.u3a5btSiguiente);
        tvError = findViewById(R.id.u3a5tvError);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        tvResultadoSuma.setText(data.getStringExtra(u3a5SiguienteNumero.INFO_RESULTADO_SUMA));
                        tvNUM1.setText(tvNUM2.getText());
                        tvNUM2.setText(tvResultadoSuma.getText());
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(u3a5Fibonacci.this, u3a5SiguienteNumero.class);
                intent.putExtra(INFO_NUM1, tvNUM1.getText().toString());
                intent.putExtra(INFO_NUM2, tvNUM2.getText().toString());
                lanzadora.launch(intent);
            }
        });
    }
}