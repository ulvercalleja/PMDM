package pmdm.u2.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

import pmdm.u2.R;

public class u3a2Heladotron extends AppCompatActivity {
    Spinner spRecipientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2_heladotron);

        spRecipientes = findViewById(R.id.u3a2spRecipientes);

        ArrayList<Recipiente> recipientes = new ArrayList<>();
    }
}