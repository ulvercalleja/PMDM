package pmdm.u2.ut02;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import pmdm.u2.R;

public class u2a5TattoApp extends AppCompatActivity {

    // on below line we are creating variables.
    private Button pickDateBtn;
    private TextView selectedDateTV;
    private Button pickTimeBtn;
    private TextView selectedTimeTV;
    TextView tvErrorFecha;
    EditText ptDNI;
    Button validateDNIButton;
    TextView validationStatus;
    ImageView checkImageView;
    static final String FORMATO_DNI = "[0-9]{8}[A-Z]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a5_tatto_app);

        // on below line we are initializing our variables.
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        pickTimeBtn = findViewById(R.id.idBtnPickTime);
        selectedTimeTV = findViewById(R.id.idTVSelectedTime);
        ptDNI = findViewById(R.id.u2a5ptDNI);
        validateDNIButton = findViewById(R.id.u2a5btValidar);
        validationStatus = findViewById(R.id.u2a5vtValidar);
        checkImageView = findViewById(R.id.imageView2);
        tvErrorFecha = findViewById(R.id.u2a5tvError);
        checkImageView.setVisibility(View.GONE);
        // on below line we are adding click listener for our pick date button
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        u2a5TattoApp.this,
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            // on below line we are setting date to our text view.
                            Calendar selectedDate = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                            int diaSemana = selectedDate.get(Calendar.DAY_OF_WEEK);
                            if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
                                tvErrorFecha.setText("Fecha erronea. Abrimos de lunes a viernes.");
                            } else {
                                // on below line we are setting date to our text view.
                                selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
                                tvErrorFecha.setText("");
                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        pickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting the
                // instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(u2a5TattoApp.this,
                        (view, hourOfDay, minute1) -> {
                            // on below line we are setting selected time
                            // in our text view.
                            if (hourOfDay >= 9 && hourOfDay < 14) {
                                selectedDateTV.setText(hourOfDay + ":" + minute1);
                                tvErrorFecha.setText("");
                            }else{
                                tvErrorFecha.setText("Hora errónea. Abrimos de 9 a 14.");
                            }
                        }, hour, minute, false);
                // at last we are calling show to
                // display our time picker dialog.
                timePickerDialog.show();
            }
        });

        // Agrega un Listener al botón para validar el DNI
        validateDNIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = ptDNI.getText().toString().trim();
                if (dni.toUpperCase().matches(FORMATO_DNI) == false) {
                    validationStatus.setText("DNI no válido");
                } else {
                    validationStatus.setText("");
                    pickDateBtn.setVisibility(View.GONE);
                    selectedDateTV.setVisibility(View.GONE);
                    pickTimeBtn.setVisibility(View.GONE);
                    selectedTimeTV.setVisibility(View.GONE);
                    ptDNI.setVisibility(View.GONE);
                    validateDNIButton.setVisibility(View.GONE);
                    checkImageView.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}