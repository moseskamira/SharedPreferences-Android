package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userNameEdt, userPinEdt;
    Button saveButton;
    String userName, userPin;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdt = findViewById(R.id.edt_user_name);
        userPinEdt = findViewById(R.id.edt_pin);
        saveButton = findViewById(R.id.btn_save);
        prefs = getApplicationContext().getSharedPreferences("myPrefs", 0);
        if (saveButton != null) {
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveToSharedPreferences();
                }
            });
        }

    }

    private void saveToSharedPreferences() {
        userName = userNameEdt.getText().toString();
        userPin = userPinEdt.getText().toString();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("userName", userName);
        editor.putString("userPin", userPin);

        editor.commit();


        goToHomePage();
    }

    private void goToHomePage() {
        Intent homeIntent = new Intent(this, Home.class);
        startActivity(homeIntent);

    }
}
