package com.evomento.jpslab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PadActivity extends AppCompatActivity {
    public String currentRut = "";
    EditText rutInput;
    private static final String TAG = "pad_activity";
    public String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pad);
        // get intent extras
        Intent intent = getIntent();
        direction = intent.getStringExtra("direction");
        // set text and color depending on direction
        setDirection();
        // get RUT input for later use
        rutInput = (EditText)findViewById(R.id.rutInput);
    }

    public void padButtonClick(View view) {
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        updateRutInput(buttonText);
    }

    public void padBackspaceClick(View view) {
        if(currentRut.length() > 0) {
            currentRut = currentRut.substring(0, currentRut.length() - 1);
            rutInput.setText(currentRut);
        }
    }

    public void updateRutInput(String newCharacter) {
        currentRut += newCharacter;
        rutInput.setText(currentRut);
    }

    public void setDirection() {
        Button padSubmit = (Button) findViewById(R.id.padSubmit);
        if(direction.equals("in")) {
            padSubmit.setBackgroundColor(getResources().getColor(R.color.green_btn));
            padSubmit.setText("Entrar");
        } else {
            padSubmit.setBackgroundColor(getResources().getColor(R.color.orange_btn));
            padSubmit.setText("Salir");
        }
    }
}
