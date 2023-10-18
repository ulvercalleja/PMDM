package pmdm.u2.ut02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import pmdm.u2.R;


public class u2a3Propinatron extends AppCompatActivity {

    // Declaración de un manejador para los eventos de clic
    View.OnClickListener manejador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a3_propinatron);
        // Asignar referencias a los elementos de la interfaz
        Button btCero = findViewById(R.id.u2a3Cero);
        Button btUno = findViewById(R.id.u2a3Uno);
        Button btDos = findViewById(R.id.u2a3Dos);
        Button btTres = findViewById(R.id.u2a3Tres);
        Button btCuatro = findViewById(R.id.u2a3Cuatro);
        Button btCinco = findViewById(R.id.u2a3Cinco);
        Button btSeis = findViewById(R.id.u2a3Seis);
        Button btSiete = findViewById(R.id.u2a3Siete);
        Button btOcho = findViewById(R.id.u2a3Ocho);
        Button btNueve = findViewById(R.id.u2a3Nueve);
        Button btAC = findViewById(R.id.u2a3AC);
        Button btC = findViewById(R.id.u2a3C);
        Button btCalcular = findViewById(R.id.u2a3Calcular);
        TextView tvCuenta = findViewById(R.id.u2a3Cuenta);
        RadioButton rbMalo = findViewById(R.id.u2a3BotonMalo);
        RadioButton rbBueno = findViewById(R.id.u2a3BotonBueno);
        RadioButton rbExcelente = findViewById(R.id.u2a3BotonExcelente);

        // Definición del manejador de clic para los botones numéricos y de control
        manejador = (View botonPulsado) -> {
            Button boton = (Button)botonPulsado;

            if (botonPulsado == btC){
                // Si se presiona el botón "C", eliminar el último dígito del TextView
                String numeroActual = tvCuenta.getText().toString();
                String cadenaFinal = numeroActual.substring(0, numeroActual.length() - 1); // Borra el último dígito
                tvCuenta.setText(cadenaFinal);
            } else if(botonPulsado == btAC){
                // Si se presiona el botón "AC", borrar todo el contenido del TextView
                tvCuenta.setText("");
            } else {
                // En otros casos, agregar el texto del botón al TextView
                tvCuenta.append(boton.getText());
            }
        };

        // Asignar el manejador de clic a los botones numéricos y de control
        btCero.setOnClickListener(manejador);
        btUno.setOnClickListener(manejador);
        btDos.setOnClickListener(manejador);
        btTres.setOnClickListener(manejador);
        btCuatro.setOnClickListener(manejador);
        btCinco.setOnClickListener(manejador);
        btSeis.setOnClickListener(manejador);
        btSiete.setOnClickListener(manejador);
        btOcho.setOnClickListener(manejador);
        btNueve.setOnClickListener(manejador);
        btAC.setOnClickListener(manejador);
        btC.setOnClickListener(manejador);
        btCalcular.setOnClickListener(manejador);

        // Establecer un nuevo manejador de clic para el botón "Calcular"
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double propina;
                double cuenta = Double.parseDouble(tvCuenta.getText().toString());
                String totalCuenta;

                if (rbBueno.isChecked()) {
                    // Si el botón de opción "Bueno" está marcado, calcular la cuenta con propina del 10%
                    propina = 1.10;
                    cuenta = propina * cuenta;
                    totalCuenta = String.format("%.2f", cuenta);
                    tvCuenta.setText(totalCuenta);

                } else if (rbExcelente.isChecked()) {
                    // Si el botón de opción "Excelente" está marcado, calcular la cuenta con propina del 20%
                    propina = 1.20;
                    cuenta = propina * cuenta;
                    totalCuenta = String.format("%.2f", cuenta);
                    tvCuenta.setText(totalCuenta);
                }

            }
        });
    }
}