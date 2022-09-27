package com.evomento.jpslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        String msg = "Entrada";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void padPage(View view) {
        Button b = (Button)view;
        String tag = (String) b.getTag();
        Log.d(TAG, "padPage: " + tag);
        Intent switchActivityIntent = new Intent(this, PadActivity.class);
        switchActivityIntent.putExtra("direction", tag);
        startActivity(switchActivityIntent);
    }
}