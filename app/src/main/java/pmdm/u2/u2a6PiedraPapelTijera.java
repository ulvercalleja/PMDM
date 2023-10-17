package pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class u2a6PiedraPapelTijera extends AppCompatActivity {

    EditText ptNombre;
    Button btJugar;
    TextView validationStatus;
    ImageView ivLogoVertical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a6_piedra_papel_tijera);

        this.ptNombre = findViewById(R.id.u2a6ptNombre);
        btJugar = findViewById(R.id.u2a6btJugar);
        validationStatus = findViewById(R.id.u2a6tvValidar);
        ivLogoVertical = findViewById(R.id.u2a6logoVertical);

        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = ptNombre.getText().toString();
                if (ptNombre.length()<1) {
                    validationStatus.setText("Por favor, introduzca un nombre");
                } else {
                    validationStatus.setText("");
                    Intent intent = new Intent(u2a6PiedraPapelTijera.this, u2a6PiedraPapelTijeraPartida.class);
                    intent.putExtra("nombre", nombre); // Paso el valor del nombre a través del Intent
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    /*
    public void onClick(View view){
        String nombre = ptNombre.getText().toString().trim();
        if (ptNombre.length()<1) {
            validationStatus.setText("Por favor, introduzca un nombre");
        } else {
            validationStatus.setText("");
            Intent siguiente = new Intent(this, u2a6PiedraPapelTijeraPartida.class);
            getIntent().putExtra("jugador", nombre);
            startActivity(siguiente);
            finish();
        }
    }*/
}