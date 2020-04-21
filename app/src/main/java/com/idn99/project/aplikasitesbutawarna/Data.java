package com.idn99.project.aplikasitesbutawarna;

public class Data {
    private String soal;
    private int jawaban;
    private int gambar;

    public Data(String soal, int jawaban, int gambar) {
        this.soal = soal;
        this.jawaban = jawaban;
        this.gambar = gambar;
    }

    public String getSoal() {
        return soal;
    }

    public int getJawaban() {
        return jawaban;
    }

    public int getGambar() {
        return gambar;
    }
}
