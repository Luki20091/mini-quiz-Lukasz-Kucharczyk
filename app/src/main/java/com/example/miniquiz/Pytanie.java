package com.example.miniquiz;

public class Pytanie {
    private String trescPytania;
    private String odpowiedzA;
    private String odpowiedzB;
    private String odpowiedzC;
    private String poprawnaOdpowiedz;

    public Pytanie(String trescPytania, String odpowiedzA, String odpowiedzB, String odpowiedzC, String poprawnaOdpowiedz) {
        this.trescPytania = trescPytania;
        this.odpowiedzA = odpowiedzA;
        this.odpowiedzB = odpowiedzB;
        this.odpowiedzC = odpowiedzC;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    public String pobierzTresc() { return trescPytania; }
    public String pobierzOdpA() { return odpowiedzA; }
    public String pobierzOdpB() { return odpowiedzB; }
    public String pobierzOdpC() { return odpowiedzC; }
    public String pobierzPoprawna() { return poprawnaOdpowiedz; }
}