package com.example.codontranslator;

enum Nucleotide {
    A, T, G, C;
}

public class Codon {
    Nucleotide nucleotide1;
    Nucleotide nucleotide2;
    Nucleotide nucleotide3;

    Codon(Nucleotide nucleotide1, Nucleotide nucleotie2, Nucleotide nucleotide3) {
        this.nucleotide1 = nucleotide1;
        this.nucleotide2 = nucleotide2;
        this.nucleotide3 = nucleotide3;
    }

    public Nucleotide getNucleotide1() {
        return nucleotide1;
    }
    public Nucleotide getNucleotide2() {
        return nucleotide2;
    }
    public Nucleotide getNucleotide3() {
        return nucleotide3;
    }

}
