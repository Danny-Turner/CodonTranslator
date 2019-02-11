package com.example.codontranslator;

enum Nucleotide {
    A, T, G, C;
}

public class Codon {
    Nucleotide nucleotide1;
    Nucleotide nucleotide2;
    Nucleotide nucleotide3;

    Codon(Nucleotide nucleotide1, Nucleotide nucleotide2, Nucleotide nucleotide3) {
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

    @Override
    public String toString(){
        return nucleotide1.toString()+nucleotide2.toString()+nucleotide3.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Codon) {
            Codon that = (Codon) other;
            return this.nucleotide1.equals(that.nucleotide1)
                    && this.nucleotide2.equals(that.nucleotide2)
                    && this.nucleotide3.equals(that.nucleotide3);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
