package com.example.codontranslator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

// Dan Turner
// CSCI 352
// Project 1 - Codon Translator



public class MainActivity extends AppCompatActivity {

    private Spinner Nucleotide1;
    private Spinner Nucleotide2;
    private Spinner Nucleotide3;
    private TextView Title1;
    private TextView Title2;
    private TextView Title3;
    private TextView AminoAcid;
    private Button ShowMore;
    public Nucleotide nuc1,nuc2,nuc3;
    private static Hashtable<String,AminoAcidSLC> codonLookup = new Hashtable<>();
    private static Hashtable<AminoAcidSLC,AminoAcid> AminoAcidLookup = new Hashtable<>();
    public static void loadData(Scanner dataFile, Hashtable<Codon,AminoAcidSLC> table) {
        while (dataFile.hasNextLine()) {
            String line = dataFile.nextLine();
            String[] codonData = line.split(",");
            Nucleotide nuc1 = Nucleotide.valueOf(codonData[0]);
            Nucleotide nuc2 = Nucleotide.valueOf(codonData[1]);
            Nucleotide nuc3 = Nucleotide.valueOf(codonData[2]);
            AminoAcidSLC shortCode = AminoAcidSLC.valueOf(codonData[3]);
//            table.put(new Codon(nuc1,nuc2,nuc3), new AminoAcid("Isoleucine",AminoAcidSLC.I,"Ile"));
            table.put(new Codon(nuc1,nuc2,nuc3), shortCode);
        }
  //      codonLookup.put(new Codon(Nucleotide.A,Nucleotide.T,Nucleotide.T), new AminoAcid("Isoleucine",AminoAcidSLC.I,"Ile"));
    }

    public AminoAcidSLC findAminoAcid(){
        Codon currentCodon = new Codon(nuc1,nuc2,nuc3);


        return codonLookup.get(currentCodon.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nucleotide1 = findViewById(R.id.Nucleotide1);
        Nucleotide2 = findViewById(R.id.Nucleotide2);
        Nucleotide3 = findViewById(R.id.Nucleotide3);
        Title1 = findViewById(R.id.Title1);
        Title2 = findViewById(R.id.Title2);
        Title3 = findViewById(R.id.Title3);
        AminoAcid = findViewById(R.id.AminoAcid);
        ShowMore = findViewById(R.id.ShowMore);
    //        InputStream codonInput = getAssets().open("CodonData");
    //        try (Scanner input = new Scanner(codonInput)) {
            try {InputStream codonInput = getAssets().open("CodonData");
                Scanner input = new Scanner(codonInput);
     //           Log.d("ShowMoreActivity", "About to find acid detail3");
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] codonData = line.split(",");
                    Nucleotide nuc1 = Nucleotide.valueOf(codonData[0]);
                    Nucleotide nuc2 = Nucleotide.valueOf(codonData[1]);
                    Nucleotide nuc3 = Nucleotide.valueOf(codonData[2]);
                    AminoAcidSLC shortCode = AminoAcidSLC.valueOf(codonData[3]);
                    codonLookup.put(new Codon(nuc1, nuc2, nuc3).toString(), shortCode);
                }
                input.close();
            } catch (IOException e) {
                Log.e("MainActivity", "Could not read CodonData");
            }


        ArrayAdapter<Nucleotide> NucleotideOneAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide1.setAdapter(NucleotideOneAdapter);

        ArrayAdapter<Nucleotide> NucleotideTwoAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide2.setAdapter(NucleotideTwoAdapter);

        ArrayAdapter<Nucleotide> NucleotideThreeAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Nucleotide.values());
        Nucleotide3.setAdapter(NucleotideThreeAdapter);


        ShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMoreIntent = new Intent(MainActivity.this, ShowMoreActivity.class);
                startActivity(showMoreIntent);

            }
        });

        Nucleotide1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nuc1 = (Nucleotide) parent.getItemAtPosition(position);
                AminoAcid.setText(findAminoAcid().toString() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
              //  AminoAcid.setText("nothing");

            }
        });

        Nucleotide2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nuc2 = (Nucleotide) parent.getItemAtPosition(position);
                AminoAcid.setText(findAminoAcid().toString() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               // AminoAcid.setText("nothing");

            }
        });

        Nucleotide3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nuc3 = (Nucleotide) parent.getItemAtPosition(position);
                AminoAcid.setText(findAminoAcid().toString() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
              //  AminoAcid.setText("nothing");
            }
        });






    }
}
