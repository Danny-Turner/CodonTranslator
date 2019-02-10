package com.example.codontranslator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
    private ImageView AminoAcidImageMain;
    public Nucleotide nuc1,nuc2,nuc3;
    private static Hashtable<String,AminoAcidSLC> codonLookup = new Hashtable<>();
    private static Hashtable<AminoAcidSLC,AminoAcid> aminoAcidLookup = new Hashtable<>();

    public void loadCodonData() {
        try {
            InputStream codonInput = getAssets().open("CodonData");
            Scanner input = new Scanner(codonInput);
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

    }

    public void loadAminoAcidData() {
        try {
            InputStream AminoAcidInput = getAssets().open("AminoAcidData");
            Scanner input = new Scanner(AminoAcidInput);
            Log.d("MainActivity", "reading acid file");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Log.i("MainActivity", "acid line: " + line);
                String[] AminoAcidData = line.split(",");
                AminoAcidSLC singleLetter = AminoAcidSLC.valueOf(AminoAcidData[0]);
                String threeLetter = AminoAcidData[1];
                String fullName = AminoAcidData[2];
                String image = AminoAcidData[3];
                aminoAcidLookup.put(singleLetter, new AminoAcid(singleLetter,threeLetter, fullName, image));
            }
            input.close();
            Log.i("MainActivity", "Done with acids");
        } catch (IOException e) {
            Log.e("MainActivity", "Could not read AminoAcidData");
        }

    }

    public AminoAcid findAminoAcid(){
        Codon currentCodon = new Codon(nuc1,nuc2,nuc3);
        return aminoAcidLookup.get(codonLookup.get(currentCodon.toString()));
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
        AminoAcidImageMain = findViewById(R.id.AminoAcidImageMain);

        loadCodonData();
        loadAminoAcidData();

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

        grabSpinnerValues();
        for (Spinner Nucleotide: new Spinner[]{Nucleotide1, Nucleotide2, Nucleotide3}) {
            Nucleotide.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    grabSpinnerValues();
                    int test = AminoAcidImageMain.getContext().getResources().getIdentifier(findAminoAcid().getImage(), "drawable", AminoAcidImageMain.getContext().getPackageName());
                    AminoAcidImageMain.setImageResource(R.drawable.histidine);

                    AminoAcid.setText(findAminoAcid().getName() );
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    AminoAcid.setText("Please Select Nucleotides");

                }
            });
        }
    }

    void grabSpinnerValues() {
        nuc1 = (Nucleotide) Nucleotide1.getSelectedItem();
        nuc2 = (Nucleotide) Nucleotide2.getSelectedItem();
        nuc3 = (Nucleotide) Nucleotide3.getSelectedItem();
    }
}
