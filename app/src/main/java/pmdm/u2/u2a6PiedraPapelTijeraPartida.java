package pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class u2a6PiedraPapelTijeraPartida extends AppCompatActivity {
    TextView errorStatus;
    TextView marcadorAzul;
    TextView marcadorRojo;
    ImageView eleccionJugador;
    ImageView eleccionIA;
    TextView nombreUsuario;
    TextView nombreIA;
    TextView textoSeleccion;
    ImageView piedraImageView;
    ImageView papelImageView;
    ImageView tijeraImageView;
    Button salirBoton;
    Button reiniciarBoton;
    ImageView ganadoImageView;
    ImageView perdidoImageView;

    int datoJugador = 0;
    int datoIA = 0;
    int contadorJugador = 0;
    int contadorIA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a6_piedra_papel_tijera_partida);

        // Obtener nombre jugador
        nombreUsuario = findViewById(R.id.u2a6tvUsuario);
        // Recupero el valor del nombre del Intent
        String nombre = getIntent().getStringExtra("nombre");

        // Muestro el nombre en el TextView
        nombreUsuario.setText(nombre);

        // Asignar referencias a los elementos de la interfaz
        errorStatus = findViewById(R.id.u2a6tvError);
        marcadorAzul = findViewById(R.id.u2a6tvMarcadorAzul);
        marcadorRojo = findViewById(R.id.u2a6tvMarcadorRojo);
        eleccionJugador = findViewById(R.id.u2a6ivAzul);
        eleccionIA = findViewById(R.id.u2a6ivRojo);
        nombreIA = findViewById(R.id.u2a6tvIA);
        textoSeleccion = findViewById(R.id.u2a6tvSeleccione);
        piedraImageView = findViewById(R.id.u2a6ivPiedra);
        papelImageView = findViewById(R.id.u2a6ivPapel);
        tijeraImageView = findViewById(R.id.u2a6ivTijera);
        salirBoton = findViewById(R.id.u2a6btSalir);
        reiniciarBoton = findViewById(R.id.u2a6btReiniciar);
        ganadoImageView = findViewById(R.id.u2a6ivGanado);
        perdidoImageView = findViewById(R.id.u2a6ivPerdido);

        reiniciarBoton.setVisibility(View.GONE);
        ganadoImageView.setVisibility(View.GONE);
        perdidoImageView.setVisibility(View.GONE);

        salirBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(v.getContext(), u2a6PiedraPapelTijera.class);
                startActivity(login);
                finish();
            }
        });

        reiniciarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciar();
            }
        });

        piedraImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador = 1;
                Aleatorio();
            }
        });

        papelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador = 2;
                Aleatorio();
            }
        });

        tijeraImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoJugador = 3;
                Aleatorio();
            }
        });

    }

    //Este metodo cambia la imagen de "Esperando eleccion..." por la eleccion del jugador
    public void ResultadoJugador(){
        if(datoJugador == 1){
            eleccionJugador.setImageResource(R.drawable.piedra);
        } else if (datoJugador == 2){
            eleccionJugador.setImageResource(R.drawable.papel);
        } else if(datoJugador == 3) {
            eleccionJugador.setImageResource(R.drawable.tijera);
        }

        Resultado();
    }

    /* Este metodo genera un numero aleatorio entre el 1 y3 y
     cambia la imagen de "Esperando eleccion..." por la eleccion del jugador */
    public void Aleatorio() {
        int numAleatorio = (int) (Math.random() * 3);
        numAleatorio = numAleatorio +1;

        if(numAleatorio == 1){
            eleccionIA.setImageResource(R.drawable.piedra);
            datoIA = 1;
        } else if (numAleatorio == 2){
            eleccionIA.setImageResource(R.drawable.papel);
            datoIA = 2;
        } else if(numAleatorio == 3) {
            eleccionIA.setImageResource(R.drawable.tijera);
            datoIA = 3;
        }

        ResultadoJugador();
    }

    //Este metodo compara quien gana
    public void Resultado(){
        try {
            if (datoJugador == datoIA){
                //empate

            } else if(datoJugador == 1 && datoIA == 2){
                //piedra vs papel
                contadorIA ++;

                marcadorRojo.setText(String.valueOf(contadorIA));
            } else if(datoJugador == 1 && datoIA == 3){
                //piedra vs tijera
                contadorJugador ++;

                marcadorAzul.setText(String.valueOf(contadorJugador));
            } else if(datoJugador == 2 && datoIA == 1){
                //papel vs piedra
                contadorJugador ++;

                marcadorAzul.setText(String.valueOf(contadorJugador));
            } else if(datoJugador == 2 && datoIA == 3){
                //papel vs tijera
                contadorIA ++;

                marcadorRojo.setText(String.valueOf(contadorIA));
            } else if(datoJugador == 3 && datoIA == 1){
                //tijera vs piedra
                contadorIA ++;

                marcadorRojo.setText(String.valueOf(contadorIA));
            } else if(datoJugador == 3 && datoIA == 2){
                //tijera vs papel
                contadorJugador ++;

                marcadorAzul.setText(String.valueOf(contadorJugador));
            }

            Fin();
        }  catch (Exception e){
            String error = "Error en: " + e;
            errorStatus.setText(error);
        }
    }

    public void Fin(){
        if(contadorJugador == 3){
            errorStatus.setVisibility(View.GONE);
            marcadorAzul.setVisibility(View.GONE);
            marcadorRojo.setVisibility(View.GONE);
            eleccionJugador.setVisibility(View.GONE);
            eleccionIA.setVisibility(View.GONE);
            nombreUsuario.setVisibility(View.GONE);
            nombreIA.setVisibility(View.GONE);
            textoSeleccion.setVisibility(View.GONE);
            piedraImageView.setVisibility(View.GONE);
            papelImageView.setVisibility(View.GONE);
            tijeraImageView.setVisibility(View.GONE);
            salirBoton.setVisibility(View.GONE);
            reiniciarBoton.setVisibility(View.VISIBLE);
            ganadoImageView.setVisibility(View.VISIBLE);

        } else if (contadorIA == 3){
            errorStatus.setVisibility(View.GONE);
            marcadorAzul.setVisibility(View.GONE);
            marcadorRojo.setVisibility(View.GONE);
            eleccionJugador.setVisibility(View.GONE);
            eleccionIA.setVisibility(View.GONE);
            nombreUsuario.setVisibility(View.GONE);
            nombreIA.setVisibility(View.GONE);
            textoSeleccion.setVisibility(View.GONE);
            piedraImageView.setVisibility(View.GONE);
            papelImageView.setVisibility(View.GONE);
            tijeraImageView.setVisibility(View.GONE);
            salirBoton.setVisibility(View.GONE);
            reiniciarBoton.setVisibility(View.VISIBLE);
            perdidoImageView.setVisibility(View.VISIBLE);

        }
    }

    public void reiniciar() {
        datoJugador = 0;
        datoIA = 0;
        contadorJugador = 0;
        contadorIA = 0;

        // Restablecer las imágenes de las elecciones del jugador y la IA a la imagen predeterminada
        eleccionJugador.setImageResource(R.drawable.esperandoazul);
        eleccionIA.setImageResource(R.drawable.esperandorojo);

        // Restablecer el texto de los marcadores
        marcadorAzul.setText("0");
        marcadorRojo.setText("0");

        // Mostrar nuevamente los elementos ocultos
        errorStatus.setVisibility(View.VISIBLE);
        marcadorAzul.setVisibility(View.VISIBLE);
        marcadorRojo.setVisibility(View.VISIBLE);
        eleccionJugador.setVisibility(View.VISIBLE);
        eleccionIA.setVisibility(View.VISIBLE);
        nombreUsuario.setVisibility(View.VISIBLE);
        nombreIA.setVisibility(View.VISIBLE);
        textoSeleccion.setVisibility(View.VISIBLE);
        piedraImageView.setVisibility(View.VISIBLE);
        papelImageView.setVisibility(View.VISIBLE);
        tijeraImageView.setVisibility(View.VISIBLE);
        salirBoton.setVisibility(View.VISIBLE);
        reiniciarBoton.setVisibility(View.GONE);
        ganadoImageView.setVisibility(View.GONE);
        perdidoImageView.setVisibility(View.GONE);
    }

}