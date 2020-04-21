package com.idn99.project.aplikasitesbutawarna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private Button main,exit;
    private TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inisial();
        MainActivity.countDownTimer.cancel();
        String hasil = getIntent().getStringExtra("hasil");
        tvHasil.setText(hasil);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inisial(){
        main = findViewById(R.id.btnMain);
        exit = findViewById(R.id.btnExit);
        tvHasil = findViewById(R.id.hasil_test_tv);
    }
}
