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
import android.widget.ImageView;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a7Metalslug extends AppCompatActivity {
    public static final int DEFAULT_VALUE = 0;
    int imageViewResource = 0;
    ActivityResultLauncher<Intent> lanzadoraPersonaje1,lanzadoraPersonaje2, lanzadoraArma1, lanzadoraArma2;
    Button btSeleccionarJugador1;
    Button btSeleccionarArma1;
    Button btSeleccionarJugador2;
    Button btSeleccionarArma2;
    ImageView ivSeleccionarJugador1;
    ImageView ivSeleccionarArma1;
    ImageView ivSeleccionarJugador2;
    ImageView ivSeleccionarArma2;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7_metalslug);

        btSeleccionarJugador1 = findViewById(R.id.u3a7btSeleccionarJugador1);
        btSeleccionarArma1 = findViewById(R.id.u3a7btSeleccionarArma1);
        btSeleccionarJugador2 = findViewById(R.id.u3a7btSeleccionarJugador2);
        btSeleccionarArma2 = findViewById(R.id.u3a7btSeleccionarArma2);
        ivSeleccionarJugador1 = findViewById(R.id.u3a7ivSeleccionarJugador1);
        ivSeleccionarArma1 = findViewById(R.id.u3a7ivSeleccionarArma1);
        ivSeleccionarJugador2 = findViewById(R.id.u3a7ivSeleccionarJugador2);
        ivSeleccionarArma2 = findViewById(R.id.u3a7ivSeleccionarArma2);
        tvError = findViewById(R.id.u3a7tvError);

        btSeleccionarJugador1.setOnClickListener(View -> {
            Intent intent = new Intent(u3a7Metalslug.this, u3a7ElegirPersonaje.class);
            lanzadoraPersonaje1.launch(intent);
        });

        btSeleccionarJugador2.setOnClickListener(View -> {
            Intent intent = new Intent(u3a7Metalslug.this, u3a7ElegirPersonaje.class);
            lanzadoraPersonaje2.launch(intent);
        });

        btSeleccionarArma1.setOnClickListener(View -> {
            Intent intent = new Intent(u3a7Metalslug.this, u3a7ElegirArma.class);
            lanzadoraArma1.launch(intent);
        });

        btSeleccionarArma2.setOnClickListener(View -> {
            Intent intent = new Intent(u3a7Metalslug.this, u3a7ElegirArma.class);
            lanzadoraArma2.launch(intent);
        });

        lanzadoraPersonaje1 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imageViewResource = data.getIntExtra(u3a7ElegirPersonaje.INFO_IMAGEN, DEFAULT_VALUE);
                        ivSeleccionarJugador1.setImageResource(imageViewResource);
                        tvError.setText("");
                    } else if(result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ivSeleccionarJugador1.setImageResource(R.drawable.interrogacion);
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        lanzadoraPersonaje2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imageViewResource = data.getIntExtra(u3a7ElegirPersonaje.INFO_IMAGEN, DEFAULT_VALUE);
                        ivSeleccionarJugador2.setImageResource(imageViewResource);
                        tvError.setText("");
                    } else if(result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ivSeleccionarJugador2.setImageResource(R.drawable.interrogacion);
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        lanzadoraArma1 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    Intent data = result.getData();
                    if(result.getResultCode() == Activity.RESULT_OK) {
                        imageViewResource = data.getIntExtra(u3a7ElegirArma.INFO_IMAGEN, DEFAULT_VALUE);
                        ivSeleccionarArma1.setImageResource(imageViewResource);
                        tvError.setText("");
                    } else if(result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ivSeleccionarArma1.setImageResource(R.drawable.interrogacion);
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

        lanzadoraArma2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), (result)->{
                    Intent data = result.getData();
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imageViewResource = data.getIntExtra(u3a7ElegirArma.INFO_IMAGEN, DEFAULT_VALUE);
                        ivSeleccionarArma2.setImageResource(imageViewResource);
                        tvError.setText("");
                    } else if(result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        ivSeleccionarArma2.setImageResource(R.drawable.interrogacion);
                        tvError.setText("");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvError.setTextColor(Color.RED);
                        tvError.setText("El usuario ha cancelado la actividad.");
                    }
                }
        );

    }
}