package com.idn99.project.aplikasitesbutawarna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button jawab;
    private TextView tvHeader,time;
    private EditText edtJawaban;
    private ImageView imgSoal;
    private int x,jawaban,timer = 15000;
    private String hasil;
    private ArrayList<Data> listData = new ArrayList<>();
    public static CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisial();
        isiJawaban();
        setKonten();

        countDownTimer = new CountDownTimer(timer, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText(String.valueOf(millisUntilFinished / 1000));
                jawab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtJawaban.getText().toString().isEmpty()){
                            edtJawaban.setError("Jawaban Tidak Boleh Kosong");
                        }else {
                            cekJawaban();
                            countDownTimer.start();
                        }
                    }
                });
            }
            public void onFinish() {
                hasil = "Anda Kehabisan Waktu , Mohon Jawab Dengan Cepat";
                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("hasil", hasil);
                finish();
                startActivity(intent);
            }
        }.start();
    }

    private void inisial(){
        jawab = findViewById(R.id.btn_jawab);
        tvHeader = findViewById(R.id.tv_soal);
        time = findViewById(R.id.timer);
        edtJawaban = findViewById(R.id.edt_jawaban);
        imgSoal = findViewById(R.id.img_test);
    }

    private void isiJawaban(){
        listData.add(new Data("Test 1",12,R.mipmap.mata1));
        listData.add(new Data("Test 2",8,R.mipmap.mata2));
        listData.add(new Data("Test 3",29,R.mipmap.mata3));
        listData.add(new Data("Test 4",6,R.mipmap.mata4));
        listData.add(new Data("Test 5",5,R.mipmap.mata5));
        listData.add(new Data("Test 6",7,R.mipmap.mata6));
        listData.add(new Data("Test 7",57,R.mipmap.mata7));
        listData.add(new Data("Test 8",73,R.mipmap.mata));
    }

    private void setKonten(){
        listData.size();
        if (x>=listData.size()){
            hasil = "Mata Anda Sehat dan Tidak Buta Warna";
            Intent intent = new Intent(getApplicationContext(), Result.class);
            intent.putExtra("hasil", hasil);
            finish();
            startActivity(intent);
        }else{
            tvHeader.setText(listData.get(x).getSoal());
            imgSoal.setImageResource(listData.get(x).getGambar());
            jawaban = listData.get(x).getJawaban();
        }
        x++;
    }

    private void cekJawaban(){
        if (edtJawaban.getText().toString().equals(String.valueOf(jawaban))){
            Toast.makeText(this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
            edtJawaban.setText("");
            setKonten();
        }else{
            hasil = "Segera Cek Mata Anda ke Dokter";
            Intent intent = new Intent(getApplicationContext(), Result.class);
            intent.putExtra("hasil", hasil);
            finish();
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Selesaikan Test", Toast.LENGTH_SHORT).show();
    }

}
