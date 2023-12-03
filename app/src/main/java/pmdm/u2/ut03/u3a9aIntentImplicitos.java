package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.TextView;

import pmdm.u2.R;

public class u3a9aIntentImplicitos extends AppCompatActivity {
    public static final String URL_CANCION = "https://www.youtube.com/watch?v=EofDLqncpx8";
    public static final String CADENA_ERROR = "No se pudo realizar la operación";
    public static final String CADENA_SMS = "Te veo hoy a las 6pm";
    public static final String NUMERO_PACO = "625789413";
    public static final String STRING_GEOLOCALIZACION = "geo:0,0?q=Paseo+de+la+Florida,+10,+28008+Madrid";
    Button btCancion, btNumero, btSMS, btAbrirMapa, btAlarma;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a9a_intent_implicitos);

        btCancion = findViewById(R.id.u3a9btCancion);
        btNumero = findViewById(R.id.u3a9btNumero);
        btSMS = findViewById(R.id.u3a9btSMS);
        btAbrirMapa = findViewById(R.id.u3a9btMapa);
        btAlarma = findViewById(R.id.u3a9btAlarma);
        tvError = findViewById(R.id.u3a9atvError);

        btCancion.setOnClickListener(view -> {
            /* Se crea un nuevo objeto Intent con la acción ACTION_WEB_SEARCH, basicamente hara una
               busqueda en la web. */
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            /* El término "QUERY" se refiere a la cadena de búsqueda que se desea enviar al motor de
               búsqueda. */
            intent.putExtra(SearchManager.QUERY, URL_CANCION);

            // Se verifica si hay alguna actividad que pueda manejar la acción del intent
            if (intent.resolveActivity(getPackageManager()) != null) {
                // Si hay una actividad que puede manejar el intent, se inicia esa actividad.
                startActivity(intent);
                tvError.setText("");
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });

        btNumero.setOnClickListener(view -> {
            //  ACTION_DIAL representa la acción de iniciar la aplicación de marcado del teléfono
            Intent intent = new Intent(Intent.ACTION_DIAL);
            // Se concatena la cadena "tel:" con el número de teléfono "666".
            intent.setData(Uri.parse("tel:" + "666"));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                tvError.setText("");
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });

        btSMS.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("smsto:" + NUMERO_PACO)); //Si se cambia a mailto  manda emails
            i.putExtra("sms_body", CADENA_SMS); //mail_body

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
                tvError.setText("");
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });

        btAbrirMapa.setOnClickListener(view -> {
            Uri uri = Uri.parse(STRING_GEOLOCALIZACION);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                tvError.setText("");
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });

        btAlarma.setOnClickListener(view -> {
            String mensaje = "¡ALARMAAAAAA!";
            Integer hour = 9;
            Integer minutes = 15;

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM).
                    putExtra(AlarmClock.EXTRA_MESSAGE, mensaje).
                    putExtra(AlarmClock.EXTRA_HOUR, hour).
                    putExtra(AlarmClock.EXTRA_MINUTES, minutes);
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
                tvError.setText("");
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });
    }
}