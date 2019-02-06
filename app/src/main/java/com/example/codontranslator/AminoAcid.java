package com.example.codontranslator;

enum AminoAcidSLC {
    I, L, V, F, M, C, A, G, P, T, S,
    Y, W, Q, N, H, E, D, K, R, Stop;
}

public class AminoAcid {
    String name;
    AminoAcidSLC singleLetter;
    String threeLetter;

    AminoAcid(String name, AminoAcidSLC singleLetter, String threeLetter){
        this.name = name;
        this.singleLetter = singleLetter;
        this.threeLetter = threeLetter;
    }

    public String getName() {
        return name;
    }

    public AminoAcidSLC getSingleLetter() {
        return singleLetter;
    }

    public String getThreeLetter() {
        return threeLetter;
    }

}
