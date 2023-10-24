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

public class u3a4MostrarNombre extends AppCompatActivity {
    public static final String INFO_NOMBREP1 = "nombreActual";
    TextView tvNombreTexto;
    TextView tvNombreUsuario;
    TextView tvError;
    Button btPedirNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_mostrar_nombre);
        tvNombreTexto = findViewById(R.id.u3a4tvNombreTexto);
        tvNombreUsuario = findViewById(R.id.u3a4tvNombreUsuario);
        tvError = findViewById(R.id.u3a4tvError);
        btPedirNombre = findViewById(R.id.u3a4btPedirNombre);

        ActivityResultLauncher<Intent> lanzadora = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();
                        tvNombreUsuario.setText(data.getStringExtra(u3a4MostrarNombreP2.INFO_NOMBREP2));
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        btPedirNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(u3a4MostrarNombre.this, u3a4MostrarNombreP2.class);
                intent.putExtra(INFO_NOMBREP1, tvNombreUsuario.getText().toString());
                lanzadora.launch(intent);
            }
        });
    }
}