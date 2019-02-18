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

import java.io.IOException;

// Dan Turner
// CSCI 352
// Project 1 - Codon Translator
//
// Amino Acid information from https://en.wikipedia.org/wiki/Proteinogenic_amino_acid


public class MainActivity extends AppCompatActivity {

    private Spinner Nucleotide1, Nucleotide2, Nucleotide3;
    private TextView AminoAcidName;
    private Button ShowMore;
    private ImageView AminoAcidImageMain;
    private int imageid;
    private static Nucleotide selectedNucleotide1, selectedNucleotide2, selectedNucleotide3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCodonData();
        loadAminoAcidData();
        assignLayoutToObjects();
        createSpinnerAdapters();
        listenForSpinnerSelection();
        listenForMoreInfoButton();
        grabSpinnerValues();

    }


    private void loadCodonData() {
        try {
            Tables.loadCodonData(getAssets().open("CodonData"));
        } catch (IOException e) {
            Log.e("MainActivity", "Could not read CodonData");
        }
    }


    private void loadAminoAcidData() {
        try {
            Tables.loadAminoAcids(getAssets().open("AminoAcidData"));
        } catch (IOException e) {
            Log.e("MainActivity", "Could not read AminoAcidData");
        }
    }


    private void assignLayoutToObjects() {
        Nucleotide1 = findViewById(R.id.Nucleotide1);
        Nucleotide2 = findViewById(R.id.Nucleotide2);
        Nucleotide3 = findViewById(R.id.Nucleotide3);
        AminoAcidName = findViewById(R.id.AminoAcid);
        ShowMore = findViewById(R.id.ShowMore);
        AminoAcidImageMain = findViewById(R.id.AminoAcidImageMain);
    }


    private void createSpinnerAdapters() {
         for (Spinner NucleotideValue: new Spinner[]{Nucleotide1, Nucleotide2, Nucleotide3}) {
             ArrayAdapter<Nucleotide> NucleotideAdapter =
                     new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Nucleotide.values());
             NucleotideValue.setAdapter(NucleotideAdapter);
         }
    }


    private void listenForSpinnerSelection() {
        for (Spinner Nucleotide: new Spinner[]{Nucleotide1, Nucleotide2, Nucleotide3}) {
            Nucleotide.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    grabSpinnerValues();
                    imageid = getResources().getIdentifier(findAminoAcid().getImage(),"drawable",MainActivity.this.getPackageName());
                    AminoAcidImageMain.setImageResource(imageid);
                    AminoAcidName.setText(findAminoAcid().getName() );
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    AminoAcidName.setText("Please Select Nucleotides");
                }
            });
        }
    }


    public static AminoAcid findAminoAcid(){
        Codon currentCodon = new Codon(selectedNucleotide1, selectedNucleotide2, selectedNucleotide3);
        return Tables.aminoAcidLookup.get(Tables.codonLookup.get(currentCodon.toString()));
    }


    private void listenForMoreInfoButton() {
        ShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMoreIntent = new Intent(MainActivity.this, ShowMoreActivity.class);
                showMoreIntent.putExtra("ImageID", imageid);
                startActivity(showMoreIntent);
            }
        });
    }


    private void grabSpinnerValues() {
        selectedNucleotide1 = (Nucleotide) Nucleotide1.getSelectedItem();
        selectedNucleotide2 = (Nucleotide) Nucleotide2.getSelectedItem();
        selectedNucleotide3 = (Nucleotide) Nucleotide3.getSelectedItem();
    }

}
