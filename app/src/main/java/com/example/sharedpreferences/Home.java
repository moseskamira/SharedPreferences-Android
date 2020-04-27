package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView usernameTv, userPinTv;
    Button retrieveBtn;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameTv = findViewById(R.id.tv_user_name);
        userPinTv = findViewById(R.id.tv_pin);
        retrieveBtn = findViewById(R.id.btn_retrieve);
        preferences = getApplicationContext().getSharedPreferences("myPrefs", 0);
        if (retrieveBtn != null) {
            retrieveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    retrieveSharedPreferences();
                }
            });
        }
    }

    private void retrieveSharedPreferences() {
        usernameTv.setText(preferences.getString("userName", null));
        userPinTv.setText(preferences.getString("userPin", null));
    }
}
