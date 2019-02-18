package com.example.codontranslator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Scanner;


public class Tables {
    public static Hashtable<String, AminoAcidSLC> codonLookup = new Hashtable<>();
    public static Hashtable<AminoAcidSLC, AminoAcid> aminoAcidLookup = new Hashtable<>();

    public static void loadCodonData(InputStream codonInput) throws IOException {
        Scanner input = new Scanner(codonInput);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] codonData = line.split(",");
            Nucleotide nuc1 = Nucleotide.valueOf(codonData[0]);
            Nucleotide nuc2 = Nucleotide.valueOf(codonData[1]);
            Nucleotide nuc3 = Nucleotide.valueOf(codonData[2]);
            AminoAcidSLC shortCode = AminoAcidSLC.valueOf(codonData[3]);
            Tables.codonLookup.put(new Codon(nuc1, nuc2, nuc3).toString(), shortCode);
        }
        input.close();
    }


    public static void loadAminoAcids(InputStream aminoAcidInput) throws IOException {
        Scanner input = new Scanner(aminoAcidInput);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] AminoAcidData = line.split(",");
            AminoAcidSLC singleLetter = AminoAcidSLC.valueOf(AminoAcidData[0]);
            String threeLetter = AminoAcidData[1];
            String fullName = AminoAcidData[2];
            String image = AminoAcidData[3];
            String hydrophobic = AminoAcidData[4];
            String polar = AminoAcidData[5];
            String description = AminoAcidData[6];
            Tables.aminoAcidLookup.put(singleLetter, new AminoAcid(singleLetter, threeLetter, fullName,
                    image, hydrophobic, polar, description));
        }
        input.close();
    }
}
