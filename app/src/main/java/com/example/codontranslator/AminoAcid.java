package com.example.codontranslator;

enum AminoAcidSLC {
    I, L, V, F, M, C, A, G, P, T, S,
    Y, W, Q, N, H, E, D, K, R, Stop;
}

public class AminoAcid {
    AminoAcidSLC singleLetter;
    String name, threeLetter, image, hydrophobic, polar, description;

    AminoAcid(AminoAcidSLC singleLetter, String threeLetter, String name,
              String image, String hydrophobic, String polar, String description){
        this.singleLetter = singleLetter;
        this.threeLetter = threeLetter;
        this.name = name;
        this.image = image;
        this.hydrophobic = hydrophobic;
        this.polar = polar;
        this.description = description;
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

    public String getHydrophobic() { return hydrophobic; }

    public String getPolar() { return polar; }

    public String getDescription() { return description; }

}
