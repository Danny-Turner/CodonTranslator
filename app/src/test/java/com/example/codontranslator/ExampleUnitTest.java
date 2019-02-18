package com.example.codontranslator;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    @Test
    public void findAminoAcidDataFile() throws IOException {
        File amino = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "AminoAcidData");
        assertTrue(amino.exists());
    }

    @Test
    public void checkGlycineData() throws IOException {
        File amino = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "AminoAcidData");
        Tables.loadAminoAcids(new FileInputStream(amino));
        AminoAcid gotten = Tables.aminoAcidLookup.get(AminoAcidSLC.G);
        assertEquals("Gly", gotten.getThreeLetter());
        assertEquals("Glycine", gotten.getName());
        assertEquals("yes", gotten.getHydrophobic());
        assertEquals("no", gotten.getPolar());
        assertEquals("glycine", gotten.getImage());
        assertEquals("Glycine", gotten.getDescription());
        assertEquals(AminoAcidSLC.G, gotten.getSingleLetter());

    }

    @Test
    public void checkAsparticAcidData() throws IOException {
            File amino = new File("src" + File.separator + "main" + File.separator +
                    "assets" + File.separator + "AminoAcidData");
            Tables.loadAminoAcids(new FileInputStream(amino));
            AminoAcid gotten = Tables.aminoAcidLookup.get(AminoAcidSLC.D);
            assertEquals("Asp", gotten.getThreeLetter());
            assertEquals("Aspartic acid", gotten.getName());
            assertEquals("no", gotten.getHydrophobic());
            assertEquals("yes", gotten.getPolar());
            assertEquals("aspartic_acid", gotten.getImage());
            assertEquals("AsparticAcid", gotten.getDescription());
            assertEquals(AminoAcidSLC.D, gotten.getSingleLetter());
    }

    @Test
    public void checkGlutamineData() throws IOException {
        File amino = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "AminoAcidData");
        Tables.loadAminoAcids(new FileInputStream(amino));
        AminoAcid gotten = Tables.aminoAcidLookup.get(AminoAcidSLC.Q);
        assertEquals("Gln", gotten.getThreeLetter());
        assertEquals("Glutamine", gotten.getName());
        assertEquals("no", gotten.getHydrophobic());
        assertEquals("yes", gotten.getPolar());
        assertEquals("glutamine", gotten.getImage());
        assertEquals("Glutamine", gotten.getDescription());
        assertEquals(AminoAcidSLC.Q, gotten.getSingleLetter());
    }

    @Test
    public void checkTryptophanData() throws IOException {
        File amino = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "AminoAcidData");
        Tables.loadAminoAcids(new FileInputStream(amino));
        AminoAcid gotten = Tables.aminoAcidLookup.get(AminoAcidSLC.W);
        assertEquals("Trp", gotten.getThreeLetter());
        assertEquals("Tryptophan", gotten.getName());
        assertEquals("yes", gotten.getHydrophobic());
        assertEquals("no", gotten.getPolar());
        assertEquals("tryptophan", gotten.getImage());
        assertEquals("Tryptophan", gotten.getDescription());
        assertEquals(AminoAcidSLC.W, gotten.getSingleLetter());
    }


    @Test
    public void checkStopData() throws IOException {
        File amino = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "AminoAcidData");
        Tables.loadAminoAcids(new FileInputStream(amino));
        AminoAcid gotten = Tables.aminoAcidLookup.get(AminoAcidSLC.Stop);
        assertEquals("Stop", gotten.getThreeLetter());
        assertEquals("Stop", gotten.getName());
        assertEquals("na", gotten.getHydrophobic());
        assertEquals("na", gotten.getPolar());
        assertEquals("stop", gotten.getImage());
        assertEquals("Stop", gotten.getDescription());
        assertEquals(AminoAcidSLC.Stop, gotten.getSingleLetter());
    }

    @Test
    public void findCodonDataFile() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
    }

    @Test
    public void lookupTTC() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        assertTrue(codon.exists());
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("TTC");
        assertEquals(AminoAcidSLC.F, gotten);
    }

    @Test
    public void lookupCTT() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("CTT");
        assertEquals(AminoAcidSLC.L, gotten);
    }

    @Test
    public void lookupATA() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("ATA");
        assertEquals(AminoAcidSLC.I, gotten);
    }

    @Test
    public void lookupATG() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("ATG");
        assertEquals(AminoAcidSLC.M, gotten);
    }

    @Test
    public void lookupGTA() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("GTA");
        assertEquals(AminoAcidSLC.V, gotten);
    }

    @Test
    public void lookupAGG() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("AGG");
        assertEquals(AminoAcidSLC.R, gotten);
    }

    @Test
    public void lookupTCA() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("TCA");
        assertEquals(AminoAcidSLC.S, gotten);
    }

    @Test
    public void lookupCCT() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("CCT");
        assertEquals(AminoAcidSLC.P, gotten);
    }

    @Test
    public void lookupACC() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("ACC");
        assertEquals(AminoAcidSLC.T, gotten);
    }

    @Test
    public void lookupGCG() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("GCG");
        assertEquals(AminoAcidSLC.A, gotten);
    }

    @Test
    public void lookupTAT() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("TAT");
        assertEquals(AminoAcidSLC.Y, gotten);
    }

    @Test
    public void lookupTAA() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("TAA");
        assertEquals(AminoAcidSLC.Stop, gotten);
    }

    @Test
    public void lookupTGG() throws IOException {
        File codon = new File("src" + File.separator + "main" + File.separator +
                "assets" + File.separator + "CodonData");
        Tables.loadCodonData(new FileInputStream(codon));
        AminoAcidSLC gotten = Tables.codonLookup.get("TGG");
        assertEquals(AminoAcidSLC.W, gotten);
    }

}