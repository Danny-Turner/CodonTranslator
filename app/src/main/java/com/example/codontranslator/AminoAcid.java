package com.example.codontranslator;

enum AminoAcidSLC {
    I, L, V, F, M, C, A, G, P, T, S,
    Y, W, Q, N, H, E, D, K, R, Stop;
}

public class AminoAcid {
    String name;
    AminoAcidSLC singleLetter;
    String threeLetter;
    String image;

    AminoAcid(AminoAcidSLC singleLetter, String threeLetter, String name, String image){
        this.singleLetter = singleLetter;
        this.threeLetter = threeLetter;
        this.name = name;
        this.image = image;
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

    public String getImage() { return image; }


}
