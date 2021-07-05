package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.sax.SAXSource;

public class MainActivity extends AppCompatActivity {

    RadioButton rBtnM, rBtnF;
    RadioGroup RadioG1;
    private String mSpinnerLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Recuperar_id();


        Spinner spinner = (Spinner) findViewById(R.id.ciudad);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               mSpinnerLabel = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void Recuperar_id() {
        rBtnM = findViewById(R.id.rBtnM);
        rBtnF = findViewById(R.id.rBtnF);
        RadioG1 = findViewById(R.id.rdbG1);


    }

    public void onRadioButtonClicked (View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.rBtnM:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Selecciono masculino", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rBtnF:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Selecciono Femenino", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showDatePickerDialog(View v) {
        final TextView etPlannedDate = (TextView) findViewById(R.id.txt_fecha);

        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                //+1 porque enero es 0
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                etPlannedDate.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "Calendario");
    }
}