package pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
public class u2a2Coloratron extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_coloratron);
        EditText et = findViewById(R.id.u2a2EntradaTexto);
        SeekBar sbR = findViewById(R.id.u2a2Red);
        SeekBar sbG = findViewById(R.id.u2a2Green);
        SeekBar sbB = findViewById(R.id.u2a2Blue);
        SwitchCompat sw = findViewById(R.id.u2a2BlancoNegro);
        Button bt = findViewById(R.id.u2a2Click);
        TextView tv = findViewById(R.id.u2a2TextoSalida);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Establece el texto en el TextView
                String texto = et.getText().toString();
                tv.setText(texto);

                if (sw.isChecked()){
                    tv.setTextColor(Color.WHITE);
                } else {
                    tv.setTextColor(Color.BLACK);
                }

                int red = sbR.getProgress();
                int green = sbG.getProgress();
                int blue = sbB.getProgress();
                int backgroundColor = Color.rgb(red, green, blue);
                tv.setBackgroundColor(backgroundColor);
            }
        });
    }
}